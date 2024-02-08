package com.mohap.actions.mobile;

import java.lang.invoke.MethodHandles;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mohap.core.DataRecorder;
import com.mohap.utils.selenium.MobUtils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

/**
 * It contains all actions that can be performed on Home page of the
 * application.
 */
public class MHomePageActions {

	private AndroidDriver<MobileElement> driver;
	private MobUtils mobUtils;
	private static Map<String,String> or;
	
	// write your locators here
	@FindBy(how = How.ID, using = "com.Splitwise.SplitwiseMobile:id/loginButton")
	MobileElement loginBtn;

	
	public MHomePageActions(WebDriver driver) {
		this.driver = (AndroidDriver<MobileElement>) driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
		mobUtils = new MobUtils(this.driver);
	}


	static {
		or = DataRecorder.LOCATORS_CACHE.get(MethodHandles.lookup().lookupClass().getSimpleName());
	}	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MHomePageActions.class);

}
