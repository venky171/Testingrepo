package com.mohap.actions.web;

import java.lang.invoke.MethodHandles;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mohap.core.DataRecorder;
import com.mohap.utils.selenium.WebUtils;

/**
 * It contains all actions that can be performed on Home page of the application.
 */
public class HomePageActions {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(HomePageActions.class);
	private WebDriver driver;
	private WebUtils webUtils;
	private static Map<String,String> or;

	// write your locators here
	@FindBy(how = How.ID, using = "username")
	WebElement usernameField;
	
	
	public HomePageActions(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		webUtils = new WebUtils(driver);
	}
	
	static {
		or = DataRecorder.LOCATORS_CACHE.get(MethodHandles.lookup().lookupClass().getSimpleName());
	}
	
}
