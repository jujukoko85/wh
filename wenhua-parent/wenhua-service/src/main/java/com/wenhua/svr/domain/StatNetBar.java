package com.wenhua.svr.domain;

import java.util.Date;

import com.wenhua.svr.domain.base.BaseStatNetBar;
import com.wenhua.svr.domain.base.BaseStatNetBarKey;

public class StatNetBar extends BaseStatNetBar {
	
	private StatNetBar() {
	}
	
	/**
	 * 产生ID
	 * @param barId
	 * @param statDate
	 * @return
	 */
	public static BaseStatNetBarKey generateId(String barId, Date statDate) {
		BaseStatNetBarKey id = new BaseStatNetBarKey();
		id.setBarId(barId);
		id.setStatDate(statDate);
		return id;
	}
	
	/**
	 * 创建统计信息
	 * @param barId
	 * @param statDate
	 * @param online
	 * @param offline
	 * @param valid
	 * @return
	 */
	public static StatNetBar newOne(int barId, Date statDate, int online, int offline, int valid) {
		StatNetBar s = new StatNetBar();
		s.setBarId(String.valueOf(barId));
		s.setStatDate(statDate);
		s.setOnline(online);
		s.setOffline(offline);
		s.setValid(valid);
		return s;
	}
	
	/**
	 * 比较两个状态, 获取更新后的状态
	 * @param old 老状态
	 * @return 返回null 则状态不需要更新
	 */
	public StatNetBar compare(StatNetBar old) {
		if(null == old) return null;
		
		int online = 0;
		int offline = 0;
		int valid = 0;
		boolean needUpdate = false;
		
		if(this.getOnline() > old.getOnline()) {
			online = this.getOnline();
			needUpdate = needUpdate | true;
		} else {
			online = old.getOnline();
			needUpdate = needUpdate | false;
		}
		
		if(this.getOffline() < old.getOffline()) {
			offline = this.getOffline();
			needUpdate = needUpdate | true;
		} else {
			offline = old.getOffline();
			needUpdate = needUpdate | false;
		}
		
		if(this.getValid() > old.getValid()) {
			valid = this.getValid();
			needUpdate = needUpdate | true;
		} else {
			valid = old.getValid();
			needUpdate = needUpdate | false;
		}
		
		if(!needUpdate) return null;
		
		return StatNetBar.newOne(this.getIntBarId(), this.getStatDate(), online, offline, valid);
	}
	
	/**
	 * 获取BarId的整数型
	 * @return
	 */
	public Integer getIntBarId() {
		return Integer.parseInt(getBarId());
	}
}
