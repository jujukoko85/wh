package com.wenhua.base.web.controller;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.support.DelegatingMessageSource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.ui.ModelMap;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wenhua.base.web.context.AppContext;
import com.wenhua.base.web.util.AppConfigExt;
import com.wenhua.util.i18n.ResourceBundleMessageSource;

/**
 * SpringMVC 基础控制器。
 *
 * @author Fuchun
 * @version $Id: BaseController.java 30684 2013-05-28 11:29:25Z C629 $
 * @since 1.0
 */
public abstract class BaseController implements Serializable {

    private static final long serialVersionUID = 1L;
    
    /** 系统用户 */
    public static final String USER_SYSTEM = "system";
    /**
     * 默认的404视图名称。
     */
    protected static final String PAGE_NOT_FOUND = "/404";
    /**
     * 默认的没有权限的视图。
     */
    protected static final String NO_PERMISSION = "/403";
    /**
     * 重定向视图名称字符串模版。
     */
    protected static final String REDIRECT_TPL = "redirect:%s";
    /**
     * 请求转发字符串模板。
     */
    protected static final String FORWARD_TPL = "forward:%s";
    /**
     * 登录用户信息
     */
    protected static final String USER_INFO = "user";
    
    /**
     * 同步页面错误信息
     */
    protected static final String ERROR_MSGS = "errorMsgs";
    
    /**
     * 响应头
     */
    protected static final String JSON_PRODUCER = "text/json;charset=UTF-8";
    
    protected static final Integer DEFAULT_CURR_PAGE = 1;
    protected static final Integer DEFAULT_PAGE_SIZE = 12;
    protected static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    protected static final String DEFAULT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";
    protected static final String DEFAULT_SMALL_TIME_FORMAT = "HH:mm";
    
    protected final Logger LOGGER = LoggerFactory.getLogger(getClass());

    @Resource
    protected AppConfigExt appConfig;

//    @Resource
//    protected ModuleConfig moduleConfig;

    protected ResourceBundleMessageSource messageSource;

//    /**
//     * 返回重定向跳转至指定的视图的命令。
//     *
//     * @param viewName 视图名称。
//     * @return 跳转命令。
//     */
//    protected String redirect(String viewName) {
//        return String.format(REDIRECT_TPL, viewName);
//    }
    
//    /**
//     * 请求转发到指定action。
//     * @param actionName
//     * @return
//     */
//    protected String forward(String actionName) {
//    	return String.format(FORWARD_TPL, actionName);
//    }

    /**
     * 返回重定向的模型与视图对象。
     *
     * @param viewName 视图名称。
     * @return 重定向的模型与视图对象。
     */
    protected ModelAndView redirectView(String viewName, ModelMap model) {
    	model = build(model);
        return new ModelAndView(String.format(REDIRECT_TPL, viewName), model);
    }
    
    protected ModelAndView forward(String actionName, ModelMap model) {
    	model = build(model);
    	return new ModelAndView(new InternalResourceView(actionName), model);
    }
    
    /**
     * 禁止访问页面
     * @param model
     * @return
     */
    protected ModelAndView forbidden(ModelMap model) {
    	return view("/403.ftl", model);
    }
    
    protected ModelAndView view(String viewName, ModelMap model) {
        model = build(model);

        final String viewPath = Joiner.on("").join("/", "default", viewName);
        return new ModelAndView(viewPath, model);
    }

	private ModelMap build(ModelMap model) {
		if (model == null) {
            model = new ModelMap();
        }
        model.put(AppConfigExt.REF_NAME, appConfig);
//        model.put(ModuleConfig.REF_NAME, moduleConfig);
        if (AppContext.getUserDetails() != null) {
            model.put("currUser", AppContext.getUserExt());
            // 向后兼容
            model.put("name", AppContext.getUserDetails().getUsername());
            
            Collection<? extends GrantedAuthority> authorities = AppContext.getUserDetails().getAuthorities();
            if(null != authorities && 0 != authorities.size()) {
            	Map<String, GrantedAuthority> currUserRoles = Maps.newHashMap();
            	for(GrantedAuthority ga : authorities) {
            		currUserRoles.put(ga.getAuthority(), ga);
            	}
            	model.put("currUserRoles", currUserRoles);
            }
        }
		return model;
	}

    /**
     * 返回指定键的国际化资源信息。
     *
     * @param key    国际化资源Key。
     * @param params 参数（{0} {1} ...）。
     * @return 国际化资源信息。
     */
    protected String getText(String key, Object... params) {
        return messageSource.getMessage(key, params, new Locale(""));
    }

    @Resource
    public void setMessageSource(MessageSource messageSource) {
        if (messageSource instanceof ResourceBundleMessageSource) {
            this.messageSource = (ResourceBundleMessageSource) messageSource;
        } else if (messageSource instanceof DelegatingMessageSource) {
            this.messageSource = (ResourceBundleMessageSource) ((DelegatingMessageSource) messageSource).getParentMessageSource();
        }
    }
    
    /**
     * 产生错误信息
     * @param messages
     * @return
     */
    protected List<String> getErrorMsgs(String...messages) {
    	List<String> list = Lists.newArrayList();
    	if(null == messages) return list;
    	for(String message : messages) {
    		list.add(message);
    	}
    	return list;
    }
}
