package com.wenhua.svr.component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wenhua.svr.domain.StatAreaInstanceCity;
import com.wenhua.svr.dao.AreasCodeDao;
import com.wenhua.svr.dao.NetBarDao;
import com.wenhua.svr.domain.AreasCode;
import com.wenhua.svr.domain.StatAreaInstance;
import com.wenhua.svr.domain.StatAreaInstanceArea;
import com.wenhua.util.BarIdUtils;

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
	
	public StatAreaInstanceCacher() {
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
				logger.warn(String.format("##Found unexpected area code: [%s] name: [%s]", code.getAreasid(), code.getAreasname()));
				continue;
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
	
}
