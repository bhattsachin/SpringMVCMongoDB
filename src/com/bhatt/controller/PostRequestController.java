package com.bhatt.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bhatt.dao.HttpRequestEntityDAO;
import com.bhatt.entity.HttpRequestEntity;
import com.bhatt.util.ObjectId;

@Controller
public class PostRequestController{

	protected final Log logger = LogFactory.getLog(getClass());
	
	
	@RequestMapping(value = { "/post", "/post.htm" }, method = RequestMethod.POST)
	public ModelAndView handleRequest() throws Exception {
		String param1 = "";
        //@RequestParam String param2, @RequestParam String param3,@RequestParam String param4
		logger.info("Returning post request");
		param1 = param1 + System.currentTimeMillis();
		//param2 = param2 + System.currentTimeMillis();
		//param3 = param3 + System.currentTimeMillis();
		//param4 = param4 + System.currentTimeMillis();
		
		
		//save to database
		HttpRequestEntityDAO dao = HttpRequestEntityDAO.getInstance();
		HttpRequestEntity entity = new HttpRequestEntity();
		Date currDate = new Date();
		
		entity.setBody(currDate.toLocaleString());
		entity.setType(param1);
		entity.setUid(param1);
		ObjectId id = new ObjectId();
		entity.setGuid(id.toStringMongod());
		entity.setUrl(param1);
		
		
		
		
		dao.save(entity);
		
        return new ModelAndView("post.jsp");
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
	
	

}
