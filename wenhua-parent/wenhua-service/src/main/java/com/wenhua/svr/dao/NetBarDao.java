package com.wenhua.svr.dao;

import com.wenhua.svr.domain.NetBar;

public interface NetBarDao {
    int deleteByPrimaryKey(String id);

    int insert(NetBar record);

    int insertSelective(NetBar record);

    NetBar selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(NetBar record);

    int updateByPrimaryKey(NetBar record);
}