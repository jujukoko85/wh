package com.wenhua.svr.domain;

import java.util.List;

public class BarFileBar {

	// 文件ID
	private int fileId;
	// 该文件应用到的网吧列表
	List<Integer> barIdList;

	public int getFileId() {
		return fileId;
	}

	public void setFileId(int fileId) {
		this.fileId = fileId;
	}

	public List<Integer> getBarIdList() {
		return barIdList;
	}

	public void setBarIdList(List<Integer> barIdList) {
		this.barIdList = barIdList;
	}

}
