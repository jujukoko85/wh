package com.wenhua.svr.domain;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实时区域信息
 * 
 * @author zhuzhaohua
 *
 */
public class StatAreaInstance {

	private AreasCode area;
	
	private AtomicInteger online = new AtomicInteger(0);
	/** 区域内网吧数 */
	private int areaMaxBar = 0;
	/** 区域内PC数 */
	private int areaMaxPc = 0;
	/** 区内用户数 */
	private int areaLogin = 0;
	
	private StatAreaInstance() {
	}
	
	/**
	 * 创建1个区域实时信息
	 * @param area
	 * @param areaMaxBar
	 * @param areaMaxPc
	 * @return
	 */
	public static StatAreaInstance newOne(AreasCode area, int areaMaxBar, int areaMaxPc) {
		StatAreaInstance sai = new StatAreaInstance();
		sai.setArea(area);
		sai.setAreaMaxBar(areaMaxBar);
		sai.setAreaMaxPc(areaMaxPc);
		return sai;
	}
	
	public void setArea(AreasCode area) {
		this.area = area;
	}
	
	public boolean isProvince() {
		return this.area.isProvince();
	}
	
	public boolean isCity() {
		return this.area.isCity();
	}
	
	public boolean isArea() {
		return this.area.isArea();
	}

	/**
	 * 上线1个网吧
	 * @param barId
	 * @return
	 */
	public int online(String barId) {
		return this.online.incrementAndGet();
	}
	
	/**
	 * 下线1个网吧
	 * @param barId
	 * @return
	 */
	public int offline(String barId) {
		return this.online.decrementAndGet();
	}

	public String getCode() {
		return this.area.getAreasid();
	}

	public AtomicInteger getOnline() {
		return online;
	}

	public void setOnline(AtomicInteger online) {
		this.online = online;
	}

	public int getAreaMaxBar() {
		return areaMaxBar;
	}

	public void setAreaMaxBar(int areaMaxBar) {
		this.areaMaxBar = areaMaxBar;
	}

	public int getAreaMaxPc() {
		return areaMaxPc;
	}

	public void setAreaMaxPc(int areaMaxPc) {
		this.areaMaxPc = areaMaxPc;
	}

	public String getName() {
		return this.area.getAreasname();
	}

	public String getRankno() {
		return this.area.getRankno();
	}

	public int getAreaLogin() {
		return areaLogin;
	}

	public void setAreaLogin(int areaLogin) {
		this.areaLogin = areaLogin;
	}

}
