package com.bhatt.dao;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.bhatt.entity.HttpRequestEntity;
import com.mongodb.Mongo;
import com.mongodb.ServerAddress;


/**
 * use [database];
db.dropDatabase();
 * @author sbhatt
 *
 */
public class BaseDAO {

	@Autowired(required = true)
	private MongoTemplate template = null;
	private static List<ServerAddress> addrs = new ArrayList<ServerAddress>();
	private static int MONGO_PORT = 27017;

	static {
		try {
			addrs.add(new ServerAddress("localhost", MONGO_PORT));
		} catch (UnknownHostException ex) {
			ex.printStackTrace();
			System.out.println("ERROR CONNECTING TO DATABASE");
		}
	}

	private String dbName;

	public BaseDAO(String dbName) {
		this.dbName = dbName;
	}

	public void setTemplate(MongoTemplate temp) {
		this.template = temp;
	}

	public synchronized MongoTemplate getTemplate() {
		if (template == null) {
			Mongo mongo = null;
			mongo = new Mongo(addrs);
			template = new MongoTemplate(mongo, this.dbName);
			//if(template.collectionExists(HttpRequestEntity.class))
			//	template.dropCollection(HttpRequestEntity.class);
			
			
		}
		System.out.println("BEFORE!!");
		if(!template.collectionExists(HttpRequestEntity.class)){
			System.out.println("WE GOT IN!!");
			CollectionOptions options = new CollectionOptions(1,2,true);
	        template.createCollection(HttpRequestEntity.class, options);
	        
		}	

		return template;
	}

}
