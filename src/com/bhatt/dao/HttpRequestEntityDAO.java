package com.bhatt.dao;

import java.util.List;

import com.bhatt.entity.HttpRequestEntity;

public class HttpRequestEntityDAO extends BaseDAO {

	private final static String HTTP_DOCUMENT = "httpdocument";
	
	private static HttpRequestEntityDAO dao = new HttpRequestEntityDAO();
	
	private HttpRequestEntityDAO() {
		super(HTTP_DOCUMENT);
		
		//DBCollection collection;
		
	}
	
	public static HttpRequestEntityDAO getInstance(){
		return dao;
	}
	
	public void save(HttpRequestEntity entity){
		getTemplate().save(entity);
	}
	
	public List<HttpRequestEntity> getAll(){
		List<HttpRequestEntity> result;
		result = getTemplate().findAll(HttpRequestEntity.class);
		
		return result;
	}
	
	
	
	
	
	

}
