package waits;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utility.BrowserFactoryUtility;

public class fluentWait {
	
	@Test
	public void fluentWaitTest(){
		
		String url="http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html";
		WebDriver driver=BrowserFactoryUtility.startBrowser("Chrome", url);
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
				
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
				
		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
					@Override
					public WebElement apply(WebDriver driver) {
						
						WebElement ele = driver.findElement(By.id("demo"));
						String value = ele.getAttribute("innerHTML");
						
						if(value.equalsIgnoreCase("WebDriver")){
							return ele;
						}else{
							System.out.println("Text which is coming on the page is : "+value);
							return null;
						}
						
					}
					
				});
				
		System.out.println("Element is Displayed ? "+element.isDisplayed());		
		
	}

}
