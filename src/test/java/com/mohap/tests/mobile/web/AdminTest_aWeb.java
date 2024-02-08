package com.mohap.tests.mobile.web;

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

public class AdminTest_aWeb extends BaseConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(AdminTest_aWeb.class);

	private WebUtils utils;
	private LoginActions loginActions;

	@BeforeClass
	public void setup() {
		utils = new WebUtils(driver);
		loginActions = new LoginActions(driver);
	}

	@Test(testName = "ADMIN_MOBILE_TEST_1")
	public void adminMobileTest_1() {
		Reporter.log("Inside ADMIN_MOBILE_TEST_1");

		Map<String,String> testData = DataRecorder.getTestData("ADMIN_MOBILE_TEST_1");

		loginActions.loginWithDefaultCreds();
		utils.sleep(5);
	}

	@Test(testName = "ADMIN_MOBILE_TEST_2")
	public void adminMobileTest_2() {
		Reporter.log("Inside ADMIN_MOBILE_TEST_2");

		Map<String,String> testData = DataRecorder.getTestData("ADMIN_MOBILE_TEST_2");

		loginActions.loginWithDefaultCreds();
		utils.sleep(5);
	}

}
