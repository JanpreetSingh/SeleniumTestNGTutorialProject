package dSeleniumTutorial;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class D23_WindowsAuthentication {
	
	@Test
	public void windowAuthTest() {
	System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	/* 
	 * http://username:password@url
	 */
	driver.get("http://admin:admin@www.engprod-charter.net/");
	
	driver.manage().window().maximize();
	System.out.println("page title: " + driver.getTitle());
	
	
	driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
	
	System.out.println("page loaded");
	
  
 }

}
