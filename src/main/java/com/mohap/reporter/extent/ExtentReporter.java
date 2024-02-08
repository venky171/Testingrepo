package com.mohap.reporter.extent;

import static com.mohap.utils.common.Constants.EXTENT_REPORT_HTML;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ExtentHtmlReporterConfiguration;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.mohap.utils.common.Config;


/** This class is responsible for whole extent reporting operations.
 * 
 * @author Jaikant
 *
 */
public class ExtentReporter {

	
	public ExtentTest extentTest;
    public static ExtentReports extentReports;

	private ThreadLocal<ExtentTest> parentTest = new ThreadLocal<>();
	private ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	/**
	 * It will create and get instance of ExtentReports.
	 * 
	 * @return instance of ExtentReports
	 */
	public static ExtentReports getInstance() {
		if (extentReports == null) {
			createInstance();
		}
   
		return extentReports; 
	} 

	/**
	 * @param fileName The filename which will be created for extent reporting 
	 * @return instance of ExtentReports.
	 */
	public static ExtentReports createInstance() {
		String reportName = "extent_report";
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(EXTENT_REPORT_HTML);
		ExtentHtmlReporterConfiguration extentHtmlReporterConfiguration = new ExtentHtmlReporterConfiguration(
				htmlReporter);
		extentHtmlReporterConfiguration.setTheme(Theme.DARK);
		extentHtmlReporterConfiguration.setDocumentTitle(reportName);
		extentHtmlReporterConfiguration.setEncoding("UTF-8");
		extentHtmlReporterConfiguration.setReportName(reportName);

		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);

		return extentReports;
	}

	/**
	 * It will create instance of ExtentReports on starting of suite execution.
	 */
	public static void onExceutionStart() {   
		extentReports = getInstance();
	}
  
	/**
	 * onStart- OnStart method is called when any Test starts.
	 */
	public synchronized void onStart(ITestContext testContext) {
		extentTest = extentReports.createTest(testContext.getCurrentXmlTest().getName());
		extentTest.assignAuthor(System.getProperty("user.name"));
		extentTest.assignCategory(Config.getProperty("suiteName"));
		parentTest.set(extentTest);
	}

	/**
	 * onFinish method is called after all Tests are executed in specific <test> tag
	 * in xml.
	 */
	public synchronized void onFinish(ITestContext testContext) {
		parentTest.get().getModel().setStartTime(getTime(testContext.getStartDate().getTime())); 
		parentTest.get().getModel().setEndTime(getTime(testContext.getEndDate().getTime()));
		extentReports.flush();
	}

	/**
	 * @param result
	 */
	public synchronized void onTestStart(ITestResult result) {
		String testId = result.getMethod().getConstructorOrMethod().getMethod()
				.getAnnotation(org.testng.annotations.Test.class).testName();
		testId = testId.isEmpty() ? "" : "[" + testId + "] ";
		extentTest = parentTest.get().createNode(testId + result.getMethod().getMethodName());
		test.set(extentTest);
	}

	/**
	 * @param result
	 */
	public synchronized void onTestPass(ITestResult result) {
		extentTest.log(Status.PASS, MarkupHelper
				.createLabel("Test : [" + result.getMethod().getMethodName() + "] :  PASSED", ExtentColor.GREEN));

	}

	/**
	 * @param result
	 */
	public synchronized void onTestFail(ITestResult result) {
		extentTest.log(Status.FAIL, MarkupHelper
				.createLabel("Test : [" + result.getMethod().getMethodName() + "] : FAILED", ExtentColor.RED));

	}

	/**
	 * @param result
	 */
	public synchronized void onTestSkip(ITestResult result) {
		extentTest.log(Status.SKIP, MarkupHelper
				.createLabel("Test : [" + result.getMethod().getMethodName() + "] : SKIPPED", ExtentColor.ORANGE));

	}

	/**
	 * @param millis
	 * @return
	 */
	private static Date getTime(long millis) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(millis);
		return calendar.getTime();
	}

	/**
	 * It will set the total execution time for the test case in report.
	 * 
	 * @param ITestResult
	 */
	public synchronized void setExecutionTime(ITestResult result) {
		extentTest.getModel().setStartTime(getTime(result.getStartMillis()));
		extentTest.getModel().setEndTime(getTime(result.getEndMillis()));
	}

	/**
	 * 
	 */
	public synchronized void onSuiteFinish() {
		extentReports.flush();
	}

	/**
	 * It will add provided info on extent report on extent report.
	 * 
	 * @param details
	 */
	public synchronized void info(String details) {
		extentTest.log(Status.INFO, MarkupHelper.createLabel(details, ExtentColor.WHITE));
	}

	/**
	 * It will add pass status on test step on extent report.
	 * 
	 * @param details
	 */
	public synchronized void pass(String details) {
		extentTest.log(Status.PASS, MarkupHelper.createLabel(details, ExtentColor.GREEN));
	}
  
	/**
	 * It will add fail status on test step on extent report.
	 * 
	 * @param details
	 */
	public synchronized void fail(String details) {
		extentTest.log(Status.FAIL, MarkupHelper.createLabel(details, ExtentColor.RED));
	}

	/**
	 * It will add skip status on test step on extent report.
	 * 
	 * @param details
	 */
	public synchronized void skip(String details) {
		extentTest.log(Status.SKIP, MarkupHelper.createLabel(details, ExtentColor.ORANGE));
	}

	/**
	 * @param details Throwable object
	 */
	public synchronized void fail(Throwable details) {
		extentTest.log(Status.FAIL, details);
	}

	/**
	 * It will add warning status on test step on extent report.
	 * 
	 * @param details
	 */
	public synchronized void warning(String details) {
		extentTest.log(Status.WARNING, MarkupHelper.createLabel(details, ExtentColor.YELLOW));
	}

	/**
	 * It will add attach screenshot to extent report.
	 * 
	 * @param screenShotPath
	 */
	public synchronized void attachScreenshot(String screenShotPath) {
		try {
			extentTest.addScreenCaptureFromPath(screenShotPath);
		} catch (IOException e) {
			fail("!!!!!!!!! Exception occurred while attaching the screenshot to extent report.");
		}

	}

}
