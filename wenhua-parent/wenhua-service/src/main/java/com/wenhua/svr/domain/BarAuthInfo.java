package com.wenhua.svr.domain;

import java.io.UnsupportedEncodingException;

import com.wenhua.util.tools.Md5Util;
import com.wenhua.util.tools.NumberUtil;

/**
 * 网吧认证信息
 * 
 * @author zhuzhaohua
 *
 */
public class BarAuthInfo {

	private int barId;
	private String when;
	private String sign;
	
	/**
	 * 检查sign与网吧信息是否合法
	 * @param key
	 * @return
	 */
	public boolean isValid(String key) {
		
		if(null == getSign() || 0 == getSign().length()) {
			return false;
		}
		String targetMD5 = getMD5(key);
		
		if(!getSign().equals(targetMD5)) {
			return false;
		}
		return true;
	}

	private String getMD5(String key) {
		String targetMD5 = Md5Util.getMD5HexString(getByteArray(getBarId(), getWhen(), key));
		return targetMD5.toUpperCase();
	}
	
	/**
	 * 计算签名信息
	 * @param barId
	 * @param when
	 * @param key
	 * @return
	 */
	public static byte[] getByteArray(Integer barId, String when, String key) {
		
		if(null == barId || null == when || null == key) {
			return null;
		}
		
		String target = barId + when + key;
		
		try {
			return target.getBytes("gbk");
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	public BarAuthInfo(int barId, String when, String sign) {
		super();
		this.barId = barId;
		this.when = when;
		this.sign = sign;
	}

	public int getBarId() {
		return barId;
	}

	public void setBarId(int barId) {
		this.barId = barId;
	}

	public String getWhen() {
		return when;
	}

	public void setWhen(String when) {
		this.when = when;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

}
