package dSeleniumTutorial;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.base.Function;


public class D12_FluentWaitTutorial {
	
	@Test
	public void useFluentWait() {
		
		System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-use-explicit-wait-in-selenium.html");
		driver.manage().window().maximize();
		System.out.println("page title: " + driver.getTitle());
		
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
		

		// Fluent Wait.
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver);
		   
		// Waiting 10 seconds for an element to be present on the page.
		wait.withTimeout(10, TimeUnit.SECONDS);
		       
		// Checking for the presence of the element once every 500 ms.    
		wait.pollingEvery(500, TimeUnit.MILLISECONDS);
		       
		// Specifying exception to ignore.
		wait.ignoring(NoSuchElementException.class);

		   WebElement element = wait.until(new Function<WebDriver, WebElement>() {
			   
		     public WebElement apply(WebDriver driver) {
		    	 
		       WebElement ele = driver.findElement(By.xpath("//p[@id='demo']"));
		       String eleValue = ele.getAttribute("innerHTML");
		       
		       if (eleValue.equals("WebDriver")) {
		    	   
		    	   System.out.println("This is the correct Value: " + eleValue);
		    	   return ele;
		    	   
			}else {
				
				System.out.println("Not the desired Value: " + eleValue);
				return null;
				
			}
	
		 }
		 });
		
		Assert.assertTrue(element.isDisplayed(), "Element not Displayed");
	}
}






















