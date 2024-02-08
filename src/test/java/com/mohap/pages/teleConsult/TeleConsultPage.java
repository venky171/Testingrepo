package com.mohap.pages.teleConsult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mohap.utils.selenium.WebUtils;

public class TeleConsultPage {

	private WebUtils utils;
	private WebDriver driver;
	
	
	public TeleConsultPage(WebDriver driver) {
		this.driver=driver;		
		utils=new WebUtils(driver);
		PageFactory.initElements(driver, this );
		
	}		
	
	@FindBy(how = How.XPATH, using = "//*[text()=' Tele Consult']")
	WebElement TeleConsult_LeftMenu;
	@FindBy(how = How.XPATH, using = "//*[text()='Colon Cancer']")
	WebElement ColonCancer_leftLInk;
	@FindBy(how = How.XPATH, using = "//*[text()='Home Patient']")
	WebElement HomePatient_leftLInk;
	@FindBy(how = How.XPATH, using = "//*[text()='Renew Patient']")
	WebElement RenewPatient_leftLInk; 
	@FindBy(how = How.XPATH, using = "btnBackToRisk")
	WebElement ReturnToRiskStratification; 
	@FindBy(how = How.ID, using = "btnResetPatient")
	WebElement resetPatient_button;   
	
	  
	
	//TeleConsult-Colon Cancer Page
	@FindBy(how = How.ID, using = "txtNationalId")
	WebElement searchPatient_byNationalID;
	@FindBy(how = How.ID, using = "FHPCSearchLocation")
	WebElement searchBy_FHPCemirateDropDown;
	@FindBy(how = How.ID, using = "btnSearch")
	WebElement search_button;
	@FindBy(how = How.ID, using = "btnReset")
	WebElement resetFilter_button;
	
	
    //this xpath will locate 1st call button. When we will perform search using search button. Need to write in more efficient way.
	@FindBy(how = How.XPATH, using = "//*[@class='odd']/td[13]/div/button")
	WebElement callButton_1st;
	
	@FindBy(how = How.ID, using = "reason")
	WebElement teleConsultPopUp_ReasonIfNotAvailable_dropDown;
	@FindBy(how = How.ID, using = "txtifbtreason")
	WebElement callMeBackReason;
	@FindBy(how = How.ID, using = "ifobtResult")
	WebElement IFOBTtestResult_dropDown;
	@FindBy(how = How.ID, using = "btnSave")
	WebElement saveButton_popUp;
	@FindBy(how = How.XPATH, using = "//button[@id='btnSave']/following-sibling::button")
	WebElement closeButton_popUp;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement Finalconfirmation_OKpopUp;
	
	
	@FindBy(how = How.ID, using = "idmammography")
	WebElement resultOfColonoscopy_DropDown;
	@FindBy(how = How.ID, using = "btnSaveMemography")
	WebElement saveButton;
	
	//Refer Patient this xpath will be common for all tests
	@FindBy(how = How.ID, using = "btnReferrWareed")
	WebElement ReferPatient_button;
	@FindBy(how = How.ID, using = "mRefSpecilism")
	WebElement selectSpecialist;
	@FindBy(how = How.ID, using = "mRefTypes")
	WebElement selectReferralType;
	@FindBy(how = How.ID, using = "mRefLocation")
	WebElement selectLocation;
	@FindBy(how = How.ID, using = "mtxtRefRemark")
	WebElement remarks; 
	@FindBy(how = How.XPATH, using = "//button[@id='mbtnRefSubmit']/preceding-sibling::button")
	WebElement CloseButton;
	@FindBy(how = How.ID, using = "mbtnRefSubmit")
	WebElement confirmReferralButton;
	@FindBy(how = How.XPATH, using = "//button[text()='Ok']")
	WebElement finalOkPopUp_referalPatient;
	
	//============================================================

	    
	  
	// HOME Patient or Renew Patient
	
	
	//Set Appointment Tab
	@FindBy(how = How.XPATH, using = "//button[@id='maleprigroup'][@data-groupid=1]")
	WebElement malePriorityGroup_button; 
	@FindBy(how = How.ID, using = "femaleprigroup")
	WebElement femalePriorityGroup_button;
	
	@FindBy(how = How.XPATH, using = "//table[@id='aptdata1']/tbody/tr[1]/td[2]")
	WebElement male_1839;
	@FindBy(how = How.XPATH, using = "//table[@id='aptdata1']/tbody/tr[1]/td[3]")
	WebElement male_4049;
	@FindBy(how = How.XPATH, using = "//table[@id='aptdata1']/tbody/tr[1]/td[4]")
	WebElement male_5059;
	@FindBy(how = How.XPATH, using = "//table[@id='aptdata1']/tbody/tr[1]/td[5]")
	WebElement male_60;
	
	@FindBy(how = How.XPATH, using = "//table[@id='aptdata1']/tbody/tr[2]/td[2]")
	WebElement female_1839;
	@FindBy(how = How.XPATH, using = "//table[@id='aptdata1']/tbody/tr[2]/td[3]")
	WebElement female_4049;
	@FindBy(how = How.XPATH, using = "//table[@id='aptdata1']/tbody/tr[2]/td[4]")
	WebElement female_5059;
	@FindBy(how = How.XPATH, using = "//table[@id='aptdata1']/tbody/tr[2]/td[5]")
	WebElement female_60;
	
	
	@FindBy(how = How.XPATH, using = "//button[@id='maleprigroup'][@data-groupid=11]")
	WebElement questionnaireNotFed_button;
	@FindBy(how = How.XPATH, using = "//button[@id='maleprigroup'][@data-groupid=12]")
	WebElement patientsAlreadyRegistered;
	
	@FindBy(how = How.ID, using = "txtbxPatientorNationalID")
	WebElement searchByNameORnationalID;
	@FindBy(how = How.ID, using = "btnSearch")
	WebElement searchButton_HomePatient;
	
	@FindBy(how = How.XPATH, using = "//select[@id='phcEmitates']")
	WebElement PHCemirates_dropDown;
	@FindBy(how = How.XPATH, using = "//select[@id='phcName']")
	WebElement PHCname_dropDown;
	
	@FindBy(how = How.ID, using = "txtSearchVal")
	WebElement searchByNameORnationalID_RenewalPatient;	
	@FindBy(how = How.ID, using = "FHPCSearchLocation")
	WebElement FHPCemirates_dropDown;
	@FindBy(how = How.ID, using = "FHPCSearchName")
	WebElement FHPCname_dropDown;
	@FindBy(how = How.XPATH, using = "//div[@id='aptdata_wrapper']/div[2]/div/table/tbody/tr[1]/td[13]")
	WebElement BookAppointment_button1Table_renewalPatient;
	  
	
	@FindBy(how = How.XPATH, using = "//div[@id='aptdata_wrapper']/div[2]/div/table/tbody/tr[1]/td[11]")
	WebElement BookAppointment_button1Table;
	
	@FindBy(how = How.ID, using = "aptreason")
	WebElement reasonIfNotAvailable;
	@FindBy(how = How.ID, using = "FHPCSearchLocationaptinner")
	WebElement FHPCEmirate_dropDown; 
	@FindBy(how = How.ID, using = "FHPCSearchNameaptinner")
	WebElement FHPCName_dropDown;
	@FindBy(how = How.ID, using = "aptunit")
	WebElement Unit_dropDown;
	 
	//How to click on green highlighted date in calender.Need to read & R&D
	//this xpath locate all date in green color
	@FindBy(how = How.XPATH, using = "//table[@class='table-sm']/tbody/tr/td[@class='day show-green']")
	WebElement Calendar_GreenColorSlotAll;
	
	//xpath of 1st active slot
	@FindBy(how = How.XPATH, using = "//div[@id='availableSlots']/div/details/span[1]")
	WebElement SelectSlot_1stSlot;
	
	@FindBy(how = How.ID, using = "btnaptSave")
	WebElement SaveButton;
	@FindBy(how = How.XPATH, using = "//button[text()='Close']")
	WebElement Close_Button;
	
	//===============================================================================================================
	//Booked Appointment Tab
	@FindBy(how = How.XPATH, using = "//*[text()='Booked Appointment']")
	WebElement BookedAppointment_Tab;
	
	@FindBy(how = How.ID, using = "bookFHPCSearchLocation")
	WebElement FHPCEmirates_dropDown;
		
	@FindBy(how = How.ID, using = "bookFHPCSearchName")
	WebElement FHPCName_dropDown_bookedAppointment;
		
	@FindBy(how = How.ID, using = "bookunit")
	WebElement Units_dropDown_bookedAppointment;
	@FindBy(how = How.ID, using = "bookgroup")
	WebElement Group_dropDown_bookedAppointment;
	@FindBy(how = How.XPATH, using = "//input[@value='0']")
	WebElement Next90Days;
	@FindBy(how = How.XPATH, using = "//input[@value='1']")
	WebElement ByAppointmentDate;
	@FindBy(how = How.XPATH, using = "//input[@value='2']")
	WebElement ByBookingDate;
	@FindBy(how = How.ID, using = "booksearch")
	WebElement search_button_bookedAppointment;
		
	
	@FindBy(how = How.ID, using = "txtbxPatientorNationalID2")
	WebElement searchByNameORNationalID_textBox;
	
	
	
	@FindBy(how = How.ID, using = "btnSearch2")
	WebElement searchSign_buttonBookedAppointment;
	@FindBy(how = How.XPATH, using = "//span[text()='Export to excel']")
	WebElement ExportToExcel_button_bookedAppointment;
	
	
	@FindBy(how = How.XPATH, using = "//a[text()='Cancel Appointment']")
	WebElement cancelAppointment_button;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement cancelAppointment_popUp_OK;
	@FindBy(how = How.XPATH, using = "//button[text()='Cancel']")
	WebElement cancelAppointment_popUp_Cancel;
	

	
	
	
}
