package com.mohap.pages.qaBooth;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.mohap.utils.selenium.WebUtils;

public class QaBoothPage {
	
	private WebDriver driver;
	private WebUtils webUtils;
	
	
	@FindBy(how = How.XPATH, using = "//span[text()='  QA Booth ']")
	WebElement QA_Booth_leftHandLink;
	
	@FindBy(how = How.ID, using = "btnShowModal")
	WebElement manual_link;	
	@FindBy(how = How.XPATH, using = "//input[@id='Email']")
	WebElement loginPopUp_email;	
	@FindBy(how = How.XPATH, using = "//input[@id='Password']")
	WebElement loginPopUp_password;	
	@FindBy(how = How.XPATH, using = "//input[@id='btnVerify']")
	WebElement popUpButton_login;
	@FindBy(how = How.XPATH, using = "//button[@class='btn btn-secondary']")
	WebElement popUpButton_return;
	@FindBy(how = How.ID, using = "p_id")
	WebElement questionnaire_emiratesID;
	@FindBy(how = How.ID, using = "btnSubmit")
	WebElement Questionnaire_NextButtonORcontinueButton;
	@FindBy(how = How.ID, using = "IsConsent")
	WebElement consent_Checkbox;
	
	
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr4'][@id='0']")
	WebElement highBloodPressure_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr5'][@id='0']")
	WebElement takeMedForhighBloodPressure_yes;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr6'][@id='0']")
	WebElement diabetes_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr7'][@id='39']")
	WebElement diabetes_Type_1;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr7'][@id='40']")
	WebElement diabetes_Type_2;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr7'][@id='2']")
	WebElement diabetes_Type_DonotKnow;
	
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr8'][@id='0']")
	WebElement doYouHaveHeartORvascularDisease_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr8'][@id='1']")
	WebElement doYouHaveHeartORvascularDisease_No;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr9'][@id='0']")
	WebElement heartDiseaseBeforeAge55_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr9'][@id='1']")
	WebElement heartDiseaseBeforeAge55_no;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr10'][@id='0']")
	WebElement heartOrViscularDiseaseBefore65_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr10'][@id='1']")
	WebElement heartOrViscularDiseaseBefore65_no;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr37'][@id='0']")
	WebElement doYouSmoke_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr35'][@id='1']")
	WebElement doYouSmoke_no;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr38'][@id='45']")
	WebElement smokeCigratteDaily_1;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr38'][@id='46']")
	WebElement smokeCigratteDaily_2;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr38'][@id='47']")
	WebElement smokeCigratteDaily_5;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr38'][@id='48']")
	WebElement smokeCigratteDaily_10;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr38'][@id='24']")
	WebElement smokeCigratteDaily_10_More;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr39'][@id='49']")
	WebElement triedToStopSmoking_0;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr39'][@id='45']")
	WebElement triedToStopSmoking_1;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr39'][@id='46']")
	WebElement triedToStopSmoking_2;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr39'][@id='25']")
	WebElement triedToStopSmoking_2_More;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr40'][@id='0']")
	WebElement smokingAfter30minsWaking_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr40'][@id='1']")
	WebElement smokingAfter30minsWaking_no;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr11'][@id='26']")
	WebElement cigratte_previousEffectHasWornOff_A;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr11'][@id='27']")
	WebElement cigratte_feelBetter_B;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr59'][@id='0']")
	WebElement eatVegetableDaily_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr59'][@id='1']")
	WebElement eatVegetableDaily_no;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr12'][@id='0']")
	WebElement eat_FruitsDaily_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr12'][@id='1']")
	WebElement eat_FruitsDaily_no;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr13'][@id='0']")
	WebElement exerciseDaily_30mins_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr13'][@id='1']")
	WebElement exerciseDaily_30mins_no;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Next Question']")
	WebElement Height_Weight_NextQuestion_button;
	
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr16'][@id='0']")
	WebElement maleDoctorDiscussSugarLevelInBlood_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr16'][@id='1']")
	WebElement maleDoctorDiscussSugarLevelInBlood_no;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr15'][@id='0']")
	WebElement doctorDiscussSugarLevelInBlood_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr15'][@id='1']")
	WebElement doctorDiscussSugarLevelInBlood_no;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr16'][@id='0']")
	WebElement  IncreasedSugarLevelDuringPregnency_yes;
	 
		
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr18'][@id='0']")
	WebElement MaleincSugarLevelHospitalAdmission_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr18'][@id='1']")
	WebElement MaleincSugarLevelHospitalAdmission_no;
	
	//female--
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr17'][@id='0']")
	WebElement incSugarLevelHospitalAdmission_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr17'][@id='1']")
	WebElement incSugarLevelHospitalAdmission_no;
	
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr18'][@id='0']")
	WebElement babyBirthWeight4orMore_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr18'][@id='1']")
	WebElement babyBirthWeight4orMore_no;
	
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr19'][@id='0']")
	WebElement fatherMotherBrotherSisterHaveDiabetes_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr19'][@id='1']")
	WebElement fatherMotherBrotherSisterHaveDiabetes_no; 
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr20'][@id='0']")
	WebElement tetanusInjection10yearAgo_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr20'][@id='1']")
	WebElement tetanusInjection10yearAgo_no;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr20'][@id='2']")
	WebElement tetanusInjection10yearAgo_IDonotKnow;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr60'][@id='0']")
	WebElement LungPatient_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr60'][@id='1']")
	WebElement LungPatient_no;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr61'][@id='0']")
	WebElement heartPatient_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr61'][@id='1']")
	WebElement heartPatient_no;
		
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr62'][@id='0']")
	WebElement liverPatient_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr62'][@id='1']")
	WebElement liverPatient_no;
		
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr26'][@id='0']")
	WebElement kidneyPatient_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr26'][@id='1']")
	WebElement kidneyPatient_no;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr21'][@id='0']")
	WebElement femalekidneyPatient_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr21'][@id='1']")
	WebElement femalekidneyPatient_no;
	
	
	
	
	
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr41'][@id='0']")
	WebElement breastCancer_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr41'][@id='1']")
	WebElement breastCancer_no;
	
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr22'][@id='28']")
	WebElement cancerDiagnosedat_40;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr22'][@id='29']")
	WebElement cancerDiagnosedat_40_50;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr22'][@id='30']")
	WebElement cancerDiagnosedat_50;
	
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr42'][@id='0']")
	WebElement breastORovarianCancer_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr23'][@id='1']")
	WebElement breastORovarianCancer_no;
	
	
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr43'][@id='0']")
	WebElement fatherMothSisBroSonDaug_BreastCancer_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr44'][@id='1']")
	WebElement fatherMothSisBroSonDaug_BreastCancer_no;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr44'][@id='28']")
	WebElement fatherMothSisBroSonDaug_BreastCancer_age40;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr44'][@id='29']")
	WebElement fatherMothSisBroSonDaug_BreastCancer_age40TO50;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr44'][@id='30']")
	WebElement fatherMothSisBroSonDaug_BreastCancer_age50;
	
	
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr23'][@id='0']")
	WebElement GrandfatherMothUncleAuntCousHalfSisBro_BreastCancer_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr23'][@id='1']")
	WebElement GrandfatherMothUncleAuntCousHalfSisBro_BreastCancer_no;
	
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr24'][@id='0']")
	WebElement Memogram2yearsAgo_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr24'][@id='1']")
	WebElement Memogram2yearsAgo_no;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr24'][@id='2']")
	WebElement Memogram2yearsAgo_IdonotKnow;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr26'][@id='0']")
	WebElement papSmear3yearsAgo_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr25'][@id='1']")
	WebElement papSmear3yearsAgo_no;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr26'][@id='2']")
	WebElement papSmear3yearsAgo_IdonotKnow;
	
	
	
	
	
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr27'][@id='0']")
	WebElement fatherMothSisBro_intestinalCancer_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr27'][@id='1']")
	WebElement fatherMothSisBro_intestinalCancer_no;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr28'][@id='0']")
	WebElement alcoholicBeverages_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr28'][@id='1']")
	WebElement alcoholicBeverages_no;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr29'][@id='15']")
	WebElement wineGlassesPerWeek_5to7;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr29'][@id='18']")
	WebElement wineGlassesPerWeek_14to15;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr45'][@id='20']")
	WebElement wineGlassesPerWeek_21to25;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr46'][@id='31']")
	WebElement drinkAlcohol_Never;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr46'][@id='32']")
	WebElement drinkAlcohol_lessThanMonthly;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr46'][@id='33']")
	WebElement drinkAlcohol_Monthly;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr46'][@id='34']")
	WebElement drinkAlcohol_Weekly;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr46'][@id='35']")
	WebElement drinkAlcohol_Daily;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr47'][@id='13']")
	WebElement alcoholGlasses_0to2;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr47'][@id='14']")
	WebElement alcoholGlasses_3to4;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr47'][@id='36']")
	WebElement alcoholGlasses_5to6;	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr47'][@id='37']")
	WebElement alcoholGlasses_7to9;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr47'][@id='24']")
	WebElement alcoholGlasses_10Plus;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr48'][@id='31']")
	WebElement glasses6InASingleOccasion_Never;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr48'][@id='32']")
	WebElement glasses6InASingleOccasion_lessThanMonthly;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr48'][@id='33']")
	WebElement glasses6InASingleOccasion_Monthly;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr48'][@id='34']")
	WebElement glasses6InASingleOccasion_Weekly;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr48'][@id='35']")
	WebElement glasses6InASingleOccasion_Daily;
		
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr49'][@id='31']")
	WebElement couldNotStopDrinking_Never;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr49'][@id='32']")
	WebElement couldNotStopDrinking_lessThanMonthly;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr49'][@id='33']")
	WebElement couldNotStopDrinking_Monthly;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr49'][@id='34']")
	WebElement couldNotStopDrinking_Weekly;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr49'][@id='35']")
	WebElement couldNotStopDrinking_Daily;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr50'][@id='31']")
	WebElement notAbleToDoButExpected_Never;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr50'][@id='32']")
	WebElement notAbleToDoButExpected_lessThanMonthly;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr50'][@id='33']")
	WebElement notAbleToDoButExpected_Monthly;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr50'][@id='34']")
	WebElement notAbleToDoButExpected_Weekly;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr50'][@id='35']")
	WebElement notAbleToDoButExpected_Daily;	
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr51'][@id='31']")
	WebElement needAlcoholForPreviousNightOut_Never;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr51'][@id='32']")
	WebElement needAlcoholForPreviousNightOut_lessThanMonthly;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr51'][@id='33']")
	WebElement needAlcoholForPreviousNightOut_Monthly;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr51'][@id='34']")
	WebElement needAlcoholForPreviousNightOut_Weekly;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr51'][@id='35']")
	WebElement needAlcoholForPreviousNightOut_Daily;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr52'][@id='31']")
	WebElement feelingGuiltAfterDrinking_Never;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr52'][@id='32']")
	WebElement feelingGuiltAfterDrinking_lessThanMonthly;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr52'][@id='33']")
	WebElement feelingGuiltAfterDrinking_Monthly;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr52'][@id='34']")
	WebElement feelingGuiltAfterDrinking_Weekly;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr52'][@id='35']")
	WebElement feelingGuiltAfterDrinking_Daily;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr53'][@id='31']")
	WebElement UnableToRememberNightEvents_Never;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr53'][@id='32']")
	WebElement UnableToRememberNightEvents_lessThanMonthly;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr53'][@id='33']")
	WebElement UnableToRememberNightEvents_Monthly;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr53'][@id='34']")
	WebElement UnableToRememberNightEvents_Weekly;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr53'][@id='35']")
	WebElement UnableToRememberNightEvents_Daily;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr54'][@id='0']")
	WebElement injuredBehaviour_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr54'][@id='1']")
	WebElement injuredBehaviour_no;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr29'][@id='0']")
	WebElement adviseDrinkLess_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr29'][@id='1']")
	WebElement adviseDrinkLess_no;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr30'][@id='0']")
	WebElement moreMedicationTaken_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr30'][@id='1']")
	WebElement moreMedicationTaken_no;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr31'][@id='0']")
	WebElement desireToStopTakingMedicine_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr31'][@id='1']")
	WebElement desireToStopTakingMedicine_no;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr32'][@id='0']")
	WebElement forgetTakingMedicine_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr32'][@id='1']")
	WebElement forgetTakingMedicine_no;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr32'][@id='21']")
	WebElement forgetTakingMedicine_DonotTakeMedicine;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr33'][@id='22']")
	WebElement thisHappens_Sometimes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr33'][@id='23']")
	WebElement thisHappens_often;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr33'][@id='38']")
	WebElement thisHappens_conciously;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr55'][@id='0']")
	WebElement sleepingPills_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr55'][@id='1']")
	WebElement sleepingPills_no;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr56'][@id='0']")
	WebElement HopelessExhausted_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr56'][@id='1']")
	WebElement HopelessExhausted_no;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr57'][@id='0']")
	WebElement lackedEnjoymentOfJob_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr57'][@id='1']")
	WebElement lackedEnjoymentOfJob_no;
		
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr58'][@id='0']")
	WebElement coughingExtremeMucus_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr58'][@id='1']")
	WebElement coughingExtremeMucus_no;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr63'][@id='0']")
	WebElement exposedToDustSmokeFumes_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr63'][@id='1']")
	WebElement exposedToDustSmokeFumes_no;
		
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr64'][@id='0']")
	WebElement hearingImpaired_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr64'][@id='1']")
	WebElement hearingImpaired_no;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr65'][@id='0']")
	WebElement hearingProblemMeetingWithNewPeople_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr65'][@id='1']")
	WebElement hearingProblemMeetingWithNewPeople_no;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr65'][@id='22']")
	WebElement hearingProblemMeetingWithNewPeople_sometimes;
	
	
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr66'][@id='0']")
	WebElement hearingProblemTalkingToFamilyMembers_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr66'][@id='1']")
	WebElement hearingProblemTalkingToFamilyMembers_no;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr66'][@id='22']")
	WebElement hearingProblemTalkingToFamilyMembers_sometimes;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr67'][@id='0']")
	WebElement hearingProblemWithFriendsColleagues_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr67'][@id='1']")
	WebElement hearingProblemWithFriendsColleagues_no;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr67'][@id='22']")
	WebElement hearingProblemWithFriendsColleagues_sometimes;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr68'][@id='0']")
	WebElement hearingLossLimitsDailyActivities_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr68'][@id='1']")
	WebElement hearingLossLimitsDailyActivities_no;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr68'][@id='22']")
	WebElement hearingLossLimitsDailyActivities_sometimes;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr69'][@id='0']")
	WebElement hearingProblemVisitsFamilyFriendsNeighbours_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr69'][@id='1']")
	WebElement hearingProblemVisitsFamilyFriendsNeighbours_no;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr69'][@id='22']")
	WebElement hearingProblemVisitsFamilyFriendsNeighbours_sometimes;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr70'][@id='0']")
	WebElement hearingProblemAtCinemaConcerts_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr70'][@id='1']")
	WebElement hearingProblemAtCinemaConcerts_no;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr70'][@id='22']")
	WebElement hearingProblemAtCinemaConcerts_sometimes;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr71'][@id='0']")
	WebElement hearingProblemCreateConflictsWithFamily_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr71'][@id='1']")
	WebElement hearingProblemCreateConflictsWithFamily_no;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr71'][@id='22']")
	WebElement hearingProblemCreateConflictsWithFamily_sometimes;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr72'][@id='0']")
	WebElement hearingProblemWithTVradio_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr72'][@id='1']")
	WebElement hearingProblemWithTVradio_no;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr72'][@id='22']")
	WebElement hearingProblemWithTVradio_sometimes;
	
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr73'][@id='0']")
	WebElement hearingProblemPrivateLifeSocialLife_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr73'][@id='1']")
	WebElement hearingProblemPrivateLifeSocialLife_no;
	@FindBy(how = How.XPATH, using = "//button[@data-next='vr73'][@id='22']")
	WebElement hearingProblemPrivateLifeSocialLife_sometimes;
	
	@FindBy(how = How.XPATH, using = "//button[@data-answerid='0'][@id='0']")
	WebElement hearingProblemVisitingResturants_yes;
	@FindBy(how = How.XPATH, using = "//button[@data-answerid='1'][@id='1']")
	WebElement hearingProblemVisitingResturants_no;
	@FindBy(how = How.XPATH, using = "//button[@data-answerid='22'][@id='22']")
	WebElement hearingProblemVisitingResturants_sometimes;
	
	@FindBy(how = How.XPATH, using = "//a[@id='btnSubmitAllData']")
	WebElement Submit_button;
	@FindBy(how = How.XPATH, using = "//a[@id='btnBack']")
	WebElement restartQuestionnaire;
	@FindBy(how = How.XPATH, using = "//button[@id='btnOk']")
	WebElement OKpopUpAtEndOfQuestionnaire;
	

	
	public QaBoothPage(WebDriver driver) {
		this.driver=driver;
		webUtils=new WebUtils(driver);
		PageFactory.initElements(driver,this);
	}
	

	public void maleQuestions(String ePatientEmiratesId,String eloginPopUpEmail,String eloginPopUpPassword) {
		
		webUtils.click(QA_Booth_leftHandLink);
		webUtils.switchToNextTab();
		webUtils.click(manual_link);
		
		webUtils.sleep(2);
		
		
		webUtils.enterText(loginPopUp_email,eloginPopUpEmail );
		webUtils.enterText(loginPopUp_password,eloginPopUpPassword);

		
		//webUtils.enterText(loginPopUp_email, "poonianurseTEST@gmail.com");
		//webUtils.enterText(loginPopUp_password, "Nurse@123");
		webUtils.click(popUpButton_login);
		
		 
		//entring emirates id code is pending
		webUtils.sleep(2);
		
		///webUtils.enterText(questionnaire_emiratesID, "784345916868417");
		
		webUtils.enterText(questionnaire_emiratesID, ePatientEmiratesId);

		webUtils.click(Questionnaire_NextButtonORcontinueButton);
		webUtils.sleep(2);
		webUtils.click(consent_Checkbox);
		webUtils.click(Questionnaire_NextButtonORcontinueButton);
		webUtils.sleep(2);
 
		webUtils.click(highBloodPressure_yes);
		webUtils.click(takeMedForhighBloodPressure_yes);
		webUtils.click(diabetes_yes);
	//	webUtils.click(diabetes_Type_1);
		webUtils.click(diabetes_Type_2);
		webUtils.click(doYouHaveHeartORvascularDisease_yes);
		webUtils.click(heartDiseaseBeforeAge55_yes);
		webUtils.click(heartOrViscularDiseaseBefore65_yes);
		webUtils.click(doYouSmoke_yes);
		webUtils.click(smokeCigratteDaily_10_More);
		webUtils.click(triedToStopSmoking_1);
		webUtils.click(smokingAfter30minsWaking_yes);
		webUtils.click(cigratte_previousEffectHasWornOff_A);
		webUtils.click(eatVegetableDaily_no);
		webUtils.click(eat_FruitsDaily_no);
		webUtils.click(exerciseDaily_30mins_no);  
		
		webUtils.click(Height_Weight_NextQuestion_button);
		
		webUtils.click(maleDoctorDiscussSugarLevelInBlood_yes);
		
		webUtils.click(MaleincSugarLevelHospitalAdmission_yes);
		
		webUtils.click(fatherMotherBrotherSisterHaveDiabetes_yes);
		webUtils.click(tetanusInjection10yearAgo_yes);
		webUtils.click(LungPatient_yes);
		
		webUtils.click(heartPatient_yes);
		webUtils.click(liverPatient_yes);
		webUtils.click(kidneyPatient_yes);
		 
		webUtils.click(fatherMothSisBro_intestinalCancer_yes);
		webUtils.click(alcoholicBeverages_yes);
		webUtils.click(wineGlassesPerWeek_21to25);
		
		webUtils.click(drinkAlcohol_Daily);
		webUtils.click(alcoholGlasses_10Plus);
		webUtils.click(glasses6InASingleOccasion_Daily);
		webUtils.click(couldNotStopDrinking_Weekly);
		webUtils.click(notAbleToDoButExpected_Weekly);
		webUtils.click(needAlcoholForPreviousNightOut_Weekly);
		webUtils.click(feelingGuiltAfterDrinking_Daily);
		webUtils.click(UnableToRememberNightEvents_Daily);
		webUtils.click(injuredBehaviour_yes);
		webUtils.click(adviseDrinkLess_yes);
		webUtils.click(moreMedicationTaken_yes);
		webUtils.click(desireToStopTakingMedicine_no);
		webUtils.click(forgetTakingMedicine_yes);
		webUtils.click(thisHappens_Sometimes);
		webUtils.click(sleepingPills_yes);
		webUtils.click(HopelessExhausted_yes);
		webUtils.click(lackedEnjoymentOfJob_yes);
		webUtils.click(coughingExtremeMucus_yes);
		webUtils.click(exposedToDustSmokeFumes_yes);
		webUtils.click(hearingImpaired_yes);
		webUtils.click(hearingProblemMeetingWithNewPeople_yes);
		webUtils.click(hearingProblemTalkingToFamilyMembers_yes);
		webUtils.click(hearingProblemWithFriendsColleagues_yes);
		webUtils.click(hearingLossLimitsDailyActivities_yes);
		webUtils.click(hearingProblemVisitsFamilyFriendsNeighbours_yes);
		webUtils.click(hearingProblemAtCinemaConcerts_yes);
		webUtils.click(hearingProblemCreateConflictsWithFamily_yes);
		webUtils.click(hearingProblemWithTVradio_yes);
		webUtils.click(hearingProblemPrivateLifeSocialLife_yes);
		webUtils.click(hearingProblemVisitingResturants_yes);
				
		webUtils.click(Submit_button);
		webUtils.sleep(2);
		webUtils.click(OKpopUpAtEndOfQuestionnaire);	
		
	}
	
	
	
	
	
public void femaleQuestions(String ePatientEmiratesId,String eloginPopUpEmail,String eloginPopUpPassword) {
		
		webUtils.click(QA_Booth_leftHandLink);
		webUtils.switchToNextTab();
		webUtils.click(manual_link);
		
		webUtils.sleep(5);
		
		
		webUtils.enterText(loginPopUp_email,eloginPopUpEmail );
		webUtils.enterText(loginPopUp_password,eloginPopUpPassword);

		
		//webUtils.enterText(loginPopUp_email, "poonianurseTEST@gmail.com");
		//webUtils.enterText(loginPopUp_password, "Nurse@123");
		webUtils.click(popUpButton_login);
		
		 
		//entring emirates id code is pending
		webUtils.sleep(4);
		
		///webUtils.enterText(questionnaire_emiratesID, "784345916868417");
		
		webUtils.enterText(questionnaire_emiratesID, ePatientEmiratesId);

		webUtils.click(Questionnaire_NextButtonORcontinueButton);
		webUtils.sleep(3);
		webUtils.click(consent_Checkbox);
		webUtils.click(Questionnaire_NextButtonORcontinueButton);
		webUtils.sleep(2);
 
		webUtils.click(highBloodPressure_yes);
		webUtils.click(takeMedForhighBloodPressure_yes);
		webUtils.click(diabetes_yes);
	//	webUtils.click(diabetes_Type_1);
		webUtils.click(diabetes_Type_2);
		webUtils.click(doYouHaveHeartORvascularDisease_yes);
		webUtils.click(heartDiseaseBeforeAge55_yes);
		webUtils.click(heartOrViscularDiseaseBefore65_yes);
		webUtils.click(doYouSmoke_yes);
		webUtils.click(smokeCigratteDaily_10_More);
		webUtils.click(triedToStopSmoking_1);
		webUtils.click(smokingAfter30minsWaking_yes);
		webUtils.click(cigratte_previousEffectHasWornOff_A);
		webUtils.click(eatVegetableDaily_no);
		webUtils.click(eat_FruitsDaily_no);
		webUtils.click(exerciseDaily_30mins_no);
		
		webUtils.click(Height_Weight_NextQuestion_button);
		
		webUtils.click(doctorDiscussSugarLevelInBlood_yes);
		
		webUtils.click(IncreasedSugarLevelDuringPregnency_yes);
		
		
		
		webUtils.click(incSugarLevelHospitalAdmission_yes);
		
		webUtils.click(babyBirthWeight4orMore_yes);
		
		webUtils.click(fatherMotherBrotherSisterHaveDiabetes_yes);
		webUtils.click(tetanusInjection10yearAgo_yes);
		webUtils.click(LungPatient_yes);
		
		webUtils.click(heartPatient_yes);
		webUtils.click(liverPatient_yes);
		webUtils.click(femalekidneyPatient_yes);
		
		 
		webUtils.click(breastCancer_yes);
		webUtils.click(cancerDiagnosedat_40);
		
		webUtils.click(breastORovarianCancer_yes);
		
		webUtils.click(fatherMothSisBroSonDaug_BreastCancer_yes);
		webUtils.click(fatherMothSisBroSonDaug_BreastCancer_age40);
		
		webUtils.click(GrandfatherMothUncleAuntCousHalfSisBro_BreastCancer_yes);
		
		webUtils.click(Memogram2yearsAgo_yes);
		
		webUtils.click(papSmear3yearsAgo_yes);
		
		
		webUtils.click(fatherMothSisBro_intestinalCancer_yes);
		webUtils.click(alcoholicBeverages_yes);
		webUtils.click(wineGlassesPerWeek_21to25);
		
		webUtils.click(drinkAlcohol_Daily);
		webUtils.click(alcoholGlasses_10Plus);
		webUtils.click(glasses6InASingleOccasion_Daily);
		webUtils.click(couldNotStopDrinking_Weekly);
		webUtils.click(notAbleToDoButExpected_Weekly);
		webUtils.click(needAlcoholForPreviousNightOut_Weekly);
		webUtils.click(feelingGuiltAfterDrinking_Daily);
		webUtils.click(UnableToRememberNightEvents_Daily);
		webUtils.click(injuredBehaviour_yes);
		webUtils.click(adviseDrinkLess_yes);
		webUtils.click(moreMedicationTaken_yes);
		webUtils.click(desireToStopTakingMedicine_no);
		webUtils.click(forgetTakingMedicine_yes);
		webUtils.click(thisHappens_Sometimes);
		webUtils.click(sleepingPills_yes);
		webUtils.click(HopelessExhausted_yes);
		webUtils.click(lackedEnjoymentOfJob_yes);
		webUtils.click(coughingExtremeMucus_yes);
		webUtils.click(exposedToDustSmokeFumes_yes);
		webUtils.click(hearingImpaired_yes);
		webUtils.click(hearingProblemMeetingWithNewPeople_yes);
		webUtils.click(hearingProblemTalkingToFamilyMembers_yes);
		webUtils.click(hearingProblemWithFriendsColleagues_yes);
		webUtils.click(hearingLossLimitsDailyActivities_yes);
		webUtils.click(hearingProblemVisitsFamilyFriendsNeighbours_yes);
		webUtils.click(hearingProblemAtCinemaConcerts_yes);
		webUtils.click(hearingProblemCreateConflictsWithFamily_yes);
		webUtils.click(hearingProblemWithTVradio_yes);
		webUtils.click(hearingProblemPrivateLifeSocialLife_yes);
		webUtils.click(hearingProblemVisitingResturants_yes);
				
		webUtils.click(Submit_button);
		webUtils.sleep(3);
		webUtils.click(OKpopUpAtEndOfQuestionnaire);	
		
	}

	

	
	
}
