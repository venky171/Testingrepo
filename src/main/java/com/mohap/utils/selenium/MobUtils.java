package com.mohap.utils.selenium;

import static com.mohap.utils.common.Constants.LOG_DESIGN;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * This class is responsible for performing all actions required to automate
 * mobile devices. i.e Android/iPad/tablets etc.
 * 
 *  @author Jaikant
 */
public class MobUtils {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MobUtils.class);

	public AndroidDriver<MobileElement> driver;
	
	public MobUtils(WebDriver driver) {
		this.driver = (AndroidDriver<MobileElement>) driver;
	}
  
	/** It will rotate the android device screen to LANDSCAPE mode.
	 * 
	 */
	public void setDeviceOrientation(String orientation) {
		ScreenOrientation screenOrientation = orientation.equalsIgnoreCase("PORTRAIT") ? ScreenOrientation.PORTRAIT : ScreenOrientation.LANDSCAPE;
		driver.rotate(screenOrientation);
	}
	
	/**
	 * It will give the object of "By"
	 * 
	 * @param locator e.g : //div[@class='demo']_xpath
	 * @return By object
	 */
	public By getByObject(String locator) {
		locator = locator.trim();
		By byObj = null;
		if (locator.endsWith("_xpath")) {
			byObj = By.xpath(locator.replaceAll("_xpath", ""));
		} else if (locator.endsWith("_css")) {
			byObj = By.cssSelector(locator.replaceAll("_css", ""));
		} else if (locator.endsWith("_id")) {
			byObj = By.id(locator.replaceAll("_id", ""));
		} else if (locator.endsWith("_linkText")) {
			byObj = By.linkText(locator.replaceAll("__linkText", ""));
		} else if (locator.endsWith("_name")) {
			byObj = By.name(locator.replaceAll("_name", ""));
		}

		return byObj;

	}
	/**
	 * It just check that an element is present on the DOM of a page.
	 * 
	 * @param locator
	 * @param seconds
	 */
	public void waitForElementPresence(String locator, long seconds) {
		LOGGER.info(LOG_DESIGN + "waiting for presence of element [{}] for {} seconds", locator, seconds);
		
		WebDriverWait wait = new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.presenceOfElementLocated(getByObject(locator)));
	}
	
	
	/** It will get InnerText of element using JavaScript.
	 * @param element
	 * @return innerText of element.
	 */
	public String getInnerText(WebElement element) {
		LOGGER.info(LOG_DESIGN + "Getting innerText using javascript, WebElement : [{}]", element);
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].innerText;",element);
	}
	
	/**
	 * It will highlight the web element
	 * 
	 * @param element
	 */
	public void highlightWebElement(MobileElement element) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].setAttribute('style', 'background:#ffffb3; border:3px solid green;');", element);
	}
	
	/**
	 * It will click on a given locator.
	 * 
	 * @param locator
	 */
	public void click(MobileElement element) {
		try {
			LOGGER.info(LOG_DESIGN + "Clicking on : [{}]", element);
		//	highlightWebElement(element);
			element.click();
		} catch (Exception e) {
			LOGGER.error(LOG_DESIGN + "Exception occurred while clicking : [{}]", e.getMessage());
		}
	}
	
	/** It will switch to native context if present and will return the original context so that we can switch back to original.
	 * 
	 */
	public String switchToNativeContext() {
		LOGGER.info("Switching to NATIVE context...");
			String webContext = driver.getContext();
			Set<String> contexts = driver.getContextHandles();
			for (String context: contexts){
				if (context.contains("NATIVE_APP")){
					LOGGER.info("Switching from WEB CONTEXT to NATIVE CONTEXT.");
					driver.context(context);
					LOGGER.info("Done switching from WEB CONTEXT to NATIVE CONTEXT.");
					break;
				}
			}
			
			return webContext;
	}
	
	/** It will switch to web context from.
	 * 
	 */
	public void switchToWebContext(String webContext) {
		LOGGER.info("Switching to Web context...");
		driver.context(webContext);
		LOGGER.info("Done switching to WEB CONTEXT");
	}

}
