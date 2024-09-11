package testNGTutorial;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

@Listeners(testNGTutorial.ITestListnerClass.class)
public class ITestListnerTest {
	WebDriver driver;
	
	@Test
	public void googleTitleVerify() throws IOException{
		
		String path = System.getProperty("user.dir");//returns current path.
		System.out.println(path);
		 
			System.setProperty("webdriver.chrome.driver",path + "\\chromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();			
		
		
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());

}
	
	@Test
	public void DummyFail(){
		System.out.println("Test Dummy Fail");
		Assert.assertTrue(false);
	}
	
	@Test
	public void testSoftAssert(){
		System.out.println("Before Assert Statement");
		
		SoftAssert assertion = new SoftAssert();
		assertion.assertEquals(12, 13);		
		
		System.out.println("After Assert Statement : Soft Assert does not stop test excution despite test failure");
		
		assertion.assertAll();
	}

}