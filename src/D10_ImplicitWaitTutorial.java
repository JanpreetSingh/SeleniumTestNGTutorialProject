
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//ImplicitWait.
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
		// Maximize browser window
		driver.manage().window().maximize();
		System.out.println("page title: " + driver.getTitle());
		
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
				
		WebElement element = driver.findElement(By.xpath("//p[text()='WebDriver']"));
		
		Assert.assertTrue(element.isDisplayed(), "Element not Displayed");
		
	}
	
}
