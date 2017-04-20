package com.wenhua.svr.domain;

/**
 * 网吧服务器信息
 * @author zhuzhaohua
 *
 */
public class BarServerInfo {

	private String mac;
	private String ip;
	private String pcName;
	/** 操作系统类型 0-windows, 1-macos, 2-android, 3-linux */
	private int osType;
	private String osVersion;
	
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getPcName() {
		return pcName;
	}
	public void setPcName(String pcName) {
		this.pcName = pcName;
	}
	public int getOsType() {
		return osType;
	}
	public void setOsType(int osType) {
		this.osType = osType;
	}
	public String getOsVersion() {
		return osVersion;
	}
	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}
	
}
