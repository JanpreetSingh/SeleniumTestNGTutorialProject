package SeleniumTutorial;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import utility.BrowserFactoryUtility;


public class D11_ExplicitWaitTutorial {
	
	@Test
	public void explicitWaitTest(){
		
		String url="http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html";
		WebDriver driver=BrowserFactoryUtility.startBrowser("Chrome", url);
		
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));

		//		Using Lambda Expression
		WebElement element2 = driver.findElement(By.xpath("//p[text()='WebDriver']"));
		wait.until(d -> d.findElement(By.xpath("//p[text()='WebDriver']")));
	
		
		System.out.println("Element is Displayed ? "+element.isDisplayed());	

	}

}


















