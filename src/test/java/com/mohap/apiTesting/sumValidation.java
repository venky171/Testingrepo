package com.mohap.apiTesting;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mohap.apiFiles.payloads;

import io.restassured.path.json.JsonPath;

public class sumValidation {

		
		
		@Test
		public void sumOfCourses() {
			// verify if sum of all course prices matches with Purchase Amount
			
			int sum=0;
			JsonPath js = new JsonPath(payloads.CoursePrice());
			int count = js.getInt("courses.size()");
			
			for(int i=0;i<count;i++) {
                    int price=  js.getInt("courses["+i+"].price");
                    int copies=  js.getInt("courses["+i+"].copies");
			         int amount=price*copies;
			         System.out.println(amount);
			         sum=sum+amount;		
		}
		
			 System.out.println(sum);
		int purchaseAmount=  js.getInt("dashboard.purchaseAmount");
		 System.out.println("Purchase Amount="+purchaseAmount);
		
		Assert.assertEquals(sum, purchaseAmount);
		
		}
		
		
		 
		
		
		
		
		
		
		
	

}
