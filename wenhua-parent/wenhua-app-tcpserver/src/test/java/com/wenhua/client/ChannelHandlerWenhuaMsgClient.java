package com.wenhua.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.ByteString;
import com.wenhua.proto.WenhuaMsg;
import com.wenhua.util.ByteUtil;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ChannelHandlerWenhuaMsgClient extends ChannelInboundHandlerAdapter {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		logger.info("MessageProto channelActive");

		WenhuaMsg.Message message = WenhuaMsg.Message.newBuilder().setId(System.currentTimeMillis()).setMethod("auth")
				.setContent(ByteString.copyFromUtf8("hello")).setExceptCode(0).setExceptMsg("OK").build();
		
		System.out.println(ByteUtil.bytes2hex(message.toByteArray()));
		
//		String hello = "hello world";
//		System.out.println(ByteUtil.bytes2hex(hello.getBytes()));

		ctx.writeAndFlush(message);

		super.channelActive(ctx);
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		logger.info("##read");
		WenhuaMsg.Message message = (WenhuaMsg.Message) msg;
		String content = String.format(
			"Id[%d] Method[%s] Content[%s] ReturnCode[%d] ReturnMsg[%s]", 
			message.getId(),
			message.getMethod(), 
			message.getContent().toString(), 
			message.getExceptCode(),
			message.getExceptMsg()
			);
		logger.info(
				content
				);
		super.channelRead(ctx, msg);
	}

}
