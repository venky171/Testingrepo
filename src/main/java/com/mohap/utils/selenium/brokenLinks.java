package com.mohap.utils.selenium;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class brokenLinks {

		private static WebDriver  driver=null;	
		
		public brokenLinks(WebDriver driver) {
			this.driver=driver;
		}
		
		public static void verifyLinks(String linkUrl) {
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total links are " + links.size());

		for (int i = 0; i < links.size(); i++) {
			WebElement ele = links.get(i);
			String url = ele.getAttribute("href");}

		try {
			URL url = new URL(linkUrl);
			HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
			httpURLConnect.setConnectTimeout(3000);
			httpURLConnect.connect();

			if (httpURLConnect.getResponseCode() == 200) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
			}
			if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
						+ HttpURLConnection.HTTP_NOT_FOUND);}
		} catch (Exception e) {
            System.out.println("Error while locating broken URL--"+ e);
		}
	}
	
			

		public static void verifyBrokenImages(String linkUrl) {
			
			List<WebElement> links = driver.findElements(By.tagName("img"));
			System.out.println("Total imageLinks are " + links.size());

			for (int i = 0; i < links.size(); i++) {
				WebElement ele = links.get(i);
				String url = ele.getAttribute("src");}

			try {
				URL url = new URL(linkUrl);
				HttpURLConnection httpURLConnect = (HttpURLConnection) url.openConnection();
				httpURLConnect.setConnectTimeout(3000);
				httpURLConnect.connect();

				if (httpURLConnect.getResponseCode() == 200) {
					System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage());
				}
				if (httpURLConnect.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
					System.out.println(linkUrl + " - " + httpURLConnect.getResponseMessage() + " - "
							+ HttpURLConnection.HTTP_NOT_FOUND);}
			} catch (Exception e) {
	            System.out.println("Error while locating broken Images--"+ e);
			}
		}
			
			
		

	

	
		
}
