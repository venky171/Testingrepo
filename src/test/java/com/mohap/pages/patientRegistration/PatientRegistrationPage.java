package com.mohap.pages.patientRegistration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import com.mohap.pages.login.LoginPage;
import com.mohap.utils.common.DateUtils;
import com.mohap.utils.selenium.ScreenShotGenerator;
import com.mohap.utils.selenium.WebUtils;

public class PatientRegistrationPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(PatientRegistrationPage.class);
	
	
	private WebDriver driver;
	private WebUtils webUtils;
		
	
	@FindBy(how = How.XPATH, using = "//img[@title='Patient Registration']")
	WebElement PatientRegistration_LeftMenu;
	@FindBy(how = How.ID, using = "txtNationalID")
	WebElement Patient_Emirates_ID;
	@FindBy(how = How.ID, using = "btnSearch")
	WebElement search_button;
	@FindBy(how = How.ID, using = "btnReadEID")
	WebElement Reading_EID_button;
	
	// Patient personal information
	@FindBy(how = How.ID, using = "p_f_nameE")
	WebElement firstName_EN;
	@FindBy(how = How.ID, using = "p_naamE")
	WebElement lastName_EN;
	@FindBy(how = How.ID, using = "FirstNameArablic")
	WebElement firstName_Arabic;
	@FindBy(how = How.ID, using = "LastNameArablic")
	WebElement lastName_Arabic;
	
	//span[@class='input-group-addon']/i
	@FindBy(how = How.ID, using = "DOB")
	WebElement dateOfBirth;
	@FindBy(how = How.XPATH, using = "//*[@class='active day']")
	WebElement Highlighted_date;
		
	@FindBy(how = How.XPATH, using = "//input[@id='Gender'][@value=1]")
	WebElement gender_male;
	@FindBy(how = How.XPATH, using = "//input[@id='Gender'][@value=2]")
	WebElement gender_female;
	
	@FindBy(how = How.XPATH, using = "//input[@id='Email']")
	WebElement email;
	@FindBy(how = How.ID, using = "mobile")
	WebElement mobileNumber;
	
	@FindBy(how = How.ID, using = "Province")
	WebElement emiratesOfResidence;
	@FindBy(how = How.ID, using = "Country")
	WebElement country;
	@FindBy(how = How.ID, using = "Assistance")
	WebElement assistance_Required;
	
	//Primary Health Center (PHC) and FHPC
	@FindBy(how = How.ID, using = "PHCLocation")
	WebElement emiratesWhere_PHC_isLocated;
	@FindBy(how = How.ID, using = "FHPCLocation")
	WebElement emiratesWhere_FHPC_isLocated;
	@FindBy(how = How.ID, using = "PHCName")
	WebElement PHC_Name_EN;
	@FindBy(how = How.ID, using = "FHPCName")
	WebElement FHPC_Name_EN;
	
	@FindBy(how = How.ID, using = "SaveRequest")
	WebElement Submit_Button;
	
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement confirmationMsg_OK;		   
	
	
	
	public PatientRegistrationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		webUtils=new WebUtils(driver);
	}
	
	
	
	public void registerANewPatientMale(String ePatientEmiratesId,String efirstName_EN,String elastName_EN,String efirstName_Arabic,
			String elastName_Arabic,String eDateOfBirth, String eemail,String emobileNumber,
			String eemiratesOfResidence,String ecountry,String eassistance_Required,String eemiratesWhere_PHC_isLocated,
			String eemiratesWhere_FHPC_isLocated,String ePHC_Name_EN,String eFHPC_Name_EN) {
		   
		
		LOGGER.info("Here we are registering a new patient");
		webUtils.click(PatientRegistration_LeftMenu);
		webUtils.sleep(4);
		   
	    webUtils.enterText(Patient_Emirates_ID, ePatientEmiratesId);
	   
		webUtils.click(search_button);  
		webUtils.sleep(2); 
		webUtils.enterText(firstName_EN,efirstName_EN); 
		webUtils.enterText(lastName_EN,elastName_EN);
		webUtils.enterText(firstName_Arabic,efirstName_Arabic);
		webUtils.enterText(lastName_Arabic,elastName_Arabic);
		 
		   
		//String Date=DateUtils.getPreviousDateFromCurrent("ddMMYYYY", 8050);
		webUtils.sleep(1);
		webUtils.click(dateOfBirth);
		webUtils.sleep(2);
 		webUtils.enterText(dateOfBirth,eDateOfBirth);
		webUtils.sleep(4);
		webUtils.click(Highlighted_date);
		//webUtils.sleep(2);
		webUtils.click(gender_male);
		//webUtils.click(gender_female);
		//webUtils.enterText(gender_male,egender_male);
		//webUtils.enterText(gender_female,egender_female);
		
		
		webUtils.enterText(email,eemail); 
		webUtils.enterText(mobileNumber,emobileNumber);
		
		webUtils.selectDropDownByVisibleText(emiratesOfResidence, eemiratesOfResidence);
		
		webUtils.selectDropDownByVisibleText(country,ecountry);		
		webUtils.selectDropDownByVisibleText(assistance_Required,eassistance_Required);
	    webUtils.scrollDownPage(0, 200);
		
		webUtils.selectDropDownByVisibleText(emiratesWhere_PHC_isLocated,eemiratesWhere_PHC_isLocated);
		webUtils.selectDropDownByVisibleText(emiratesWhere_FHPC_isLocated,eemiratesWhere_FHPC_isLocated);
		webUtils.sleep(2);
		webUtils.selectDropDownByVisibleText(PHC_Name_EN,ePHC_Name_EN);
		webUtils.selectDropDownByVisibleText(FHPC_Name_EN,eFHPC_Name_EN);
		webUtils.sleep(2);
		
		ScreenShotGenerator.takeScreenShotAll(driver, "Male patient registration");
		
	    webUtils.click(Submit_Button);
	    //webUtils.sleep(2);
	    
	    //now confirmation message is removed.
		//webUtils.click(confirmationMsg_OK);
		//webUtils.sleep(10);
		
	    LOGGER.info("Verify that patient is registered successfully");
	    
	    webUtils.enterText(Patient_Emirates_ID, ePatientEmiratesId);
		   
		webUtils.click(search_button);
		webUtils.sleep(2);
		if(webUtils.isElementDisplayed(Reading_EID_button)==true) {
			
			LOGGER.info("!!-Male Patient Registered Sccessfully-!!");
			 Reporter.log("###--Male patient registered successfully--###");
		}
		
		else {
			Reporter.log("ERROR !!--Male Patient NOT Registered");
			LOGGER.info("ERROR !!-- Male Patient NOT Registered");
		}       
	
	}
	
		
	public void registerANewPatientFemale(String ePatientEmiratesId,String efirstName_EN,String elastName_EN,String efirstName_Arabic,
			String elastName_Arabic,String eDateOfBirth, String eemail,String emobileNumber,
			String eemiratesOfResidence,String ecountry,String eassistance_Required,String eemiratesWhere_PHC_isLocated,
			String eemiratesWhere_FHPC_isLocated,String ePHC_Name_EN,String eFHPC_Name_EN) {
		   
		Reporter.log("Registration of a new Male patient");
		LOGGER.info("Here we are registering a new patient");
		webUtils.click(PatientRegistration_LeftMenu);
		webUtils.sleep(4);
		   
	    webUtils.enterText(Patient_Emirates_ID, ePatientEmiratesId);
	   
		webUtils.click(search_button);  
		webUtils.sleep(2); 
		webUtils.enterText(firstName_EN,efirstName_EN);
		webUtils.enterText(lastName_EN,elastName_EN);
		webUtils.enterText(firstName_Arabic,efirstName_Arabic);
		webUtils.enterText(lastName_Arabic,elastName_Arabic);
		 
		   
		//String Date=DateUtils.getPreviousDateFromCurrent("ddMMYYYY", 8050);
		webUtils.sleep(1);
		webUtils.click(dateOfBirth);
		webUtils.sleep(2);
 		webUtils.enterText(dateOfBirth,eDateOfBirth);
		webUtils.sleep(4);
		webUtils.click(Highlighted_date);
		//webUtils.sleep(2);
		//webUtils.click(gender_male);
		webUtils.click(gender_female);
		//webUtils.enterText(gender_male,egender_male);
		//webUtils.enterText(gender_female,egender_female);
		
		
		webUtils.enterText(email,eemail); 
		webUtils.enterText(mobileNumber,emobileNumber);
		
		webUtils.selectDropDownByVisibleText(emiratesOfResidence, eemiratesOfResidence);
		
		webUtils.selectDropDownByVisibleText(country,ecountry);		
		webUtils.selectDropDownByVisibleText(assistance_Required,eassistance_Required);
	    webUtils.scrollDownPage(0, 200);
		
		webUtils.selectDropDownByVisibleText(emiratesWhere_PHC_isLocated,eemiratesWhere_PHC_isLocated);
		webUtils.selectDropDownByVisibleText(emiratesWhere_FHPC_isLocated,eemiratesWhere_FHPC_isLocated);
		webUtils.sleep(2);
		webUtils.selectDropDownByVisibleText(PHC_Name_EN,ePHC_Name_EN);
		webUtils.selectDropDownByVisibleText(FHPC_Name_EN,eFHPC_Name_EN);
		webUtils.sleep(2);
		 ScreenShotGenerator.takeScreenShotAll(driver, "FemalePatient Registeration");
		 webUtils.sleep(2);
	    webUtils.click(Submit_Button);
	    webUtils.sleep(3);
	    
	    //now confirmation message is removed.
		//webUtils.click(confirmationMsg_OK);
		//webUtils.sleep(10);
		
	
	}
	

	
	
	
	
	
	

	
}
