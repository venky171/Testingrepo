package com.mohap.listeners;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mohap.utils.selenium.DriverPool;

public class SunilSeleniumGridPractice {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException,MalformedURLException {
		//System.setProperty("webdriver.chrome.driver",
			//	"C:\\Users\\punia\\Downloads\\Automation framework by Dangi\\EDPU Mohap\\src\\main\\resources\\drivers\\chromedriver.exe");
		
		DesiredCapabilities cap=new DesiredCapabilities();
		cap.setBrowserName("chrome");
		//cap.setPlatform(Platform.WINDOWS);
		cap.getVersion();
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS,true);
		cap.chrome().getVersion();
		cap.chrome().getBrowserName();
		cap.chrome().getVersion();
		cap.chrome().getPlatform().name(); 
		 
		driver = new RemoteWebDriver(new URL("http://192.168.0.83:4444"), cap);
		                        
		     
		driver.get("http://125.63.117.102:86/");
		//driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		//driver.findElement(By.id("username")).sendKeys("poonianurseTEST@gmail.com");
		driver.findElement(By.id("username")).sendKeys("GPTEST@gmail.com");
		driver.findElement(By.id("nopend")).sendKeys("Nurse@123");
		 
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//*[text()='  Patient Dashboard ']")).click();
				
		driver.findElement(By.id("txtbxPatientorNationalID")).sendKeys("784345916869002");
		
		WebElement drop=driver.findElement(By.id("FHPCSearchLocation"));
		Select sel=new Select(drop);		
		sel.selectByVisibleText("Dubai");
		
		 
		
		     
		
		
		Thread.sleep(3);
		driver.findElement(By.id("btnSearch")).click();
		 
		
		try {
			 driver.findElement(By.xpath("//a[text()='Open Risk Stratification']")).click();
		}
		catch(StaleElementReferenceException e ) {
			driver.findElement(By.xpath("//a[text()='Open Risk Stratification']")).click();
			
		}
		 
		  
		 //WebDriverWait wait=new WebDriverWait(driver,10);				
		//wait.until(ExpectedConditions.elementToBeClickable(risk)).click();		
			
		
		driver.findElement(By.xpath("//a[text()='Diabetes']")).click();
	
	  
		List<WebElement>  list=driver.findElements(By.xpath("//*[@class='col-md-5 text-left']//span//following-sibling::span"));
		
	   for(WebElement ele:list) {
		   
		  String text= ele.getText();
		  System.out.println(text);
		  
		  if(text.equalsIgnoreCase("Angor")) {
			//  Thread.sleep(3);
			  ele.click();
		  }
		   
	   }
	}
	
	
	                 
	
	
	
	
	
	
}