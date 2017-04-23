package com.wenhua.svr.service;

import java.util.List;

import com.wenhua.svr.domain.BarAuthInfo;
import com.wenhua.svr.domain.BarConfig;
import com.wenhua.svr.domain.BarFileBar;
import com.wenhua.svr.domain.BarFileInfo;
import com.wenhua.svr.domain.BarPcInfo;
import com.wenhua.svr.domain.BarPcInstantInfo;
import com.wenhua.svr.domain.BarServerInfo;
import com.wenhua.svr.domain.BarSoftwareVersion;
import com.wenhua.svr.exception.AuthBarNotExistException;
import com.wenhua.svr.exception.AuthSignNotValidException;
import com.wenhua.svr.exception.FileNotExistException;
import com.wenhua.svr.exception.SystemException;

/**
 * 验证接口
 * @author zhuzhaohua
 *
 */
public interface AuthService {

	/**
	 * 检查客服端认证请求是否通过
	 * @param barAuthInfo
	 * @throws AuthBarNotExistException
	 * @throws AuthSignNotValidException
	 */
	public void auth(BarAuthInfo barAuthInfo) throws AuthBarNotExistException, AuthSignNotValidException;
	
	/**
	 * 获取网吧配置信息
	 * @param barId
	 * @return
	 * @throws AuthBarNotExistException
	 */
	public BarConfig getBarConfig(int barId) throws AuthBarNotExistException;
	
	/**
	 * 上报网吧服务器信息
	 * @param barServerInfo
	 * @throws AuthBarNotExistException
	 */
	public void setServerInfo(BarServerInfo barServerInfo) throws AuthBarNotExistException;
	
	/**
	 * 更新网吧PC信息
	 * @param barPcInfoList
	 */
	public void updatePcInfoList(List<BarPcInfo> barPcInfoList);
	
	/**
	 * 更新网吧实时PC信息
	 * @param barPcInstantInfoList
	 */
	public void updatePcInstantInfoList(List<BarPcInstantInfo> barPcInstantInfoList);
	
	/**
	 * 获取文件信息列表
	 * @param version
	 * @return
	 */
	public List<BarFileInfo> getBarFileInfoList(BarSoftwareVersion version);
	
	/**
	 * 
	 * @param version
	 * @return
	 */
	public List<BarFileBar> getBarFileBarList(BarSoftwareVersion version);
	
	/**
	 * 根据文件ID获取文件字节数组
	 * @param fileId
	 * @return
	 * @throws FileNotExistException 
	 * @throws SystemException 
	 */
	public byte[]	getFileById(int fileId) throws FileNotExistException, SystemException;
}
