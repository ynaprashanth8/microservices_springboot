package com.myspace.microservices.netflixzuulapigatewayserver;


import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class ZuulLoggingFilter extends ZuulFilter{
	
	private org.slf4j.Logger logging = LoggerFactory.getLogger(this.getClass());

	@Override
	public Object run() throws ZuulException {
		HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
		logging.info("request -> {} request uri -> {}", request, request.getRequestURI()); 
		return null;
	}
   //Should we need to filter this or not if yes then return true
	@Override
	public boolean shouldFilter() {
		return true;
	}
    //This will indicate the order of the filter
	@Override
	public int filterOrder() {
		return 1;
	}
  //when you wnat to filter "pre" mean before the request, error when we have error, post after the request is posted 
	@Override
	public String filterType() {
		return "pre";
	}

}
