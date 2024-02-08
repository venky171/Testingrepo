package com.mohap.pages.login;

import java.lang.invoke.MethodHandles;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.mohap.core.DataRecorder;
import com.mohap.utils.common.Config;
import com.mohap.utils.common.ExcelUtilsMy;
import com.mohap.utils.common.dataProvider;
import com.mohap.utils.selenium.WebUtils;
public class LoginPage {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginPage.class);

	
	private WebDriver driver;
	private WebUtils webUtils;  
	
	
	@FindBy(how = How.NAME, using = "Email")
	WebElement email;
	@FindBy(how = How.NAME, using = "Password")
	WebElement password;
	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	WebElement loginButton;
	@FindBy(how = How.PARTIAL_LINK_TEXT, using = "Forgot username or password?")
	WebElement forgotUserNameORPassword;
	
	@FindBy(how = How.ID, using = "Email")
	WebElement email_ResetPassword;
	@FindBy(how = How.CLASS_NAME, using = "btn btn-secondary model-remove-reset")
	WebElement cancel_ResetPsword;
	@FindBy(how = How.ID, using = "btnsavechanges")
	WebElement submit_ResetPassrd;
	
	@FindBy(how = How.CLASS_NAME, using = "mr-2 d-none d-lg-inline small userLogin mr-4")
	WebElement dropDown_logout;	
	@FindBy(how = How.ID, using = "btnLogout")
	WebElement logout;
	@FindBy(how = How.ID, using = "myVideo")
	WebElement HomePage_Image;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	PageFactory.initElements(driver, this);
	webUtils=new WebUtils(driver);
	  
		
	}
	  		 
	public void   validlogin_Username_Password(String userName,String Password) {
		Reporter.log("Login valid");
		LOGGER.info("This is login message from logger");
		webUtils.enterText(email, userName);
		webUtils.enterText(password, Password);
		webUtils.click(loginButton);
		
	}
	  
	
	public void logOut() {
		Reporter.log("LogOut");
		LOGGER.info("This is LogOut message from logger");
		driver.findElement(By.id("userDropdown")).click();
		driver.findElement(By.id("btnLogout")).click();
		
	}
	   
	
	public void   login_TestAllScenarios(String userName,String Password, String exp) {
		Reporter.log("Login test with all permotation and combination");
		LOGGER.info("This is login message from logger");
		webUtils.enterText(email, userName);
		webUtils.enterText(password, Password);
		webUtils.click(loginButton);
	  
		if(exp.equals("Valid")) 
		{	
			if(HomePage_Image.isDisplayed()) {
			driver.findElement(By.id("userDropdown")).click();
			driver.findElement(By.id("btnLogout")).click();
				//webUtils.actionClick(dropDown_logout);
				//webUtils.actionClick(logout);
			Assert.assertTrue(true);
		} 
		else {
			Assert.assertTrue(false);
		}	 
	}	  
		else if(exp.equals("Invalid")) 
		{
			try{
				if(HomePage_Image.isDisplayed()) 
				{
				driver.findElement(By.id("userDropdown")).click();
				driver.findElement(By.id("btnLogout")).click();
				//webUtils.actionClick(dropDown_logout);
				//webUtils.actionClick(logout);
				Assert.assertTrue(false);
			}
			}
			catch(Exception e){
			System.err.println("Home Page is not visible" + e.getMessage());
			}
			}
			else {
				Assert.assertTrue(true);
			}		
	}
		
	
	
	}
