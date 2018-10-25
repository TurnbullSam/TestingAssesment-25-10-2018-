package com.qa;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JSonObejcts 
{

			
	public JSONObject postObject(int id)
	{
		JSONObject JSONOb = new JSONObject();
		JSONObject pets = new JSONObject();
		
		JSONArray jsonArray = new JSONArray();
		JSONOb.put("address" , "test");//
		JSONOb.put("city" , "test");//
		JSONOb.put("firstName" , "test");//
		JSONOb.put("id" , id);//
		JSONOb.put("lastName" , "test");//
		JSONOb.put("telephone" , "0");//
		
		
		pets.put("birthDate", "2018-10-25T08:38:43.570Z");//
		pets.put("id" , 1);//
		pets.put("name" , "testpet");//
		pets.put("owner" , id);//
		pets.put("type","{\"id\": 0,\"name\": \"string\"}");//
		pets.put("visits", "[{\"date\": \"yyyy/MM/dd\",\"description\": \"string\",\"id\": 0,\"pet\": {}}]");
		JSONOb.put("pets",pets);
		
		return JSONOb;
	}
	public JSONObject putObject(int id)
	{
		JSONObject JSONOb = new JSONObject();
		JSONObject pets = new JSONObject();
		
		JSONArray jsonArray = new JSONArray();
		JSONOb.put("address" , "update");//
		JSONOb.put("city" , "update");//
		JSONOb.put("firstName" , "update");//
		JSONOb.put("id" , id);//
		JSONOb.put("lastName" , "update");//
		JSONOb.put("telephone" , "0");//
		
		pets.put("birthDate", "2018-10-25T08:38:43.570Z");//
		pets.put("id" , 1);//
		pets.put("name" , "updatepet");//
		pets.put("owner" , id);//
		pets.put("type","{\"id\": 0,\"name\": \"string\"}");//
		pets.put("visits", "[{\"date\": \"yyyy/MM/dd\",\"description\": \"string\",\"id\": 0,\"pet\": {}}]");
		JSONOb.put("pets",pets);
		return JSONOb;
	}

}
