package com.mohap.pages.ConsultTasks;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mohap.utils.common.CommonUtils;
import com.mohap.utils.selenium.ScreenShotGenerator;
import com.mohap.utils.selenium.WebUtils;

public class AllconsultTasksPage {

	private WebUtils utils;
	private WebDriver driver;
	
	
	public AllconsultTasksPage(WebDriver driver) {
		
		this.driver=driver;
		utils=new WebUtils(driver);
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(how = How.XPATH, using = "//img[@title='Patient Dashboard']")
	WebElement PatientDashboard_LeftMenu;
	
	
	@FindBy(how = How.ID, using = "txtbxPatientorNationalID")
	WebElement Search_Patient;
	@FindBy(how = How.ID, using = "FHPCSearchLocation")
	WebElement FHPC_Emirates_dropdown;
	@FindBy(how = How.ID, using = "FHPCSearchName")
	WebElement FHPC_Name_dropdown;
	@FindBy(how = How.ID, using = "btnSearch")
	WebElement search_button;
	@FindBy(how = How.XPATH, using = "//a[text()='Consult Tasks ']")
	WebElement ConsultTasksButton_TableGrid;
	
	@FindBy(how = How.ID, using = "amenu1")
	WebElement TasksToBeCompleted_tab;
	@FindBy(how = How.ID, using = "amenu2")
	WebElement UploadResults_tab;
	
	
	
	
	//Blood Test
	@FindBy(how = How.XPATH, using = "//a[text()='Blood Test']")
	WebElement BloodTest_button;
	@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
	WebElement bloodTestApprovalRequestToGP_yes;
	@FindBy(how = How.XPATH, using = "//button[text()='No']")
	WebElement bloodTestApprovalRequestToGP_no;
	@FindBy(how = How.ID, using = "btnSave1")
	WebElement AddNewTest_button;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement OKpopUp_comingAfteraddNewTest;
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'Cholesterol_Total')]")
	WebElement CholesterolTotal;
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'Fasting_Sugar')]")
	WebElement FastingSugar;
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'HDL')]")
	WebElement HDL;
	@FindBy(how = How.XPATH, using = "//button[@id='btnSave']")
	WebElement saveButton_bloodTest;
	@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
	WebElement saveBloodTestValue_popUpYes;
	@FindBy(how = How.XPATH, using = "//button[text()='No']")
	WebElement saveBloodTestValue_popUpNo;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement bloodTestdataSavedSuccessfully_finalPopUp;
	
	
	@FindBy(how = How.ID, using = "btnBackToNurse")
	WebElement backToList_button;
	
	
	@FindBy(how = How.XPATH, using = "//a[text()='Tasks to be completed']")
	WebElement tasksToBeCompleted_tab;
	
	
	//Spirometry test
	@FindBy(how = How.XPATH, using = "//a[text()='Spirometry']")
	WebElement spirometry_button;
	@FindBy(how = How.ID, using = "FEV1")
	WebElement FEV1;
	@FindBy(how = How.ID, using = "FVC")
	WebElement FVC;
	@FindBy(how = How.ID, using = "btnSaveSpirometry")
	WebElement saveButton_spirometry;
	
	
	
	//  Need to replace below xpath using logic.Currently it is hardcoded.
	//if we enter FEV1=1 and FVC=8 then spirometry opens
	@FindBy(how = How.XPATH, using = "//a[@id='Q_1+A_0']")
	WebElement iNeverCough_0;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_1+A_1']")
	WebElement iNeverCough_1;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_1+A_2']")
	WebElement iNeverCough_2;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_1+A_3']")
	WebElement iNeverCough_3;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_1+A_4']")
	WebElement iNeverCough_4;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_1+A_5']")
	WebElement iNeverCough_5;
	
	
	@FindBy(how = How.XPATH, using = "//a[@id='Q_2+A_0']")
	WebElement idonotHavePhlegmInMyLungs_0;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_2+A_1']")
	WebElement idonotHavePhlegmInMyLungs_1;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_2+A_2']")
	WebElement idonotHavePhlegmInMyLungs_2;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_2+A_3']")
	WebElement idonotHavePhlegmInMyLungs_3;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_2+A_4']")
	WebElement idonotHavePhlegmInMyLungs_4;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_2+A_5']")
	WebElement idonotHavePhlegmInMyLungs_5;
	
	
	@FindBy(how = How.XPATH, using = "//a[@id='Q_3+A_0']")
	WebElement idonotFeelTightnessInChest_0;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_3+A_1']")
	WebElement idonotFeelTightnessInChest_1;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_3+A_2']")
	WebElement idonotFeelTightnessInChest_2;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_3+A_3']")
	WebElement idonotFeelTightnessInChest_3;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_3+A_4']")
	WebElement idonotFeelTightnessInChest_4;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_3+A_5']")
	WebElement idonotFeelTightnessInChest_5;
	
	@FindBy(how = How.XPATH, using = "//a[@id='Q_4+A_0']")
	WebElement idonotHaveShortnessOfBreathInSlopeORStairs_0;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_4+A_1']")
	WebElement idonotHaveShortnessOfBreathInSlopeORStairs_1;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_4+A_2']")
	WebElement idonotHaveShortnessOfBreathInSlopeORStairs_2 ;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_4+A_3']")
	WebElement idonotHaveShortnessOfBreathInSlopeORStairs_3;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_4+A_4']")
	WebElement idonotHaveShortnessOfBreathInSlopeORStairs_4;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_4+A_5']")
	WebElement idonotHaveShortnessOfBreathInSlopeORStairs_5;
	
	@FindBy(how = How.XPATH, using = "//a[@id='Q_5+A_0']")
	WebElement noWayRestrictedInActivitiesDoAtHome_0;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_5+A_1']")
	WebElement noWayRestrictedInActivitiesDoAtHome_1;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_5+A_2']")
	WebElement noWayRestrictedInActivitiesDoAtHome_2;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_5+A_3']")
	WebElement noWayRestrictedInActivitiesDoAtHome_3;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_5+A_4']")
	WebElement noWayRestrictedInActivitiesDoAtHome_4;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_5+A_5']")
	WebElement noWayRestrictedInActivitiesDoAtHome_5;
	
	@FindBy(how = How.XPATH, using = "//a[@id='Q_6+A_0']")
	WebElement iFeelConfidentGoOutdoor_0;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_6+A_1']")
	WebElement iFeelConfidentGoOutdoor_1;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_6+A_2']")
	WebElement iFeelConfidentGoOutdoor_2;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_6+A_3']")
	WebElement iFeelConfidentGoOutdoor_3;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_6+A_4']")
	WebElement iFeelConfidentGoOutdoor_4;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_6+A_5']")
	WebElement iFeelConfidentGoOutdoor_5;
	
	@FindBy(how = How.XPATH, using = "//a[@id='Q_7+A_0']")
	WebElement iSleepDeeply_0;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_7+A_1']")
	WebElement iSleepDeeply_1;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_7+A_2']")
	WebElement iSleepDeeply_2;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_7+A_3']")
	WebElement iSleepDeeply_3;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_7+A_4']")
	WebElement iSleepDeeply_4;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_7+A_5']")
	WebElement iSleepDeeply_5;
	
	@FindBy(how = How.XPATH, using = "//a[@id='Q_8+A_0']")
	WebElement iamFullOfEnergy_0;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_8+A_1']")
	WebElement iamFullOfEnergy_1;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_8+A_2']")
	WebElement iamFullOfEnergy_2;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_8+A_3']")
	WebElement iamFullOfEnergy_3;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_8+A_4']")
	WebElement iamFullOfEnergy_4;
	@FindBy(how = How.XPATH, using = "//a[@id='Q_8+A_5']")
	WebElement iamFullOfEnergy_5;
	
	@FindBy(how = How.ID, using = "btnSubmitAssessment")
	WebElement submit_button;
	@FindBy(how = How.ID, using = "btnBackToNurse") 
	WebElement BackToList_button;
	
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement popUpMessageAfterSubmit;
	
	//==================================================================================
	
	
	
    //Vaccination
	@FindBy(how = How.XPATH, using = "//a[text()='Vaccination']")
	WebElement vaccination_button;
	
	@FindBy(how = How.XPATH, using = "//*[@id='tblVaccination']//td[contains(text(),'Tetanus Vaccination')]/following-sibling::td[2]/a")
	WebElement TetanusVaccination_performButton;
	@FindBy(how = How.XPATH, using = "//*[@id='tblVaccination']//td[contains(text(),'Pneumococcal Vaccination')]/following-sibling::td[2]/a")
	WebElement PneumococcalVaccination_performButton;
	@FindBy(how = How.XPATH, using = "//*[@id='tblVaccination']//td[contains(text(),'Flu Vaccination')]/following-sibling::td[2]/a")
	WebElement FluVaccination_performButton;
	@FindBy(how = How.ID, using = "btnSave")
	WebElement saveButton_vaccination;
	
	
	//common xpath for all vaccination types
	@FindBy(how = How.ID, using = "date")
	WebElement lastPerformedOn_dateCalendar;
	@FindBy(how = How.XPATH, using = "//div[@class='datepicker-days']/table/tbody/tr/td[@class='today day']")
	WebElement lastPerformedOn_HighlightedDate;
	
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement lastPerformedOn_SaveButtonPOPup;
	
	//Life Style
	@FindBy(how = How.XPATH, using = "//a[text()='Life Style']")
	WebElement LifeStyle_button;
	@FindBy(how = How.XPATH, using = "//a[text()='Change basic measurements']")
	WebElement changeBasicMeasurementLink;
	
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
	
	@FindBy(how = How.ID, using = "auditSave")
	WebElement yesButton_atBottomOfLifeStylePage;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement popUpComingClickingOn_yesButton; 
	@FindBy(how = How.ID, using = "print")
	WebElement printButton;
	@FindBy(how = How.ID, using = "email")
	WebElement sendToEmailButton;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement popUpComingAfterClickingOn_sendToEmailButton;
	
	@FindBy(how = How.XPATH, using = "//i[@class='fa fa-angle-up']")
	WebElement scroll_button_lifeStyle;
	
	
	
	//Smoke Stop
	@FindBy(how = How.XPATH, using = "//a[text()='Smoke Stop']")
	WebElement SmokeStop_button;
	@FindBy(how = How.ID, using = "smokestop")
	WebElement DoYouWantToStopSmokingDropDown;
	@FindBy(how = How.ID, using = "smokedate")
	WebElement WhenDoYouWantToStopDropDown;
	@FindBy(how = How.ID, using = "btnSmoke")
	WebElement Result_button;
	@FindBy(how = How.ID, using = "smdate")
	WebElement stopSmokingDate_calendar;
	
	@FindBy(how = How.XPATH, using = "//table[@class='table-sm']/tbody/tr/td[@class='today day']")
	WebElement stopSmoking_highlightedDate;
	
	
	//Auditory
	@FindBy(how = How.XPATH, using = "//a[text()='Auditory']")
	WebElement Auditory_button;
	@FindBy(how = How.ID, using = "otoscopie")
	WebElement resultOfOtoscope_dropDown;
	@FindBy(how = How.ID, using = "audio_vr1")
	WebElement additionalQuestionsHearing_Before;
	@FindBy(how = How.ID, using = "audio_vr2")
	WebElement additionalQuestionsHearing_Previously;
	@FindBy(how = How.ID, using = "AudiSave")
	WebElement save_button_auditory;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement popUp_auditorySaveSuccessfully;
	
	
	//ECG
	@FindBy(how = How.XPATH, using = "//a[text()='ECG']")
	WebElement ECG_button;
	
	@FindBy(how = How.ID, using = "FileUpload1")
	
	//@FindBy(how = How.XPATH, using = "//input[@id='FileUpload1']")
	WebElement Choosefile;
	@FindBy(how = How.ID, using = "btnUploadECG")
	WebElement uploadECGresult_button;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement popUpComingAfterClickingOn_uploadECGResultButton;
	
	
	//Therapy Compliance
	@FindBy(how = How.XPATH, using = "//a[text()='Therapy Compliance']")
	WebElement TherapyComliance_button;
	@FindBy(how = How.XPATH, using = "//button[text()='Send by E-mail']")
	WebElement popupOfCompliance_sendByEmail;
	@FindBy(how = How.XPATH, using = "//button[text()='Cancel']")
	WebElement popupOfCompliance_cancel;
	
	
	
	//Vision Impairment
	@FindBy(how = How.XPATH, using = "//a[text()='Vision Impairment']")
	WebElement visionImpairment_button;
	@FindBy(how = How.ID, using = "visionscorel")
	WebElement leftEye_dropDown;	
	@FindBy(how = How.ID, using = "visionscorer")
	WebElement rightEye_dropDown;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement popUpMessage_clickingOnSaveButtonVision;
	@FindBy(how = How.ID, using = "btnReferrWareed")
	WebElement referPatient_visionImpairment;
	@FindBy(how = How.ID, using = "mRefSpecilism")
	WebElement selectSpecialist_visionImpairment;
	@FindBy(how = How.ID, using = "mRefTypes")
	WebElement selectReferralType_visionImpairment;
	@FindBy(how = How.ID, using = "mRefLocation")
	WebElement selectLocation_visionImpairment;
	@FindBy(how = How.ID, using = "mtxtRefRemark")
	WebElement remarks_visionImpairment;
	@FindBy(how = How.ID, using = "mbtnRefSubmit")
	WebElement confirmReferral_visionImpairment;
	@FindBy(how = How.XPATH, using = "//button[text()='Close']")
	WebElement close_visionImpairment;
	@FindBy(how = How.XPATH, using = "//button[text()='Ok']")
	WebElement popUpMessage_visionImpairment;
	@FindBy(how = How.ID, using = "btnSave")
	WebElement saveButton_visionImpairment;
	
	
	// Lab Results tab
	@FindBy(how = How.XPATH, using = "//a[text()='Lab Results']")
	WebElement LabResults_tab;
	
	
	//Vitamin D Deficiency
	@FindBy(how = How.XPATH, using = "//a[text()='Vitamin D Deficiency']")
	WebElement vitaminDdeficiency_button;
	
	@FindBy(how = How.ID, using = "res")
	WebElement indicateVitaminDdeficiency;
	@FindBy(how = How.ID, using = "vitDsubmit")
	WebElement submitButtonVitaminD;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement popUpmessage_afterSubmittingVitamineD;
	
	  
	//End Screening 
		@FindBy(how = How.ID, using = "btnNStopScreening")
		WebElement End_Screening_button; 
		
		@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
		WebElement End_Screening_YesPopUp;
		@FindBy(how = How.XPATH, using = "//button[text()='No']")
		WebElement End_Screening_NoPopUp;
		@FindBy(how = How.XPATH, using = "//button[text()='OK']")
		WebElement EndScreening_Finalpopup;
		
		
	
	public void spirometry(String eFEV1,String eFVC) {
		
		 /*
		utils.click(PatientDashboard_LeftMenu);
		utils.sleep(4);
		
		//help from dangi 
		//eNationalId=eNationalId+String.valueOf(utils.generateRandomNumber(13));
				
		
		utils.enterText(Search_Patient, eNationalId);
		utils.selectDropDownByVisibleText(FHPC_Emirates_dropdown,eFHPCemirates);
		utils.selectDropDownByVisibleText(FHPC_Name_dropdown,eFHPCname);
		
		utils.click(search_button);
		utils.sleep(4);
		utils.click(ConsultTasksButton_TableGrid);
		utils.sleep(4);
		utils.click(tasksToBeCompleted_tab);
		utils.sleep(1);
		*/
		                                                
		utils.click(spirometry_button);	
      	utils.click(UploadResults_tab);
      	utils.sleep(3);
		utils.enterText(FEV1, eFEV1);
		utils.enterText(FVC, eFVC);
		utils.click(saveButton_spirometry);
	
		utils.click(iNeverCough_2);		
		utils.click(idonotHavePhlegmInMyLungs_3);
		utils.click(idonotFeelTightnessInChest_2);
		utils.scrollDownPage(0, 500);
		utils.sleep(2);
		utils.click(idonotHaveShortnessOfBreathInSlopeORStairs_1);
		utils.sleep(2);
		utils.click(noWayRestrictedInActivitiesDoAtHome_3);
		utils.sleep(2);
		utils.click(iFeelConfidentGoOutdoor_2);
    	utils.sleep(2);
		utils.click(iSleepDeeply_3);
		utils.sleep(2);
		utils.click(iamFullOfEnergy_4);
		
		ScreenShotGenerator.takeScreenShotAll(driver, "spirometry test details filled");
		utils.sleep(2);
        utils.click(submit_button);	
        
		utils.click(backToList_button);
		utils.click(tasksToBeCompleted_tab);
		       
        
        
        
		
	}
		
	public void  successfullyValidation() {
		
		
	}
		
		   
		
		public void vaccinationTest() {
			
			/**
			utils.click(PatientDashboard_LeftMenu);
			utils.sleep(4);
			utils.enterText(Search_Patient, eNationalId);
			utils.selectDropDownByVisibleText(FHPC_Emirates_dropdown,eFHPCemirates);
			utils.selectDropDownByVisibleText(FHPC_Name_dropdown,eFHPCname);
			
			utils.click(search_button);
			utils.sleep(4);
			utils.click(ConsultTasksButton_TableGrid);
			utils.sleep(4);
			utils.click(tasksToBeCompleted_tab);
			utils.sleep(1);
			
			**/
			
			utils.click(vaccination_button);
			utils.sleep(1);
			utils.click(TetanusVaccination_performButton);
			utils.click(lastPerformedOn_dateCalendar);
			utils.sleep(3);
			utils.click(lastPerformedOn_HighlightedDate);
			utils.sleep(2);
			utils.click(saveButton_vaccination);
			utils.sleep(2);
			
			utils.click(PneumococcalVaccination_performButton);
			utils.click(lastPerformedOn_dateCalendar);
			utils.sleep(3);
			utils.click(lastPerformedOn_HighlightedDate);
			utils.sleep(2);
			utils.click(saveButton_vaccination);
			utils.sleep(6);
			
			utils.click(FluVaccination_performButton);
			utils.click(lastPerformedOn_dateCalendar);
			utils.sleep(3);
			utils.click(lastPerformedOn_HighlightedDate);
			utils.sleep(2);
			utils.click(saveButton_vaccination);
			utils.sleep(2);		
			
			utils.click(backToList_button);
			utils.click(tasksToBeCompleted_tab);
			
		}
		
		                  
		      
		
	public void lifeStyle( ) {
		
		/**
		utils.click(PatientDashboard_LeftMenu);
		utils.sleep(4);
		utils.enterText(Search_Patient, eNationalId);
		utils.selectDropDownByVisibleText(FHPC_Emirates_dropdown,eFHPCemirates);
		utils.selectDropDownByVisibleText(FHPC_Name_dropdown,eFHPCname);
		
		utils.click(search_button);
		utils.sleep(4);
		utils.click(ConsultTasksButton_TableGrid);
		utils.sleep(4);
		utils.click(tasksToBeCompleted_tab);
		utils.sleep(1);
		**/
		
		utils.click(LifeStyle_button);
		
		//utils.scrollingToElementofAPage(yesButton_atBottomOfLifeStylePage);	
		utils.scrollingToElementofAPage(printButton);
		utils.click(yesButton_atBottomOfLifeStylePage);		
		//utils.click(sendToEmailButton);
		utils.sleep(2);
		
		
		utils.click(printButton);
		//utils.sleep(3);
		//utils.scrollDownPage(0, 10);
		utils.sleep(10);
		
		try{
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		utils.sleep(2);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		utils.sleep(2);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		utils.sleep(2);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		utils.sleep(2);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		utils.sleep(2);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		utils.sleep(2);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyRelease(KeyEvent.VK_TAB);
		utils.sleep(2); 
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		}
		catch(Exception e) {
			System.out.println("Exception occured while pressing TAB -----"+e);
		}
		
		
		utils.sleep(2);
		//utils.scrollingToElementofAPage(backToList_button);
		utils.click(scroll_button_lifeStyle);
		utils.sleep(3);
		utils.click(backToList_button);
		utils.click(tasksToBeCompleted_tab);
		
		 
	}
	
	
	
	
public void smokeStop(String enoSmoke,String eYesSmoke,String eWhenToStopSomoking,
		String eWhenToStopSmokingSixMonth,String eWhenToStopSmokingOneMonth) {
		
	/**
		utils.click(PatientDashboard_LeftMenu);
		utils.sleep(4);
		utils.enterText(Search_Patient, eNationalId);
		utils.selectDropDownByVisibleText(FHPC_Emirates_dropdown,eFHPCemirates);
		utils.selectDropDownByVisibleText(FHPC_Name_dropdown,eFHPCname);
		utils.click(search_button);
		utils.sleep(4);
		utils.click(ConsultTasksButton_TableGrid);
		utils.sleep(4);
		utils.click(tasksToBeCompleted_tab);
		utils.sleep(1);
		**/
		
		utils.click(SmokeStop_button);
	
		utils.scrollDownPage(0, 200);
	
	utils.selectDropDownByVisibleText(DoYouWantToStopSmokingDropDown, enoSmoke);
	
	utils.click(Result_button);
	utils.sleep(1);
	
	
	utils.selectDropDownByVisibleText(DoYouWantToStopSmokingDropDown, eYesSmoke);
	utils.selectDropDownByVisibleText(WhenDoYouWantToStopDropDown, eWhenToStopSomoking);
	utils.click(Result_button);
	
	utils.sleep(1);
    //utils.selectDropDownByVisibleText(DoYouWantToStopSmokingDropDown, eYesSmoke);
	utils.selectDropDownByVisibleText(WhenDoYouWantToStopDropDown, eWhenToStopSmokingSixMonth);
	utils.click(Result_button);
	utils.sleep(2);
	utils.selectDropDownByVisibleText(DoYouWantToStopSmokingDropDown, eYesSmoke);
	utils.selectDropDownByVisibleText(WhenDoYouWantToStopDropDown, eWhenToStopSmokingOneMonth);
	utils.click(Result_button);
	utils.sleep(2);
	utils.click(stopSmokingDate_calendar);
	utils.sleep(2);
	utils.click(stopSmoking_highlightedDate);
	utils.sleep(2);
	utils.click(Result_button);
	
	utils.sleep(2);
	utils.click(backToList_button);
	utils.click(tasksToBeCompleted_tab);
	
	
}
	
	
	public void visionImpairment(String eLeftEye,String eRightEye){
		
		
		/**		
		utils.click(PatientDashboard_LeftMenu);
		utils.sleep(4);
		utils.enterText(Search_Patient, eEmiratesID);
		utils.selectDropDownByVisibleText(FHPC_Emirates_dropdown,eFHPCemirates);
		utils.selectDropDownByVisibleText(FHPC_Name_dropdown,eFHPCname);
		utils.click(search_button);
		utils.sleep(4);
		utils.click(ConsultTasksButton_TableGrid);
		utils.sleep(4);
		utils.click(tasksToBeCompleted_tab);
		utils.sleep(1);
		
		**/
			
		utils.click(visionImpairment_button);
		utils.selectDropDownByVisibleText(leftEye_dropDown, eLeftEye);
		utils.selectDropDownByVisibleText(rightEye_dropDown, eRightEye);
		utils.click(saveButton_visionImpairment);
		utils.sleep(2);                  
		utils.click(backToList_button);
		utils.click(tasksToBeCompleted_tab);
		
	}
	
	
	
	public void endScreening() {
		
		utils.click(End_Screening_button);
		utils.sleep(2);
		utils.click(End_Screening_YesPopUp);
		
		
		
	}
	
	
	
	
	
	
	public void auditory(String resultOfOtoscope,String additionalQuestionBefore,String additionalQuestionPreviously) {
		
		
		/**
		utils.click(PatientDashboard_LeftMenu);
		utils.sleep(4);
		utils.enterText(Search_Patient, eEmiratesID);
		utils.selectDropDownByVisibleText(FHPC_Emirates_dropdown,eFHPCemirates);
		utils.selectDropDownByVisibleText(FHPC_Name_dropdown,eFHPCname);
		utils.click(search_button);
		utils.sleep(4);
		utils.click(ConsultTasksButton_TableGrid);
		utils.sleep(4);
		utils.click(tasksToBeCompleted_tab);
		utils.sleep(1);
		**/
			
		utils.click(Auditory_button);
		utils.sleep(1);
		utils.scrollDownPage(0, 400);
		utils.sleep(1);
		utils.selectDropDownByVisibleText(resultOfOtoscope_dropDown, resultOfOtoscope);
		utils.selectDropDownByVisibleText(additionalQuestionsHearing_Before, additionalQuestionBefore);
		utils.selectDropDownByVisibleText(additionalQuestionsHearing_Previously, additionalQuestionPreviously);
		
		utils.click(save_button_auditory);

		utils.scrollDownPage(0, -150);
		utils.sleep(2);
		//utils.scrollingToElementofAPage(backToList_button);
		utils.click(backToList_button);
		utils.click(tasksToBeCompleted_tab);
		
				
		
	}
	
	 
	 
public void ecg(String eUploadFilePath) throws IOException {
		
	/**	utils.click(PatientDashboard_LeftMenu);
		utils.sleep(4);
		utils.enterText(Search_Patient, eEmiratesID);
		utils.selectDropDownByVisibleText(FHPC_Emirates_dropdown,eFHPCemirates);
		utils.selectDropDownByVisibleText(FHPC_Name_dropdown,eFHPCname);
		utils.click(search_button);
		utils.sleep(4);
		utils.click(ConsultTasksButton_TableGrid);
		utils.sleep(4);
		utils.click(tasksToBeCompleted_tab);
		utils.sleep(1);
			   
		**/	   
			   
		utils.click(ECG_button); 
		utils.sleep(2); 
				
		//utils.click(Choosefile);
		//utils.jsClick(Choosefile);
		
		//***Here only action click is working. Other click like normal click or JS click is not working
		//utils.actionClick(Choosefile);
		
		//****  here getElement method is not working. Need to find out why?
		//utils.getElement("FileUpload1").sendKeys("C:\\Users\\punia\\dummy pdf file.pdf");
				  
		
		//** below line is working but so instead of using driver directly I have used webElement Directly.
		//driver.findElement(By.id("FileUpload1")).sendKeys("C:\\Users\\punia\\dummy pdf file.pdf");
		
		Choosefile.sendKeys(eUploadFilePath);				
		
		//=====Uploading file using robot class is also working.
		/**utils.sleep(3);	
		utils.UploadFileUsingRobot("C:\\Users\\punia\\dummy pdf file.pdf");
		**/	
		
		utils.sleep(2);  
		//*** Auto IT is working fine but it is not recommended. So i am using send keys method.
		//utils.uploadFileUsingAutoIT("C:\\Users\\punia\\Downloads\\Automation framework by Dangi\\autoIT scripts\\ECG_nurseTask.exe");
		//utils.sleep(3); 
	
		utils.click(uploadECGresult_button);
		utils.sleep(2);
		utils.scrollingToElementofAPage(backToList_button);
		
		utils.click(backToList_button);
		utils.click(tasksToBeCompleted_tab);		      
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	  
	
}
