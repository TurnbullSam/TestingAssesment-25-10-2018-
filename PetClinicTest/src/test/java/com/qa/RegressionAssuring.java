package com.qa;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.relevantcodes.extentreports.LogStatus;

import groovyjarjarantlr.ParserSharedInputState;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RegressionAssuring 
{
	
	public int IDreturn()
	{
		Constants con = new Constants();
		JSONArray array = null;
		RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
		Response response = null;
		request = RestAssured.given().contentType(ContentType.JSON).header("Content-Type", "application/json");
		
		 response = request.when().get(con.URLmain + con.URLget);
		 JSONParser parser = new JSONParser();
		  String str = response.asString();
		 try {
			array = (JSONArray) parser.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object[] test = array.toArray();
		int lnth = test.length;
		
		JSONObject LastObject = new JSONObject();
		try {
			LastObject = (JSONObject) parser.parse(test[lnth-1].toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int returnVal = Integer.parseInt(LastObject.get("id").toString());
		return returnVal;
		
	}
	
}
