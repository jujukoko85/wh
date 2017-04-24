package com.wenhua.svr.dao.mybatis;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.wenhua.svr.dao.NetBarDao;
import com.wenhua.svr.domain.NetBar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app-context.xml")
@Rollback(false)
@Transactional
public class TestNetBarDao {

	@Resource
	private NetBarDao netBarDao;
	
	@Test
	public void test1() {
		System.out.println(netBarDao);
		NetBar target = netBarDao.selectByPrimaryKey("4101020001");
		System.out.println(target.getAddressCode());
	}
	
	@Test
	public void test2() {
		NetBar target = netBarDao.selectByPrimaryKey("4101020001");
		System.out.println(target.getContactName());
	}
}
