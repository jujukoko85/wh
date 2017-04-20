package com.wenhua.svr.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.wenhua.svr.domain.BarAuthInfo;
import com.wenhua.svr.domain.BarConfig;
import com.wenhua.svr.domain.BarFileBar;
import com.wenhua.svr.domain.BarFileInfo;
import com.wenhua.svr.domain.BarPcInfo;
import com.wenhua.svr.domain.BarPcInstantInfo;
import com.wenhua.svr.domain.BarServerInfo;
import com.wenhua.svr.domain.BarSoftwareVersion;
import com.wenhua.svr.exception.AuthBarNotExistException;
import com.wenhua.svr.exception.AuthSignNotValidException;
import com.wenhua.svr.service.AuthService;

@Service("authService")
public class AuthServiceImpl implements AuthService {

	@Override
	public void auth(BarAuthInfo barAuthInfo) throws AuthBarNotExistException, AuthSignNotValidException {
		if(null == barAuthInfo) throw new AuthBarNotExistException();
		
		//TODO 获取 KEY
		
		if(!barAuthInfo.isValid("hn123wh")) {
			throw new AuthSignNotValidException();
		}
	}

	@Override
	public BarConfig getBarConfig(int barId) throws AuthBarNotExistException {
		
		//TODO 获取网吧配置信息
		
		BarConfig config = new BarConfig();
		config.setFreqInstantPcInfo(60);
		return config;
	}

	@Override
	public void setServerInfo(BarServerInfo barServerInfo) throws AuthBarNotExistException {
		// TODO 保存网吧服务器信息
		
	}

	@Override
	public void updatePcInfoList(List<BarPcInfo> barPcInfoList) {
		// TODO 更新网吧PC信息
		
	}

	@Override
	public void updatePcInstantInfoList(List<BarPcInstantInfo> barPcInstantInfoList) {
		// TODO 更新网吧实时PC信息
		
	}

	@Override
	public List<BarFileInfo> getBarFileInfoList(BarSoftwareVersion version) {
		// TODO 重新实现
		List<BarFileInfo> list = Lists.newArrayList();
		BarFileInfo bfb1 = new BarFileInfo();
		bfb1.setAction(1);
		bfb1.setApplyAllBar(true);
		bfb1.setFileName("fileName");
		bfb1.setFlag(1);
		bfb1.setId(222);
		bfb1.setMd5("md5");
		bfb1.setType(1);
		bfb1.setVersion("version");
		
		list.add(bfb1);
		
		return list;
	}

	@Override
	public List<BarFileBar> getBarFileBarList(BarSoftwareVersion version) {
		//TODO 重新实现
		
		List<BarFileBar> list = Lists.newArrayList();
		BarFileBar bfb1 = new BarFileBar();
		bfb1.setFileId(222);
		
		List<Integer> barIds = Lists.newArrayList();
		barIds.add(1);
		barIds.add(2222);
		
		bfb1.setBarIdList(barIds);
		
		list.add(bfb1);
		return list;
	}

}
