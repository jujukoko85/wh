package com.wenhua.base.web.vo;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.wenhua.util.i18n.ResourceBundleMessageSource;


@Component
public class VoComponent {

	private static ResourceBundleMessageSource messageSource;
	
	 /**
     * 返回指定键的国际化资源信息。
     *
     * @param key    国际化资源Key。
     * @param params 参数（{0} {1} ...）。
     * @return 国际化资源信息。
     */
	public static String getText(String key, Object... params) {
		 return messageSource.getMessage(key, params, new Locale(""));
	}

	public ResourceBundleMessageSource getMessageSource() {
		return messageSource;
	}

	@Resource
	public void setMessageSource(
			ResourceBundleMessageSource messageSource) {
		VoComponent.messageSource = messageSource;
	}

}
