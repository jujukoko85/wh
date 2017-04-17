package com.wenhua.base.web.util;

import com.google.common.base.Preconditions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.util.StringUtils;


//import java.io.File;
import java.util.regex.Pattern;

import static org.springframework.util.StringUtils.*;

/**
 * 
 *
 * @author Yichuan
 * @version $Id$
 * @since 1.0
 */
public class DefaultAppConfig implements AppConfig {

    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());
    
    public static DefaultAppConfig getInstance() {
        return INSTANCE;
    }

    private static final DefaultAppConfig INSTANCE = new DefaultAppConfig();

    private String rootDomain;
    private String siteDomain;
    private String siteUrl;
    private String imagesUrl;
    private String stylesUrl;
    private String scriptsUrl;
    private String excelDownloadUrl;
    private String tempDir;

    private Theme theme;
    private int captchaCount = 3;

//    private String uploadedDirPath;
//    private String uploadedImagesDirPath;
//    private String uploadedImagesUserDirPath;
//    private String uploadedImagesSysDirPath;
//    private String uploadedOtherDirPath;
//    private File uploadedDir;
//    private File uploadedImagesDir;
//    private File uploadedImagesUserDir;
//    private File uploadedImagesSysDir;
//    private File uploadedOthersDir;
//    private String uploadedImagesRootUrl;
    
    protected DefaultAppConfig() {
    }

    @Override
    public String getRootDomain() {
        return rootDomain;
    }

    @Override
    public String getCookieRootDomain() {
        if (hasText(rootDomain)) {
            if (Pattern.matches("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}", rootDomain)) {
                return rootDomain;
            }
        }
        if (countOccurrencesOf(rootDomain, ".") > 1) {
            return rootDomain;
        } else {
            return String.format(".%s", rootDomain);
        }
    }

    @Override
    public String getSiteDomain() {
        return siteDomain;
    }

    @Override
    public String getSiteUrl() {
        return siteUrl;
    }

    @Override
    public String getImagesUrl() {
        return imagesUrl;
    }

    @Override
    public String getScriptsUrl() {
        return scriptsUrl;
    }

    @Override
    public String getStylesUrl() {
        return stylesUrl;
    }

    @Override
    public Theme getTheme() {
        return theme;
    }

    @Override
    public int getCaptchaCount() {
        return captchaCount;
    }

    public void setRootDomain(String rootDomain) {
        this.rootDomain = rootDomain;
    }

    public void setCookieRootDomain(String cookieRootDomain) {
    }

    public String getExcelDownloadUrl() {
        return excelDownloadUrl;
    }

    public void setSiteDomain(String siteDomain) {
        Preconditions.checkArgument(siteDomain != null, "The configuration property 'siteDomain' must not be null");
        if (startsWithIgnoreCase(siteDomain, "http://")) {
            this.siteDomain = siteDomain.substring(7);
        } else {
            this.siteDomain = siteDomain;
        }
        siteUrl = "http://".concat(siteDomain);
    }
    
    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl;
    }
    
    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public void setStylesUrl(String stylesUrl) {
        this.stylesUrl = stylesUrl;
    }

    public void setScriptsUrl(String scriptsUrl) {
        this.scriptsUrl = scriptsUrl;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    public void setCaptchaCount(int captchaCount) {
        this.captchaCount = captchaCount;
    }
    
    public void setThemeName(final String name) {
        setTheme(new Theme() {
            
            @Override
            public String getName() {
                // TODO Auto-generated method stub
                return name;
            }
        });
    }

    public void setExcelDownloadUrl(String excelDownloadUrl) {
        this.excelDownloadUrl = excelDownloadUrl;
    }

	@Override
	public String getTempDir() {
		return this.tempDir;
	}

	public void setTempDir(String tempDir) {
		this.tempDir = tempDir;
	}
	

//    @Override
//    public File getUploadedDir() {
//        return uploadedDir;
//    }
//
//    @Override
//    public File getUploadedImagesDir() {
//        return uploadedImagesDir;
//    }
//
//    @Override
//    public String getUploadedImagesRootUrl() {
//        return uploadedImagesRootUrl;
//    }
//
//    @Override
//    public File getUploadedImagesUserDir() {
//        return uploadedImagesUserDir;
//    }
//
//    @Override
//    public File getUploadedImagesSysDir() {
//        return uploadedImagesSysDir;
//    }
//
//    @Override
//    public File getUploadedOthersDir() {
//        return uploadedOthersDir;
//    }
//
//    /**
//     * Sets {@link #uploadedDir} File object with path string.
//     *
//     * @param uploadedDirPath uploadedDir path string.
//     * @throws IllegalAccessException if security access error.
//     */
//    public void setUploadedDirPath(String uploadedDirPath) throws IllegalAccessException {
//        this.uploadedDirPath = uploadedDirPath;
//    }
//
//    public void setUploadedImagesDirPath(String uploadedImagesDirPath) {
//        this.uploadedImagesDirPath = uploadedImagesDirPath;
//    }
//
//    public void setUploadedImagesUserDirPath(String uploadedImagesUserDirPath) {
//        this.uploadedImagesUserDirPath = uploadedImagesUserDirPath;
//    }
//
//    public void setUploadedImagesSysDirPath(String uploadedImagesSysDirPath) {
//        this.uploadedImagesSysDirPath = uploadedImagesSysDirPath;
//    }
//
//    public void setUploadedOtherDirPath(String uploadedOtherDirPath) {
//        this.uploadedOtherDirPath = uploadedOtherDirPath;
//    }
//
//    public void setUploadedImagesRootUrl(String uploadedImagesRootUrl) {
//        this.uploadedImagesRootUrl = uploadedImagesRootUrl;
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//        if (!StringUtils.hasText(uploadedDirPath)) {
//            throw new IllegalArgumentException("The 'uploadedDirPath' must not be null or empty.");
//        }
//        uploadedDir = new File(uploadedDirPath);
//        makeDirIfNecessary(uploadedDir, "uploadedDirPath");
//
//        /* initialize uploadedImagesDir */
//        if (!StringUtils.hasText(uploadedImagesDirPath)) {
//            uploadedImagesDir = new File(uploadedDir, "/images");
//        } else {
//            uploadedImagesDir = new File(uploadedImagesDirPath);
//        }
//        makeDirIfNecessary(uploadedImagesDir, "uploadedImagesDirPath");
//
//        /* initialize uploadedImagesSysDir */
//        if (!StringUtils.hasText(uploadedImagesSysDirPath)) {
//            uploadedImagesSysDir = new File(uploadedImagesDir, "/sys");
//        } else {
//            uploadedImagesSysDir = new File(uploadedImagesSysDirPath);
//        }
//        makeDirIfNecessary(uploadedImagesSysDir, "uploadedImagesSysDirPath");
//
//        /* initialize uploadedImagesUserDir */
//        if (!StringUtils.hasText(uploadedImagesUserDirPath)) {
//            uploadedImagesUserDir = new File(uploadedImagesDir, "/users");
//        } else {
//            uploadedImagesUserDir = new File(uploadedImagesUserDirPath);
//        }
//        makeDirIfNecessary(uploadedImagesUserDir, "uploadedImagesUserDirPath");
//
//        /* initialize uploadedOthersDir */
//        if (!StringUtils.hasText(uploadedOtherDirPath)) {
//            uploadedOthersDir = new File(uploadedDir, "/others");
//        } else {
//            uploadedOthersDir = new File(uploadedOtherDirPath);
//        }
//        makeDirIfNecessary(uploadedOthersDir, "uploadedOtherDirPath");
//
//        if (!StringUtils.hasText(uploadedImagesRootUrl)) {
//            uploadedImagesRootUrl = getImagesUrl() + "/upload/images";
//        }
//    }
//
//    private void makeDirIfNecessary(final File target, String pathName)
//            throws IllegalAccessException {
//        if (!target.exists()) {
//            LOGGER.debug("The '{}' -> \"{}\" dir not exists. it will be created by application.", pathName, target);
//            if (!target.mkdirs()) {
//                throw new IllegalAccessException(String.format("The application cannot make dirs for %s", target));
//            }
//            LOGGER.info("The application make dir: {}", target.getPath());
//        } else {
//            LOGGER.debug("The '{}' -> \"{}\" already exists.", pathName, target);
//        }
//    }
}
