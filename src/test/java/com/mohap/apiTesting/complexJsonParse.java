package com.mohap.apiTesting;

import com.mohap.apiFiles.payloads;

import io.restassured.path.json.JsonPath;

public class complexJsonParse {

	public static void main(String[] args) {
			
		JsonPath js = new JsonPath(payloads.CoursePrice());
		// print no of courses returned by API
		int count = js.getInt("courses.size()");
		System.out.println(count);

		// print purchase amount
		int totalAmount = js.getInt("dashboard.purchaseAmount");
		System.out.println(totalAmount);

		// print titile of 1st course
		String titleFirstCourse = js.get("courses[0].title");
		System.out.println(titleFirstCourse);
		 	
		for(int i=0;i<count;i++) {
		String courseTitles=js.get("courses["+i+"].title");
		       int coursePrice=js.getInt("courses["+i+"].price");
		System.out.println(courseTitles +" Price= "+ coursePrice);
		}
		
		//print no. of copies sold by RPA Course
		
		for(int i=0;i<count;i++) {
			String courseTitles=js.get("courses["+i+"].title");
			    if(courseTitles.equalsIgnoreCase("RPA")) {
			    	int copies=js.getInt("courses["+i+"].copies");
			    	System.out.println(copies);
			    	break;
			    }
			
			}
		
		
		
		
		
		
		
	}

}
