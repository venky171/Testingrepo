package com.mohap.pages.riskStratification;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mohap.utils.selenium.WebUtils;

public class RiskStratificationPage {

	
	private WebUtils utils;
	private WebDriver driver;
	
	
	public RiskStratificationPage(WebDriver driver) {
		
		this.driver=driver;
		utils=new WebUtils(driver);
		PageFactory.initElements(driver, this);	
	}
	
	 
	@FindBy(how = How.XPATH, using = "//a[text()='Open Risk Stratification']")
	WebElement OpenRiskStratification_button;
	@FindBy(how = How.ID, using = "btnBackToRisk")
	WebElement ReturnToRiskStratification;
	@FindBy(how = How.ID, using = "btnBackToNurse")
	WebElement Consult_Tasks; 
	
	@FindBy(how = How.ID, using = "btnStartScreening")
	WebElement startScreeningButton;
	@FindBy(how = How.XPATH, using = "//button[text()='No']")
	WebElement startScreeningPopUp_No;
	@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
	WebElement startScreeningPopUp_Yes;
	@FindBy(how = How.ID, using = "btnEndScreening")
	WebElement EndScreeningButton;
	@FindBy(how = How.ID, using = "mtxtRemark")
	WebElement endScreeningPop_remarksField;
	@FindBy(how = How.ID, using = "mbtnEnd")
	WebElement endScreening_popUpButton;
	@FindBy(how = How.ID, using = "//button[@id='mbtnEnd']/preceding-sibling::button")
	WebElement closeButton_endScreenPopUp;
	 
	
	//Cardio Vascular Risk
	@FindBy(how = How.XPATH, using = "//a[text()='Cardio Vascular Risk']")
	WebElement cardioVascularRisk_button;
	@FindBy(how = How.ID, using = "btnReferrWareed")
	WebElement ReferPatient_button;
	@FindBy(how = How.ID, using = "mRefSpecilism")
	WebElement selectSpecialist_dropDown;
	@FindBy(how = How.ID, using = "mRefTypes")
	WebElement selectReferralType_dropDown;
	@FindBy(how = How.ID, using = "mRefLocation")
	WebElement selectLocation_dropDown;
	@FindBy(how = How.XPATH, using = "mtxtRefRemark")
	WebElement remarks;
	@FindBy(how = How.ID, using = "mbtnRefSubmit")
	WebElement confirmReferral_button;
	@FindBy(how = How.XPATH, using = "//button[text()='Close']")
	WebElement close;
	
	
	
	//COPD
	@FindBy(how = How.XPATH, using = "//a[text()='COPD']")
	WebElement COPD_button;
	@FindBy(how = How.ID, using = "rdYes")
	WebElement patientSufferingFromChronicInsufficiency_yes;
	@FindBy(how = How.ID, using = "rdNo")
	WebElement patientSufferingFromChronicInsufficiency_No;
	@FindBy(how = How.ID, using = "btnReferrWareed")
	WebElement ReferPatientbutton_COPD;
	
	@FindBy(how = How.ID, using = "mRefSpecilism")
	WebElement selectSpecialist_dropDownCOPD;
	@FindBy(how = How.ID, using = "mRefTypes")
	WebElement selectReferralType_dropDownCOPD;
	@FindBy(how = How.ID, using = "mRefLocation")
	WebElement selectLocation_dropDownCOPD;
	@FindBy(how = How.XPATH, using = "mtxtRefRemark")
	WebElement remarksCOPD;
	@FindBy(how = How.ID, using = "mbtnRefSubmit")
	WebElement confirmReferral_buttonCOPD;
	@FindBy(how = How.XPATH, using = "//button[text()='Close']")
	WebElement closeCOPD;
	
	
	
	
	//Aging Male
	
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary font-14 dropdown-toggle naRisk']")
	WebElement AgingMale;
	
	//Colon Cancer
	@FindBy(how = How.ID, using = "btnColonYes")
	WebElement HNPCCorFAPinTheFamily_yes;
	@FindBy(how = How.XPATH, using = "btnColonNo")
	WebElement HNPCCorFAPinTheFamily_no;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement popUpMessageComingbyClicking_yesHNPCC;
	@FindBy(how = How.ID, using = "btnResetPatient")
	WebElement resetPatient_button;
	@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
	WebElement popUpMessage_yes;
	@FindBy(how = How.XPATH, using = "//button[text()='No']")
	WebElement popUpMessage_no;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement popUpMessageComingAfter_resetYesPopUp;
	@FindBy(how = How.ID, using = "btnColonYes")
	WebElement HighRiskPatient_yes;
	@FindBy(how = How.ID, using = "btnColonNo")
	WebElement HighRiskPatient_no;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement popUpcomingClickingOnAnyYesButton;
	
	@FindBy(how = How.ID, using = "btnColonYes")
	WebElement twoOrMoreFirstDegreeRelativesWithCRC_yes;
	@FindBy(how = How.ID, using = "btnColonNo")
	WebElement twoOrMoreFirstDegreeRelativesWithCRC_no;
	@FindBy(how = How.ID, using = "btnColonYes")
	WebElement oneFirstDegreeRelativewithCRCDiagnosis60years_yes;
	@FindBy(how = How.ID, using = "btnColonNo")
	WebElement oneFirstDegreeRelativewithCRCDiagnosis60years_no;
	@FindBy(how = How.ID, using = "btnColonYes")
	WebElement HaveYouProvidedFOBTtestKitToPatient_yes;
	
	//now to complete flow login with nurse and go to tele consult>>colon cancer   and complete iFOBT test
	//PENDING flow of colon cancer
	
	
	
	//Depression Module
	
	@FindBy(how = How.XPATH, using = "//a[text()='Depression']")
	WebElement Depression_button;
	
	//Need to replace below xpath. Need to write in more optimized way
	@FindBy(how = How.XPATH, using = "//input[@name='radio_1' and @value='0']")
	WebElement depressionAudit_Q1_NotAtAll;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_1' and @value='1']")
	WebElement depressionAudit_Q1_MultipleDays;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_1' and @value='2']")
	WebElement depressionAudit_Q1_MoreThanHalfTheDays;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_1' and @value='3']")
	WebElement depressionAudit_Q1_AlmostEveryDay;
	
	
	
	@FindBy(how = How.XPATH, using = "//input[@name='radio_2' and @value='0']")
	WebElement depressionAudit_Q2_NotAtAll;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_2' and @value='1']")
	WebElement depressionAudit_Q2_MultipleDays;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_2' and @value='2']")
	WebElement depressionAudit_Q2_MoreThanHalfTheDays;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_2' and @value='3']")
	WebElement depressionAudit_Q2_AlmostEveryDay;
	
	@FindBy(how = How.XPATH, using = "//input[@name='radio_3' and @value='0']")
	WebElement depressionAudit_Q3_NotAtAll;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_3' and @value='1']")
	WebElement depressionAudit_Q3_MultipleDays;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_3' and @value='2']")
	WebElement depressionAudit_Q3_MoreThanHalfTheDays;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_3' and @value='3']")
	WebElement depressionAudit_Q3_AlmostEveryDay;
	
	@FindBy(how = How.XPATH, using = "//input[@name='radio_4' and @value='0']")
	WebElement depressionAudit_Q4_NotAtAll;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_4' and @value='1']")
	WebElement depressionAudit_Q4_MultipleDays;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_4' and @value='2']")
	WebElement depressionAudit_Q4_MoreThanHalfTheDays;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_4' and @value='3']")
	WebElement depressionAudit_Q4_AlmostEveryDay;
	
	@FindBy(how = How.XPATH, using = "//input[@name='radio_5' and @value='0']")
	WebElement depressionAudit_Q5_NotAtAll;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_5' and @value='1']")
	WebElement depressionAudit_Q5_MultipleDays;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_5' and @value='2']")
	WebElement depressionAudit_Q5_MoreThanHalfTheDays;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_5' and @value='3']")
	WebElement depressionAudit_Q5_AlmostEveryDay;
	
	@FindBy(how = How.XPATH, using = "//input[@name='radio_6' and @value='0']")
	WebElement depressionAudit_Q6_NotAtAll;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_6' and @value='1']")
	WebElement depressionAudit_Q6_MultipleDays;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_6' and @value='2']")
	WebElement depressionAudit_Q6_MoreThanHalfTheDays;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_6' and @value='3']")
	WebElement depressionAudit_Q6_AlmostEveryDay;
	
	@FindBy(how = How.XPATH, using = "//input[@name='radio_7' and @value='0']")
	WebElement depressionAudit_Q7_NotAtAll;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_7' and @value='1']")
	WebElement depressionAudit_Q7_MultipleDays;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_7' and @value='2']")
	WebElement depressionAudit_Q7_MoreThanHalfTheDays;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_7' and @value='3']")
	WebElement depressionAudit_Q7_AlmostEveryDay;
	
	@FindBy(how = How.XPATH, using = "//input[@name='radio_8' and @value='0']")
	WebElement depressionAudit_Q8_NotAtAll;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_8' and @value='1']")
	WebElement depressionAudit_Q8_MultipleDays;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_8' and @value='2']")
	WebElement depressionAudit_Q8_MoreThanHalfTheDays;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_8' and @value='3']")
	WebElement depressionAudit_Q8_AlmostEveryDay;
	
	@FindBy(how = How.XPATH, using = "//input[@name='radio_9' and @value='0']")
	WebElement depressionAudit_Q9_NotAtAll;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_9' and @value='1']")
	WebElement depressionAudit_Q9_MultipleDays;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_9' and @value='2']")
	WebElement depressionAudit_Q9_MoreThanHalfTheDays;
	@FindBy(how = How.XPATH, using = "//input[@name='radio_9' and @value='3']")
	WebElement depressionAudit_Q9_AlmostEveryDay;
	
	@FindBy(how = How.ID, using = "submitAudit")
	WebElement SubmitAudit;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement PopUpMessageAfterSubmittingAudit;
	
	//Repeated xpaths for referring patient for all TESTS
	@FindBy(how = How.ID, using = "repeatAudit")
	WebElement auditResetLink;
	@FindBy(how = How.ID, using = "mRefSpecilism")
	WebElement selectSpecialist_dropDownDepression;
	@FindBy(how = How.ID, using = "mRefTypes")
	WebElement selectReferralType_dropDownDepression;
	@FindBy(how = How.ID, using = "mRefLocation")
	WebElement selectLocation_dropDownDepression;
	@FindBy(how = How.XPATH, using = "mtxtRefRemark")
	WebElement remarksDepression;
	@FindBy(how = How.ID, using = "mbtnRefSubmit")
	WebElement confirmReferral_buttonDepression;
	@FindBy(how = How.XPATH, using = "//button[text()='Close']")
	WebElement closeDepression;
	
	
	 
	
	//Addictive Drugs
	
	
	@FindBy(how = How.XPATH, using = "//a[text()='Addictive Drugs']")
	WebElement AddictiveDrugs;
	@FindBy(how = How.ID, using = "slp_score")
	WebElement auditHasNotYetBeenPerformed_dropdown;
	@FindBy(how = How.ID, using = "btnSave")
	WebElement saveButton_addictiveDrugs;
	
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement okPopUpComingClickingOnSaveButton;
	
	//repeated code of Refer Patient
	@FindBy(how = How.ID, using = "btnReferrWareed")
	WebElement referPatient_button_addictiveDrugs;
	@FindBy(how = How.ID, using = "mRefSpecilism")
	WebElement selectSpecialist_dropDownAddictiveDrugs;
	@FindBy(how = How.ID, using = "mRefTypes")
	WebElement selectReferralType_dropDownAddictiveDrugs;
	@FindBy(how = How.ID, using = "mRefLocation")
	WebElement selectLocation_dropDownAddictiveDrugs;
	@FindBy(how = How.XPATH, using = "mtxtRefRemark")
	WebElement remarksAddictiveDrugs;
	@FindBy(how = How.ID, using = "mbtnRefSubmit")
	WebElement confirmReferral_buttonAddictiveDrugs;
	@FindBy(how = How.XPATH, using = "//button[text()='Close']")
	WebElement closeAddictiveDrugs;
	
	
	
	//Alcohol
	
	@FindBy(how = How.ID, using = "AlcoholYes")
	WebElement alcohol_yesButton;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement okPopUp_afterAlcoholYESbutton;
	
	
	// Vitamine D deficiency
	@FindBy(how = How.ID, using = "res")
	WebElement VitamineDdropDown;
	@FindBy(how = How.ID, using = "vitDsubmit")
	WebElement submitButton_VitamineD;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement okPopUp_submitButtonVitamineD;
	
	
	
	
	
	// Diabetes
	@FindBy(how = How.XPATH, using = "//a[text()='Diabetes']")
	WebElement Diabetes_button;
	
	//add blood test
	@FindBy(how = How.XPATH, using = "//button[text()='Add Blood Test']")
	WebElement addBloodTest;
	
	
	
	
	@FindBy(how = How.ID, using = "btnSave1")
	WebElement printAddNewTest_diabetes;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement OKpopUpClickPrintAddNewTestbutton;
	
	
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'Cholesterol_Total')]")
	WebElement CholesterolTotal;
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'Fasting_Sugar')]")
	WebElement FastingSugar;
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'HDL')]")
	WebElement HDL;
	@FindBy(how = How.XPATH, using = "//button[@id='btnSave']")
	WebElement saveButton;
	@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
	WebElement saveBloodTestValue_popUpYes;
	@FindBy(how = How.XPATH, using = "//button[text()='No']")
	WebElement saveBloodTestValue_popUpNo;
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	WebElement bloodTestdataSavedSuccessfully_finalPopUp;
	
	//Glycaemia measurement
	@FindBy(how = How.XPATH, using = "//div[@class='row pl-3 mt-2'][1]/label[1]/span[1]")
	WebElement polydipsyAndemaciation_yes;
	@FindBy(how = How.XPATH, using = "//div[@class='row pl-3 mt-2'][1]/label[2]/span[2]")
	WebElement polydipsyAndemaciation_no;
	
	@FindBy(how = How.XPATH, using = "//div[@class='row pl-3 mt-2'][2]/label[1]/span[2]")
	WebElement isPatientFollowingTreatment_Yes;
	@FindBy(how = How.XPATH, using = "//div[@class='row pl-3 mt-2'][2]/label[2]/span[2]")
	WebElement isPatientFollowingTreatment_No;
	
	@FindBy(how = How.ID, using = "diabtype")
	WebElement determineDiabetesType_dropDown;
	@FindBy(how = How.ID, using = "btnsavetype")
	WebElement saveButtonDiabetes;
	
	//Refer Patient--xpath is common for all 
	
	
	@FindBy(how = How.XPATH, using = "//button[text()='No']")
	WebElement save_withoutSelectingDiabetesType_No; 
	@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
	WebElement save_withoutSelectingDiabetesType_Yes;
	
	@FindBy(how = How.ID, using = "btnSaveQuestion")
	WebElement BloodTestResultReceived;

	//GP performing blood test in detail 
	
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'Amylase')]")
	WebElement Amylase;
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'Creatinine')]")
	WebElement Creatinine;
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'Fasting_Sugar')]")
	WebElement Fasting_Sugar;
	//xpath not correct
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'Fe')]")
	WebElement Fe;
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'Ferritine')]")
	WebElement Ferritine;
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'gamma-GT')]")
	WebElement gamma_GT;
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'HbA1c')]")
	WebElement HbA1c;
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'LDL')]")
	WebElement LDL;
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'Micro_Albumin_(Urine)')]")
	WebElement Micro_Albumin_Urine;
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'Transferrine')]")
	WebElement Transferrine;
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'Vitamine_B12')]")
	WebElement Vitamine_B12;
	
	@FindBy(how = How.ID, using = "btnChecklist")
	WebElement NEXT_button; 
	
	//------------------------------------------------------------------
	@FindBy(how = How.XPATH, using = "//input[@id='q2'][@value='3']")
	WebElement ThePatientTakesMetformin;
	@FindBy(how = How.XPATH, using = "//input[@id='q2'][@value='4']")
	WebElement ThePatientDoesNotTakeMetformin;
	
	//checkbox xpath is pending write here
	
	
	@FindBy(how = How.ID, using = "btnNextTemplate")
	WebElement GoToTheNextQuestionForm;
	
	@FindBy(how = How.XPATH, using = "//input[@id='q3'][@value='5']")
	WebElement HasASVCDorCKDBeenDefined;
	@FindBy(how = How.XPATH, using = "//input[@id='q3'][@value='6']")
	WebElement miniMizeWeightGainWeightLoss;
	@FindBy(how = How.XPATH, using = "//input[@id='q3'][@value='7']")
	WebElement IsThereaNeedToMinimizeHypoglycaemia;
	
	//checkbox xpath is pending write here
	
	@FindBy(how = How.ID, using = "btnNextTemplate")
	WebElement BloodTestResultsReceived_treatmentProposal;
	
	@FindBy(how = How.XPATH, using = "//input[@id='q4'][@value='8']")
	WebElement ThePatientTakesMetforminAndaSulfonylurea;
	@FindBy(how = How.XPATH, using = "//input[@id='q4'][@value='9']")
	WebElement ThePatientTakesMetforminAndaGliptin;
	@FindBy(how = How.XPATH, using = "//input[@id='q4'][@value='10']")
	WebElement ThePatientTakesMetforminAndaGliflozin;
	@FindBy(how = How.XPATH, using = "//input[@id='q4'][@value='11']")
	WebElement ThePatientTakeMetformin;
	@FindBy(how = How.XPATH, using = "//input[@id='q4'][@value='12']")
	WebElement ThePatientTakesMetforminAndanIncretinomimetic;
	
	//checkbox xpath is pending write here
	
	@FindBy(how = How.XPATH, using = "//input[@id='q5'][@value='13']")
	WebElement doYouWishToStartDiabetesCareTrajectory;
	
	//checkbox xpath is pending write here
	
	@FindBy(how = How.XPATH, using = "//input[@id='q6'][@value='14']")
	WebElement patientGetsInsulin;
	@FindBy(how = How.XPATH, using = "//input[@id='q6'][@value='15']")
	WebElement patientGetsInsulinAndGLP_RA;
	
	
	//Diabetics
	//checkbox xpath is pending write here
	
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='High cardiovascular risk']")
	WebElement HighCardiovascularRisk_checkbox;
	
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='Angor']")
	WebElement Angor_checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='Heart Decompensation']")
	WebElement HeartDecompensation_checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='Carotid noise']")
	WebElement CarotidNoise_checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='Claudication']")
	WebElement Claudication_checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='Smoking']")
	WebElement Smoking_checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='Severe liver cirrhosis']")
	WebElement SevereLiverCirrhosis_checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='Respiratory failure']")
	WebElement RespiratoryFailure_checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='Corticoid use']")
	WebElement CorticoidUse_checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='Alcohol abuse']")
	WebElement AlcoholAbuse_checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='Neuropathic pain']")
	WebElement NeuropathicPain_checkbox;
	
	
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='Erectile dysfunction - morning erection present']")
	WebElement ErectileDysfunctionMorningErectionPresent_checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='Erectile dysfunction - morning erection absent']")
	WebElement ErectileDysfunctionMorningErectionAbsent_checkbox;
	
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='Positive foot inspection']")
	WebElement PositiveFootInspection_checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='Blood pressure> 130/80 mmHg']")
	WebElement BloodPressureMoreThan130_80_checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='Increased Fe parameters']")
	WebElement IncreasedFeParameters_checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='Increased amylase']")
	WebElement IncreasedAmylase_checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='Increased yGt']")
	WebElement IncreasedYGt_checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='Drop in Vitamin B12 levels']")
	WebElement DropInVitaminB12Levels_checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='HbA1c> 7.0% (> 53 mmol / mol)']")
	WebElement HbA1c0753MmolMol_checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='LDL> 70 mg / dl']")
	WebElement LDL70MgDl_checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='LDL> 100 mg / dl']")
	WebElement LDL100MgDl_checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='MDRD (e-GFR) <60 ml / min']")
	WebElement MDRDeGFR60MlMin_checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='MDRD (e-GFR) <30 ml / min']")
	WebElement MDRDeGFR30MlMin_checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='Microalbuminuria> 30']")
	WebElement Microalbuminuria30_checkbox;
	@FindBy(how = How.XPATH, using = "//input[@class='checklists']//following::span[text()='HbA1c> 10% (> 86 mmol / mol)']")
	WebElement HbA1c1086MmolMol_checkbox;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
