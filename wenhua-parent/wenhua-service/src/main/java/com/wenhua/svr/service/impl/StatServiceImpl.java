package com.wenhua.svr.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.wenhua.svr.dao.StatNetBarDao;
import com.wenhua.svr.domain.BarPcInstantInfo;
import com.wenhua.svr.domain.StatNetBar;
import com.wenhua.svr.service.StatService;
import com.wenhua.util.tools.DateUtils;

public class StatServiceImpl implements StatService {
	
	private Map<String, StatNetBar> netBarCache = new ConcurrentHashMap<String, StatNetBar>();
	
	private Map<String, Set<String>> areaBarCache = new ConcurrentHashMap<>();
	
	/** 文化客户端运行多少分钟 认为已运行 */
	private Integer wenhuaDuration = 30;
	
	private StatNetBarDao statNetBarDao;
	
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
		for(BarPcInstantInfo info : infos) {
			if(info.isPowerOn()) {
				online++;
			} else {
				offline++;
			}
			
			if(info.isRunWenhua() && info.getWenhuaDuration() >= wenhuaDuration) {
				valid++;
			}
		}
		StatNetBar current = StatNetBar.newOne(barId, DateUtils.getChinaToday(), online, offline, valid);
		return current;
	}

	@Override
	public void countAreaDaily(String barId) {
		if(null == barId || 10 != barId.length()) return;
		
//		String provinceCode = barId.substring(0, 2);
		String cityCode = barId.substring(2, 4);
		String areaCode = barId.substring(4, 6);
		
		Set<String> citySet = areaBarCache.get(cityCode);
		if(null == citySet) {
//			citySet = new Concurrent
		}
		
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

}
