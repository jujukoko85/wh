package com.wenhua.client;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.ByteString;
import com.wenhua.proto.Wenhua;
import com.wenhua.proto.Wenhua.AuthInfo;
import com.wenhua.proto.Wenhua.AuthInfo.Builder;
import com.wenhua.proto.WenhuaMsg;
import com.wenhua.server.ChannelHandlerWenhuaMsg;
import com.wenhua.svr.domain.BarAuthInfo;
import com.wenhua.util.ByteUtil;
import com.wenhua.util.RandomNumberGenerator;
import com.wenhua.util.tools.DateUtils;
import com.wenhua.util.tools.Md5Util;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ChannelHandlerWenhuaMsgClient extends ChannelInboundHandlerAdapter {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		logger.info("MessageProto channelActive");

		WenhuaMsg.Message message = getAuthInfoMessage();
		
		System.out.println(ByteUtil.bytes2hex(message.toByteArray()));

		ctx.writeAndFlush(message);

		super.channelActive(ctx);
	}
	
	/**
	 * 获取验证消息体
	 * @return
	 */
	private WenhuaMsg.Message getAuthInfoMessage() {
		
		Integer barId = Integer.valueOf(RandomNumberGenerator.generateNumber());
		String when = DateUtils.getString(new Date());
		String key = "hn123wh";
		
		byte[] target = BarAuthInfo.getByteArray(barId, when, key);
		
		Builder builder = Wenhua.AuthInfo.newBuilder()
			.setBarID(barId)
//			.setSign(Md5Util.getMD5HexString(target))
			.setSign("hello")
			.setWhen(when);
			
		
		AuthInfo authInfo = builder.build();
		
		com.wenhua.proto.WenhuaMsg.Message.Builder normalMessageBuilder = getNormalMessageBuilder(System.currentTimeMillis(), "Authentication", authInfo.toByteString(), 0, "OK");
		
		return normalMessageBuilder.build();
	}

	private com.wenhua.proto.WenhuaMsg.Message.Builder getNormalMessageBuilder(
			Long id,
			String method,
			ByteString content,
			int exceptCode,
			String exceptMsg
			) {
		com.wenhua.proto.WenhuaMsg.Message.Builder builder = WenhuaMsg.Message.newBuilder().
				setId(id)
				.setMethod(method)
				.setContent(content)
				.setExceptCode(exceptCode)
				.setExceptMsg(exceptMsg);
		return builder;
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
