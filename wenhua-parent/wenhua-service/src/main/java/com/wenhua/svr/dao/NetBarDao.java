package com.wenhua.svr.dao;

import com.wenhua.svr.domain.NetBar;
import com.wenhua.svr.domain.base.BaseNetBar;

public interface NetBarDao {
    int deleteByPrimaryKey(String id);

    int insert(BaseNetBar record);

    int insertSelective(BaseNetBar record);

    NetBar selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BaseNetBar record);

    int updateByPrimaryKey(BaseNetBar record);
    
    NetBar selectByBarId(String barId);
}