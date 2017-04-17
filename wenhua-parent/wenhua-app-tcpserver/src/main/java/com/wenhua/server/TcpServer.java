package com.wenhua.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TcpServer {

	private static Logger logger = LoggerFactory.getLogger(TcpServer.class);
	
	private ChannelInitializer<SocketChannel> initializer;
	
	private int defaultPort = 9527;
	
	public TcpServer() {
		logger.info("##TcpServer bean inited");
	}
	
	public void start(int port) {
		logger.info("##Server start at [" + port + "]...");
		
		EventLoopGroup bossGroup = new NioEventLoopGroup(); // (1)
		EventLoopGroup workerGroup = new NioEventLoopGroup();
		try {
			ServerBootstrap b = new ServerBootstrap(); // (2)
			b
				.group(bossGroup, workerGroup)
				.channel(NioServerSocketChannel.class) // (3)
				.childHandler(initializer)
				.option(ChannelOption.SO_BACKLOG, 128) // (5)
				.childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

			// Bind and start to accept incoming connections.
			ChannelFuture f = b.bind(port).sync(); // (7)

			// Wait until the server socket is closed.
			// In this example, this does not happen, but you can do that to
			// gracefully
			// shut down your server.
			f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			logger.error("##TcpServer error", e);
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
			logger.info("##Server shutdown");
		}
	}
	
	public static void main(String[] args) {
		logger.info("##Wenhua Mesage Tcp Server starting...");
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ap = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
		TcpServer tcpServer = ap.getBean("tcpServer", TcpServer.class);
		
		int port = 0;
		if(null == args || 0 == args.length) {
			port = tcpServer.getDefaultPort();
		} else {
			try {
				port = Integer.parseInt(args[0]);
			} catch (NumberFormatException e) {
				port = tcpServer.getDefaultPort();
			}
		}
		logger.info("##TcpServer begin start, port is [" + port +"]");
		tcpServer.start(port);
		
	}

	public void setInitializer(ChannelInitializer<SocketChannel> initializer) {
		this.initializer = initializer;
	}

	public int getDefaultPort() {
		return defaultPort;
	}

	public void setDefaultPort(int defaultPort) {
		this.defaultPort = defaultPort;
	}

	public ChannelInitializer<SocketChannel> getInitializer() {
		return initializer;
	}
	
}
