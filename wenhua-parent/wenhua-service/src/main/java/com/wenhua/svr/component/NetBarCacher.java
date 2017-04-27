package com.wenhua.svr.component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.wenhua.svr.domain.StatNetBar;

/**
 * 实时 网吧的 线终端数 离线终端数 有效终端数 登录人数 缓存
 * @author zhuzhaohua
 *
 */
public class NetBarCacher {

	/** BarId : 网吧实时信息 */
	private static final Map<String, StatNetBar> netBarCache = new ConcurrentHashMap<String, StatNetBar>();
	
	private NetBarCacher() {
	}
	
	public static StatNetBar get(String barId) {
		return netBarCache.get(barId);
	}
	
	public static void put(String barId, StatNetBar statNetBar) {
		netBarCache.put(barId, statNetBar);
	}
	
	public static StatNetBar remove(String barId) {
		return netBarCache.remove(barId);
	}
}
