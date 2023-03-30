import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import utility.ScreenCaptureUtility;


public class ScreenshotFacebook {
	
	@Test
	public void captureScreenshot() throws IOException {
		
		System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		System.out.println("page title: " + driver.getTitle());
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("Apple Email");
		
		//Custom reusable code for taking screenshot.
		ScreenCaptureUtility.captureScreenshot(driver, "facebookLoginScreenshotFileName");
		
		/*
		 TakesScreenshot tsh = (TakesScreenshot)driver;
		
		//Obtain the screenshot into a temporary file that will be deleted once the JVM exits. It is up to users to make a copy of this file.
		File sourceFile = tsh.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./screenshots/faceebookLoginPage.png");
		
		FileHandler.copy(sourceFile, destFile);	//FileUtils can also be used to copy files. But, first 'org.apache.commons.io.jar' needs to be configured in build path.
		
		System.out.println("Screenshot Taken");*/
		
	}

}















