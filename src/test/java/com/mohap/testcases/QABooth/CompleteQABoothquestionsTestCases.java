/**
 * 
 */
package com.mohap.testcases.QABooth;

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
import com.mohap.pages.qaBooth.QaBoothPage;
import com.mohap.utils.common.dataProvider;
import com.mohap.utils.selenium.ScreenShotGenerator;
import com.mohap.utils.selenium.WebUtils;

/**
 * @author punia
 *
 */
public class CompleteQABoothquestionsTestCases extends BaseConfiguration {

	private static final Logger LOGGER = LoggerFactory.getLogger(CompleteQABoothquestionsTestCases.class);

	WebUtils utilsObj;
	private QaBoothPage qabooth;
	private LoginPage login;

	@BeforeClass
	public void setUp() {

		utilsObj = new WebUtils(driver);
		qabooth = new QaBoothPage(driver);
		DataRecorder.recordData(); // recording all excel sheet data before suite starts to execute.
		DataRecorder.recordLocators();  // recording all locators present in actions package
		login=new LoginPage(driver);	

		 //********or login code  ***********
	   	 //====================================================================
	    Map<String,String> testData = DataRecorder.getTestData("VALID_LOGIN_01");
		Map<String,String> profileCredientials=DataRecorder.PROFILES_CACHE.get(testData.get("profile"));
		System.err.println(testData);
		login.validlogin_Username_Password(profileCredientials.get("username"), profileCredientials.get("password")); 
		//=====================================================================
	}
	
	@AfterClass
	public void closeDriver() {
		driver.quit();
	} 
	 
	@Test(dataProvider ="complete questionnaire",  dataProviderClass = dataProvider.class )
	public void completeQuestionnaireMale(String ePatientEmiratesId,String eloginPopUpEmail,String eloginPopUpPassword ) {
		
		Reporter.log("===Nurse started filling questionnaire of a Male patient===");		 		 
		qabooth.maleQuestions(ePatientEmiratesId,eloginPopUpEmail,eloginPopUpPassword);
  
		Reporter.log("---### Nurse completed questionnaire of a male patient having all diseases ###--- ");
	}
	
	 
 /**
	//@Test(dataProvider ="complete questionnaire",  dataProviderClass = dataProvider.class )
	public void completeQuestionnaireFemale(String ePatientEmiratesId,String eloginPopUpEmail,String eloginPopUpPassword ) {
		
		Reporter.log("===Nurse started filling questionnaire of a Female patient===");		 		 
		qabooth.femaleQuestions(ePatientEmiratesId,eloginPopUpEmail,eloginPopUpPassword);
		
		
		Reporter.log("---### Nurse completed questionnaire of a Female patient having all diseases ###--- ");
	}
	
	
	**/
	 
	
	
	
	
	
	
	
	

}
