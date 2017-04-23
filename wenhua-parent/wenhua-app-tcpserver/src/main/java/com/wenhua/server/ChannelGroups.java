package com.wenhua.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.channel.Channel;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.ChannelGroupFuture;
import io.netty.channel.group.ChannelMatcher;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class ChannelGroups {

	private static final ChannelGroup CHANNEL_GROUP = new DefaultChannelGroup("ChannelGroups",
			GlobalEventExecutor.INSTANCE);
	
	private static Logger logger = LoggerFactory.getLogger(ChannelGroups.class);

	public static void add(Channel channel) {
		CHANNEL_GROUP.add(channel);
		logger.info(String.format("##Channel: %s is added into ChannelGroups", channel.id().asLongText()));
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

	public static boolean discard(Channel channel) {
		boolean flag = CHANNEL_GROUP.remove(channel);
		logger.info(String.format("##Channel: %s is removed from ChannelGroups", channel.id().asLongText()));
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
