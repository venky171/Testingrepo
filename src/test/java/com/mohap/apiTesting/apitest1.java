package com.mohap.apiTesting;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static org.hamcrest.Matchers.*;

import com.mohap.apiFiles.payloads;
import com.mohap.apiTestingPojo.GetCourse;

import static io.restassured.RestAssured.*;
public class apitest1 {

	public static void main(String[] args) {
			 
		
		RestAssured.baseURI="http://192.168.0.76";
		
		String response=given().log().all().queryParam("entityId", "9").queryParam("userId","153512" ).header("Content-Type","application/json")
		.body(payloads.processCheckBody()).when().post("api/v1/ProcessCheck/SaveNewProcessCheckRequest")
		
		.then().assertThat().statusCode(200)
		.header("Server", "Microsoft-IIS/10.0").extract().response().asString();
		
		//.header("Server", "Microsoft-IIS/10.0").extract().response().as(GetCourse.class);
		
		
		
		System.out.println(response);
		  JsonPath js=new JsonPath(response);  //for parsing Json
		 String res=   js.getString("ResultDesc");
		    
		 
		 
		 
		
		
		
		
		

	}

}
