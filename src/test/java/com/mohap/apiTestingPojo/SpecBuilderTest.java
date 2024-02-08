package com.mohap.apiTestingPojo;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.*;


public class SpecBuilderTest {

	public static void main(String[]args) {
		
		//RestAssured.baseURI="https://rahulshettyacademy.com";
		
		AddPlace p=new AddPlace();
		p.setAccuracy(50);
		p.setAddress("this addess is only for testing");
		p.setName("Frontline house");
		p.setPhone_number(8010031);
		p.setLanguage("English_id");
		p.setWebsite("www.google.com");
		
		List<String> myList=new ArrayList<String>();
	     myList.add("shoe park");
	     myList.add("shop");
	     
		p.setTypes(myList);
		Location l=new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);	
	    p.setLocation(l);
		    
	    
RequestSpecification reqSpec=new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com").addQueryParam("key", "quclick123").setContentType(ContentType.JSON).build();
ResponseSpecification  respSpec=new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();             
	    
	           
RequestSpecification req = given().spec(reqSpec).body(p);
			
   
   Response   response=    req.when().post("/maps/api/place/add/json").then().spec(respSpec).extract().response();

		
		String responseString = response.asString();

		System.out.println(responseString);
	    
  
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
