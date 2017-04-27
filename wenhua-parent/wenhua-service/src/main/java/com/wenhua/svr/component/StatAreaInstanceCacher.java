package com.wenhua.svr.component;

import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wenhua.svr.domain.StatAreaInstance;
import com.wenhua.util.BarIdUtils;

/**
 * 区域的实时信息缓存 在线网吧数  离线网吧数 登录人数
 * @author zhuzhaohua
 *
 */
public class StatAreaInstanceCacher {
	
	private static Logger logger = LoggerFactory.getLogger(StatAreaInstanceCacher.class);

	private static final Map<String, StatAreaInstance> STAT_AREA_INSTANCE_CACHER = new ConcurrentHashMap<String, StatAreaInstance>();
	
	/** 区域代码 : 该区域登录人数 */
	private static final Map<String, AtomicInteger> AREA_LOGIN_CACHER = new ConcurrentHashMap<String, AtomicInteger>();
	
	private StatAreaInstanceCacher() {
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
	public static void addLogin(String barId, int login) {
		
		String cityCode = BarIdUtils.getCityCode(barId);
		
		AtomicInteger currentCity = AREA_LOGIN_CACHER.get(cityCode);
		synchronized (AREA_LOGIN_CACHER) {
			if(null == currentCity) currentCity = new AtomicInteger(0);
			AREA_LOGIN_CACHER.put(cityCode, currentCity);
		}
		
		int nowCity = currentCity.addAndGet(login);
		logger.info(String.format("##Login added. [%s] now is [%d]", cityCode, nowCity));
		
		String areaCode = BarIdUtils.getAreaCode(barId);
		
		AtomicInteger currentArea = AREA_LOGIN_CACHER.get(areaCode);
		synchronized (AREA_LOGIN_CACHER) {
			if(null == currentArea) currentCity = new AtomicInteger(0);
			AREA_LOGIN_CACHER.put(cityCode, currentArea);
		}
		
		int nowArea = currentCity.addAndGet(login);
		logger.info(String.format("##Login added. [%s] now is [%d]", areaCode, nowArea));
	}
	
	public static void clearLoginCache() {
		AREA_LOGIN_CACHER.clear();
		logger.info("##Clear the AREA_LOGIN_CACHER");
	}
	
//	/**
//	 * 给指定区域减少登录人数
//	 * @param barId 网吧注册号
//	 * @param logout
//	 */
//	public static void addLogout(String barId, int logout) {
//		String cityCode = BarIdUtils.getCityCode(barId);
//		AtomicInteger currentCity = AREA_LOGIN_CACHER.get(cityCode);
//		int now = currentCity.addAndGet(-logout);
//		logger.info(String.format("##Login removed. [%s] is [%d]", cityCode, now));
//	}
}
