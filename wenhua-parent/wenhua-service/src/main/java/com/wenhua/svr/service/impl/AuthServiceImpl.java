package com.wenhua.svr.service.impl;

import org.springframework.stereotype.Service;

import com.wenhua.svr.domain.BarAuthInfo;
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

}
