package com.mohap.core;

import static com.mohap.utils.common.Constants.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlSuite.ParallelMode;

import com.mohap.utils.common.CommonUtils;
import com.mohap.utils.common.Config;

import org.testng.xml.XmlTest;


/** It is the heart of this framework.
 * It controls and configures everything that is defined in TestData sheet and executes the dynamic prepared test suite.
 *
 * @author Jaikant.lnu
 *
 */
public class DynamicSuiteRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DynamicSuiteRunner.class);
	private static final String LOG_DESIGN = "####################################################################################################";
	public static Map<String, Map<String, String>> testAndClasses = new HashMap<>(); 
	public static Map<String, Map<String, String>> LOCATORS_CACHE = new HashMap<>(); 
	// test packages
	public static final String WEB_PACKAGE = "com.telus.tests.web";
	public static final String MOBILE_PACKAGE_WEB = "com.telus.tests.mobile.web";
	public static final String MOBILE_PACKAGE_NATIVE = "com.telus.tests.mobile.nativee";

	
	
	public static void main(String[] args) throws IOException {
		String suiteName = Config.getProperty("suiteName");
		
		// getting all test classes
		testAndClasses = ReflectionUtils.getClassAndTests(WEB_PACKAGE);
		testAndClasses.putAll(ReflectionUtils.getClassAndTests(MOBILE_PACKAGE_WEB));
		testAndClasses.putAll(ReflectionUtils.getClassAndTests(MOBILE_PACKAGE_NATIVE));
		
		// recording all locators
		DataRecorder.recordLocators();
		
		// recording spreadsheet data
		DataRecorder.recordData();
		
		// generating dynamic testng xml and running
		genrateTestNGAndRun(suiteName, testAndClasses);
	}

	
	/** It will create a dynamic testng xml form excel sheet and run.
	 * @param suiteName name to be given to suite e.g Smoke,Regression etc.
	 * @param testAndClasses all @Test annotated methods and their respective classes
	 */
	public static void genrateTestNGAndRun(String suiteName, Map<String, Map<String, String>> testAndClasses) {
		// first getting all classes or modules(where test cases are written) and their test cases in a map.
		// e.g map : AdminTest={KEY="ADMIN_TEST__100", value= "add_new_work_skill"}
		
		// setting suite name and verbose in xml
		XmlSuite suite = new XmlSuite();
		
		// adding listeners
		suite.addListener("com.telus.listeners.CustomReporter");  // reporter listener
		
		if(Config.getProperty("retryEnabled").equals("yes"))     // retry listener  [By default : no]
		suite.addListener("com.telus.listeners.RetryListener");
		
		suite.setName(suiteName);
		suite.setVerbose(8);
		if (Config.getProperty("parallel").equals("yes"))      // setting parallel mode [By default : no]
		suite.setParallel(ParallelMode.TESTS);
		
		// filtering all enabled test classes and their test cases
		List<String> testClassesEnabledInExcel = DataRecorder.TESTSCRIPTS_CACHE.keySet().stream().filter(key -> DataRecorder.TESTSCRIPTS_CACHE.get(key).get("RunMode").equalsIgnoreCase("Y")).collect(Collectors.toList());
		List<String> testClassesToRun = testAndClasses.keySet().stream().filter(className -> testClassesEnabledInExcel.contains(className)).collect(Collectors.toList());
		testClassesToRun.sort(Comparator.comparingInt(testClassesEnabledInExcel::indexOf));  // sorting test classes as defined in TestData.xlsx
		
		List<XmlSuite> suites = new ArrayList<XmlSuite>();
		LOGGER.info(LOG_DESIGN);
		
		// iterating each class (where test cases are present e.g AdminTest) and writing all @Test annotated methods to testng xml which have RunMode as "Y" in excel data sheet.
		// here we are making each class as e.g  <test name="AdminTest"> and writing parameters and test methods (i.e @Test methods) in that <test> tag.
		testClassesToRun.forEach(className -> {
			// here "className" value is like : AdminTest,QuotaTest etc.
			List<XmlInclude> includedMethods = new ArrayList<>();
			
			// getting all test case ids e.g (@Test (name="ADMIN_TEST_100"))
			// here "ADMIN_TEST_100" is testId
			List<String> testIdsPresentInClass = testAndClasses.get(className).keySet().stream().collect(Collectors.toList()); 
			LOGGER.info("Test Ids present in class : [{}] are : {}", className, testIdsPresentInClass);
			
			List<String> testIdsInExcel = DataRecorder.TC_MAPPING_CACHE.keySet().stream().collect(Collectors.toList());
			
			// filtering test ids which have RunMode enabled in excel sheet.
			List<String> filteredTestId = testIdsPresentInClass.stream().filter(id -> Objects.nonNull(DataRecorder.TC_MAPPING_CACHE.get(id)) && DataRecorder.TC_MAPPING_CACHE.get(id).get("RUNMODE").equalsIgnoreCase("Y")).collect(Collectors.toList());
			filteredTestId.sort(Comparator.comparingInt(testIdsInExcel::indexOf));  // sorting according test ids as defined in excel sheet.
			
			LOGGER.info("Test Ids that are enabled in Excel data sheet are : {}", testIdsPresentInClass);
			
			// adding filtered test cases to the testng xml.
			filteredTestId.forEach(id -> includedMethods.add(new XmlInclude(testAndClasses.get(className).get(id))));
			
			if (!includedMethods.isEmpty()) {
				// getting test configuration like browser,runmode etc related to that class as defined in excel sheet.
				Map<String, String> testScriptConfig =  DataRecorder.TESTSCRIPTS_CACHE.get(className); 
				LOGGER.info("TestScript Configuration for class [{}] is {}", className, testScriptConfig);
				
				List<XmlClass> classes = new ArrayList<XmlClass>();
				XmlTest test = new XmlTest(suite);
				test.setName(className);  // e.g <test name="AdminTest">
				
				Map<String, String> parameters = new HashMap<>();
				parameters.put("browser", testScriptConfig.get("Browser")); // e.g <parameter name="browser" value="chrome"></parameter>
				parameters.put("nodeURL", testScriptConfig.get("NodeURL"));
				if (testScriptConfig.get("Browser").contains("mobile")) {
					parameters.put("deviceOrientation", testScriptConfig.get("DeviceOrientation"));
				}
				
				String packagePath = getPackagePath(testScriptConfig.get("Browser"));
				test.setParameters(parameters);
				XmlClass xmlClass = new XmlClass(packagePath + "." + className); // e.g <class name="com.wfm.tests.web.AdminTest">
				xmlClass.setIncludedMethods(includedMethods); // e.g <include name="add_new_work_skill"></include>
				classes.add(xmlClass);
				test.setXmlClasses(classes);
				LOGGER.info(LOG_DESIGN);
			}
		});
		suites.add(suite);
		
		// creating testng xml for debug purpose.
		// it will be created in src/main/resources/testSuiteXmls folder
		CommonUtils.generateXmlFile(SUITE_XML_PATH + File.separator + "dynamic_suite.xml", suite.toXml());
		
		TestNG tng = new TestNG();
	//	List<Class<? extends ITestNGListener>> listenerClasses = Arrays.asList(CustomReporter.class,RetryListener.class);
		List<String> suitesToRun = Arrays.asList(SUITE_XML_PATH + File.separator + "dynamic_suite.xml");
		tng.setTestSuites(suitesToRun);  // setting suites
	//	tng.setXmlSuites(suites);			 
	//  tng.setListenerClasses(listenerClasses);  // setting listener classes.
		tng.run();
	}


	/** It will return the package path according to browser or application [Browser column in spreadsheet]
	 * @param browser
	 * @return package path : e.g com.telus.test.web
	 */
	public static String getPackagePath(String browser) {
		String packagePath = null;
		switch (browser) {
		case MOBILE_CHROME_ANDROID :
			packagePath = MOBILE_PACKAGE_WEB;
			break;
		case MOBILE_NATIVE_ANDROID :
			packagePath = MOBILE_PACKAGE_NATIVE;
			break;
		case CHROME:
			packagePath = WEB_PACKAGE;
			break;
		}
		
		return packagePath;
	}	

	
}
