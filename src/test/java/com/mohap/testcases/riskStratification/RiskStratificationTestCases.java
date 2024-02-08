package com.mohap.testcases.riskStratification;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;

import com.mohap.core.BaseConfiguration;
import com.mohap.core.DataRecorder;
import com.mohap.pages.ConsultTasks.AllconsultTasksPage;
import com.mohap.pages.login.LoginPage;
import com.mohap.pages.riskStratification.RiskStratificationPage;
import com.mohap.pages.waitingRoom.WaitingRoomPage;
import com.mohap.testcases.ConsultTasks.AllconsultTasksTestCases;
import com.mohap.utils.selenium.WebUtils;

public class RiskStratificationTestCases extends BaseConfiguration{

	 private static final Logger LOGGER=LoggerFactory.getLogger(RiskStratificationTestCases.class);
     WebUtils utils;
                               
     private LoginPage login;
     private RiskStratificationPage RiskStratificationPageObject;
         
@BeforeClass
public void setUp() {        
     utils=new WebUtils(driver);
	DataRecorder.recordData(); // recording all excel sheet data before suite starts to execute.
	DataRecorder.recordLocators();  // recording all locators present in actions package
	login=new LoginPage(driver);
	RiskStratificationPageObject=new RiskStratificationPage(driver);
	 //********or login code  ***********
	 //====================================================================
 
	 Map<String,String> testData = DataRecorder.getTestData("VALID_LOGIN_01");
		Map<String,String> profileCredientials=DataRecorder.PROFILES_CACHE.get(testData.get("profile"));
		System.err.println(testData);
		login.validlogin_Username_Password(profileCredientials.get("username"), profileCredientials.get("password")); 	
	 //======================================================================
		 
     } 


  
	
	
	
	
	  
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
