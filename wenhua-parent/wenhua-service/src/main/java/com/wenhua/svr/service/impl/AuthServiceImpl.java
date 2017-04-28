package com.wenhua.svr.service.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import com.google.common.collect.Lists;
import com.wenhua.svr.dao.AreasCodeDao;
import com.wenhua.svr.dao.FileBarDao;
import com.wenhua.svr.dao.FileInfoDao;
import com.wenhua.svr.dao.NetBarDao;
import com.wenhua.svr.dao.PcInfoDao;
import com.wenhua.svr.dao.ServerInfoDao;
import com.wenhua.svr.dao.StatAreaDao;
import com.wenhua.svr.dao.StatNetBarDao;
import com.wenhua.svr.domain.AreasCode;
import com.wenhua.svr.domain.BarAuthInfo;
import com.wenhua.svr.domain.BarConfig;
import com.wenhua.svr.domain.BarFileBar;
import com.wenhua.svr.domain.BarFileInfo;
import com.wenhua.svr.domain.BarSoftwareVersion;
import com.wenhua.svr.domain.FileBar;
import com.wenhua.svr.domain.NetBar;
import com.wenhua.svr.domain.PcInfo;
import com.wenhua.svr.domain.ServerInfo;
import com.wenhua.svr.domain.StatArea;
import com.wenhua.svr.domain.StatNetBar;
import com.wenhua.svr.domain.base.BaseStatAreaKey;
import com.wenhua.svr.domain.base.BaseStatNetBarKey;
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
	
	private FileBarDao fileBarDao;
	
	private FileInfoDao fileInfoDao;
	
	private AreasCodeDao areasCodeDao;
	
	private StatAreaDao statAreaDao;
	
	private StatNetBarDao statNetBarDao;
	
	private String key = "hn123wh";
	/** 客户机上报信息频率 */
	private int freqInstantPcInfo = 60;

	@Override
	public NetBar isAuth(BarAuthInfo barAuthInfo) throws AuthBarNotExistException, AuthSignNotValidException, AuthBarNotValidException {
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
	public BarConfig getBarConfig(String barId) throws AuthBarNotExistException {
		
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

	@Override
	public List<BarFileInfo> getBarFileInfoList(String barId, BarSoftwareVersion version) {
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
	public List<BarFileBar> getBarFileBarList(String barId, BarSoftwareVersion version) {
		
		List<FileBar> fileBars = fileBarDao.selectAllByBarId(barId);
		List<BarFileBar> list = Lists.newArrayList();
		if(null == fileBars || 0 == fileBars.size()) return list;
		
		for(FileBar fb : fileBars) {
			BarFileBar bfb = new BarFileBar();
//			bfb.se
		}
		
		
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

	public FileBarDao getFileBarDao() {
		return fileBarDao;
	}

	public void setFileBarDao(FileBarDao fileBarDao) {
		this.fileBarDao = fileBarDao;
	}

	public FileInfoDao getFileInfoDao() {
		return fileInfoDao;
	}

	public void setFileInfoDao(FileInfoDao fileInfoDao) {
		this.fileInfoDao = fileInfoDao;
	}

	@Override
	public List<AreasCode> selectAllAreasCode() {
		return this.areasCodeDao.selectAll();
	}

	@Override
	public int countNetBarByAreaCode(String areaCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("areaCode", areaCode);
		return this.netBarDao.countAreaBar(params);
	}

	@Override
	public int countNetBarPcByAreaCode(String areaCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("areaCode", areaCode);
		return this.netBarDao.countAreaPc(params);
	}

	@Override
	public int countNetBarByCityCode(String cityCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("areaCode", cityCode);
		return this.netBarDao.countCityBar(params);
	}

	@Override
	public int countNetBarPcByCityCode(String cityCode) {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("areaCode", cityCode);
		return this.netBarDao.countCityPc(params);
	}

	@Override
	public StatArea getStatAreaById(String areaCode, Date statDate) {
		return this.statAreaDao.selectByPrimaryKey(BaseStatAreaKey.newOne(areaCode, statDate));
	}

	@Override
	public void saveStatArea(StatArea statArea) {
		this.statAreaDao.insert(statArea);
	}

	@Override
	public void updateStatArea(StatArea statArea) {
		this.statAreaDao.updateByPrimaryKey(statArea);
	}

	@Override
	public List<NetBar> getAllBar() {
		return this.netBarDao.selectAll();
	}

	@Override
	public StatNetBar getStatNetBarById(String barId, Date statDate) {
		return this.statNetBarDao.selectByPrimaryKey(BaseStatNetBarKey.newOne(barId, statDate));
	}

	@Override
	public void saveStatNetBar(StatNetBar statNetBar) {
		this.statNetBarDao.insert(statNetBar);
	}

	@Override
	public void updateStatNetBar(StatNetBar statNetBar) {
		this.statNetBarDao.updateByPrimaryKey(statNetBar);
	}

	public AreasCodeDao getAreasCodeDao() {
		return areasCodeDao;
	}

	public void setAreasCodeDao(AreasCodeDao areasCodeDao) {
		this.areasCodeDao = areasCodeDao;
	}

	public StatAreaDao getStatAreaDao() {
		return statAreaDao;
	}

	public void setStatAreaDao(StatAreaDao statAreaDao) {
		this.statAreaDao = statAreaDao;
	}

	public StatNetBarDao getStatNetBarDao() {
		return statNetBarDao;
	}

	public void setStatNetBarDao(StatNetBarDao statNetBarDao) {
		this.statNetBarDao = statNetBarDao;
	}

	
}
