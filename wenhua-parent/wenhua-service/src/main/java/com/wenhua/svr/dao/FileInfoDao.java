package com.wenhua.svr.dao;

import com.wenhua.svr.domain.FileInfo;

public interface FileInfoDao {

	int deleteByPrimaryKey(Long id);

    int insert(FileInfo record);

    int insertSelective(FileInfo record);

    FileInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FileInfo record);

    int updateByPrimaryKeyWithBLOBs(FileInfo record);

    int updateByPrimaryKey(FileInfo record);
}