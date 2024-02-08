package com.mohap.testcases.waitingRoom;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mohap.core.BaseConfiguration;
import com.mohap.core.DataRecorder;
import com.mohap.pages.login.LoginPage;
import com.mohap.pages.patientRegistration.PatientRegistrationPage;
import com.mohap.pages.waitingRoom.WaitingRoomPage;
import com.mohap.testcases.patientRegistration.PatientRegistrationTestCases;
import com.mohap.utils.common.dataProvider;
import com.mohap.utils.selenium.ScreenShotGenerator;
import com.mohap.utils.selenium.WebUtils;

public class WaitingRoomTestCases extends BaseConfiguration {

	
	 private static final Logger LOGGER=LoggerFactory.getLogger(WaitingRoomTestCases.class);
     WebUtils utils;
     //private PatientRegistrationPage patientRegistration;
     private LoginPage login;
     private WaitingRoomPage waitingRoomPageObject;
     
@BeforeClass
public void setUp() {        
     utils=new WebUtils(driver);
    // patientRegistration=new PatientRegistrationPage(driver);
		DataRecorder.recordData(); // recording all excel sheet data before suite starts to execute.
	DataRecorder.recordLocators();  // recording all locators present in actions package
	login=new LoginPage(driver);
	waitingRoomPageObject=new WaitingRoomPage(driver);
	
	//********or login code  ***********
		 //====================================================================
		 Map<String,String> testData = DataRecorder.getTestData("VALID_LOGIN_Nurse_01");
			Map<String,String> profileCredientials=DataRecorder.PROFILES_CACHE.get(testData.get("profile"));
			System.err.println("This is Sunil Login Data"+testData);
			login.validlogin_Username_Password(profileCredientials.get("username"), profileCredientials.get("password")); 	 
		 //=====================================================================
	
     }
@AfterClass
public void closeDriver() {
	driver.quit();
}
  
@Test (dataProvider = "Complete Screening of a Patient"  , dataProviderClass = dataProvider.class)
public void completeScreeningOfPatientByNurse(String eFHPCEmirate,String eFHPCName,String eFHPCEmirateWaitingPopUp,String eAbdominal,String eBloodPressureHigh,
		String eBloodPressureLow,String eHeight,String eWeight,String eCholesterolTotal,String eFastingSugar,String eHDL) {
	
	
	     Reporter.log("====** -Admitting Patient from waiting room and completing the screening of a patient by Nurse - **====");
	  	
		waitingRoomPageObject.screeningStartsWithBloodTest(eFHPCEmirate, eFHPCName,eFHPCEmirateWaitingPopUp, eAbdominal, eBloodPressureHigh, eBloodPressureLow, eHeight, eWeight, eCholesterolTotal, eFastingSugar, eHDL);
	 
		ScreenShotGenerator.takeScreenShotAll(driver, "screening completed by Nurse");
		
		
		  Reporter.log("====Screening completed by Nurse ===");
	
	
}

	
	
	
	
	
	
	
	

	
	
	
	
}
