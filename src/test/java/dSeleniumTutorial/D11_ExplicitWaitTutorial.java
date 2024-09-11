package dSeleniumTutorial;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class D11_ExplicitWaitTutorial {
	
	@Test
	public void useExplicitWait() {
		
		System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
		driver.manage().window().maximize();
		System.out.println("page title: " + driver.getTitle());
		
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
		
		//Explicit  Wait.
		WebDriverWait explicitlyWait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = explicitlyWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));
		
		Assert.assertTrue(element.isDisplayed(), "Element not Displayed");
	}

}


















