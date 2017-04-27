package com.wenhua.svr.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import com.google.common.collect.Lists;
import com.wenhua.svr.dao.NetBarDao;
import com.wenhua.svr.dao.PcInfoDao;
import com.wenhua.svr.dao.ServerInfoDao;
import com.wenhua.svr.domain.BarAuthInfo;
import com.wenhua.svr.domain.BarConfig;
import com.wenhua.svr.domain.BarFileBar;
import com.wenhua.svr.domain.BarFileInfo;
import com.wenhua.svr.domain.BarSoftwareVersion;
import com.wenhua.svr.domain.NetBar;
import com.wenhua.svr.domain.PcInfo;
import com.wenhua.svr.domain.ServerInfo;
import com.wenhua.svr.exception.AuthBarNotExistException;
import com.wenhua.svr.exception.AuthBarNotValidException;
import com.wenhua.svr.exception.AuthSignNotValidException;
import com.wenhua.svr.exception.FileNotExistException;
import com.wenhua.svr.exception.SystemException;
import com.wenhua.svr.service.AuthService;

public class AuthServiceImpl implements AuthService {
	
//	private Logger logger = LoggerFactory.getLogger(getClass());
	private NetBarDao netBarDao;
	
	private ServerInfoDao serverInfoDao;
	
	private PcInfoDao pcInfoDao;
	
	private String key = "hn123wh";
	/** 客户机上报信息频率 */
	private int freqInstantPcInfo = 60;

	@Override
	public NetBar auth(BarAuthInfo barAuthInfo) throws AuthBarNotExistException, AuthSignNotValidException, AuthBarNotValidException {
		if(null == barAuthInfo) throw new AuthBarNotExistException();

		if(!barAuthInfo.isValid(key)) {
			throw new AuthSignNotValidException();
		}
		
		NetBar netBar = netBarDao.selectByPrimaryKey(String.valueOf(barAuthInfo.getBarId()));
		if(null == netBar) {
			throw new AuthBarNotExistException();
		}
		if(!netBar.isValid()) {
			throw new AuthBarNotValidException();
		}
		return netBar;
	}

	@Override
	public BarConfig getBarConfig(int barId) throws AuthBarNotExistException {
		
		BarConfig config = new BarConfig();
		config.setFreqInstantPcInfo(this.getFreqInstantPcInfo());
		return config;
	}

	@Override
	public void setServerInfo(ServerInfo serverInfo) throws AuthBarNotExistException {
		if(null == serverInfo || null == serverInfo.getId()) return;
		
		NetBar bar = netBarDao.selectByPrimaryKey(serverInfo.getBarId());
		if(null == bar) {
			throw new AuthBarNotExistException();
		}

		ServerInfo target = serverInfoDao.selectByPrimaryKey(serverInfo.getId());
		if(null == target) {
			serverInfoDao.insert(serverInfo);
			return;
		}
		
		serverInfoDao.updateByPrimaryKey(serverInfo);
	}

	@Override
	public void updatePcInfoList(List<PcInfo> pcInfoList) {
		if(null == pcInfoList || 0 == pcInfoList.size()) return;
		
		for(PcInfo pi : pcInfoList) {
			PcInfo target = pcInfoDao.selectByPrimaryKey(pi.getId());
			if(null == target) {
				pcInfoDao.insert(pi);
			} else {
				pcInfoDao.updateByPrimaryKey(pi);
			}
		}
		
	}

//	@Override
//	public void updatePcInstantInfoList(List<BarPcInstantInfo> barPcInstantInfoList) {
//		// TODO 更新网吧实时PC信息
//		
//	}

	@Override
	public List<BarFileInfo> getBarFileInfoList(BarSoftwareVersion version) {
		// TODO 重新实现
		List<BarFileInfo> list = Lists.newArrayList();
		BarFileInfo bfb1 = new BarFileInfo();
		bfb1.setAction(1);
		bfb1.setApplyAllBar(true);
		bfb1.setFileName("fileName");
		bfb1.setFlag(1);
		bfb1.setId(222);
		bfb1.setMd5("md5");
		bfb1.setType(1);
		bfb1.setVersion("version");
		
		list.add(bfb1);
		
		return list;
	}

	@Override
	public List<BarFileBar> getBarFileBarList(BarSoftwareVersion version) {
		//TODO 重新实现
		
		List<BarFileBar> list = Lists.newArrayList();
		BarFileBar bfb1 = new BarFileBar();
		bfb1.setFileId(222);
		
		List<String> barIds = Lists.newArrayList();
		barIds.add("1");
		barIds.add("2222");
		
		bfb1.setBarIdList(barIds);
		
		list.add(bfb1);
		return list;
	}

	@Override
	public byte[] getFileById(int fileId) throws FileNotExistException, SystemException {
		byte[] target = null;
		try {
			File cfgFile = ResourceUtils.getFile("classpath:test.txt");
			target = FileCopyUtils.copyToByteArray(cfgFile);
		} catch (FileNotFoundException e) {
			throw new FileNotExistException();
		} catch (IOException e) {
			throw new SystemException();
		}
		return target;
	}

	public NetBarDao getNetBarDao() {
		return netBarDao;
	}

	public void setNetBarDao(NetBarDao netBarDao) {
		this.netBarDao = netBarDao;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public ServerInfoDao getServerInfoDao() {
		return serverInfoDao;
	}

	public void setServerInfoDao(ServerInfoDao serverInfoDao) {
		this.serverInfoDao = serverInfoDao;
	}

	public PcInfoDao getPcInfoDao() {
		return pcInfoDao;
	}

	public void setPcInfoDao(PcInfoDao pcInfoDao) {
		this.pcInfoDao = pcInfoDao;
	}

	public int getFreqInstantPcInfo() {
		return freqInstantPcInfo;
	}

	public void setFreqInstantPcInfo(int freqInstantPcInfo) {
		this.freqInstantPcInfo = freqInstantPcInfo;
	}

	@Override
	public void updateVersion(String barId, String serverVersion, String clientVersion) throws AuthBarNotExistException {
		NetBar bar = netBarDao.selectByPrimaryKey(barId);
		if(null == bar) {
			throw new AuthBarNotExistException();
		}
		
		bar.setClientVersion(clientVersion);
		bar.setServerVersion(serverVersion);
		
		netBarDao.updateByPrimaryKey(bar);
	}

}
