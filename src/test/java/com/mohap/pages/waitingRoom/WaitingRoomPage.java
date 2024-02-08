package com.mohap.pages.waitingRoom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mohap.utils.selenium.ScreenShotGenerator;
import com.mohap.utils.selenium.WebUtils;

public class WaitingRoomPage {

	private WebDriver driver;
	private WebUtils utils;
	
	
	@FindBy(how = How.XPATH, using = "//span[text()='Waiting Room']")
	WebElement waitingRoom_icon;
	
	@FindBy(how = How.ID, using = "FHPCSearchLocation")
	WebElement FHPC_emirates;	
	
	@FindBy(how = How.ID, using = "FHPCSearchName")
	WebElement FHPCName;
	
	@FindBy(how = How.XPATH, using = "//table[@id='tbldata']/tbody/tr[1]/td[3]")
	WebElement waitingRoomTable_1stRecordFHPCName;
	
	@FindBy(how = How.ID, using = "mFHPCSearchLocation")
	WebElement FHPCEmirate_WaitingRoom_PopUP;
	
	@FindBy(how = How.ID, using = "btnBackToNurse")
	WebElement backToList_button;
	
	
	
	@FindBy(how = How.CLASS_NAME, using = "btn btn-secondary")
	WebElement PatientWaitingRoomPopUP_Close;
	
	@FindBy(how = How.ID, using = "mbtnAdmit")
	WebElement PatientWaitingRoomPopUP_AdmitPatient;
	
	@FindBy(how = How.CLASS_NAME, using = "swal-button__loader")
	WebElement PatientWaitingRoom_finalConfirmationPopUp;
	
	
	//PATIENT DETAILS
	//Basics tab
	@FindBy(how = How.ID, using = "ptAbdominal")
	WebElement AbdominalCircumference;
	@FindBy(how = How.ID, using = "ptBloodHigh")
	WebElement BloodPressure_High;
	@FindBy(how = How.ID, using = "ptBloodLow")
	WebElement BloodPressure_Low;
	
	@FindBy(how = How.ID, using = "ptHeight")
	WebElement Height;
	@FindBy(how = How.ID, using = "ptWeight")
	WebElement Weight;
	
	@FindBy(how = How.ID, using = "btnSaveBasic")
	WebElement SaveMeasurement_button;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement Confirmation_popUp_saveMeasurement;
	
	//Tasks to be Completed ---TAB
	@FindBy(how = How.XPATH, using = "//a[text()='Tasks to be completed']")
	WebElement TaskToBeCompleted_tab;
	@FindBy(how = How.XPATH, using = "//a[text()='Blood Test']")
	WebElement BloodTest_button;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Spirometry']")
	WebElement Spirometry_button;
	@FindBy(how = How.XPATH, using = "//a[text()='Vaccination']")
	WebElement Vaccination_button;
	@FindBy(how = How.XPATH, using = "//a[text()='Life Style']")
	WebElement LifeStyle_button;
	@FindBy(how = How.XPATH, using = "//a[text()='Smoke Stop']")
	WebElement SmokeStop_button;
	@FindBy(how = How.XPATH, using = "//a[text()='Auditory']")
	WebElement Auditory_button;
	@FindBy(how = How.XPATH, using = "//a[text()='Therapy Compliance']")
	WebElement TherapyCompliance_button;
	@FindBy(how = How.XPATH, using = "//a[text()='ECG']")
	WebElement ECG_button;
	
	//Blood Test #1
	@FindBy(how = How.ID, using = "Cholesterol_Total1")
	WebElement CholesterolTotal;
	@FindBy(how = How.ID, using = "Fasting_Sugar1")
	WebElement FastingSugar;
	
	@FindBy(how = How.ID, using = "HDL1")
	WebElement HDL;
	
	@FindBy(how = How.ID, using = "rdYes")
	WebElement fasting_YES;
	@FindBy(how = How.ID, using = "rdNo")
	WebElement fasting_NO;
	@FindBy(how = How.ID, using = "btnSave")
	WebElement save_button;
	
	@FindBy(how = How.XPATH, using = "//button[@class='swal-button swal-button--confirm']")
	WebElement bloodTest_confirmationPopUp_YES;
	@FindBy(how = How.XPATH, using = "//button[@class='swal-button swal-button--cancel']")
	WebElement bloodTest_confirmationPopUp_NO;
	
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement finalPopUp_OK;
	
	//End Screening 
	@FindBy(how = How.ID, using = "btnNStopScreening")
	WebElement End_Screening_button; 
	
	@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
	WebElement End_Screening_YesPopUp;
	@FindBy(how = How.XPATH, using = "//button[text()='No']")
	WebElement End_Screening_NoPopUp;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement EndScreening_Finalpopup;
	
	public WaitingRoomPage(WebDriver driver) {
		this.driver=driver;
		 
		utils=new WebUtils(driver);
		PageFactory.initElements(driver, this);		
	}
	
	public void screeningStartsWithBloodTest(String eFHPCEmirate,String eFHPCName, String eFHPCEmirateWaitingPopUp,String eAbdominal,String eBloodPressureHigh,String eBloodPressureLow,
			String eHeight,String eWeight,String eCholesterolTotal,String eFastingSugar,String eHDL) {
		
		 
		utils.click(waitingRoom_icon);				
		utils.selectDropDownByVisibleText(FHPC_emirates, eFHPCEmirate);
		utils.sleep(2);
		utils.selectDropDownByVisibleText(FHPCName, eFHPCName);
		utils.sleep(2);  
		utils.click(waitingRoomTable_1stRecordFHPCName);
		
		utils.selectDropDownByVisibleText(FHPCEmirate_WaitingRoom_PopUP,eFHPCEmirateWaitingPopUp);
		 
		utils.click(PatientWaitingRoomPopUP_AdmitPatient);
		utils.click(finalPopUp_OK);
		utils.enterText(AbdominalCircumference, eAbdominal);
		utils.enterText(BloodPressure_High, eBloodPressureHigh);
		utils.enterText(BloodPressure_Low, eBloodPressureLow);
		
		utils.enterText(Height, eHeight);
		utils.enterText(Weight, eWeight);
		ScreenShotGenerator.takeScreenShotAll(driver, "basic measusrement filled by nurse");
		
		utils.click(SaveMeasurement_button);
		
		//confirmation msg removed
		//utils.click(Confirmation_popUp_saveMeasurement);
		
		utils.click(TaskToBeCompleted_tab);
		utils.click(BloodTest_button);
		utils.scrollDownPage(0, 220);
		utils.enterText(CholesterolTotal, eCholesterolTotal);
		utils.enterText(FastingSugar, eFastingSugar);
		utils.enterText(HDL, eHDL);
		utils.click(fasting_YES);
		ScreenShotGenerator.takeScreenShotAll(driver, "Blood Test done by nurse");
		
		utils.click(save_button);
		utils.click(bloodTest_confirmationPopUp_YES);
		
		//confirmation msg removed
		//utils.click(finalPopUp_OK);
		
    	//utils.scrollDownPage(0, -150);
		//utils.sleep(3);
		//utils.click(End_Screening_button);
		//utils.click(End_Screening_YesPopUp);
	    //utils.sleep(3);
		//confirmation msg removed
		//utils.click(EndScreening_Finalpopup);	
		
		//utils.refreshBrowser();
		utils.sleep(2);
		utils.click(backToList_button);
		utils.sleep(1);
		utils.click(TaskToBeCompleted_tab);
		utils.sleep(1);
		
	}
	
}
