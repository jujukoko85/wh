package com.wenhua.server;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.wenhua.proto.Wenhua;
import com.wenhua.proto.Wenhua.AuthInfo;
import com.wenhua.proto.WenhuaMsg;
import com.wenhua.proto.WenhuaMsg.Message;
import com.wenhua.svr.domain.BarAuthInfo;
import com.wenhua.svr.exception.AuthBarNotExistException;
import com.wenhua.svr.exception.AuthSignNotValidException;
import com.wenhua.svr.service.AuthService;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
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
		
		boolean close = false; //是否需要关闭当前链接
		long id = message.getId();
		int exceptCode = 0;
		String exceptMsg = null;
		ByteString content = null;
		String methodName = message.getMethod();
		
		
		InetSocketAddress remoteAddress = (InetSocketAddress)ctx.channel().remoteAddress();
		logMsg(remoteAddress.getAddress().getHostAddress(), message);
		
		TcpMethod method = TcpMethod.getEnumFromString(methodName);
		
		if(null == method || 0 == id) {
			close = true;
			exceptCode = 1001;
			methodName = "MethodNameIsNull";
			exceptMsg = "Message无接口名称或序列号";
		} else {
			
			switch(method) {
				case Authentication : 
				try {
					doAuthentication(message);
					exceptCode = 0;
					exceptMsg = "验证成功";
				} catch (AuthBarNotExistException e) {
					close = true;
					exceptCode = 1002;
					exceptMsg = "中心无此网吧";
				} catch (AuthSignNotValidException e) {
					close = true;
					exceptCode = 1003;
					exceptMsg = "sign无效";
				} catch (Exception e) {
					logger.error(e.getMessage(), e);
					close = true;
					exceptCode = 1004;
					exceptMsg = "网络链接错误";
					e.printStackTrace();
				}
				case GetVersinInfo : ;
				case SetInstantPcInfoList : ;
				case SetPcInfoList : ;
				case SetServerInfo : ;
				default : ;
			}
			
		}
		
		Message response = WenhuaMsg.Message.newBuilder()
			.setId(id)
			.setMethod(methodName)
			.setContent(null == content ? ByteString.copyFrom(exceptMsg.getBytes()) : content)
			.setExceptCode(exceptCode)
			.setExceptMsg(exceptMsg)
			.build();
		
		ChannelFuture future = ctx.writeAndFlush(response);
		
		if (close) {
			// future.addListener(ChannelFutureListener.CLOSE).sync().channel().closeFuture().sync();
			future.addListener(ChannelFutureListener.CLOSE);
		}
		
		super.channelRead(ctx, msg);
	}

	/**
	 * 处理验证请求
	 * @param message
	 * @throws AuthSignNotValidException 
	 * @throws AuthBarNotExistException 
	 */
	private void doAuthentication(Message message) throws AuthBarNotExistException, AuthSignNotValidException {
		AuthInfo authInfo = null;
		try {
			authInfo = Wenhua.AuthInfo.parseFrom(message.getContent());
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
		}
		logger.info(String.format("##Authentication BarId: %d When: %s Sign: %s", authInfo.getBarID(), authInfo.getWhen(), authInfo.getSign()));
		
		authService.auth(new BarAuthInfo(authInfo.getBarID(), authInfo.getWhen(), authInfo.getSign()));
		
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
