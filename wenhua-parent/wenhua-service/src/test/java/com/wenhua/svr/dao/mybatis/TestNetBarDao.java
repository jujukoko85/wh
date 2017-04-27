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
	public void test0() {
		NetBar bar = NetBar.newOne("4101020001", "1234567890", "me");
		netBarDao.insert(bar);
		
	}
	
	@Test
	public void test1() {
		System.out.println(netBarDao);
		NetBar target = netBarDao.selectByPrimaryKey("4101020001");
		System.out.println(target.getAreaCode());
		target.setServerVersion("V1.0");
		target.setClientVersion("V2.0");
		
		netBarDao.updateByPrimaryKey(target);
	}
	
	@Test
	public void test2() {
		NetBar target = netBarDao.selectByPrimaryKey("4101020001");
		System.out.println(target.getContactName());
	}
}
