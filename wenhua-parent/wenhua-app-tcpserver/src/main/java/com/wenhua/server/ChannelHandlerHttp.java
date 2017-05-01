package com.wenhua.server;

import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.wenhua.server.vo.StatAreaVo;
import com.wenhua.server.vo.StatBarVo;
import com.wenhua.svr.component.StatAreaInstanceCacher;
import com.wenhua.svr.component.StatBarInstancerCacher;
import com.wenhua.svr.domain.StatAreaInstance;
import com.wenhua.svr.domain.StatAreaInstanceCity;
import com.wenhua.svr.domain.StatBarInstance;
import com.wenhua.util.BarIdUtils;
import com.wenhua.util.base.AjaxResult;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpUtil;

public class ChannelHandlerHttp extends ChannelInboundHandlerAdapter {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final String URL_PROVINCE = "/province/";
	private static final String URL_CITY = "/city/";
	private static final String URL_AREA = "/area/";
	private static final String URL_UPDATE_AREA = "/update_area/";
	
	private static final String SEP = "/";

	private HttpRequest request = null;
	private String uri = null;
	private String param = null;

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
	}
	
	private String getRemoteIp(ChannelHandlerContext ctx) {
		InetSocketAddress remoteAddress = (InetSocketAddress)ctx.channel().remoteAddress();
		String ip = remoteAddress.getAddress().getHostAddress();
		return ip;
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

		List<Object> list = null;
		
		if (msg instanceof HttpRequest) {
			request = (HttpRequest) msg;

			uri = request.uri();
			logger.info(String.format("##Http reqest uri: %s, remoteIp: %s", uri, getRemoteIp(ctx)));
		}
		if (msg instanceof HttpContent) {
			
			if(null == uri) {
				invalidRequestCloseChannel(ctx);
				return;
				
			} else if(uri.startsWith(URL_PROVINCE)) {
				param = uri.substring(URL_PROVINCE.length(), uri.length());
				logger.info(String.format("##Uri begin with: %s, param is: %s", URL_PROVINCE, param));
				list = doProvince();
				
			} else if(uri.startsWith(URL_CITY)) {
				param = uri.substring(URL_CITY.length(), uri.length());
				logger.info(String.format("##Uri begin with: %s, param is: %s", URL_CITY, param));
				list = doCity(param);
				
			} else if(uri.startsWith(URL_AREA)) {
				param = uri.substring(URL_AREA.length(), uri.length());
				logger.info(String.format("##Uri begin with: %s, param is: %s", URL_AREA, param));
				list = doArea(param);
			} else if(uri.startsWith(URL_UPDATE_AREA)) {
				param = uri.substring(URL_AREA.length(), uri.length());
				
				String[] params = param.split(SEP);
				
				if(null == params || 3 != params.length) {
					invalidRequestCloseChannel(ctx);
					return;
				}
				
				int maxbar = 0;
				int maxPc = 0;
				String areaCode = params[0];
				try {
					maxbar = Integer.parseInt(params[1]);
					maxPc = Integer.parseInt(params[2]);
				} catch (Exception e) {
					invalidRequestCloseChannel(ctx);
					return;
				}
				
				//更新 区域的网吧数与PC数
				StatAreaInstanceCacher.updateArea(areaCode, maxbar, maxPc);
				
			} else {
				invalidRequestCloseChannel(ctx);
				return;
			}
			
			
			AjaxResult ajaxResult = AjaxResult.getSuccess("success");
			ajaxResult.addValue("stat", list);

			String res = JSON.toJSONString(ajaxResult);
			logger.info(String.format("response: %s", res));

			FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK,
					Unpooled.wrappedBuffer(res.getBytes("UTF-8")));
			response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
			response.headers().set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
			if (HttpUtil.isKeepAlive(request)) {
				response.headers().set(HttpHeaderNames.CONNECTION, "keep-alive");
			}
			ctx.write(response);
			ctx.flush();
		}
		super.channelRead(ctx, msg);
	}

	private List<Object> doArea(String areaCode) {

		List<Object> list = new ArrayList<Object>();
		
		List<StatBarInstance> bars = StatBarInstancerCacher.getBarInArea(areaCode);
		for(StatBarInstance bar : bars) {
			list.add(StatBarVo.newOne(BarIdUtils.getAreaCode(bar.getBarId()), bar.getBarName(), bar.getOnline(), bar.getOffline(), bar.getValid(), bar.getServerVersion()));
		}
		return list;
	}

	private List<Object> doCity(String cityCode) {
		List<Object> list = new ArrayList<Object>();
		
		StatAreaInstanceCity city = (StatAreaInstanceCity)StatAreaInstanceCacher.get(cityCode);
		for(StatAreaInstance area : city.getAreas()) {
			StatAreaVo v = StatAreaVo.newOne(
					area.getCode(), 
					area.getName(), 
					area.getOnline().get(), 
					area.getAreaMaxBar() - area.getOnline().get(), 
					area.getAreaMaxPc(), 
					area.getLoginTotal());
			
			list.add(v);
		}
		return list;
	}

	private List<Object> doProvince() {
		List<Object> list = new ArrayList<Object>();
		
		List<StatAreaInstance> cities = StatAreaInstanceCacher.getAllCity();
		for(StatAreaInstance city : cities) {
			StatAreaVo v = StatAreaVo.newOne(
					city.getCode(), 
					city.getName(), 
					city.getOnline().get(), 
					city.getAreaMaxBar() - city.getOnline().get(), 
					city.getAreaMaxPc(), 
					city.getLoginTotal());
			
			list.add(v);
		}
		return list;
	}
	
	/**
	 * 请求不合法 关闭Channel
	 * @param ctx
	 * @param id
	 * @param exceptCode
	 * @param methodName
	 * @throws UnsupportedEncodingException 
	 */
	private void invalidRequestCloseChannel(ChannelHandlerContext ctx) throws UnsupportedEncodingException {
		AjaxResult result = AjaxResult.getError(String.format("##HttpServer invalid uri: %s", request.uri()));
		String res = JSON.toJSONString(result);
		logger.info(String.format("response: %s", res));

		FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK,
				Unpooled.wrappedBuffer(res.getBytes("UTF-8")));
		response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
		response.headers().set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
		if (HttpUtil.isKeepAlive(request)) {
			response.headers().set(HttpHeaderNames.CONNECTION, "keep-alive");
		}
		ChannelFuture future = ctx.write(response);
		ctx.flush();
		logger.warn(String.format("##HttpServer request invalid. Return response: %s", res));
		future.addListener(ChannelFutureListener.CLOSE);
	}
}
