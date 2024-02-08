package com.mohap.utils.common;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
public class ExcelUtilsMy {

	
	
	/**
	 * @author punia --reference from Step by Step Automation 
	 */
	
	 private static final  Logger LOGGER=LoggerFactory.getLogger(ExcelUtilsMy.class);
	                 	                
	 	public static XSSFWorkbook workbook;
	 	public static XSSFSheet sheet;
	 	public static String projectPath;
	 	
	 	public ExcelUtilsMy(String excelPath, String sheetName) throws IOException {
	 		
	 		try {
	 			projectPath=System.getProperty("user.dir");
	 			System.err.println("This is project path printed==="+projectPath);
	 		File file=new File(projectPath+excelPath);
	 		System.err.println("this is file path printed==="+file);
	 		
	 		FileInputStream fis=new FileInputStream(file);
	 		workbook = new XSSFWorkbook(fis);
	 		sheet = workbook.getSheet(sheetName);  
	 		}
	 		catch(Exception e) {
	 			System.out.println("Excel file ---"+e.getMessage());
	 			System.out.println("Reason why Excel file not found---!!!"+e.getCause());
	 		     e.printStackTrace();
	 		}
	 		  
	        
	 	} 

	 	/*public static int getRowCount() {
	 		int rowCount=0;
	 		try {
	 			rowCount=   sheet.getPhysicalNumberOfRows();
	 			System.out.println("Total number of Rows :-"+rowCount);
	 		}
	 		catch(Exception e) {
	 			System.out.println(e.getMessage());
	 			System.out.println(e.getCause());
	 		     e.printStackTrace();
	 		     
	 		}
	 		return rowCount;   
	 	}
	 	   
	 	     */

	 	public static int getColCount() {
	 		int colCount=0;
	 		try {
	 			 colCount=   sheet.getRow(0).getPhysicalNumberOfCells();
	 			System.out.println("Total number of Cols :-"+colCount);
	 		}
	 		catch(Exception e) {
	 			System.out.println(e.getMessage());
	 			System.out.println(e.getCause());
	 		     e.printStackTrace();
	 		}
	 		return colCount;
	 	}

	 	
	 	public static String getCellDataString(int rowNum,int colNum) {
	 		String cellData=null;
	 		try {
	 			cellData= sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
	 			//System.out.println(cellData);
	 		}
	 		catch(Exception e) {
	 			System.out.println(e.getMessage());
	 			System.out.println(e.getCause());
	 		     e.printStackTrace();
	 		}
	 		return cellData;
	 	}
	 	
	 	
	 	
	 public static void getCellDataNumber(int rowNum,int colNum) {
	 		
	 		try {
	 			double cellData= sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
	 			//System.out.println(cellData);
	 		}
	 		catch(Exception e) {
	 			System.out.println(e.getMessage());
	 			System.out.println(e.getCause());
	 		     e.printStackTrace();
	 		}
	 		
	 	}
	 	
	 	
	 	
	 //==================================================================================

	 	//Need to Write generic method for excel for writing the data.
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 	
	 

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
