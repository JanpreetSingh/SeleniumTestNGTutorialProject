package SeleniumTutorial;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class D10_ImplicitWaitTutorial {
	
	@Test
	public void useImplicitWait() {
		
		System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//Page Load Time
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		
		//Implicit Wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
		
		// Maximize browser window
		driver.manage().window().maximize();
		
		System.out.println("page title: " + driver.getTitle());
		
		

	}
	


}
