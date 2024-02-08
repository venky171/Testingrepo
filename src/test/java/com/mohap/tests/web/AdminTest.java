package com.mohap.tests.web;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mohap.actions.web.LoginActions;
import com.mohap.core.BaseConfiguration;
import com.mohap.core.DataRecorder;
import com.mohap.utils.selenium.WebUtils;

public class AdminTest extends BaseConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminTest.class);
	private LoginActions loginActions;
	private WebUtils utils;

	@BeforeClass
	public void setUp() {
		loginActions = new LoginActions(driver);
		utils = new WebUtils(driver);
	}

	@Test(testName = "ADMIN_TEST_1")
	public void adminTest_1() {
		Reporter.log("Inside ADMIN_TEST_1");

		Map<String, String> testData = DataRecorder.getTestData("ADMIN_TEST_1");

		loginActions.loginWithDefaultCreds();
		utils.sleep(20);

	}

	@Test(testName = "ADMIN_TEST_2")
	public void adminTest_2() {
		Reporter.log("Inside ADMIN_TEST_2");

		Map<String, String> testData = DataRecorder.getTestData("ADMIN_TEST_2");

		loginActions.loginWithDefaultCreds();
	}

	@Test(testName = "ADMIN_TEST_3")
	public void adminTest_3() {
		Reporter.log("Inside ADMIN_TEST_3");

		Map<String, String> testData = DataRecorder.getTestData("ADMIN_TEST_3");

		loginActions.hello();
	}

	@Test(testName = "ADMIN_TEST_4")
	public void adminTest_4() {
		Reporter.log("Inside ADMIN_TEST_4");
		
		Map<String, String> testData = DataRecorder.getTestData("ADMIN_TEST_4");
		loginActions.loginWithDefaultCreds();
	}


}
