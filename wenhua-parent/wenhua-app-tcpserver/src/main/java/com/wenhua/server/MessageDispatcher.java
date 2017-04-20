package com.wenhua.server;

/**
 * 消息分发处理
 * 
 * @author zhuzhaohua
 *
 */
public class MessageDispatcher {

	private static MessageDispatcher instance = new MessageDispatcher();

	public static MessageDispatcher getInstance() {
		return instance;
	}
	
	
}
