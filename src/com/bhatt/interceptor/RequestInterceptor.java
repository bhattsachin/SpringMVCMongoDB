package com.bhatt.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bhatt.helper.HttpRequestWrapper;
;

@Component
public class RequestInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest httpRequest,
			HttpServletResponse httpResponse, Object handler) throws Exception {

		   String hostString = httpRequest.getHeader("HOST");
		   String requestedPage = getRequestedPage(httpRequest); 
	       
	       System.out.println("URL: " + hostString); 
	       System.out.println("REQUESTED PAGE: " + requestedPage);
	       HttpRequestWrapper reqWrapper = new HttpRequestWrapper(httpRequest);
	       System.out.println("BODY: " + reqWrapper.getBody());
	       
	       System.out.println();
	       return true;
	    } 

	    private String getRequestedPage( 
	            HttpServletRequest aHttpRequest) { 
	        String url = aHttpRequest.getRequestURI(); 
	        int firstSlash = url.indexOf("/",1); 
	        String requestedPage = null; 
	        if (firstSlash != -1) requestedPage = 
	            url.substring(firstSlash + 1, url.length()); 
	        return requestedPage; 
	    } 



	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
		System.out.println("RESPONSE: " + response.toString());
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		super.afterCompletion(request, response, handler, ex);
	}


}
