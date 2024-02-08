package com.mohap.testcases.login;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory; 
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.aventstack.extentreports.externalconfig.model.Config;
import com.mohap.core.BaseConfiguration;
import com.mohap.core.DataRecorder;
import com.mohap.pages.login.LoginPage;
import com.mohap.utils.common.ExcelUtilsMy;
import com.mohap.utils.common.dataProvider;
import com.mohap.utils.selenium.ScreenShotGenerator;
import com.mohap.utils.selenium.WebUtils;

import ch.lambdaj.function.matcher.NotNullOrEmptyMatcher;

public class LoginTestCases extends BaseConfiguration

{	 
	  
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginTestCases.class);
	WebUtils utils;
	private LoginPage login;  
	
	@BeforeClass
	public void setUp() { 
		utils=new WebUtils(driver);
		login=new LoginPage(driver);  
		DataRecorder.recordData(); // recording all excel sheet data before suite starts to execute.
		DataRecorder.recordLocators();  // recording all locators present in actions package	
	}	 
	 
	//@Test(testName = "LoginTestCases") Getting data using MAP
	//@Test(priority=1,testName = "VALID_LOGIN_01")
	public void validLogin() {
		
		Reporter.log("This is valid username and password user test");
		
		Map<String,String> testData = DataRecorder.getTestData("VALID_LOGIN_01");
		
		Map<String,String> profileCredientials=DataRecorder.PROFILES_CACHE.get(testData.get("profile"));
		System.err.println(testData);
		login.validlogin_Username_Password(profileCredientials.get("username"), profileCredientials.get("password")); 	              
	}	  	
	
	//@Test(testName = "Login test all possible username and password")
	@Test(dataProvider = "loginTest", dataProviderClass = dataProvider.class)
	public void loginAllScenarios(String userName, String password, String test) {
		
		Reporter.log("Testing all scenarios of username and password combination using data provider");
		//if(userName != null && userName != "" && password != null && password != "") {

			login.login_TestAllScenarios(userName,password,test);
			ScreenShotGenerator.takeScreenShotAll(driver, "sunilScreenshots"); 
	  
	}     
	
}
