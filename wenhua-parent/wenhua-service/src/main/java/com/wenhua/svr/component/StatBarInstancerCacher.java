package com.wenhua.svr.component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wenhua.svr.domain.AreasCode;
import com.wenhua.svr.domain.BarPcInstantInfo;
import com.wenhua.svr.domain.NetBar;
import com.wenhua.svr.domain.StatBarInstance;
import com.wenhua.svr.domain.StatNetBar;
import com.wenhua.svr.service.AuthService;
import com.wenhua.util.tools.DateUtils;

/**
 * 实时 网吧的 线终端数 离线终端数 有效终端数 登录人数 缓存
 * @author zhuzhaohua
 *
 */
public class StatBarInstancerCacher {

	private static final Logger logger = LoggerFactory.getLogger(StatBarInstancerCacher.class);
	
	/** BarId : 网吧实时信息 */
	private static final Map<String, StatBarInstance> barInstanceCacher = new ConcurrentHashMap<String, StatBarInstance>();
	
	/** 单位分钟 文化客户端需要运行的时间 */
	private static int wenhuaDuration = 60;
	
	private AuthService authService;
	
	public StatBarInstancerCacher() {
	}
	
	/**
	 * 新增 or 更新 缓存
	 * @param bar
	 */
	public static void addOrUpdate(NetBar bar) {
		StatBarInstance instance = barInstanceCacher.get(bar.getId());
		if(null == instance) {
			barInstanceCacher.put(bar.getId(), StatBarInstance.newOne(bar.getId(), bar.getNetBarName(), bar.getServerVersion(), bar.getClientVersion()));
		} else {
			instance.setClientVersion(bar.getClientVersion());
			instance.setServerVersion(bar.getServerVersion());
			instance.setBarName(bar.getNetBarName());
		}
	}
	
	/**
	 * 获取指定区域的网吧实时信息列表
	 * @param areaCode
	 * @return
	 */
	public static List<StatBarInstance> getBarInArea(String areaCode) {

		List<StatBarInstance> list = new ArrayList<StatBarInstance>();
		if(null == areaCode || !AreasCode.isValidCode(areaCode)) return list;
		
		Set<String> barIds = barInstanceCacher.keySet();
		for(String barId : barIds) {
			
			if(!AreasCode.isBelong(areaCode, barId)) continue;
			
			list.add(barInstanceCacher.get(barId));
		}
		
		return list;
	}
	
	/**
	 * 初始化所有网吧信息 系统启动时运行
	 */
	public void init() {
		logger.info("###############################");
		logger.info("##Begin get all net bar info.");
		List<NetBar> bars = authService.getAllBar();
		logger.info(String.format("##update the bar cache [%d]", null == bars ? 0 : bars.size()));
		
		if(null == bars || 0 == bars.size()) return;
		
		for(NetBar bar : bars) {
			barInstanceCacher.put(bar.getId(), StatBarInstance.newOne(bar.getId(), bar.getNetBarName(), bar.getServerVersion(), bar.getClientVersion()));
		}
	}
	
	/**
	 * 每天重置当天的最大值
	 */
	public void resetMax() {
		logger.info("###############################");
		
		Collection<StatBarInstance> instances = barInstanceCacher.values();
		logger.info(String.format("##Rest the max value of bar instance. Instance size is [%d]", null == instances ? 0 : instances.size()));
		
		for(StatBarInstance instance : instances) {
			instance.clearMax();
		}
		logger.info("##Rest the max value of bar instance over.");
	}
	
	/**
	 * 定时將实时信息中的最大值保存到数据库中
	 */
	public void save() {
		logger.info("###############################");
		Collection<StatBarInstance> instances = barInstanceCacher.values();
		logger.info(String.format("##Update the max value of bar instance into database. Bar size is [%d]", null == instances ? 0 : instances.size()));
		
		if(null == instances || 0 == instances.size()) return;
		
		Date today = DateUtils.getChinaDay();
		for(StatBarInstance instance : instances) {
			StatNetBar old = authService.getStatNetBarById(instance.getBarId(), today);
			
			if(null == old) {
				authService.saveStatNetBar(
						StatNetBar.newOne(
								instance.getBarId(), 
								today, 
								instance.getMaxOnline(), 
								instance.getMaxOffline(), 
								instance.getMaxValid(), 
								instance.getMaxLogin()));
			} else {
				old.setOnline(old.getOnline() > instance.getMaxOnline() ? old.getOnline() : instance.getMaxOnline());
				old.setOffline(old.getOffline() > instance.getOffline() ? old.getOffline() : instance.getMaxOffline());
				old.setValid(old.getValid() > instance.getMaxValid() ? old.getValid() : instance.getMaxValid());
				old.setLogin(old.getLogin() > instance.getMaxLogin() ? old.getLogin() : instance.getLogin());
				authService.updateStatNetBar(old);
			}
			
		}
		logger.info("##Update the max value of bar instance into database over.");
	}
	
	/**
	 * 更新指定网吧的信息
	 * @param barId
	 * @param infos
	 */
	public static StatBarInstance updateCache(String barId, List<BarPcInstantInfo> infos) {
		
		StatBarInstance barInstance = barInstanceCacher.get(barId);
		
		if(null == barInstance) {
			logger.warn(String.format("##Found unexcepted barId: [%s], the bar is not in the cacher", barId));
			return null;
		}
		barInstance.update(infos, wenhuaDuration);
		return barInstance;
		
	}
	
	public int getWenhuaDuration() {
		return wenhuaDuration;
	}

	public void setWenhuaDuration(int wenhuaDuration) {
		StatBarInstancerCacher.wenhuaDuration = wenhuaDuration;
	}

	public AuthService getAuthService() {
		return authService;
	}

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
}
