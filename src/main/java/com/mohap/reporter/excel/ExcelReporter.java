package com.mohap.reporter.excel;

import static com.mohap.utils.common.Constants.LOG_DESIGN;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mohap.utils.common.Constants;
import com.mohap.utils.common.ExcelUtils;


/** Work under construction for this  // TODO
 * @author Jaikant.lnu
 *
 */
public class ExcelReporter {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExcelReporter.class);
	public static Map<String,String> TEST_RESULT_MAP = new HashMap<>();
	public static String originalFilePath = Constants.CONFIG_FOLDER_PATH + File.separator + "TestData.xlsx";
	public static String resultFilePath = Constants.CONFIG_FOLDER_PATH + File.separator + "TestData_WithResult.xlsx";
	public static int scenarioIdCellNo;
	public static int executionResultCellNo;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		TEST_RESULT_MAP.put("ADMIN_TEST_101", "PASSED");
		TEST_RESULT_MAP.put("ADMIN_TEST_100", "FAILED");
		TEST_RESULT_MAP.put("ADMIN_TEST_102", "PASSED");
		TEST_RESULT_MAP.put("COMMAND_CENTER_TEST_338", "PASSED");
		TEST_RESULT_MAP.put("COMMAND_CENTER_TEST_333", "PASSED");
		
		
		File resultFile = new File(resultFilePath);
		if (resultFile.exists()) {
			LOGGER.info("Result excel file [{}] already existes. Deleting it first for fresh results.", resultFile.getAbsolutePath());
			FileUtils.forceDelete(resultFile);
			LOGGER.info("Old result file deleted successfully.");
		}
		FileUtils.copyFile(new File(originalFilePath), resultFile);
	
		
		
		
		generateNewColumn(resultFile);
		//Thread.sleep(5000);
		//fillResults(new File(resultFilePath));
		
	}
	
	public static void generateNewColumn(File resultFile) throws IOException {
		XSSFWorkbook workbook = null;
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(resultFile);
			workbook = new XSSFWorkbook(fileInputStream);
		} catch (Exception e) {
			LOGGER.error(LOG_DESIGN + "Exception occurred while reading excel workbook : {}", e.getMessage());
		}
		XSSFSheet sheet = workbook.getSheet("TC_MAPPING");
		Iterator<Row> iterator = sheet.iterator();
		
		Map<String,Map<String,String>> tcMappingData = ExcelUtils.getSheetData(resultFilePath, "TC_MAPPING");
		List <String> tcIds = new ArrayList<>(tcMappingData.keySet());
		Map<String,String> sortedMapAccToIds = new LinkedHashMap<>();
		tcIds.forEach(id -> sortedMapAccToIds.put(id, TEST_RESULT_MAP.get(id)));
		List<String> testIdKeys = new ArrayList<>(sortedMapAccToIds.keySet());
		// Add additional column for results
		while (iterator.hasNext()) {
			int testIdCounter = 0;
			
			System.out.println("Inside iterator");
			Row currentRow = iterator.next();
			XSSFCellStyle style = workbook.createCellStyle();
			style.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
			style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
			style.setBorderTop(BorderStyle.THIN);
			style.setBorderBottom(BorderStyle.THIN);
			style.setBorderLeft(BorderStyle.THIN);
			style.setBorderRight(BorderStyle.THIN);
			
			
			
			Cell cell = currentRow.createCell(currentRow.getLastCellNum(), CellType.STRING);
			if (currentRow.getRowNum() == 0) {
				System.out.println("Creating new column");
				cell.setCellValue("SCENARIO_ID");
				cell.setCellStyle(style);
				scenarioIdCellNo = cell.getColumnIndex();
				//System.out.println("Scenario Id is:  " + scenarioIdCellNo);
				System.out.println();
				cell = currentRow.createCell(currentRow.getLastCellNum(), CellType.STRING);
				cell.setCellValue("EXECUTION_RESULT");
				cell.setCellStyle(style);
				executionResultCellNo = cell.getColumnIndex();
				// Create map of headers with [name,index] as key value pair
		} else {
			
			System.out.println("Scenario id : " + scenarioIdCellNo);
			String tcId = testIdKeys.get(testIdCounter);
			cell.setCellValue(tcId);
			cell = currentRow.createCell(currentRow.getLastCellNum(), CellType.STRING);
			cell.setCellValue(sortedMapAccToIds.get(tcId));
			testIdCounter++;
		}
		
	}
		fileInputStream.close();
		FileOutputStream output_file =new FileOutputStream(resultFile); 
		workbook.write(output_file);
		output_file.close();
}
	
	public static void fillResults(File resultFile) throws IOException {
		XSSFWorkbook workbook = null;
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(resultFile);
			workbook = new XSSFWorkbook(fileInputStream);
		} catch (Exception e) {
			LOGGER.error(LOG_DESIGN + "Exception occurred while reading excel workbook : {}", e.getMessage());
		}
		XSSFSheet sheet = workbook.getSheet("TC_MAPPING");
		Iterator<Row> iterator = sheet.iterator();
		while (iterator.hasNext()) {
			int testIdCounter = 0;
			Row currentRow = iterator.next();
			Map<String,Map<String,String>> tcMappingData = ExcelUtils.getSheetData(resultFilePath, "TC_MAPPING");
			List <String> tcIds = new ArrayList<>(tcMappingData.keySet());
			Map<String,String> sortedMapAccToIds = new LinkedHashMap<>();
			tcIds.forEach(id -> sortedMapAccToIds.put(id, TEST_RESULT_MAP.get(id)));
			List<String> testIdKeys = new ArrayList<>(sortedMapAccToIds.keySet());
			Map<String, Integer> headerMap = new LinkedHashMap<String, Integer>(); 
			
			short minColIx = currentRow.getFirstCellNum(); // get the first column index for a row
			short maxColIx = currentRow.getLastCellNum(); // get the last column index for a row
			for (short colIx = minColIx; colIx < maxColIx; colIx++) { // loop from first to last index
				Cell cell1 = currentRow.getCell(colIx); // get the cell
				headerMap.put(cell1.getStringCellValue(), cell1.getColumnIndex()); // add the cell contents (name of column)
			}
			
			if (!(currentRow.getRowNum() == 0)) {
			String tcId = testIdKeys.get(testIdCounter);
			System.out.println(currentRow.getRowNum());
			currentRow.getCell(headerMap.get("SCENARIO_ID")).setCellValue(tcId);
			currentRow.getCell(headerMap.get("EXECUTION_RESULT")).setCellValue(sortedMapAccToIds.get(tcId));
			testIdCounter++;
			}
		}
		fileInputStream.close();
		FileOutputStream output_file =new FileOutputStream(resultFile); 
		workbook.write(output_file);
		output_file.close();
	}
	
}
