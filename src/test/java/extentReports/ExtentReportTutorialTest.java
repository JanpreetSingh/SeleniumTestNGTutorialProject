package extentReports;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import utility.ScreenCaptureUtility;



public class ExtentReportTutorialTest {
	
	ExtentReports report;
	WebDriver driver;
	ExtentTest test;
	
	@BeforeClass
	public void setupExtentReporter() {
		
		ExtentSparkReporter reporter = new ExtentSparkReporter("./reports/verifySeleniumTitle.html");
		
		report = new ExtentReports();
		report.attachReporter(reporter);
		
		System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@AfterMethod
	public void tearDownExtentReporter(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE) {
			
			String screenshotPath = ScreenCaptureUtility.captureScreenshot(driver, result.getName());
			
			// log FAIL status with snapshot
	        test.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
		}
		
		report.flush();
		
	}
	
	@Test
	public void extentTutorial1() throws IOException{
	
		driver.get("http://www.google.com");
		
		test = report.createTest("verifyTitle method Test", "This test method gives Extent Report tutorial");
		
		test.log(Status.INFO, "This step shows usage of INFO(details)");
		test.pass("This step shows usage of PASS(details)");
		
		String screenshotPath = ScreenCaptureUtility.captureScreenshot(driver, driver.getTitle());
		// log PASS status with snapshot
        test.pass(driver.getCurrentUrl(), MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        
        //calling flush writes everything to the log file
		//report.flush();
		
		Assert.assertTrue(driver.getTitle().contains("Google"));
		
	}
	
	
	@Test
	public void extentTutorial2() throws IOException{
		
		driver.get("http://learn-automation.com/");
		
		
		ExtentTest test2 = report.createTest("extentTutorial method Test2", "This test method shows way to create multiple tests in a single test method");
		
		test2.info("This step shows usage of INFO(details)");
		test2.log(Status.PASS, "This step shows usage of PASS(details)");
		// attach a snapshot to the test
        test2.addScreenCaptureFromPath("F:\\workspaceSelenium\\Day1\\screenshots\\Google.png");
		
        test = report.createTest("extentTutorial method Test", "This test method shows way to create multiple tests in a single test method");
		
		test.log(Status.WARNING, "This step shows usage of WARNING(details)");
		test.fail("This step shows usage of FAIL(details)");	
		//report.flush();
	
		Assert.assertTrue(driver.getTitle().contains("Google"), "This is not Google HOMEPAGE");
			
	}
	
}






























