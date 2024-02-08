package com.mohap.tests.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mohap.actions.web.LoginActions;
import com.mohap.core.BaseConfiguration;
import com.mohap.core.DataRecorder;
import com.mohap.utils.selenium.WebUtils;

public class UserTest extends BaseConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserTest.class);
	private LoginActions loginActions;
	WebUtils utils;

	@BeforeClass
	public void setUp() {
		loginActions = new LoginActions(driver);
		utils = new WebUtils(driver);
	}

	@Test(testName = "USER_TEST_1")
	public void userTest_1() {
		Reporter.log("Inside USER_TEST_1");
		
		Map<String,String> testData = DataRecorder.getTestData("USER_TEST_1");

		loginActions.loginWithDefaultCreds();
		utils.sleep(10);
	}

	@Test(testName = "USER_TEST_2")
	public void userTest_2(ITestContext context) {
		Reporter.log("Inside USER_TEST_2");
		  
		Map<String,String> testData = DataRecorder.getTestData("USER_TEST_2");


		loginActions.loginWithDefaultCreds();
	}

	@Test(testName = "USER_TEST_3")
	public void userTest_3() {
		Reporter.log("Inside USER_TEST_3");
		
		Map<String,String> testData = DataRecorder.getTestData("USER_TEST_3");

		loginActions.loginWithDefaultCreds();
	}

	@Test(testName = "USER_TEST_4")
	public void userTest_4() {
		Reporter.log("Inside USER_TEST_4");
		
		Map<String,String> testData = DataRecorder.getTestData("USER_TEST_3");

		loginActions.hello();
	}

}
