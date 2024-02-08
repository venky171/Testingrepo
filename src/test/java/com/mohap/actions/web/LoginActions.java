package com.mohap.actions.web;

import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import com.mohap.core.DataRecorder;
import com.mohap.utils.common.Config;
import com.mohap.utils.selenium.WebUtils;

/**
 * It contains all actions that can be performed on Login page of the
 * application. *
 */
public class LoginActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginActions.class);
	
	
	private WebDriver driver;  
	private WebUtils webUtils;
	private static Map<String,String> or;

	@FindBy(how = How.ID, using = "username")  
	WebElement usernameField;

	@FindBy(how = How.ID, using = "password")
	WebElement passwordField;

	@FindBy(how = How.NAME, using = "user_submitted_login_form")
	WebElement signInButton;

	@FindBy(how = How.CSS, using = "div.toa-header-usermenu div.user-name")
	WebElement userProfileName;

	@FindBy(how = How.CSS, using = "li[label='logout")
	WebElement logOutButton;

	@FindBy(how = How.CSS, using = "input[name='delsession']")
	List<WebElement> errorMessage;

	public LoginActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}
	
	static {
		or = DataRecorder.LOCATORS_CACHE.get(MethodHandles.lookup().lookupClass().getSimpleName());
	}	
	
	/**
	 * It will perform login operation with default credentials present in
	 * config.properties file.
	 */
	public void loginWithDefaultCreds() {
		Reporter.log("Looging in with default credentials..........");
		LOGGER.info("Loogging in application using default credentials");

		webUtils.waitForElementPresence(or.get("usernameField"), 10);
		webUtils.enterText(usernameField, Config.getProperty("default_uName"));
		
		webUtils.waitForElementPresence(or.get("passwordField"), 10);
		webUtils.enterText(passwordField, Config.getProperty("default_pwd"));
		
		webUtils.waitForElementPresence(or.get("signInButton"), 10);
		webUtils.click(signInButton);
		
		if (errorMessage.size() > 0) {
			webUtils.jsClick(errorMessage.get(0));
			webUtils.enterText(passwordField, Config.getProperty("default_pwd"));
			webUtils.click(signInButton);
		}
	}

	/**
	 * It will perform logout from application
	 */
	public void logOut() {
		Reporter.log("Looging OUt.");

		LOGGER.info("Logging out form application");
		webUtils.actionClick(userProfileName);
		
		webUtils.actionClick(logOutButton);
	}

	public void hello() {
		Reporter.log("Hello HoW ARE YOU MAN 1");
		Reporter.log("Hello HoW ARE YOU MAN 2");
		Reporter.log("Hello HoW ARE YOU MAN 3");
		Reporter.log("Hello HoW ARE YOU MAN 4");
		Reporter.log("Hello HoW ARE YOU MAN 5");
	}
}
