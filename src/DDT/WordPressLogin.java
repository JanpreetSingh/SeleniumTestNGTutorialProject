package DDT;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import lib.ExcelDataConfig;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WordPressLogin extends DataProviderClass{
	
	@Test(dataProvider="wordpressData")
	public void loginToWordpress(String username, String password) throws InterruptedException{
		
		/*Getting driver reference from DataProviderClass*/
		 driver.findElement(By.id("user_login")).sendKeys(username);
		 driver.findElement(By.id("user_pass")).sendKeys(password);
		 driver.findElement(By.xpath("//*[@id='wp-submit']")).click();
		 
		 Thread.sleep(5000);
		 
		 Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Cannot login -invalid credentials");
		 System.out.println("Page title verified - User logged in.");
		 
	}	

}
