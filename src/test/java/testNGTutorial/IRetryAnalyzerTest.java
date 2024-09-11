package testNGTutorial;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class IRetryAnalyzerTest {
	
	WebDriver driver;
	

/* IRetryAnalyzer re-runs the @Test methods(with retryAnalyzer attribute) if it fails, for the retry limit specified.
 * */
	
	@Test(retryAnalyzer=testNGTutorial.IRetryAnalyserClass.class)
	public void dummyFailTest1(){
		System.out.println("Test1 Dummy Fail");
		Assert.assertTrue(false);
	}
	
	
	@Test
	public void dummyFailTest2(){
		System.out.println("Test2 Dummy Fail");
		Assert.assertTrue(false);
}
	
	
	
}
