package com.wenhua.svr.service;

import org.junit.Test;

import com.wenhua.svr.exception.FileNotExistException;
import com.wenhua.svr.exception.SystemException;
import com.wenhua.svr.service.impl.AuthServiceImpl;
import com.wenhua.util.ByteUtil;

public class TestGetFile {

	@Test
	public void test1() throws FileNotExistException, SystemException {
		AuthService service = new AuthServiceImpl();
		byte[] target = service.getFileById(123);
		System.out.println(ByteUtil.bytes2hex(target));
		System.out.println(target.length);
	}
}
