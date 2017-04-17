package com.wenhua.base.web.util;

/**
 * 应用通用配置接口。
 *
 * @author Yichuan
 * @version $Id$
 * @since 1.0
 */
public interface AppConfig {

    /**
     * {@code AppConfig} 在视图中的引用名称。
     */
    String REF_NAME = "appConfig";

    /**
     * 返回当前站点的根域名。如：tonglukuaijian.com
     */
    public String getRootDomain();

    /**
     * 返回记录 Cookie 的主域名，如果没有域名，则返回服务器IP。例如：.domain.com、10.35.53.10
     */
    public String getCookieRootDomain();

    /**
     * 返回站点域名（不包含 http://）。如：mq.tonglukuaijian.com
     */
    public String getSiteDomain();

    /**
     * 返回站点URL。如：http://mq.tonglukuaijian.com
     */
    public String getSiteUrl();

    /**
     * 返回图片地址前缀URL。如：http://img1.survey.tonglukuaijian.com/images
     */
    public String getImagesUrl();

    /**
     * 返回JS脚本地址前缀URL。如：http://img1.survey.tonglukuaijian.com/scripts
     */
    public String getScriptsUrl();

    /**
     * 返回CSS样式地址前缀URL。如：http://img1.survey.tonglukuaijian.com/styles
     */
    public String getStylesUrl();

    /**
     * 返回当前主题。
     */
    public Theme getTheme();

    /**
     * 表示用户登录系统时，输入错误的次数后，系统将要求输入验证码。
     */
    public int getCaptchaCount();

    /**
     * 返回下载目录
     */
    public String getExcelDownloadUrl();
    
    /**
     * 获取临时目录
     * @return
     */
    public String getTempDir();

//    /**
//     * 返回服务器端的文件上传目录。
//     * <p/>
//     * 例如：/web/www/mq/upload/
//     */
//    public File getUploadedDir();
//
//    /**
//     * 返回服务器端图片文件上传目录（Web版图片根目录）。
//     * <p/>
//     * 例如：/web/www/mq/upload/images/
//     */
//    public File getUploadedImagesDir();
//
//    /**
//     * 返回上传的图片文件的根URL。Default: {@link #getImagesUrl()} + "/upload/images"
//     * <p/>
//     * 例如：http://static.domain.com/upload/images
//     */
//    public String getUploadedImagesRootUrl();
//
//    /**
//     * 返回服务器端用户上传的图片根目录（web版用户图片根目录）。
//     * <p/>
//     * 例如：/web/www/mq/upload/images/users/
//     */
//    public File getUploadedImagesUserDir();
//
//    /**
//     * 返回服务器端后台管理员上传的图片根目录（web版系统图片根目录）。
//     * <p/>
//     * 例如：/web/www/mq/upload/images/sys/
//     */
//    public File getUploadedImagesSysDir();
//
//    /**
//     * 返回服务器端其它文件上传目录（txt、doc、cfg等）
//     * <p/>
//     * 例如：/web/www/mq/upload/others/
//     */
//    public File getUploadedOthersDir();
}
