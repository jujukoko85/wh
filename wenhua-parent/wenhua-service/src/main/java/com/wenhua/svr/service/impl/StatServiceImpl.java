package com.wenhua.svr.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wenhua.svr.component.NetBarCacher;
import com.wenhua.svr.component.StatAreaInstanceCacher;
import com.wenhua.svr.dao.AreasCodeDao;
import com.wenhua.svr.dao.StatAreaDao;
import com.wenhua.svr.dao.StatNetBarDao;
import com.wenhua.svr.domain.AreasCode;
import com.wenhua.svr.domain.BarPcInstantInfo;
import com.wenhua.svr.domain.StatArea;
import com.wenhua.svr.domain.StatAreaInstance;
import com.wenhua.svr.domain.StatNetBar;
import com.wenhua.svr.service.StatService;
import com.wenhua.util.BarIdUtils;
import com.wenhua.util.tools.DateUtils;

public class StatServiceImpl implements StatService {
	
	/** 文化客户端运行多少分钟 认为已运行 */
	private Integer wenhuaDuration = 30;
	
	private StatNetBarDao statNetBarDao;
	private StatAreaDao statAreaDao;
	private AreasCodeDao areasCodeDao;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public void init() {
		List<AreasCode> list = areasCodeDao.selectAll();
		logger.info(String.format("##init the area cache [%d]", null == list ? 0 : list.size()));
		if(null == list || 0 == list.size()) return;
		
		for(AreasCode code : list) {
			if(code.isProvince()) {
				continue;
			}
			
			int areaMaxBar = 0;
			int areaMaxPc = 0;
			//TODO 获取该区域最大网吧数与PC数量
			
			StatAreaInstance instance = StatAreaInstance.newOne(code, areaMaxBar, areaMaxPc);
			
			StatAreaInstanceCacher.put(code.getAreasid(), instance);
		}
		
	}
	
	@Override
	public void activeBar(String barId) {
		if(!BarIdUtils.isValid(barId)) {
			logger.warn(String.format("##Invalid barId: %s", barId));
			return;
		}
		String areaCode = BarIdUtils.getAreaCode(barId);
		String cityCode = BarIdUtils.getCityCode(barId);
		
		StatAreaInstance areaInstance = StatAreaInstanceCacher.get(areaCode);
		StatAreaInstance cityInstance = StatAreaInstanceCacher.get(cityCode);
		
		int areaCurrent = areaInstance.online(barId);
		int cityCurrent = cityInstance.online(barId);
		
		logger.info(
				String.format(
						"##ActiveBar id: %s, Area: %s %s CurrentActive Bar: %d City: %s %s CurrentActive Bar: %d", 
						barId,
						areaCode,
						areaInstance.getName(),
						areaCurrent,
						cityCode,
						cityInstance.getName(),
						cityCurrent
						));
	}

	@Override
	public void inactiveBar(String barId) {
		if(!BarIdUtils.isValid(barId)) {
			logger.warn(String.format("##Invalid barId: %s", barId));
			return;
		}
		
		String areaCode = BarIdUtils.getAreaCode(barId);
		String cityCode = BarIdUtils.getCityCode(barId);
		
		StatAreaInstance areaInstance = StatAreaInstanceCacher.get(areaCode);
		StatAreaInstance cityInstance = StatAreaInstanceCacher.get(cityCode);
		
		int areaCurrent = areaInstance.offline(barId);
		int cityCurrent = cityInstance.offline(barId);
		
		logger.info(
				String.format(
						"##InactiveBar id: %s, Area: %s %s CurrentActive Bar: %d City: %s %s CurrentActive Bar: %d", 
						barId,
						areaCode,
						areaInstance.getName(),
						areaCurrent,
						cityCode,
						cityInstance.getName(),
						cityCurrent
						));
	}
	
	@Override
	public void countAreaDaily() {
		Date yesterday = DateUtils.getChinaDay(-1);
		logger.info("#########################");
		logger.info(String.format("##Begin deal with [%s]", DateUtils.getString(yesterday)));
		logger.info("#########################");
		
		//获取所有市级地区 与 区级地区
		List<AreasCode> allAreaCode = areasCodeDao.selectAll();
		logger.info(String.format("##Get [%d] area codes", null == allAreaCode ? 0 : allAreaCode.size()));
		
		if(null == allAreaCode || 0 == allAreaCode.size()) return;
		
		for(AreasCode code : allAreaCode) {
			if(code.isProvince()) {
				// 忽略 省
				continue;
			}
			
			logger.info(String.format("##Begin AreaStat [%s][%s]", code.getAreasid(), code.getAreasname()));
			try {
				countAreaDaily(code.getAreasid(), yesterday);
			} catch (Exception e) {
				logger.error(String.format("##AreaStat [%s][%s] error", code.getAreasid(), code.getAreasname()), e);
			}
			
		}
	}
	
	@Override
	public void countAreaDaily(String areaCode, Date statDate) {
		if(!AreasCode.isValidCode(areaCode)) {
			logger.error(String.format("##CountAreaDaily error, wrong areaCode, areaCode: %s", areaCode));
			return;
		}
		
		if(null == statDate) {
			logger.error("##CountAreaDaily error, statDate is null");
			return;
		}
		
		// A 在线网吧  B 离线网吧  C 用户总数
		
		// A.1 获取指定日期 在线网吧最大数
		int online = 0;
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("areaCode", areaCode);
		params.put("statDate", statDate);
		if(areaCode.endsWith("00")) {
			//统计 市
			online = statNetBarDao.countCityDaily(params);
		} else {
			//统计 区
			online = statNetBarDao.countAreaDaily(params);
		}
		
		//TODO B.1 获取某地区网吧总数
		int total = 99999;
		int offline = total - online;
		
		//C.1 
		int login = 0;
		if(areaCode.endsWith("00")) {
			login = statNetBarDao.countLoginCityDaily(params);
		} else {
			login = statNetBarDao.countLoginAreaDaily(params);
		}
		
		StatArea sa = StatArea.newOne(areaCode, statDate, online, offline, login);
		statAreaDao.insert(sa);
	}
	
	/**
	 * 根据网上传的实时客户机信息 实时更新该网吧的 在线终端数 离线终端数 有效终端数 登录人数
	 */
	@Override
	public void countBarDaily(String barId, List<BarPcInstantInfo> infos) {
		StatNetBar current = getCurrentStatNetBar(barId, infos);
		if(null == current) return;
		
		StatNetBar cache = NetBarCacher.get(current.getBarId());
		StatNetBar needUpdate = null;
		
		if(null == cache) {

			StatNetBar dbCache = statNetBarDao.selectByPrimaryKey(StatNetBar.generateId(current.getBarId(), current.getStatDate()));
			if(null == dbCache) {
				statNetBarDao.insert(current);
				NetBarCacher.put(current.getBarId(), current);
				
				//处理统计区域登录人数
				StatAreaInstanceCacher.addLogin(barId, current.getLogin());
				
			} else {
				needUpdate = current.compare(dbCache);
				if(null == needUpdate) {
					NetBarCacher.put(dbCache.getBarId(), dbCache);
					return;
				} else {
					statNetBarDao.updateByPrimaryKey(needUpdate);
					NetBarCacher.put(needUpdate.getBarId(), needUpdate);
					
				}
			}
			
		} else {
			
			if(current.getStatDate().getTime() > cache.getStatDate().getTime()) {
				// 当前状态日期 大于 缓存日期 则缓存过期
				NetBarCacher.remove(cache.getBarId()); // 清除老缓存
				statNetBarDao.insert(current);
				NetBarCacher.put(current.getBarId(), current); // 加入新缓存
			} else {
				
				needUpdate = current.compare(cache);

				if(null == needUpdate) return;
				
				statNetBarDao.updateByPrimaryKey(needUpdate);
			}
			
		}
		
		//处理统计区域登录人数
		if(null != needUpdate && needUpdate.getLogin() > current.getLogin()) {
			StatAreaInstanceCacher.addLogin(barId, needUpdate.getLogin() - current.getLogin());
		}
		
		
	}

	/**
	 * 获取当前网吧状态
	 * @param barId
	 * @param infos
	 * @return
	 */
	private StatNetBar getCurrentStatNetBar(String barId, List<BarPcInstantInfo> infos) {
		if(null == infos || 0 == infos.size()) return null;
		
		int online = 0;
		int offline = 0;
		int valid = 0;
		int login = 0;
		for(BarPcInstantInfo info : infos) {
			if(info.isPowerOn()) {
				online++;
			} else {
				offline++;
			}
			
			if(info.isRunWenhua() && info.getWenhuaDuration() >= wenhuaDuration) {
				valid++;
			}
			
			if(info.isUserLogin()) {
				login++;
			}
		}
		StatNetBar current = StatNetBar.newOne(barId, DateUtils.getChinaDay(), online, offline, valid, login);
		return current;
	}

	public Integer getWenhuaDuration() {
		return wenhuaDuration;
	}

	public void setWenhuaDuration(Integer wenhuaDuration) {
		this.wenhuaDuration = wenhuaDuration;
	}

	public StatNetBarDao getStatNetBarDao() {
		return statNetBarDao;
	}

	public void setStatNetBarDao(StatNetBarDao statNetBarDao) {
		this.statNetBarDao = statNetBarDao;
	}

	public StatAreaDao getStatAreaDao() {
		return statAreaDao;
	}

	public void setStatAreaDao(StatAreaDao statAreaDao) {
		this.statAreaDao = statAreaDao;
	}

	@Override
	public List<StatAreaInstance> getCityListStat() {
		
		List<StatAreaInstance> list = new ArrayList<StatAreaInstance>();
		for(StatAreaInstance sai : StatAreaInstanceCacher.values()) {
			if(!sai.isCity()) continue;
			
			list.add(sai);
			
			// 当前该区域登录人数
			int currentLogin = 0;
			
		}
		
		return list;
	}

	@Override
	public List<StatAreaInstance> getAreaListStat(String cityCode) {
		// TODO Auto-generated method stub
		return null;
	}


}
