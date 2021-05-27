package com.mvc.upgrade.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogFilter implements Filter {

	private Logger logger = LoggerFactory.getLogger(LogFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		
		String remoteAddr = req.getRemoteAddr(); // ip 주소 ipv6, localhost 대신에 127.0.0.1로 하면 ipv4로 나온다.
		String uri = req.getRequestURI(); // http 요청 url 중에 queryString까지 반환. (context path)
		String url = req.getRequestURL().toString(); // protocol + servername + portnumber + serverpath : 전체 주소
		String queryString = req.getQueryString(); // key=value 형태로 데이터 전달
		
		String referer = req.getHeader("referer"); // 이전 페이지의 url(getHeader: 지정한 요청 헤더값을 문자열로 반환)
		String agent = req.getHeader("User-Agent"); // 사용자 정보(browser version, os 등)
		
		StringBuffer sb = new StringBuffer();
		sb.append("\n+ remoteAddr : " + remoteAddr)
		  .append("\n* uri : " + uri)
		  .append("\n* url : " + url)
		  .append("\n* queryString : " + queryString)
		  .append("\n* referer : " + referer)
		  .append("\n* agent : " + agent)
		  .append("\n");
		
		logger.info("\nLOG Filter" + sb);
		
		chain.doFilter(req, response);
		
	}

	@Override
	public void destroy() {
		

	}

}
