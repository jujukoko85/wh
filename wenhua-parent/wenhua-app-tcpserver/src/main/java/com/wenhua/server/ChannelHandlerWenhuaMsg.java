package com.wenhua.server;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wenhua.proto.WenhuaMsg;
import com.wenhua.proto.WenhuaMsg.Message;
import com.wenhua.svr.service.AuthService;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ChannelHandlerWenhuaMsg extends ChannelInboundHandlerAdapter {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private AuthService authService;

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		logger.debug("##Active");
		
		super.channelActive(ctx);
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		logger.debug("##read");
		WenhuaMsg.Message message = (WenhuaMsg.Message) msg;
		InetSocketAddress remoteAddress = (InetSocketAddress)ctx.channel().remoteAddress();
		logMsg(remoteAddress.getAddress().getHostAddress(), message);
		
		String methodName = message.getMethod();
		TcpMethod method = TcpMethod.getEnumFromString(methodName);
		
		if(null == method) {
			
		} else {
			
			switch(method) {
				case Authentication : ;
				case GetVersinInfo : ;
				case SetInstantPcInfoList : ;
				case SetPcInfoList : ;
				case SetServerInfo : ;
				default : ;
			}
			
		}
		
		
		
		Message response = WenhuaMsg.Message.newBuilder()
			.setId(message.getId())
			.setMethod(methodName)
			.setContent(message.getContent())
			.setExceptCode(message.getExceptCode())
			.setExceptMsg(message.getExceptMsg())
			.build();
		
		ctx.writeAndFlush(response);
		
		super.channelRead(ctx, msg);
	}

	private void logMsg(String remoteIp, WenhuaMsg.Message message) {
		String content = String.format(
			"##From [%s] ReceivedMsg: Id[%d] Method[%s] Content[%s] ReturnCode[%d] ReturnMsg[%s]", 
			remoteIp,
			message.getId(),
			message.getMethod(), 
			message.getContent().toStringUtf8(), 
			message.getExceptCode(),
			message.getExceptMsg()
			);
		logger.info(
				content
				);
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
		logger.debug("##readComplete");
		
		super.channelReadComplete(ctx);
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		logger.error("##exceptionCaught", cause);
		super.exceptionCaught(ctx, cause);
	}

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
}
