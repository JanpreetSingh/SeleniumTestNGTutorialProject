package baseClassTestNG;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;



import utility.BrowserFactoryUtility;
import utility.ConfigReader;

public class BaseClass {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUpWebdriver() {
			
			
			ConfigReader config = new ConfigReader();
			
			String chromePath = config.getChromePath();		
			System.out.println("chrome path is ==> "+chromePath);
			
			String url = config.getWordpressUrl();
			
			driver = BrowserFactoryUtility.startBrowser("chrome", chromePath);
			driver.get(url);
			driver.manage().window().maximize();
					
	}
	
	
	@AfterMethod
	public void tearDownWebdriver() {
			
			driver.quit();
					
	}

}





























