package com.wenhua.svr.dao;

import java.util.Map;

import com.wenhua.svr.domain.StatNetBar;
import com.wenhua.svr.domain.base.BaseStatNetBarKey;

public interface StatNetBarDao {

	int deleteByPrimaryKey(BaseStatNetBarKey key);

    int insert(StatNetBar record);

    int insertSelective(StatNetBar record);

    StatNetBar selectByPrimaryKey(BaseStatNetBarKey key);

    int updateByPrimaryKeySelective(StatNetBar record);

    int updateByPrimaryKey(StatNetBar record);
    
    int countAreaDaily(Map<String, Object> params);
    
    int countCityDaily(Map<String, Object> params);
}