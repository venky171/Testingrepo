package com.mohap.utils.common;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {
		
		 
		@DataProvider(name="loginTest")
		public static Object[][] getData_LoginTest() throws IOException {
			//String excelPath="/Excel/data.xlsx";
			//String excelPath="/config/TestData.xlsx";  
			
			String excelPath="C:/Users/punia/Desktop/TestData.xlsx";
			//String excelPath="C:\\Users\\punia\\Downloads\\Automation framework by Dangi\\EDPU Mohap\\src\\main\\resources\\config\\TestData.xlsx";
			Object[][] dataObj= testData(excelPath, "Login");
			return dataObj;			     
		}		 
			
			
		@DataProvider(name="Patient Registration Page")
		public static Object[][] getData_PatientRegistration() throws IOException {
			//String excelPath="/Excel/data.xlsx"; 
			//String excelPath="/config/TestData.xlsx";  
			
			String excelPath="C:/Users/punia/Desktop/TestData.xlsx";
			//String excelPath="C:\\Users\\punia\\Downloads\\Automation framework by Dangi\\EDPU Mohap\\src\\main\\resources\\config\\TestData.xlsx";
			Object[][] dataObj= testData(excelPath, "PatientReg");
			return dataObj;			     
		}										
		
	                 
		
		@DataProvider(name="Spirometry test")
		public static Object[][] getData_SpirometryTest() throws IOException {
			//String excelPath="/Excel/data.xlsx";
			//String excelPath="/config/TestData.xlsx";  
			
			String excelPath="C:/Users/punia/Desktop/TestData.xlsx";
			//String excelPath="C:\\Users\\punia\\Downloads\\Automation framework by Dangi\\EDPU Mohap\\src\\main\\resources\\config\\TestData.xlsx";
			Object[][] dataObj= testData(excelPath, "CTSpirometry");
			return dataObj;			     
		}		
		
		
		
		
		@DataProvider(name="Vaccination test")
		public static Object[][] getData_vaccinationTest() throws IOException {
			//String excelPath="/Excel/data.xlsx";
			//String excelPath="/config/TestData.xlsx";  
			
			String excelPath="C:/Users/punia/Desktop/TestData.xlsx";
			//String excelPath="C:\\Users\\punia\\Downloads\\Automation framework by Dangi\\EDPU Mohap\\src\\main\\resources\\config\\TestData.xlsx";
			Object[][] dataObj= testData(excelPath, "CTvaxin");
			return dataObj;			     
		}		
		
		
		@DataProvider(name="Stop Smoke")
		public static Object[][] getData_stopSmoke() throws IOException {
			//String excelPath="/Excel/data.xlsx";
			//String excelPath="/config/TestData.xlsx";  
			
			String excelPath="C:/Users/punia/Desktop/TestData.xlsx";
			//String excelPath="C:\\Users\\punia\\Downloads\\Automation framework by Dangi\\EDPU Mohap\\src\\main\\resources\\config\\TestData.xlsx";
			Object[][] dataObj= testData(excelPath, "CTsmokestop");
			return dataObj;			     
		}	
		 
		@DataProvider(name="Vision Impairment")
		public static Object[][] getData_visionImpairment() throws IOException {
			//String excelPath="/Excel/data.xlsx";
			//String excelPath="/config/TestData.xlsx";  
			
			String excelPath="C:/Users/punia/Desktop/TestData.xlsx";
			//String excelPath="C:\\Users\\punia\\Downloads\\Automation framework by Dangi\\EDPU Mohap\\src\\main\\resources\\config\\TestData.xlsx";
			Object[][] dataObj= testData(excelPath, "CTvision");
			return dataObj;			     
		}	
		 
		
		@DataProvider(name="Auditory")
		public static Object[][] getData_auditory() throws IOException {
			//String excelPath="/Excel/data.xlsx";
			//String excelPath="/config/TestData.xlsx";  
			
			String excelPath="C:/Users/punia/Desktop/TestData.xlsx";
			//String excelPath="C:\\Users\\punia\\Downloads\\Automation framework by Dangi\\EDPU Mohap\\src\\main\\resources\\config\\TestData.xlsx";
			Object[][] dataObj= testData(excelPath, "CTAuditory");
			return dataObj;			     
		}	
		
		
		@DataProvider(name="ECG")
		public static Object[][] getData_ECG() throws IOException {
			//String excelPath="/Excel/data.xlsx";
			//String excelPath="/config/TestData.xlsx";  
			
			String excelPath="C:/Users/punia/Desktop/TestData.xlsx";
			//String excelPath="C:\\Users\\punia\\Downloads\\Automation framework by Dangi\\EDPU Mohap\\src\\main\\resources\\config\\TestData.xlsx";
			Object[][] dataObj= testData(excelPath, "ctECG");
			return dataObj;			     
		}			
		
		
		
		
		@DataProvider(name="complete questionnaire")
		public static Object[][] getData_queandAns() throws IOException {
			//String excelPath="/Excel/data.xlsx";
			//String excelPath="/config/TestData.xlsx";  
			
			String excelPath="C:/Users/punia/Desktop/TestData.xlsx";
			//String excelPath="C:\\Users\\punia\\Downloads\\Automation framework by Dangi\\EDPU Mohap\\src\\main\\resources\\config\\TestData.xlsx";
			Object[][] dataObj= testData(excelPath, "QA");
			return dataObj;			     
		}	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		 
		@DataProvider(name="Complete Screening of a Patient")
		public static Object[][] getData_completeScreeningOfPatient() throws IOException {
			//String excelPath="/Excel/data.xlsx";
			//String excelPath="/config/TestData.xlsx";  
			
			String excelPath="C:/Users/punia/Desktop/TestData.xlsx";
			//String excelPath="C:\\Users\\punia\\Downloads\\Automation framework by Dangi\\EDPU Mohap\\src\\main\\resources\\config\\TestData.xlsx";
			Object[][] dataObj= testData(excelPath, "waitingRoom");
			return dataObj;			     
		}				
		
		public static Object[][] testData(String excelPath, String sheetName) throws IOException {
			int rowCount = ExcelUtils.getRowCount(excelPath, sheetName);
			int colCount = ExcelUtils.getColCount(excelPath, sheetName);

			Object[][] data = new Object[rowCount-1][colCount];								
			for (int i = 1; i < rowCount; i++) {   

				for (int j = 0; j < colCount; j++) {				  
					String cellData = ExcelUtils.getCellDataString(excelPath,sheetName,i, j);			
					System.out.print(cellData + "|"); 
					data[i-1][j] = cellData;
				}    
				//System.out.println(data[0][0]);
			} 
			return data;
			} 	
}
