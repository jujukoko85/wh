package com.wenhua.server;

import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.wenhua.proto.Wenhua;
import com.wenhua.proto.Wenhua.AuthInfo;
import com.wenhua.proto.Wenhua.FileBar;
import com.wenhua.proto.Wenhua.FileInfo;
import com.wenhua.proto.Wenhua.FileInfoList;
import com.wenhua.proto.Wenhua.FileInfoList.Builder;
import com.wenhua.proto.Wenhua.PcInfo;
import com.wenhua.proto.Wenhua.PcInfoList;
import com.wenhua.proto.Wenhua.PcInstantInfo;
import com.wenhua.proto.Wenhua.PcInstantInfoList;
import com.wenhua.proto.Wenhua.ServerInfo;
import com.wenhua.proto.Wenhua.SoftwareVersion;
import com.wenhua.proto.WenhuaMsg;
import com.wenhua.proto.WenhuaMsg.Message;
import com.wenhua.svr.domain.BarAuthInfo;
import com.wenhua.svr.domain.BarConfig;
import com.wenhua.svr.domain.BarFileBar;
import com.wenhua.svr.domain.BarFileInfo;
import com.wenhua.svr.domain.BarPcInstantInfo;
import com.wenhua.svr.domain.BarSoftwareVersion;
import com.wenhua.svr.exception.AuthBarNotExistException;
import com.wenhua.svr.exception.AuthBarNotValidException;
import com.wenhua.svr.exception.AuthSignNotValidException;
import com.wenhua.svr.exception.FileNotExistException;
import com.wenhua.svr.exception.SystemException;
import com.wenhua.svr.service.AuthService;
import com.wenhua.svr.service.StatService;
import com.wenhua.util.ByteUtil;
import com.wenhua.util.tools.NumberUtil;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;

public class ChannelHandlerWenhuaMsg extends ChannelInboundHandlerAdapter {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final String METHOD_NAME_IS_NULL = "MethodNameIsNull";
	
	private static final String BAR_ID = "BAR_ID";
	
	private static final String TCP_SERVER = "TCP_SERVER";
	
	private Map<Integer, String> codeMaps;
	
	private AuthService authService;
	
	private StatService statService;

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
		logger.debug(String.format("##Active ChannelShortId: %s remoteId: %s", getChannelShortId(ctx), getRemoteIp(ctx)));
		
		ChannelGroups.add(ctx.channel());
		
		super.channelActive(ctx);
	}
	
	private String getChannelShortId(ChannelHandlerContext ctx) {
		Channel channel = ctx.channel();
		ChannelId id = channel.id();
		String shortId = id.asShortText();
		return shortId;
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		logger.debug(String.format("##Inactive ChannelShortId: %s remoteId: %s", getChannelShortId(ctx), getRemoteIp(ctx)));
		
		ChannelGroups.discard(ctx.channel());
		
		super.channelInactive(ctx);
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		logger.debug(String.format("##Read ChannelShortId: %s remoteId: %s", getChannelShortId(ctx), getRemoteIp(ctx)));
		WenhuaMsg.Message message = (WenhuaMsg.Message) msg;
		
		long id = message.getId();
		String methodName = message.getMethod();

		logMsg(ctx, message);
		
		TcpMethod method = TcpMethod.getEnumFromString(methodName);
		
		if(null == method || 0 == id) {
			invalidRequestCloseChannel(ctx, id, 1001);
			
		} else if(TcpMethod.Authentication.equals(method)) {
			doAuthentication(ctx, message);
			
		} else {
			
			Integer barId = getBarId(ctx);
			if(null == barId) {
				invalidRequestCloseChannel(ctx, id, 1005);
				return;
			}
			logger.debug(String.format("##BarId exist ChannelShortId: %s remoteId: %s barId: %d", getChannelShortId(ctx), getRemoteIp(ctx), (Integer)barId));
			
			switch(method) {
			
				/** 获取文件 */
				case GetFile :
					doGetFile(ctx, message);
				/** 获取信息 */
				case GetConfig : 
					doGetConfig(ctx, message);
					
				break;
				case GetFileInfoList : 
					doGetFileInfoList(ctx, message);
					
				break;
				/** 上报客户机实时信息列表 */
				case SetInstantPcInfoList : 
					doSetInstantPcInfoList(ctx, message);
					
				break;
				/** 上报客户机实时信息列表 */
				case SetPcInfoList : 
					doSetPcInfoList(ctx, message);
					
				break;
				/** 上报服务器信息 */
				case SetServerInfo : 
					doSetServerInfo(ctx, message);
					
				break;
				default : 
					;
				break;
			} //switch end
			
		}
		
		super.channelRead(ctx, msg);
	}

	private Integer getBarId(ChannelHandlerContext ctx) {
		Integer barId = (Integer) ctx.channel().attr(AttributeKey.valueOf(BAR_ID)).get();
		return barId;
	}

	/**
	 * 获取文件
	 * @param ctx
	 * @param message
	 */
	private void doGetFile(ChannelHandlerContext ctx, Message message) {
		ByteString fileIdByteString = message.getContent();
		logger.info(String.format("##GetFile ChannelShortId: %s  RemoteIp: %s fildIdByteStr: %s", getChannelShortId(ctx), getRemoteIp(ctx), ByteUtil.bytes2hex(fileIdByteString.toByteArray())));;
		int fileId = NumberUtil.byte4ToInt(fileIdByteString.toByteArray(), 0);
		logger.info(String.format("##GetFile ChannelShortId: %s  RemoteIp: %s fildId: %s", getChannelShortId(ctx), getRemoteIp(ctx), String.valueOf(fileId)));;
		
		byte[] target = null;
		Message response = null;
		try {
			target = authService.getFileById(fileId);
			response = getResponseMsg(message.getId(), 1006, codeMaps.get(1006), ByteString.copyFrom(target), message.getMethod());
		} catch (FileNotExistException e) {
			logger.error(String.format("##GetFile ChannelShortId: %s  RemoteIp: %s fildId: %s error FileNotFound", getChannelShortId(ctx), getRemoteIp(ctx), String.valueOf(fileId)));
			response = getResponseMsg(message.getId(), 0, codeMaps.get(0), ByteString.copyFrom(target), message.getMethod());
		} catch (SystemException e) {
			response = getResponseMsg(message.getId(), 1007, codeMaps.get(1007), ByteString.copyFrom(target), message.getMethod());
		}
		
		
		ctx.writeAndFlush(response);
	
	}

	/**
	 * 请求不合法 关闭Channel
	 * @param ctx
	 * @param id
	 * @param exceptCode
	 * @param content
	 */
	private void invalidRequestCloseChannel(ChannelHandlerContext ctx, long id, int exceptCode) {
		String exceptMsg;
		String methodName;
		methodName = METHOD_NAME_IS_NULL;
		exceptMsg = codeMaps.get(exceptCode);
		
		Message responseMsg = getResponseMsg(id, exceptCode, exceptMsg, null, methodName);
		ChannelFuture future = ctx.writeAndFlush(responseMsg);
		future.addListener(ChannelFutureListener.CLOSE);
	}

	private Message getResponseMsg(long id, int exceptCode, String exceptMsg, ByteString content, String methodName) {
		Message response = WenhuaMsg.Message.newBuilder()
			.setId(id)
			.setMethod(null == methodName ? METHOD_NAME_IS_NULL : methodName)
			.setContent(null == content ? ByteString.copyFrom(exceptMsg.getBytes()) : content)
			.setExceptCode(exceptCode)
			.setExceptMsg(exceptMsg)
			.build();
		return response;
	}

	private FileInfoList getFromPair(List<BarFileInfo> list1, List<BarFileBar> list2) {
		
		Builder builder = Wenhua.FileInfoList.newBuilder();
		
		if(null != list1 && 0 != list1.size()) {
			for(BarFileInfo fileInfo : list1) {
				FileInfo f = Wenhua.FileInfo.newBuilder()
					.setAction(fileInfo.getAction())
					.setApplyAllBar(fileInfo.isApplyAllBar())
					.setFilename(fileInfo.getFileName())
					.setFlag(fileInfo.getFlag())
					.setId(fileInfo.getId())
					.setMd5(fileInfo.getMd5())
					.setType(fileInfo.getType())
					.setVersion(fileInfo.getVersion())
					.build();
				
				builder.addInfos(f);
			}
		}
		
		if(null != list2 && 0 != list2.size()) {
			for(BarFileBar fileBar : list2) {
				com.wenhua.proto.Wenhua.FileBar.Builder b = Wenhua.FileBar.newBuilder()
					.setFileID(fileBar.getFileId());
				
				for(String i : fileBar.getBarIdList()) {
					b.addBarID(i);
				}
				FileBar fb = b.build();
				
				builder.addFileBars(fb);
			}
		}
		
		return builder.build();
	}

	/**
	 * 获取文件信息列表
	 * @param ctx
	 * @param message
	 */
	private void doGetFileInfoList(ChannelHandlerContext ctx, Message message) {
		SoftwareVersion softwareVersion = null;
		try {
			softwareVersion = Wenhua.SoftwareVersion.parseFrom(message.getContent());
		} catch (InvalidProtocolBufferException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String clientVersion = null == softwareVersion ? null : softwareVersion.getClientVersion();
		String serverVersion = null == softwareVersion ? null : softwareVersion.getServerVersion();
		logger.info(String.format("##GetFileInfoList ChannelShortId: %s  RemoteIp: %s ClientVersion: %s ServerVersion: %s", getChannelShortId(ctx), getRemoteIp(ctx), clientVersion, serverVersion));
		if(null == softwareVersion) return;
		
		BarSoftwareVersion version = new BarSoftwareVersion();
		version.setClientVersion(softwareVersion.getClientVersion());
		version.setServerVersion(softwareVersion.getServerVersion());
		
		int exceptCode =0;
		String exceptMsg = null;
		ByteString content = null;
		
		try {
			List<BarFileInfo> barFileInfoList = authService.getBarFileInfoList(version);
			List<BarFileBar> barFileBarList = authService.getBarFileBarList(version);
			
			Wenhua.FileInfoList fileInfoList = getFromPair(barFileInfoList, barFileBarList);
			exceptCode = 0;
			exceptMsg = codeMaps.get(exceptCode);
			content = fileInfoList.toByteString();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			exceptCode = 1004;
			exceptMsg = codeMaps.get(exceptCode);
			content = ByteString.copyFromUtf8(String.valueOf(false));
		}
		
		Message response = getResponseMsg(message.getId(), exceptCode, exceptMsg, content, message.getMethod());
		ctx.writeAndFlush(response);
		
	}

	/**
	 * 上报客户机实时信息列表
	 * @param ctx
	 * @param message
	 */
	private void doSetInstantPcInfoList(ChannelHandlerContext ctx, Message message) {
		PcInstantInfoList pcInstantInfoList = null;
		try {
			pcInstantInfoList = Wenhua.PcInstantInfoList.parseFrom(message.getContent());
		} catch (InvalidProtocolBufferException e) {
			logger.error(String.format("##SetInstantPcInfoList ChannelShortId: %s RemoteIp: %s InvalidProtocol", getChannelShortId(ctx), getRemoteIp(ctx)), e);
			return;
		}
		List<PcInstantInfo> infosList = pcInstantInfoList.getInfosList();
		logger.info(String.format("##SetInstantPcInfoList ChannelShortId: %s RemoteIp: %s PcInstantInfoListSize: %d", getChannelShortId(ctx), getRemoteIp(ctx), null == infosList ? 0 : infosList.size()));
		
		if(null == infosList || 0 == infosList.size()) return;
		
		List<BarPcInstantInfo> barPcInstantInfoList = new ArrayList<BarPcInstantInfo>(infosList.size());
		
		for(PcInstantInfo info : infosList) {
			BarPcInstantInfo pc = new BarPcInstantInfo();
			pc.setMac(info.getMac());
			pc.setPowerOn(info.getIsPowerOn());
			pc.setPowerDuration(info.getPoweronDuration());
			pc.setWenhuaDuration(info.getWenhuaDuration());
			pc.setRunWenhua(info.getIsRunWenhua());
			pc.setUserLogin(info.getIsUserLogin());
			
			barPcInstantInfoList.add(pc);
		}
		
		statService.countBarDaily(getBarId(ctx), barPcInstantInfoList);
		
	}

	/**
	 * 上报客户机信息列表
	 * @param ctx
	 * @param message
	 */
	private void doSetPcInfoList(ChannelHandlerContext ctx, Message message) {
		PcInfoList pcInfoList = null;
		try {
			pcInfoList = Wenhua.PcInfoList.parseFrom(message.getContent());
		} catch (InvalidProtocolBufferException e) {
			logger.error(String.format("##SetPcInfoList ChannelShortId: %s RemoteIp: %s InvalidProtocol", getChannelShortId(ctx), getRemoteIp(ctx)), e);
			return;
		}
		List<PcInfo> infosList = pcInfoList.getInfosList();
		logger.info(String.format("##SetPcInfoList ChannelShortId: %s RemoteIp: %s PcInfoListSize: %d", getChannelShortId(ctx), getRemoteIp(ctx), null == infosList ? 0 : infosList.size()));
		
		if(null == infosList || 0 == infosList.size()) return;
		
		List<com.wenhua.svr.domain.PcInfo> barPcInfoList = new ArrayList<com.wenhua.svr.domain.PcInfo>(infosList.size());
		for(PcInfo info : infosList) {
			com.wenhua.svr.domain.PcInfo pc = com.wenhua.svr.domain.PcInfo.newOne(
					info.getMac(), 
					info.getIp(), 
					info.getPcname(), 
					info.getOsType(), 
					info.getOsVersion(), 
					String.valueOf(getBarId(ctx)), 
					TCP_SERVER);
			
			barPcInfoList.add(pc);
		}
		
		authService.updatePcInfoList(barPcInfoList);
		
	}

	/**
	 * 上报服务器信息
	 * @param ctx
	 * @param message
	 * @throws AuthBarNotExistException 
	 */
	private void doSetServerInfo(ChannelHandlerContext ctx, Message message) throws AuthBarNotExistException {
		ServerInfo serverInfo = null;
		try {
			serverInfo = Wenhua.ServerInfo.parseFrom(message.getContent());
		} catch (InvalidProtocolBufferException e) {
			logger.error(String.format("##SetServerInfo ChannelShortId: %s RemoteIp: %s InvalidProtocol", getChannelShortId(ctx), getRemoteIp(ctx)), e);
			return;
		}
		logger.info(
				String.format(
						"##SetServerInfo ChannelShortId: %s remoteId: %s mac: %s ip: %s pcname: %s ostype: %d osversion:%s", 
						getChannelShortId(ctx),
						getRemoteIp(ctx), 
						serverInfo.getMac(), 
						serverInfo.getIp(), 
						serverInfo.getPcname(), 
						serverInfo.getOsType(), 
						serverInfo.getOsVersion())
				);
		
		com.wenhua.svr.domain.ServerInfo si = com.wenhua.svr.domain.ServerInfo.newOne(
				String.valueOf(getBarId(ctx)),
				serverInfo.getMac(), 
				serverInfo.getIp(), 
				serverInfo.getPcname(), 
				serverInfo.getOsType(),
				serverInfo.getOsVersion(), 
				TCP_SERVER);
		
		authService.setServerInfo(si);
	}

	private String getRemoteIp(ChannelHandlerContext ctx) {
		InetSocketAddress remoteAddress = (InetSocketAddress)ctx.channel().remoteAddress();
		String ip = remoteAddress.getAddress().getHostAddress();
		return ip;
	}

	private void doGetConfig(ChannelHandlerContext ctx, Message message) throws AuthBarNotExistException {
		ByteString content = message.getContent();
		int barId = NumberUtil.byte4ToInt(content.toByteArray(), 0);
		logger.info(String.format("##GetConfig ChannelShortId: %s RemoteIp: %s BarId: %d", getChannelShortId(ctx), getRemoteIp(ctx), barId));
		
		int exceptCode = 0;
		String exceptMsg = null;
		try {
			BarConfig myConfig = authService.getBarConfig(barId);
			exceptCode = 0;
			exceptMsg = codeMaps.get(exceptCode);
			com.wenhua.proto.Wenhua.BarConfig config = Wenhua.BarConfig.newBuilder().setFreqInstantPcInfo(myConfig.getFreqInstantPcInfo()).build();
			content = config.toByteString();
			
		} catch (AuthBarNotExistException e) {
			exceptCode = 1002;
			exceptMsg = codeMaps.get(exceptCode);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			exceptCode = 1004;
			exceptMsg = codeMaps.get(exceptCode);
			content = ByteString.copyFromUtf8(String.valueOf(false));
		}
		
		Message response = getResponseMsg(message.getId(), exceptCode, exceptMsg, content, message.getMethod());
		
		ctx.writeAndFlush(response);
	}

	/**
	 * 处理验证请求
	 * @param message
	 * @throws AuthSignNotValidException 
	 * @throws AuthBarNotExistException 
	 */
	private void doAuthentication(ChannelHandlerContext ctx, Message message) {
		AuthInfo authInfo = null;
		try {
			authInfo = Wenhua.AuthInfo.parseFrom(message.getContent());
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
			//TODO
		}
		logger.info(String.format("##Authentication ChannelShortId: %s RemoteIp: %s BarId: %d When: %s Sign: %s", getChannelShortId(ctx), getRemoteIp(ctx), authInfo.getBarID(), authInfo.getWhen(), authInfo.getSign()));
		
		int exceptCode = 0;
		String exceptMsg = null;
		ByteString content = null;
		boolean close = false;
		
		try {
			authService.auth(new BarAuthInfo(authInfo.getBarID(), authInfo.getWhen(), authInfo.getSign()));
			exceptCode = 0;
			exceptMsg = codeMaps.get(exceptCode);
			content = ByteString.copyFromUtf8(String.valueOf(true));
			
			/** 將Channel关联BarId */
			Attribute<Object> attr = ctx.channel().attr(AttributeKey.valueOf(BAR_ID));
			attr.set(authInfo.getBarID());
			
		} catch (AuthBarNotExistException e) {
			close = true;
			exceptCode = 102;
			exceptMsg = codeMaps.get(exceptCode);
			content = ByteString.copyFromUtf8(String.valueOf(false));
		} catch (AuthSignNotValidException e) {
			close = true;
			exceptCode = 1003;
			exceptMsg = codeMaps.get(exceptCode);
			content = ByteString.copyFromUtf8(String.valueOf(false));
		} catch (AuthBarNotValidException e) {
			close = true;
			exceptCode = 1008;
			exceptMsg = codeMaps.get(exceptCode);
			content = ByteString.copyFromUtf8(String.valueOf(false));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			close = true;
			exceptCode = 1004;
			exceptMsg = codeMaps.get(exceptCode);
			content = ByteString.copyFromUtf8(String.valueOf(false));
		}
		
		Message response = getResponseMsg(message.getId(), exceptCode, exceptMsg, content, message.getMethod());
		ChannelFuture future = ctx.writeAndFlush(response);
		
		if(close) {
			future.addListener(ChannelFutureListener.CLOSE);
		}
	}
	
	private void logMsg(ChannelHandlerContext ctx, WenhuaMsg.Message message) {
		String content = String.format(
			"##From ChannelShortId: %s remoteIp: [%s] ReceivedMsg: Id[%d] Method[%s] Content[%s] ReturnCode[%d] ReturnMsg[%s]", 
			getChannelShortId(ctx),
			getRemoteIp(ctx),
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
		logger.debug(String.format("##readComplete ChannelShortId: %s remoteId: %s", getChannelShortId(ctx), getRemoteIp(ctx)));
		super.channelReadComplete(ctx);
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		logger.error(String.format("##exceptionCaught ChannelShortId: %s remoteId: %s excpetionMsg: %s", getChannelShortId(ctx), getRemoteIp(ctx), cause.getMessage()), cause);
//		super.exceptionCaught(ctx, cause);
	}

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	public Map<Integer, String> getCodeMaps() {
		return codeMaps;
	}

	public void setCodeMaps(Map<Integer, String> codeMaps) {
		this.codeMaps = codeMaps;
	}

	public StatService getStatService() {
		return statService;
	}

	public void setStatService(StatService statService) {
		this.statService = statService;
	}
	
	
}
