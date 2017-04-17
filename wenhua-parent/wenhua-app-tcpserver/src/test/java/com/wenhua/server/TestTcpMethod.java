package com.wenhua.server;

import org.junit.Test;
import static org.junit.Assert.*;


public class TestTcpMethod {

	@Test
	public void test1() {
		assertEquals("Authentication", TcpMethod.Authentication.toString());
	}
}
