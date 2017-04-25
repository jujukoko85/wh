package com.wenhua.svr.dao.mybatis;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.wenhua.svr.dao.StatNetBarDao;
import com.wenhua.svr.domain.StatNetBar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app-context.xml")
@Rollback(false)
@Transactional
public class TestStatNetBarDao {

	@Resource
	private StatNetBarDao statNetBarDao;
	
	@Test
	public void test1() {
		System.out.println(statNetBarDao);
		
		StatNetBar newOne = StatNetBar.newOne(1234567890, new Date(), 10, 2, 1);
		
		statNetBarDao.insert(newOne);
	}
	
	@Test
	public void test2() {
		StatNetBar newOne = StatNetBar.newOne(1234567890, new Date(), 101, 12, 11);
		statNetBarDao.updateByPrimaryKey(newOne);
	}
}
