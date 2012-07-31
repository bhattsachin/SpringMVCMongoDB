package com.bhatt.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.OncePerRequestFilter;

import com.bhatt.dao.HttpRequestEntityDAO;
import com.bhatt.entity.HttpRequestEntity;
import com.bhatt.helper.HttpRequestWrapper;
import com.bhatt.util.LoggingHttpResponseWrapper;
import com.bhatt.util.ObjectId;

public class RequestFilter extends OncePerRequestFilter {
	
	

	@Override
	protected void initFilterBean() throws ServletException {
		
		super.initFilterBean();
		
		System.out.println("---------------------BEAN INIT ------------------");
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req,
			HttpServletResponse resp, FilterChain chain)
			throws ServletException, IOException {
		
		if (resp.getCharacterEncoding() == null) {
            resp.setCharacterEncoding("UTF-8"); // Or whatever default. UTF-8 is good for World Domination.
        }
		
		String hostString = req.getHeader("HOST");
		String requestMethod = req.getMethod();
		HttpRequestWrapper reqWrapper = new HttpRequestWrapper(req);

		String requestedPage = getRequestedPage(req);
		System.out.println("URL: " + hostString); 
		System.out.println("REQUESTED_PAGE: " + requestedPage );
	    System.out.println("BODY: " + reqWrapper.getBody());
	    System.out.println("REQUESTED METHOD: " + requestMethod);
	     
		System.out.println("----- INSIDE FILTER -----");
		
		LoggingHttpResponseWrapper respWrapper = new LoggingHttpResponseWrapper((HttpServletResponse) resp);

		
		//final CopyPrintWriter writer = new CopyPrintWriter(resp.getWriter());
		chain.doFilter(req, respWrapper);
		
		//chain.doFilter(req, resp);
		respWrapper.flushBuffer();
		
		 byte[] copy = respWrapper.getCopy();
        String response = new String(copy, resp.getCharacterEncoding());
		
		System.out.println("RESPONSE -> " + response);
		
		
		HttpRequestEntityDAO dao = HttpRequestEntityDAO.getInstance();
		HttpRequestEntity entity = new HttpRequestEntity();
		Date currDate = new Date();
		
		entity.setBody(reqWrapper.getBody() + " " + currDate.toLocaleString() + " " + response);
		entity.setType(requestMethod);
		entity.setUid("");
		ObjectId id = new ObjectId();
		entity.setGuid(id.toStringMongod());
		entity.setUrl(requestedPage);
		
		entity.setCreationdate(new Date());
		
		
		dao.save(entity);
		
		

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



}
