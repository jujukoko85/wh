package com.wenhua.svr.server.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.wenhua.svr.domain.BarPcInstantInfo;
import com.wenhua.svr.service.StatService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app-context.xml")
@Rollback(false)
@Transactional
public class TestStatServiceImpl {

	@Resource
	private StatService statService;
	
	@Test
	public void test1() {
		
		System.out.println(statService);
		BarPcInstantInfo b1 = BarPcInstantInfo.newOne("AA-BB-CC-DD-EE-01", true, false, true, 30, 30);
		BarPcInstantInfo b2 = BarPcInstantInfo.newOne("AA-BB-CC-DD-EE-02", false, false, true, 30, 30);
		BarPcInstantInfo b3 = BarPcInstantInfo.newOne("AA-BB-CC-DD-EE-03", false, false, true, 30, 30);
		
		List<BarPcInstantInfo> list = new ArrayList<>();
		list.add(b1);
		list.add(b2);
		list.add(b3);
		
//		statService.updateBarInstanceInfo("1000001", list);
	}
}












