package com.wenhua.base.web.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;

/**
 * spring mvc 日期格式化
 * @author jujukoko
 *
 */
public class DateFormatter implements Formatter<Date> {

	@Override
	public String print(Date arg0, Locale arg1) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(arg0);
	}

	@Override
	public Date parse(String arg0, Locale arg1) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = format.parse(arg0);
		} catch (Exception e) {
			format = new SimpleDateFormat("yyyy-MM-dd");
			date = format.parse(arg0);
		}
		return date;
	}

}
