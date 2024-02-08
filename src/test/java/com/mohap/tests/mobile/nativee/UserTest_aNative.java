package com.mohap.tests.mobile.nativee;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mohap.actions.mobile.MLoginActions;
import com.mohap.core.BaseConfiguration;
import com.mohap.core.DataRecorder;
import com.mohap.utils.selenium.WebUtils;

public class UserTest_aNative extends BaseConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserTest_aNative.class);

	private WebUtils utils;
	private MLoginActions loginActions;

	@BeforeClass
	public void setup() {
		utils = new WebUtils(driver);
		loginActions = new MLoginActions(driver);
	}

	@Test(testName = "USER_MOBILE_TEST_1")
	public void userMobileTest_1() {
		Reporter.log("Inside USER_MOBILE_TEST_1");
		
		Map<String,String> testData = DataRecorder.getTestData("USER_MOBILE_TEST_1");

		loginActions.loginWithDefaultCreds();
		utils.sleep(5);

	}

	@Test(testName = "USER_MOBILE_TEST_2")
	public void userMobileTest_2() {
		Reporter.log("Inside USER_MOBILE_TEST_2");
		
		Map<String,String> testData = DataRecorder.getTestData("USER_MOBILE_TEST_2");

		loginActions.loginWithDefaultCreds();
		utils.sleep(5);

	}

}
