package com.mohap.testcases.patientRegistration;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.mohap.core.BaseConfiguration;
import com.mohap.core.DataRecorder;
import com.mohap.pages.login.LoginPage;
import com.mohap.pages.patientRegistration.PatientRegistrationPage;
import com.mohap.utils.common.dataProvider;
import com.mohap.utils.selenium.ScreenShotGenerator;
import com.mohap.utils.selenium.WebUtils;

public class PatientRegistrationTestCases extends BaseConfiguration {
	
	         private static final Logger LOGGER=LoggerFactory.getLogger(PatientRegistrationTestCases.class);
	         WebUtils utils;
	         private PatientRegistrationPage patientRegistration;
		     private LoginPage login;
		     
		     
	   @BeforeClass
	   public void setUp() {        
	         utils=new WebUtils(driver);
	         patientRegistration=new PatientRegistrationPage(driver);
	 		DataRecorder.recordData(); // recording all excel sheet data before suite starts to execute.
			DataRecorder.recordLocators();  // recording all locators present in actions package
			login=new LoginPage(driver);
			
			 //********or login code  ***********
       	 //====================================================================
  
			 Map<String,String> testData = DataRecorder.getTestData("VALID_LOGIN_01");
     		Map<String,String> profileCredientials=DataRecorder.PROFILES_CACHE.get(testData.get("profile"));
     		System.err.println(testData);
     		login.validlogin_Username_Password(profileCredientials.get("username"), profileCredientials.get("password")); 		
			//==========================================================================
			 
			
	         }
	      	  	   
	  @AfterClass
	   public void closeDriver() {
	   	driver.quit();
	   }
	   
	  @Test(dataProvider ="Patient Registration Page",  dataProviderClass = dataProvider.class )
	   public void createPatientMale(String ePatient_EmiratesId,String efirstName_EN,String elastName_EN,String efirstName_Arabic,
	     			String elastName_Arabic,String eDateOfBirth,String eemail,String emobileNumber,String eemiratesOfResidence,String ecountry,
	    			String eassistance_Required,String eemiratesWhere_PHC_isLocated, 
	    			String eemiratesWhere_FHPC_isLocated,String ePHC_Name_EN,String eFHPC_Name_EN) {
	        	       
	        	 Reporter.log(" ** ==Registration of  a Male patient Starts == **");
	        	 
	        	 patientRegistration.registerANewPatientMale(ePatient_EmiratesId,efirstName_EN,elastName_EN,efirstName_Arabic,
	        			 elastName_Arabic,eDateOfBirth,eemail,emobileNumber,eemiratesOfResidence,ecountry,eassistance_Required,
	        			 eemiratesWhere_PHC_isLocated,eemiratesWhere_FHPC_isLocated,ePHC_Name_EN,eFHPC_Name_EN);        	
	        	              
	         } 
	      
	        
	   
	 //  @Test(dataProvider ="Patient Registration Page",  dataProviderClass = dataProvider.class )
	   public void createPatientFemale(String ePatient_EmiratesId,String efirstName_EN,String elastName_EN,String efirstName_Arabic,
	     			String elastName_Arabic,String eDateOfBirth,String eemail,String emobileNumber,String eemiratesOfResidence,String ecountry,
	    			String eassistance_Required,String eemiratesWhere_PHC_isLocated, 
	    			String eemiratesWhere_FHPC_isLocated,String ePHC_Name_EN,String eFHPC_Name_EN) {
	        	       
	        	 Reporter.log("Creating a Female patient and all data is coming from excel sheet");
	        	 
	        	 patientRegistration.registerANewPatientFemale(ePatient_EmiratesId,efirstName_EN,elastName_EN,efirstName_Arabic,
	        			 elastName_Arabic,eDateOfBirth,eemail,emobileNumber,eemiratesOfResidence,ecountry,eassistance_Required,
	        			 eemiratesWhere_PHC_isLocated,eemiratesWhere_FHPC_isLocated,ePHC_Name_EN,eFHPC_Name_EN);
	        	  
	        	              
	         }  
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	   
	
	//@AfterMethod
	//public void logOut() {
		
	//	login.logOut();
	//}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
