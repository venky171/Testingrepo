package com.mohap.actions.mobile;

import java.lang.invoke.MethodHandles;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Reporter;

import com.mohap.actions.web.LoginActions;
import com.mohap.core.DataRecorder;
import com.mohap.utils.selenium.MobUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * It contains all actions that can be performed on Login page of the
 * application. *
 */
public class MLoginActions {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginActions.class);

	private AndroidDriver<MobileElement> driver;
	private MobUtils mobUtils;
	private static Map<String,String> or;

	@FindBy(how = How.ID, using = "com.Splitwise.SplitwiseMobile:id/loginButton")
	MobileElement loginBtn;

	@FindBy(how = How.ID, using = "username")
	MobileElement usernameField;

	@FindBy(how = How.ID, using = "password")
	MobileElement passwordField;

	public MLoginActions(WebDriver driver) {
		this.driver = (AndroidDriver<MobileElement>) driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		mobUtils = new MobUtils(this.driver);
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
		
		mobUtils.waitForElementPresence(or.get("loginBtn"), 10);
		mobUtils.click(loginBtn);

	}

	/**
	 * It will perform logout from application
	 */
	public void logOut() {
		LOGGER.info("Logging out form application");
	}
}
