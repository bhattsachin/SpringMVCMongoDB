package com.bhatt.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import com.bhatt.dao.HttpRequestEntityDAO;
import com.bhatt.entity.HttpRequestEntity;
import com.bhatt.util.DataTableHelper;

@Controller
public class RequestController{

	protected final Log logger = LogFactory.getLog(getClass());
	
	
	@RequestMapping(value = { "/log/post", "/post.htm" }, method = RequestMethod.POST)
	public @ResponseBody String handleRequest() throws Exception {
		logger.info("Returning post request");
		
        return "OK POST RESPONSE";
	}
	
	@RequestMapping(value = { "/getall", "/getall.htm" }, method = RequestMethod.GET)
	public @ResponseBody String getAll(){
		
		HttpRequestEntityDAO dao = HttpRequestEntityDAO.getInstance();
		List<HttpRequestEntity> list = dao.getAll();
		StringBuilder sb = new StringBuilder();
		
		for(HttpRequestEntity entity : list){
			sb.append(entity + "</br>");
		}
		
		return sb.toString();
	}
	
	@RequestMapping(value = { "/getalljson", "/view/getalljson" }, method = RequestMethod.GET)
	public @ResponseBody String getAllJson(){
		HttpRequestEntityDAO dao = HttpRequestEntityDAO.getInstance();
		List<HttpRequestEntity> list = dao.getAll();
		//StringBuilder sb = new StringBuilder();
		
		return DataTableHelper.getDataTableJson(list);
		
		//return sb.toString();
	}
	
	@RequestMapping(value = { "/log/get", "/get.htm" }, method = RequestMethod.GET)
	public @ResponseBody String handleGetRequest() throws Exception {
		logger.info("Returning get request");

		return "OK GET REQUEST";
	}
	
	@RequestMapping(value = { "/", "/hello.htm" }, method = RequestMethod.GET)
	public ModelAndView handleIndex() throws Exception {
		logger.info("Returning get request");

		return new ModelAndView("index");
	}
	
	/**
	@RequestMapping(value = { "/viewlogs", }, method = RequestMethod.GET)
	public String logs() {
		logger.info("Returning get request");

		//return "happy now";
		return ("redirect:logs");
	}
	
	*/
	
	@RequestMapping(value = "/view/logs", method = RequestMethod.GET)
	public ModelAndView logsPage() {
		logger.info("Returning get request");

		//return "happy now";
		return new ModelAndView("logs");
	}
	

}
