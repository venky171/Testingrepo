package com.mohap.apiTestingPojo;

import java.util.ArrayList;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class serialization {

	public static void main(String[]args) {
		
		RestAssured.baseURI="https://rahulshettyacademy.com";
		
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
		  
	    
		Response res = given().queryParam("key", "qaclick123").body(p).log().all()
				.when().post("/maps/api/place/add/json")
				.then().assertThat().statusCode(200).extract().response();

		String responseString = res.asString();

		System.out.println(responseString);
	    
  
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
