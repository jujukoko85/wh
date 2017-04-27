package com.wenhua.svr.component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wenhua.svr.dao.AreasCodeDao;
import com.wenhua.svr.dao.NetBarDao;
import com.wenhua.svr.dao.StatAreaDao;
import com.wenhua.svr.domain.AreasCode;
import com.wenhua.svr.domain.StatArea;
import com.wenhua.svr.domain.StatAreaInstance;
import com.wenhua.svr.domain.StatAreaInstanceArea;
import com.wenhua.svr.domain.StatAreaInstanceCity;
import com.wenhua.svr.domain.base.BaseStatAreaKey;
import com.wenhua.util.BarIdUtils;
import com.wenhua.util.tools.DateUtils;

/**
 * 区域的实时信息缓存 在线网吧数  离线网吧数 登录人数
 * @author zhuzhaohua
 *
 */
public class StatAreaInstanceCacher {
	
	private static Logger logger = LoggerFactory.getLogger(StatAreaInstanceCacher.class);

	private static final Map<String, StatAreaInstance> STAT_AREA_INSTANCE_CACHER = new ConcurrentHashMap<String, StatAreaInstance>();
	
	private AreasCodeDao areasCodeDao;
	private NetBarDao netBarDao;
	private StatAreaDao statAreaDao;
	
	public StatAreaInstanceCacher() {
	}
	
	/**
	 * 每天将地区日统计最大值清0
	 */
	public void resetMax() {
		logger.info("###############################");
		Collection<StatAreaInstance> instances = STAT_AREA_INSTANCE_CACHER.values();
		logger.info(String.format("##Rest the max value of area instance. Instance size is [%d]", null == instances ? 0 : instances.size()));
		
		for(StatAreaInstance instance : instances) {
			instance.clearMaxDaily();
		}
		logger.info("##Rest the max value of area instance over.");
	}
	
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
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("areaCode", code.getAreasid());
			if(code.isCity()) {
				areaMaxBar = netBarDao.countCityBar(params);
				areaMaxPc = netBarDao.countCityPc(params);
			} else if(code.isArea()) {
				areaMaxBar = netBarDao.countAreaBar(params);
				areaMaxPc = netBarDao.countAreaPc(params);
			}
			
			StatAreaInstance instance = StatAreaInstance.newOne(code, areaMaxBar, areaMaxPc);
			
			STAT_AREA_INSTANCE_CACHER.put(code.getAreasid(), instance);
		}
		
		Collection<StatAreaInstance> instances = STAT_AREA_INSTANCE_CACHER.values();
		
		// 组织上下关系
		for(StatAreaInstance father : instances) {
			if(!father.isCity()) continue;
			
			//如果是城市,找出其下属的区
			for(StatAreaInstance child : instances) {
				if(!child.isArea()) continue;
				
				if(!father.isMine(child)) continue;
			
				StatAreaInstanceCity fatherCity = (StatAreaInstanceCity)father;
				StatAreaInstanceArea childArea = (StatAreaInstanceArea)child;
				fatherCity.put(childArea);
			}
		}
	}
	
	/**
	 * 每隔一段时间将每日最大值存入数据库
	 */
	public void save() {
		logger.info("###############################");
		logger.info("##Save the area max value into database.");
		
		Collection<StatAreaInstance> instances = STAT_AREA_INSTANCE_CACHER.values();
		if(null == instances || 0 == instances.size()) return;
		
		Date today = DateUtils.getChinaDay();
		
		for(StatAreaInstance instance : instances) {
			StatArea old = statAreaDao.selectByPrimaryKey(BaseStatAreaKey.newOne(instance.getCode(), today));
			
			int areaMaxLoginDaily = instance.getAreaMaxLoginDaily().get();
			int areaMaxBarDaily = instance.getAreaMaxBarDaily().get();
			if(null == old) {
				
				statAreaDao.insert(
						StatArea.newOne(
								instance.getCode(), 
								today, 
								areaMaxBarDaily, 
								instance.getAreaMaxBar() - areaMaxBarDaily, 
								areaMaxLoginDaily, 
								instance.getRankno()));
				
			} else {
				
				old.setLogin(old.getLogin() > areaMaxLoginDaily ? old.getLogin() : areaMaxLoginDaily);
				old.setOnline(old.getOnline() > areaMaxBarDaily ? old.getOnline() : areaMaxBarDaily);
				int offline = instance.getAreaMaxBar() - areaMaxBarDaily;
				old.setOffline(old.getOffline() > offline ? old.getOffline() : offline);
				
				statAreaDao.updateByPrimaryKey(old);
			}
			
		}
		
		logger.info("##Save the area max value into database over.");
	}
	
	/**
	 * 每天定时更新 区域拥有的网吧数 与 区域拥有的PC数
	 */
	public void updateDaily() {
		List<AreasCode> list = areasCodeDao.selectAll();
		logger.info("###############################");
		logger.info(String.format("##update the area cache [%d]", null == list ? 0 : list.size()));
		
		if(null == list || 0 == list.size()) return;
		
		for(AreasCode code : list) {
			if(code.isProvince()) {
				continue;
			}
			
			int areaMaxBar = 0;
			int areaMaxPc = 0;
			
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("areaCode", code.getAreasid());
			if(code.isCity()) {
				areaMaxBar = netBarDao.countCityBar(params);
				areaMaxPc = netBarDao.countCityPc(params);
			} else if(code.isArea()) {
				areaMaxBar = netBarDao.countAreaBar(params);
				areaMaxPc = netBarDao.countAreaPc(params);
			}
			
			StatAreaInstance instance = STAT_AREA_INSTANCE_CACHER.get(code.getAreasid());
			if(null == instance) {
				instance = StatAreaInstance.newOne(code, areaMaxBar, areaMaxPc);
				STAT_AREA_INSTANCE_CACHER.put(code.getAreasid(), instance);
			}
			
			instance.setAreaMaxBar(areaMaxBar);
			instance.setAreaMaxPc(areaMaxPc);
		}
	}
	
	public static StatAreaInstance get(String code) {
		return STAT_AREA_INSTANCE_CACHER.get(code);
	}
	
	public static StatAreaInstance put(String code, StatAreaInstance instance) {
		return STAT_AREA_INSTANCE_CACHER.put(code, instance);
	}
	
	public static Collection<StatAreaInstance> values() {
		return STAT_AREA_INSTANCE_CACHER.values();
	}
	
	/**
	 * 给指定区域增加登录人数
	 * @param barId 网吧注册号
	 * @param login
	 */
	public static void update(String barId, int login) {
		
		String areaCode = BarIdUtils.getAreaCode(barId);
		
		StatAreaInstanceArea areaInstance = (StatAreaInstanceArea)STAT_AREA_INSTANCE_CACHER.get(areaCode);
		
		areaInstance.updateLogin(barId, login);
		
		StatAreaInstance parent = STAT_AREA_INSTANCE_CACHER.get(BarIdUtils.getCityCode(barId));
		
		logger.info(
				String.format(
						"##Login added. Area:[%s %s] now login is [%d], City:[%s %s] now login is [%d]", 
						areaCode,
						areaInstance.getName(),
						areaInstance.getLoginTotal(),
						parent.getCode(),
						parent.getName(),
						parent.getLoginTotal()
						));
		
	}
	
	/**
	 * 返回所有城市的实时信息
	 * @return
	 */
	public static List<StatAreaInstance> getAllCity() {
		Collection<StatAreaInstance> areas = STAT_AREA_INSTANCE_CACHER.values();
		
		List<StatAreaInstance> targetList = new ArrayList<>();
		for(StatAreaInstance area : areas) {
			if(!area.isCity()) continue;
			targetList.add(area);
		}
		return targetList;
	}
	
	/**
	 * 返回指定城市所属区的实时信息
	 * @param cityCode
	 * @return
	 */
	public static List<StatAreaInstance> getAllArea(String cityCode) {

		if(null == cityCode) return null;
		StatAreaInstance city = STAT_AREA_INSTANCE_CACHER.get(cityCode);

		StatAreaInstanceCity areasCity = (StatAreaInstanceCity)city;
		return areasCity.getAreas();
	}
	
	public static void activeBar(String barId) {
		if(!BarIdUtils.isValid(barId)) {
			logger.warn(String.format("##Invalid barId: %s", barId));
			return;
		}
		String areaCode = BarIdUtils.getAreaCode(barId);
		String cityCode = BarIdUtils.getCityCode(barId);
		
		StatAreaInstance areaInstance = StatAreaInstanceCacher.get(areaCode);
		StatAreaInstance cityInstance = StatAreaInstanceCacher.get(cityCode);
		
		int areaCurrent = 0;
		if(null != areaInstance) {
			areaCurrent = areaInstance.online(barId);
		}
		int cityCurrent = 0;
		if(null != cityInstance) {
			 cityCurrent = cityInstance.online(barId);
		}
		
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

	public static void inactiveBar(String barId) {
		if(!BarIdUtils.isValid(barId)) {
			logger.warn(String.format("##Invalid barId: %s", barId));
			return;
		}
		
		String areaCode = BarIdUtils.getAreaCode(barId);
		String cityCode = BarIdUtils.getCityCode(barId);
		
		StatAreaInstance areaInstance = StatAreaInstanceCacher.get(areaCode);
		StatAreaInstance cityInstance = StatAreaInstanceCacher.get(cityCode);
		
		int areaCurrent = 0;
		if(null != areaInstance) {
			areaCurrent = areaInstance.offline(barId);
		}
		int cityCurrent = 0;
		if(null != cityInstance) {
			 cityCurrent = cityInstance.offline(barId);
		}
		
		
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

	public AreasCodeDao getAreasCodeDao() {
		return areasCodeDao;
	}

	public void setAreasCodeDao(AreasCodeDao areasCodeDao) {
		this.areasCodeDao = areasCodeDao;
	}

	public NetBarDao getNetBarDao() {
		return netBarDao;
	}

	public void setNetBarDao(NetBarDao netBarDao) {
		this.netBarDao = netBarDao;
	}

	public StatAreaDao getStatAreaDao() {
		return statAreaDao;
	}

	public void setStatAreaDao(StatAreaDao statAreaDao) {
		this.statAreaDao = statAreaDao;
	}
	
}
