package com.mohap.utils.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mohap.utils.common.Config;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * It contains pool of web drivers for mobile devices.
 * 
 * @author Jaikant
 *
 */
public class MobileDriverPool {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MobileDriverPool.class);

	/** It will return driver for mobile chrome browser.
	 * @param nodeURL
	 * @return driver for mobile chrome browser.
	 * @throws MalformedURLException
	 */
	public static AndroidDriver<MobileElement> getAndroidChromeDriver(String nodeURL) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("browserName", "chrome");
		capabilities.setCapability("deviceName", Config.getProperty(String.valueOf("deviceName")));
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appActivity", "com.dish.android.apps.chrome.Main");
		capabilities.setCapability("appActivity", "com.google.android.apps.chrome.Main");
		capabilities.setCapability("unicodeKeyboard", true);
		capabilities.setCapability("resetKeyboard", true);
		capabilities.setCapability("newCommandTimeout", 60 * 5);  // command timeout set to 5 minutes
		LOGGER.info("Launching android chrome driver with capabilities : {}", capabilities);
		
		return new AndroidDriver<MobileElement>(new URL(nodeURL), capabilities);
	}
	
	
	
	/** It will return driver for mobile application (Native/hybrid).
	 * @param nodeURL
	 * @return driver for mobile app.
	 * @throws MalformedURLException
	 */
	public static AndroidDriver<MobileElement> getAndroidDriver(String nodeURL) throws MalformedURLException {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", Config.getProperty(String.valueOf("deviceName")));
		capabilities.setCapability("platformName", Config.getProperty(String.valueOf("platformName")));
		capabilities.setCapability("appPackage", Config.getProperty(String.valueOf("appPackage")));
		capabilities.setCapability("appActivity", Config.getProperty(String.valueOf("appActivity")));
		capabilities.setCapability("newCommandTimeout", 60 * 5);  // command timeout set to 5 minutes
		LOGGER.info("Launching android driver with capabilities : {}", capabilities);
		
		return new AndroidDriver<MobileElement>(new URL(nodeURL), capabilities);
	}

}
