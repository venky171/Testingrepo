package com.mohap.apiTestingPojo;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FinalRun {

	public static void main(String[] args) {
		
		    
	
		RestAssured.baseURI="http://192.168.0.76";
		
		 ProcessDetail pd1=new ProcessDetail();
		 pd1.setIconUrl("www.iconURLfortesting");
		 pd1.setIsFavourite(true);
		 pd1.setMobileIconUrl("www.mobileURL.com");
		 pd1.setPendingActionCount(2);
		 pd1.setProcessId(2);
		 pd1.setProcessName("Sunil");
		 
		 List<ProcessDetail> list=new ArrayList<ProcessDetail>();
		 list.add(pd1);
		     
		   
		 ProcessBase processBaseObject=new ProcessBase();
		 processBaseObject.setResult(list);
		 processBaseObject.setResultCode(1);
		 processBaseObject.setResultDesc("test result description");
		 processBaseObject.setResultType(2);
		
		ProcessBase getRes=given().log().all().queryParam("userId", "153512").queryParam("languageId", "1").queryParam("entityId", "9").
				expect().defaultParser(Parser.JSON)
		.when().get("/api/v1/ProcessCheck/ProcessCheckListWithFavourite").as(ProcessBase.class);
		
		      
		                     
  
    System.out.println(getRes.getResultType());
		
		
		
		  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
