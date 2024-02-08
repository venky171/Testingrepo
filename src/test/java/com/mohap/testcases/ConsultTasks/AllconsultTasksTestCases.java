package com.mohap.testcases.ConsultTasks;

import java.io.IOException;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.mohap.core.BaseConfiguration;
import com.mohap.core.DataRecorder;
import com.mohap.pages.ConsultTasks.AllconsultTasksPage;
import com.mohap.pages.login.LoginPage;
import com.mohap.pages.waitingRoom.WaitingRoomPage;
import com.mohap.reporter.extent.ExtentReporter;
import com.mohap.testcases.waitingRoom.WaitingRoomTestCases;
import com.mohap.utils.common.dataProvider;
import com.mohap.utils.selenium.ScreenShotGenerator;
import com.mohap.utils.selenium.WebUtils;

public class AllconsultTasksTestCases  extends BaseConfiguration {

	  
	 private static final Logger LOGGER=LoggerFactory.getLogger(AllconsultTasksTestCases.class);
     WebUtils utils;
                               
     private LoginPage login;
     private AllconsultTasksPage AllLabTestConsultTasksPageObject;
     private WaitingRoomPage waitingRoomPageObject;
         
@BeforeClass
public void setUp() {        
     utils=new WebUtils(driver);
		DataRecorder.recordData(); // recording all excel sheet data before suite starts to execute.
	DataRecorder.recordLocators();  // recording all locators present in actions package
	login=new LoginPage(driver);
	AllLabTestConsultTasksPageObject=new AllconsultTasksPage(driver);
	waitingRoomPageObject=new WaitingRoomPage(driver);
	 //********or login code  ***********
	 //====================================================================
 
	 Map<String,String> testData = DataRecorder.getTestData("VALID_LOGIN_01");
		Map<String,String> profileCredientials=DataRecorder.PROFILES_CACHE.get(testData.get("profile"));
		System.err.println(testData);
		login.validlogin_Username_Password(profileCredientials.get("username"), profileCredientials.get("password")); 	
	 //======================================================================
		 
     } 

 



@Test (priority=-1,dataProvider = "Complete Screening of a Patient"  , dataProviderClass = dataProvider.class)
public void completeScreeningOfPatientByNurse(String eFHPCEmirate,String eFHPCName,String eFHPCEmirateWaitingPopUp,String eAbdominal,String eBloodPressureHigh,
		String eBloodPressureLow,String eHeight,String eWeight,String eCholesterolTotal,String eFastingSugar,String eHDL) {
	
	
	     Reporter.log("====** -Nurse starts screening and perform Blood Test-**====");
	  	
		waitingRoomPageObject.screeningStartsWithBloodTest(eFHPCEmirate, eFHPCName,eFHPCEmirateWaitingPopUp, eAbdominal, eBloodPressureHigh, eBloodPressureLow, eHeight, eWeight, eCholesterolTotal, eFastingSugar, eHDL);
	 
		ScreenShotGenerator.takeScreenShotAll(driver, "Blood Test Performed");
		
		
		  Reporter.log("====After starting the screening Nurse performed the Blood Test ===");
	
	
}

 


@Test(dataProvider ="Spirometry test",  dataProviderClass = dataProvider.class )
public void spirometryTest(String eFEV1,String eFVC) {
	
	 Reporter.log("===Nurse is performing Spirometry test===");
			
		AllLabTestConsultTasksPageObject.spirometry(eFEV1, eFVC);
		Reporter.log("###--Nurse completed Spirometry assessment test with FEV1=1 and FVC=8 values--###");
		ScreenShotGenerator.takeScreenShotAll(driver, "Spirometry");
		
	
}
	    
	
	
@Test
public void vaccinationTest() {
	
 Reporter.log("===Nurse is performing Vaccination test===");
	 	
		AllLabTestConsultTasksPageObject.vaccinationTest();	
		Reporter.log("###--Nurse performed 3 vaccinations-- Tetanus,Pneumococcal and Flu.--### ");
		ScreenShotGenerator.takeScreenShotAll(driver, "Vaccination");
		
}
	
	
//In lifeStyle I am using the dataProvider of vaccination as both have same column nos 
@Test(priority=0)
public void lifeStyle() {

Reporter.log("===Nurse is performing LifeStyle test===");
 	
	AllLabTestConsultTasksPageObject.lifeStyle();		
	Reporter.log("###--Nurse completed Life Style test & printed the dietary advice and sent the email to patient these instructions--###");
	ScreenShotGenerator.takeScreenShotAll(driver, "LifeStyle");
	
}
 

@Test(dataProvider ="Stop Smoke",  dataProviderClass = dataProvider.class )
public void stopSmokeTest(String enoSmoke,String eYesSmoke,String eWhenToStopSomoking,
		String eWhenToStopSmokingSixMonth,String eWhenToStopSmokingOneMonth) {

Reporter.log("===Nurse is performing Stop Smoke test===");

	AllLabTestConsultTasksPageObject.smokeStop(enoSmoke,eYesSmoke,
			eWhenToStopSomoking,eWhenToStopSmokingSixMonth,eWhenToStopSmokingOneMonth);		
	Reporter.log("###--Nurse Completed from phase-1 to phase-4 questions of stop smoke--###");
	ScreenShotGenerator.takeScreenShotAll(driver, "StopSmoke");
	
}

	

@Test(dataProvider ="Vision Impairment",  dataProviderClass = dataProvider.class )
public void visionImpairmentTest(String eLeftEye,String eRightEye) {

Reporter.log("===Nurse is performing Vision Impairment test===");
 	   
	AllLabTestConsultTasksPageObject.visionImpairment(eLeftEye,eRightEye);		
	Reporter.log("###--Nurse completed reading for Vision Impairement test of a patient--###");
	ScreenShotGenerator.takeScreenShotAll(driver, "VisionImpairment");
	
}

	

//@Test(dataProvider ="Auditory",  dataProviderClass = dataProvider.class )
public void auditoryTest(String resultOfOtoscope,String additionalQuestionBefore,
String additionalQuestionPreviously) {
	  

Reporter.log("===Nurse is performing Auditory test===");
	   
	AllLabTestConsultTasksPageObject.auditory(resultOfOtoscope,additionalQuestionBefore,additionalQuestionPreviously);		
	Reporter.log("###--Nurse completed Auditory test by filling otoscope & Additional questions -Have you hearing aids before & previously operated for hearing--###");
	ScreenShotGenerator.takeScreenShotAll(driver, "Auditory");
	
}
	
	   
	

@Test(dataProvider ="ECG",  dataProviderClass = dataProvider.class )
public void ecgtest(String eUploadFilePath) throws IOException 
{
	   
     
Reporter.log("===Nurse is Performing ECG test on a Patient===");

	AllLabTestConsultTasksPageObject.ecg(eUploadFilePath);
	 
	Reporter.log("###--Nurse completed ECG test & uploaded the test result as well--###");
	ScreenShotGenerator.takeScreenShotAll(driver, "ECGtest");
	
}   

    @Test(priority=15)
     public void nurseStopScreening() {
    	 
    	 AllLabTestConsultTasksPageObject.endScreening();
    	 Reporter.log("Nurse stop screening after performing all tests");
    	 
    	 ScreenShotGenerator.takeScreenShotAll(driver, "endScreening");
    	  
     }








	
	
	
	
	
	
	
	
	
	
	
	
}
