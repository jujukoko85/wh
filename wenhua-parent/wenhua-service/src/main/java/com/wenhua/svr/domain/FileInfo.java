package com.wenhua.svr.domain;

import java.util.Date;

import com.wenhua.svr.domain.base.BaseFileInfo;

public class FileInfo extends BaseFileInfo {

	public static FileInfo newOne(String fileName, Integer currentUser) {
		FileInfo file = new FileInfo();
		file.setFilename(fileName);
		file.setCreator(currentUser);
		file.setLastModifier(currentUser);
		Date now = new Date();
		file.setLastModifyTime(now);
		file.setCreateTime(now);
		
		return file;
	}
}
