package com.wenhua.base.web.util;


/**
 * @author Yichuan
 * @version $Id: DefaultAppConfigExt.java 32989 2013-06-08 02:38:52Z C636 $
 * @since 1.0
 */
public class DefaultAppConfigExt extends DefaultAppConfig implements AppConfigExt {

    public static DefaultAppConfigExt getInstance() {
        return INSTANCE;
    }

    private static final DefaultAppConfigExt INSTANCE = new DefaultAppConfigExt();

    private String zxingUrl;

    private String zxingPath;
    private String androidPath;
    private String iphonePath;
    private String surveyPicPath;

    private DefaultAppConfigExt() {
    }

    @Override
    public String getZxingUrl() {
        return zxingUrl;
    }

    /**
     * @see com.wenhua.base.web.util.tonglukuaijian.survey.config.AppConfigExt#getZxingPath()
     */
    @Override
    public String getZxingPath() {
        return zxingPath;
    }

    /**
     * @see com.wenhua.base.web.util.tonglukuaijian.survey.config.AppConfigExt#getAndroidPath()
     */
    @Override
    public String getAndroidPath() {
        return androidPath;
    }

    /**
     * @see com.wenhua.base.web.util.tonglukuaijian.survey.config.AppConfigExt#getIphonePath()
     */
    @Override
    public String getIphonePath() {
        return iphonePath;
    }

    /**
     * @see com.wenhua.base.web.util.tonglukuaijian.survey.config.AppConfigExt#getSurveyPicPath()
     */
    @Override
    public String getSurveyPicPath() {
        return surveyPicPath;
    }

    public void setSurveyPicPath(String surveyPicPath) {
        this.surveyPicPath = surveyPicPath;
    }
    
    public void setZxingUrl(String zxingUrl) {
        this.zxingUrl = zxingUrl;
    }

    public void setZxingPath(String zxingPath) {
        this.zxingPath = zxingPath;
    }

    public void setAndroidPath(String androidPath) {
        this.androidPath = androidPath;
    }

    public void setIphonePath(String iphonePath) {
        this.iphonePath = iphonePath;
    }
}
