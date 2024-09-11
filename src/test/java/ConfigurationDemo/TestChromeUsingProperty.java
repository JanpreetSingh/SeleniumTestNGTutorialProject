package ConfigurationDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import utility.BrowserFactoryUtility;
import utility.ConfigReader;

public class TestChromeUsingProperty {
	
	@Test
	public void testConfig() throws IOException{
		
		ConfigReader config = new ConfigReader();
		
		String chromePath = config.getChromePath();		
		System.out.println("chrome path is =="+chromePath);
		
		String url = config.getapplicationURL();
		
		WebDriver driver = BrowserFactoryUtility.startBrowser("chrome", chromePath);
		driver.get(url);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		System.out.println("Page Tile----->" + driver.getTitle());
		
	}

}


























