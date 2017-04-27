package com.wenhua.svr.domain;

import com.wenhua.svr.domain.base.BaseAreasCode;
import com.wenhua.util.BarIdUtils;

public class AreasCode extends BaseAreasCode {

	/** 省 */
	public static final String RANK_NO_PROVINCE = "1";
	/** 市 */
	public static final String RANK_NO_CITY = "2";
	/** 区 */
	public static final String RANK_NO_AREA = "3";
	
	public static final int LENGTH = 6;
	
	public boolean isProvince() {
		return RANK_NO_PROVINCE.equals(this.getRankno());
	}
	
	public boolean isCity() {
		return RANK_NO_CITY.equals(this.getRankno());
	}
	
	public boolean isArea() {
		return RANK_NO_AREA.equals(this.getRankno());
	}
	
	/**
	 * 代码是否合法
	 * @param code
	 * @return
	 */
	public static boolean isValidCode(String code) {
		
		if(null == code) return false;
		
		return LENGTH == code.length();
	}
	
	/**
	 * 指定区域 是否属于本区域
	 * @param code
	 * @return
	 */
	public boolean isMine(AreasCode area) {
		return this.isMine(area.getAreasid());
	}
	
	/**
	 * 指定区域代码 是否属于本区域
	 * @param code
	 * @return
	 */
	public boolean isMine(String code) {

		if(null == code) return false;
		if(!isValidCode(code)) return false;
		
		if(isArea()) {
			return this.getAreasid().equals(code);
		}
		
		if(isCity()) {
			return this.getAreasid().substring(0, 4).equals(code.substring(0, 4));
		}
		
		if(isProvince()) {
			return this.getAreasid().substring(0, 2).equals(code.substring(0, 2));
		}
		
		return false;
	}
	
	/**
	 * 指定网吧注册号 是否属于本区域
	 * @param barId
	 * @return
	 */
	public boolean isBarMine(String barId) {
		if(!BarIdUtils.isValid(barId)) return false;
		
		// 获取网吧区一级的区域代码
		String areaCode = BarIdUtils.getAreaCode(barId);
		
		return isMine(areaCode);
	}
}
