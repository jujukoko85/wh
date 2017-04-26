package com.wenhua.svr.service;

import java.util.Date;
import java.util.List;

import com.wenhua.svr.domain.BarPcInstantInfo;

/**
 * 统计服务
 * @author zhuzhaohua
 *
 */
public interface StatService {

	public void countBarDaily(String barId, List<BarPcInstantInfo> infos);
	
	public void countAreaDaily(String areaCode, Date statDate);
	
	public void countAreaDaily();
}
