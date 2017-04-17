package com.wenhua.svr.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wenhua.svr.dao.AccountDao;
import com.wenhua.svr.domain.Account;
import com.wenhua.svr.exception.AccountNameExistException;
import com.wenhua.svr.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	
	private AccountDao accountDao;

	@Override
	public Account getByAccountName(String name) {
		System.out.println(name);
		return null;
	}

	@Override
	public void addAccount(Account account) throws AccountNameExistException {
		
	}

	@Resource
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

}
