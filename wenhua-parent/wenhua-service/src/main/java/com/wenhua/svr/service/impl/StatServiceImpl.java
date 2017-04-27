package com.wenhua.svr.service.impl;

import com.wenhua.svr.service.StatService;

public class StatServiceImpl implements StatService {
	
//	private NetBarDao netBarDao;
//	private StatNetBarDao statNetBarDao;
//	private StatAreaDao statAreaDao;
//	private AreasCodeDao areasCodeDao;
//	
//	private Logger logger = LoggerFactory.getLogger(getClass());
//	
//	@Override
//	public void countAreaDaily() {
//		Date yesterday = DateUtils.getChinaDay(-1);
//		logger.info("#########################");
//		logger.info(String.format("##Begin deal with [%s]", DateUtils.getString(yesterday)));
//		logger.info("#########################");
//		
//		//获取所有市级地区 与 区级地区
//		List<AreasCode> allAreaCode = areasCodeDao.selectAll();
//		logger.info(String.format("##Get [%d] area codes", null == allAreaCode ? 0 : allAreaCode.size()));
//		
//		if(null == allAreaCode || 0 == allAreaCode.size()) return;
//		
//		for(AreasCode code : allAreaCode) {
//			if(code.isProvince()) {
//				// 忽略 省
//				continue;
//			}
//			
//			logger.info(String.format("##Begin AreaStat [%s][%s]", code.getAreasid(), code.getAreasname()));
//			try {
//				countAreaDaily(code, yesterday);
//			} catch (Exception e) {
//				logger.error(String.format("##AreaStat [%s][%s] error", code.getAreasid(), code.getAreasname()), e);
//			}
//			
//		}
//	}
//	
//	@Override
//	public void countAreaDaily(AreasCode areaCode, Date statDate) {
//		if(!AreasCode.isValidCode(areaCode.getAreasid())) {
//			logger.error(String.format("##CountAreaDaily error, wrong areaCode, areaCode: %s", areaCode));
//			return;
//		}
//		
//		if(null == statDate) {
//			logger.error("##CountAreaDaily error, statDate is null");
//			return;
//		}
//		
//		// A 在线网吧  B 离线网吧  C 用户总数
//		
//		// A.1 获取指定日期 在线网吧最大数
//		int online = 0;
//		Map<String, Object> params = new HashMap<String, Object>();
//		params.put("areaCode", areaCode);
//		params.put("statDate", statDate);
//		if(areaCode.isCity()) {
//			//统计 市
//			online = statNetBarDao.countCityDaily(params);
//		} else {
//			//统计 区
//			online = statNetBarDao.countAreaDaily(params);
//		}
//		
//		//TODO B.1 获取某地区网吧总数
//		int total = 99999;
//		int offline = total - online;
//		
//		//C.1 
//		int login = 0;
//		if(areaCode.isCity()) {
//			login = statNetBarDao.countLoginCityDaily(params);
//		} else {
//			login = statNetBarDao.countLoginAreaDaily(params);
//		}
//		
//		StatArea sa = StatArea.newOne(areaCode.getAreasid(), statDate, online, offline, login, areaCode.getRankno());
//		statAreaDao.insert(sa);
//	}
//	
//
//	public StatNetBarDao getStatNetBarDao() {
//		return statNetBarDao;
//	}
//
//	public void setStatNetBarDao(StatNetBarDao statNetBarDao) {
//		this.statNetBarDao = statNetBarDao;
//	}
//
//	public StatAreaDao getStatAreaDao() {
//		return statAreaDao;
//	}
//
//	public void setStatAreaDao(StatAreaDao statAreaDao) {
//		this.statAreaDao = statAreaDao;
//	}
//
//	public AreasCodeDao getAreasCodeDao() {
//		return areasCodeDao;
//	}
//
//	public void setAreasCodeDao(AreasCodeDao areasCodeDao) {
//		this.areasCodeDao = areasCodeDao;
//	}
//
//	public NetBarDao getNetBarDao() {
//		return netBarDao;
//	}
//
//	public void setNetBarDao(NetBarDao netBarDao) {
//		this.netBarDao = netBarDao;
//	}

}
