package com.wenhua.base.web.util;


/**
 * 应用通用配置接口。
 *
 * @author Yichuan
 * @version $Id: AppConfigExt.java 32989 2013-06-08 02:38:52Z C636 $
 * @since 1.0
 */
public interface AppConfigExt extends AppConfig {
    
    /**
     * 返回二维码地址
     */
    String getZxingUrl();
    
    /**
     * 二维码图片存放路径 
     */
    String getZxingPath();
    
    /**
     * MQ android应用下载地址 
     */
    String getAndroidPath();
    
    /**
     * MQ iphone应用下载地址 
     */
    String getIphonePath();
    
    /**
     * 调查任务图片存放路径 
     */
    String getSurveyPicPath();
}
