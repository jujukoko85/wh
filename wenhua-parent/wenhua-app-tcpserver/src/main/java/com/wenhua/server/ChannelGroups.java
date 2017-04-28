package com.wenhua.server;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.ChannelGroupFuture;
import io.netty.channel.group.ChannelMatcher;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class ChannelGroups {

	private static final ChannelGroup CHANNEL_GROUP = new DefaultChannelGroup("ChannelGroups",
			GlobalEventExecutor.INSTANCE);
	
	private static final Map<String, AtomicInteger> ipConnectCounter = new ConcurrentHashMap<>();
	
	private static Logger logger = LoggerFactory.getLogger(ChannelGroups.class);

	public static void add(ChannelHandlerContext ctx) {
		Channel channel = ctx.channel();
		CHANNEL_GROUP.add(channel);
		
		String remoteIp = ChannelHandlerWenhuaMsg.getRemoteIp(ctx);
		
		AtomicInteger counter = null;
		synchronized (ipConnectCounter) {
			counter = ipConnectCounter.get(remoteIp);
			if(null == counter) {
				counter = new AtomicInteger(0);
				ipConnectCounter.put(remoteIp, counter);
			}
		}
		int c = counter.incrementAndGet();
		
		
		
		logger.info(String.format("##Channel: %s is added into ChannelGroups, current size: %d. The connect num of Ip: [%s] is [%d]", channel.id().asLongText(), CHANNEL_GROUP.size(), remoteIp, c));
	}

	public static ChannelGroupFuture broadcast(Object msg) {
		return CHANNEL_GROUP.writeAndFlush(msg);
	}

	public static ChannelGroupFuture broadcast(Object msg, ChannelMatcher matcher) {
		return CHANNEL_GROUP.writeAndFlush(msg, matcher);
	}

	public static ChannelGroup flush() {
		return CHANNEL_GROUP.flush();
	}

	public static boolean discard(ChannelHandlerContext ctx) {
		Channel channel = ctx.channel();
		boolean flag = CHANNEL_GROUP.remove(channel);
		
		String remoteIp = ChannelHandlerWenhuaMsg.getRemoteIp(ctx);
		
		AtomicInteger counter = ipConnectCounter.get(remoteIp);
		int c = 0;
		if(null != counter) {
			c = counter.decrementAndGet();
			
			if(0 == c) {
				ipConnectCounter.remove(remoteIp);
			}
		}
		
		logger.info(String.format("##Channel: %s is removed from ChannelGroups, current size: %d. The connect num of Ip: [%s] is [%d]", channel.id().asLongText(), CHANNEL_GROUP.size(), remoteIp, c));
		return flag;
	}

	public static ChannelGroupFuture disconnect() {
		return CHANNEL_GROUP.disconnect();
	}

	public static ChannelGroupFuture disconnect(ChannelMatcher matcher) {
		return CHANNEL_GROUP.disconnect(matcher);
	}

	public static boolean contains(Channel channel) {
		return CHANNEL_GROUP.contains(channel);
	}

	public static int size() {
		int activeChannelSize = CHANNEL_GROUP.size();
		logger.info(String.format("##Get active channel size from channels group, size is: %s", activeChannelSize));
		return activeChannelSize;
	}
}
