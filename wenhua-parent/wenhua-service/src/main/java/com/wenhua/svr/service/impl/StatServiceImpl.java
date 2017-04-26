package com.wenhua.svr.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wenhua.svr.dao.AreasCodeDao;
import com.wenhua.svr.dao.StatAreaDao;
import com.wenhua.svr.dao.StatNetBarDao;
import com.wenhua.svr.domain.AreasCode;
import com.wenhua.svr.domain.BarPcInstantInfo;
import com.wenhua.svr.domain.StatArea;
import com.wenhua.svr.domain.StatNetBar;
import com.wenhua.svr.service.StatService;
import com.wenhua.util.tools.DateUtils;

public class StatServiceImpl implements StatService {
	
	private Map<String, StatNetBar> netBarCache = new ConcurrentHashMap<String, StatNetBar>();
	
	/** 文化客户端运行多少分钟 认为已运行 */
	private Integer wenhuaDuration = 30;
	
	private StatNetBarDao statNetBarDao;
	private StatAreaDao statAreaDao;
	private AreasCodeDao areasCodeDao;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
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
			if(AreasCode.RANK_NO_PROVINCE.equals(code.getRankno())) {
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
		if(null == areaCode || 10 != areaCode.length()) {
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
	
	@Override
	public void countBarDaily(String barId, List<BarPcInstantInfo> infos) {
		StatNetBar current = getCurrentStatNetBar(barId, infos);
		if(null == current) return;
		
		StatNetBar cache = netBarCache.get(current.getBarId());
		
		if(null == cache) {

			StatNetBar dbCache = statNetBarDao.selectByPrimaryKey(StatNetBar.generateId(current.getBarId(), current.getStatDate()));
			if(null == dbCache) {
				statNetBarDao.insert(current);
				netBarCache.put(current.getBarId(), current);
			} else {
				StatNetBar needUpdate = current.compare(dbCache);
				if(null == needUpdate) {
					netBarCache.put(dbCache.getBarId(), dbCache);
					return;
				} else {
					statNetBarDao.updateByPrimaryKey(needUpdate);
					netBarCache.put(needUpdate.getBarId(), needUpdate);
				}
			}
			
		} else {
			
			if(current.getStatDate().getTime() > cache.getStatDate().getTime()) {
				// 当前状态日期 大于 缓存日期 则缓存过期
				netBarCache.remove(cache.getBarId()); // 清除老缓存
				statNetBarDao.insert(current);
				netBarCache.put(current.getBarId(), current); // 加入新缓存
			} else {
				
				StatNetBar needUpdate = current.compare(cache);

				if(null == needUpdate) return;
				
				statNetBarDao.updateByPrimaryKey(needUpdate);
			}
			
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

}
