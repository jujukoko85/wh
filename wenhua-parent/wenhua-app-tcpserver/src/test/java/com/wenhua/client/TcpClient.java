package com.wenhua.client;

import com.wenhua.proto.WenhuaMsg;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

public class TcpClient {

	public void start(String remoteAddress, int port) throws Exception {
		NioEventLoopGroup group = new NioEventLoopGroup();
		
		try {
			Bootstrap b = new Bootstrap();
			b
				.group(group)
				.channel(NioSocketChannel.class)
				.remoteAddress(remoteAddress, port)
				.handler(
						new ChannelInitializer<SocketChannel>() {
							protected void initChannel(SocketChannel ch) throws Exception {
								
								ChannelPipeline pipeline = ch.pipeline();
								
								pipeline.addLast(new LengthFieldPrepender(4));
								pipeline.addLast(new ProtobufEncoder());
								
								pipeline.addLast(new LengthFieldBasedFrameDecoder(1024 * 1024, 0, 4, 0, 4));
								pipeline.addLast(new ProtobufDecoder(WenhuaMsg.Message.getDefaultInstance()));
								
								pipeline.addLast(new ChannelHandlerWenhuaMsgClient());
							};
					});
			
			ChannelFuture f = b.connect().sync();
			
			Thread.sleep(60 * 1000);
			
			f.channel().close().sync();
			
		} finally {
			group.shutdownGracefully().sync();
		}
	}
	
	public static void main(String[] args) {
		TcpClient client = new TcpClient();
		try {
//			client.start("202.109.114.115", 9527);
			client.start("127.0.0.1", 9527);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
