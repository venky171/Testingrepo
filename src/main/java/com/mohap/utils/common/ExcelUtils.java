package com.mohap.utils.common;
import static com.mohap.utils.common.Constants.LOG_DESIGN;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/** It contains all excel related operations.
 * 
 * @author Jaikant
 *
 */
public class ExcelUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExcelUtils.class);
	
	/** It will return excel sheet data in a HashMap with first column value of a row as key and whole column values of a row as key-value pair.
	 * For e.g if we have headers as: Id, Name
	 * 								  DATA_ID1   Brook
	 * than here DATA_ID1 is key and value is a map having key pair as {Id=DATA_ID1, Name=Brook}
	 * DATA_ID1={Id=DATA_ID1, Name=Brook}
	 * @param workBookLocation
	 * @param sheetName
	 * @return sheetData in a map
	 */	
	
	     
 	
	 public static Map<String, Map<String, String>> getSheetData(String workBookLocation, String sheetName) {
		LOGGER.info(LOG_DESIGN + "Getting data of sheet: {} from workbook: {}", sheetName, workBookLocation);
						  
		Map<String, Map<String, String>> sheetData = new LinkedHashMap<>();
		           
		File inputFile = new File(workBookLocation);   
		FileInputStream fileInputStream;
		XSSFWorkbook workbook = null;
		try {
			fileInputStream = new FileInputStream(inputFile);
			workbook = new XSSFWorkbook(fileInputStream);
		} catch (Exception e) {
			LOGGER.error(LOG_DESIGN + "Exception occurred while reading excel workbook : {}", e.getMessage());
		}
		          
		XSSFSheet sheet = workbook.getSheet(sheetName);
		Map<String, Integer> headerMap = new LinkedHashMap<String, Integer>(); // Create map of headers with [name,index] as key value pair
		XSSFRow headerRow = sheet.getRow(0); // Get first row  

		short minColIx = headerRow.getFirstCellNum(); // get the first column index for a row
		short maxColIx = headerRow.getLastCellNum(); // get the last column index for a row
		for (short colIx = minColIx; colIx < maxColIx; colIx++) { // loop from first to last index
			XSSFCell cell = headerRow.getCell(colIx); // get the cell
			headerMap.put(cell.getStringCellValue(), cell.getColumnIndex()); // add the cell contents (name of column)
		}
		// getting all headers in a list
		List<String> headerValues = headerMap.keySet().stream().collect(Collectors.toList());
		Iterator<Row> rowIterator = sheet.iterator();
		
		
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			Map<String, String> rowData = new LinkedHashMap<>();
			if (row.getRowNum() != 0) {
				IntStream.range(0, headerMap.size()).forEach(index -> {
					row.getCell(index, MissingCellPolicy.CREATE_NULL_AS_BLANK).setCellType(CellType.STRING);
					rowData.put(headerValues.get(index), row.getCell(index).getStringCellValue());
				});
				// putting every row's first column value as key and rest as value in key-value
				// pair (colName,colValue)
				sheetData.put(rowData.entrySet().stream().findFirst().get().getValue(), rowData);
			}
		}
		LOGGER.info(LOG_DESIGN + "Recorded Sheet Data Successfully. : {}", sheetData);
		
		return sheetData;
	}
	
	
//=========================================================================================================================	
	
	
	
	
	
	
	
	public static int getRowCount(String workBookLocation,String sheetName) {
			
		XSSFSheet sheet;
		int rowCount=0;
			
		File inputFile = new File(workBookLocation);
		FileInputStream fileInputStream;
		XSSFWorkbook workbook = null;
		try {
			fileInputStream = new FileInputStream(inputFile);
			workbook = new XSSFWorkbook(fileInputStream);
			sheet=workbook.getSheet(sheetName);
			rowCount=sheet.getPhysicalNumberOfRows();
			if(rowCount>0) {
				rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum()+1;
					
 			//rowCount=sheet.getPhysicalNumberOfRows();
 		System.out.println("Total number of Rows ==="+rowCount);
 			
			}	
		}
 		catch(Exception e) {
 			System.out.println(e.getMessage());
 			System.out.println(e.getCause());
 		     e.printStackTrace();
 		      
 		}	
		
 		return rowCount;
		
 		
 		
 	} 	   
 	     
	

 	public static int getColCount(String workBookLocation,String sheetName) {
 		
 		XSSFSheet sheet;
 		int colCount=0;
		File inputFile = new File(workBookLocation);
		FileInputStream fileInputStream;
		XSSFWorkbook workbook = null;
		try {
			fileInputStream = new FileInputStream(inputFile);
			workbook = new XSSFWorkbook(fileInputStream);
			sheet=workbook.getSheet(sheetName);
		
			
			
		
				
 			//rowCount=sheet.getPhysicalNumberOfRows();
 				
			
 			 colCount=   sheet.getRow(0).getPhysicalNumberOfCells();
 			System.out.println("Total number of Cols ="+colCount);
 			//return colCount;
			
 		}
 		catch(Exception e) {
 			System.out.println(e.getMessage());
 			System.out.println(e.getCause());
 		     e.printStackTrace();
 		}
 		return colCount;
 	}

 	
 	
 	public static String getCellDataString(String workBookLocation,String sheetName,int rowNum,int colNum) {
 		XSSFSheet sheet;
 		// String cellData = null;
 		XSSFCell   cellData;
 		String data=null;
 		
 		File inputFile = new File(workBookLocation);
		FileInputStream fileInputStream;
		XSSFWorkbook workbook = null;
		try {
			fileInputStream = new FileInputStream(inputFile);
			workbook = new XSSFWorkbook(fileInputStream);
			sheet=workbook.getSheet(sheetName);
		
 			//cellData= sheet.getRow(rowNum).getCell(colNum).getStringCellValue();
 			cellData= sheet.getRow(rowNum).getCell(colNum);			 
 			DataFormatter formatter=new DataFormatter();
 			try {
 				data=formatter.formatCellValue(cellData);
 			}
 			catch(Exception e) 
 			{
 				data="";
 			}
 			//System.out.println(cellData);
 		}  
 		catch(Exception e) {
 			System.out.println(e.getMessage());
 			System.out.println(e.getCause());
 		     e.printStackTrace();
 		}
 		//return cellData;
		return data;
 	}
 		
 	
      public static void getCellDataNumber(String workBookLocation,String sheetName,int rowNum,int colNum) {
 		
    	  
    	  XSSFSheet sheet;
    	  File inputFile = new File(workBookLocation);
  		FileInputStream fileInputStream;
  		XSSFWorkbook workbook = null;
  		try {
  			fileInputStream = new FileInputStream(inputFile);
  			workbook = new XSSFWorkbook(fileInputStream);
  			sheet=workbook.getSheet(sheetName);
  		//} catch (Exception e) {
  		//	LOGGER.error(LOG_DESIGN + "Exception occurred while reading excel workbook : {}", e.getMessage());
  		//}		   	  
    	  
 	//	try {
 			double cellData= sheet.getRow(rowNum).getCell(colNum).getNumericCellValue();
 			//System.out.println(cellData);
 		}
 		catch(Exception e) {
 			System.out.println(e.getMessage());
 			System.out.println(e.getCause());
 		     e.printStackTrace();
 		}
 		
 	}
 	
	
   
      
      
      
	
	

}
