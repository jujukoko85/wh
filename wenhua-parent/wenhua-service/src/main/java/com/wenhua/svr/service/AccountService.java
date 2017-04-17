package com.wenhua.svr.service;

import org.springframework.transaction.annotation.Transactional;

import com.wenhua.svr.domain.Account;
import com.wenhua.svr.exception.AccountNameExistException;

public interface AccountService {

	/**
	 * 根据登录名查询账户信息
	 * @param name
	 * @return
	 */
	@Transactional(readOnly = true)
	public Account getByAccountName(String name);
	
	@Transactional
	public void addAccount(Account account) throws AccountNameExistException;
}
