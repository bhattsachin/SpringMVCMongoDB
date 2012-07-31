package com.bhatt.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;

public class HttpRequestEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String url;
	//READ/UPDATE/MODIFY
	private String type;
	private String body;
	private String response;
	@Indexed
	private String uid;
	@Id
	@Indexed
	private String guid;
	private Date creationdate;
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	
	public Date getCreationdate() {
		return creationdate;
	}
	public void setCreationdate(Date creationdate) {
		this.creationdate = creationdate;
	}
	@Override
	public String toString() {
		return "HttpRequestEntity [url=" + url + ", type=" + type + ", body="
				+ body + ", response=" + response + ", uid=" + uid + ", guid="
				+ guid + ", creationdate=" + creationdate + "]";
	}
	

}
