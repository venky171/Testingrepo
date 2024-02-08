package com.mohap.utils.selenium;


import static com.mohap.utils.common.Constants.LOG_DESIGN;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

/**
 * This class is completely responsible for taking screenshots of a test case
 * execution when test case is executed on browsers/mobile devices etc.
 * 
 *  @author Jaikant
 *
 */
public class ScreenShotGenerator {
	private static final Logger LOGGER = LoggerFactory.getLogger(ScreenShotGenerator.class);

	/**
	 * This method includes screen capture with Ashot library
	 * Note: It only works for desktop browsers and not mobile devices.
	 * @param driver
	 * @param screenshotPath
	 */
	public static void captureFullScreenshot(WebDriver driver, String screenshotPath) {
		
		LOGGER.info(LOG_DESIGN + "Capturing Screenshot..");
		try {
			File screenShotFile = new File(screenshotPath);
			BufferedImage scrFile;
			long timeAfterScreenshot = 0l;
			long timeBeforeScreenshot = System.currentTimeMillis();
			Screenshot screenshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(150)).takeScreenshot(driver);
			scrFile = screenshot.getImage();
			timeAfterScreenshot = System.currentTimeMillis();
			LOGGER.info("Time to take Screenshot is: {} milliseconds" , (timeAfterScreenshot - timeBeforeScreenshot));
			ImageIO.write(scrFile, "PNG", screenShotFile);
			LOGGER.info(LOG_DESIGN + "Screenshot Captured. : {}", screenshotPath);
		} catch (Exception e) {
			LOGGER.error(LOG_DESIGN + "!!!!!! Exception while Copying Screen Shot to Results folder and exception details are: {}", e.getMessage());
		}
	}
	 
	
	/** It will capture the screenshot in the browser.
	 * @param webdriver
	 * @param screenshotPath
	 */
	public static void captureScreenshot(WebDriver webdriver, String screenshotPath) {
		LOGGER.info(LOG_DESIGN + "Capturing Screenshot..");
		try {
			
			TakesScreenshot scrShot = ((TakesScreenshot) webdriver);
			File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
			File destFile = new File(screenshotPath);
			FileUtils.copyFile(srcFile, destFile);
			LOGGER.info(LOG_DESIGN + "Screenshot Captured. : {}", screenshotPath);
		} catch (Exception e) {
			LOGGER.error(LOG_DESIGN + "!!!!!! Exception while Copying Screen Shot to Results folder and exception details are: {}", e.getMessage());

		}

	}     
		
		
	/**
	 * 
	 * This method is created by Sunil Poonia	
	 */
		
public static String takeScreenShotAll(WebDriver webdriver, String screnshotname) {

			
			LOGGER.info(LOG_DESIGN + "Capturing Screenshot.."); 
			try { 
				TakesScreenshot screensht = (TakesScreenshot) webdriver;
				File source = screensht.getScreenshotAs(OutputType.FILE);
				String dest = "C:\\Users\\punia\\Downloads\\Automation framework by Dangi\\EDPU Mohap\\Screenshots\\" +getCurrentDateTime() + screnshotname + ".png";
				
			//	String dest = "C:\\Users\\punia\\Downloads\\Screenshots" +getCurrentDateTime() + screnshotnam + ".png";
				File destination = new File(dest); 
				FileUtils.copyFile(source, destination);
				System.err.println("Screenshot taken");
				return dest;
			} catch (Exception e) {
				System.err.println("Exception while taking screenshot" + e.getMessage());
				return e.getMessage();
			}  
		}              
		 
		/**
		 * 
		 * This method is created by Sunil Poonia	
		 */
		public static String getCurrentDateTime() {
			
			 DateFormat customFormat= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");					
			Date currentDate=new Date();
			return customFormat.format(currentDate);
				
		 
		
		
	}

}