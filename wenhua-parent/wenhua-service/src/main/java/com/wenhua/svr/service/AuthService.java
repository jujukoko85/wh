package com.wenhua.svr.service;

import com.wenhua.svr.domain.BarAuthInfo;
import com.wenhua.svr.exception.AuthBarNotExistException;
import com.wenhua.svr.exception.AuthSignNotValidException;

/**
 * 验证接口
 * @author zhuzhaohua
 *
 */
public interface AuthService {

	/**
	 * 检查客服端认证请求是否通过
	 * @param barAuthInfo
	 * @throws AuthBarNotExistException
	 * @throws AuthSignNotValidException
	 */
	public void auth(BarAuthInfo barAuthInfo) throws AuthBarNotExistException, AuthSignNotValidException;
}
