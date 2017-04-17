package com.wenhua.base.web.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.wenhua.base.web.util.ParameterTrimRequestWrapper;

public class ParameterTrimFilter extends OncePerRequestFilter {

	public ParameterTrimFilter() {
		
	}
	
	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
			ParameterTrimRequestWrapper requestWrapper = new ParameterTrimRequestWrapper(request);
	        filterChain.doFilter(requestWrapper, response);
	}
}