package com.qa;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class BackEndTest_RestAssured 
{
	static ExtentReports extent = new ExtentReports("C:\\Users\\Admin\\Documents\\Testing Assessment\\PetAssessment.html",true);
	ExtentTest test;
	RequestSpecification request = RestAssured.given().contentType(ContentType.JSON);
	Response response = null;
	ValidatableResponse json = null;
	JSONObject JSONOb = null;
	Constants con = new Constants();
	RegressionAssuring RA = new RegressionAssuring();
	int id = 0;
	JSonObejcts inputObjects = new JSonObejcts();
	JSONArray array = null;
	
	@Test
	public void getData()
	{
		 test = extent.startTest("Verify application data is recived");
		
		 request = RestAssured.given().contentType(ContentType.JSON).header("Content-Type", "application/json");
		 test.log(LogStatus.INFO, "Sending Request to server ");
		 response = request.when().get(con.URLmain + con.URLget);
		  if(response.asString().equals(null))
		  {
			  test.log(LogStatus.FAIL, "Get data request Unsuccessfull");
		  }
		  else
		  {
			  test.log(LogStatus.PASS, "Get data request Successfull");  
		  }
		 extent.endTest(test);
		 extent.flush();
		 
		 response.then().statusCode(200);
		 response.prettyPrint();
		
	}
	@Test
	public void post_PutAndDeleteData()
	{
		//post data test
		int id1 = RA.IDreturn();
		int idDel = id1 - 1; 
		test = extent.startTest("Verify application can post data ");
		test.log(LogStatus.INFO, "Creating Body to send to the server");
		JSONOb = inputObjects.postObject(id1+1);
		
		test.log(LogStatus.INFO, "Specifing Content Type and the Body in the request");
		request.header("Content-Type", "application/json").body(JSONOb);
		
		test.log(LogStatus.INFO, "Sending Request to server ");
		response = request.post(con.URLmain + con.URLget);
		response.asString();
		
		if(response.statusCode() == 201)
		{
			test.log(LogStatus.PASS, "Post data request Successfull");  
		}
		else
		{
			 test.log(LogStatus.FAIL, "Post data request Unsuccessfull");
		}
		extent.endTest(test);
		extent.flush();
		response.then().statusCode(201);
		
		// Put / Update data test
		test = extent.startTest("Verify application can Put/Update data ");
		test.log(LogStatus.INFO, "Creating Body to send to the server");
		JSONOb = inputObjects.putObject(id);
		
		test.log(LogStatus.INFO, "Specifing Content Type and the Body in the request");
		request.header("Content-Type", "application/json").body(JSONOb);
		
		test.log(LogStatus.INFO, "Sending Request to server with specified ID");
		response = request.put(con.URLmain + con.URLget + "/" + id1);
		
		extent.endTest(test);
		extent.flush();
		
		if(response.statusCode() == 204)
		{
			test.log(LogStatus.PASS, "Put/Update data request Successfull");  
		}
		else
		{
			 test.log(LogStatus.FAIL, "Put/Update data request Unsuccessfull");
		}
		
		response.then().statusCode(204);
		
		
		//Delete data test
		test = extent.startTest("Verify application can Delete data ");
		
		test.log(LogStatus.INFO, "Sending Request to server with specified ID");
		Response response1 = request.delete(con.URLmain + con.URLget + "/" + id1);
		
		if(response1.statusCode() == 204)
		{
			test.log(LogStatus.PASS, "Delete data request Successfull");  
		}
		else
		{
			 test.log(LogStatus.FAIL, "Delete data request Unsuccessfull");
		}
		
		extent.endTest(test);
		extent.flush();
		response1.then().statusCode(204); 
	}
	
}
