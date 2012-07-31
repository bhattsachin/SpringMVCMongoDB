package com.bhatt.util;

import java.util.List;

import com.bhatt.entity.HttpRequestEntity;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class DataTableHelper {

	public static final String EMPTY_STRING = "";

	public static String getDataTableJson(List<HttpRequestEntity> entities) {

		JsonObject obj = new JsonObject();
		JsonArray tableArr = new JsonArray();
		int totalRecords = 0;

		totalRecords = entities.size();
		JsonArray rowArr = null;
		if (entities.size() > 0) {
			for (HttpRequestEntity logEntry : entities) {
				rowArr = new JsonArray();
				rowArr.add(new JsonPrimitive((logEntry.getType())==null?EMPTY_STRING:logEntry.getType()));
				rowArr.add(new JsonPrimitive((logEntry.getBody())==null?EMPTY_STRING:logEntry.getBody()));
				rowArr.add(new JsonPrimitive((String.valueOf(logEntry.getCreationdate()))==null?EMPTY_STRING:String.valueOf(logEntry.getCreationdate())));
				rowArr.add(new JsonPrimitive((logEntry.getUid())==null?EMPTY_STRING:logEntry.getUid()));
				tableArr.add(rowArr);
			}
		}

		obj.add("aaData", tableArr);
		obj.add("iTotalRecords", new JsonPrimitive(totalRecords));
		obj.add("iTotalDisplayRecords", new JsonPrimitive(totalRecords));

		return obj.toString();

	}

}
