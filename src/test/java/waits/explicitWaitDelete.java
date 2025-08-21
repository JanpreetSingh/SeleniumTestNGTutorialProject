package waits;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import utility.BrowserFactoryUtility;

public class explicitWaitDelete {
	
	@Test
	public void explicitWaitTest(){
		
		String url="http://seleniumpractise.blogspot.in/2016/08/how-to-use-explicit-wait-in-selenium.html";
		WebDriver driver=BrowserFactoryUtility.startBrowser("Chrome", url);
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//button[text()='Click me to start timer']")).click();
		//WebElement element = driver.findElement(By.xpath("//p[text()='WebDriver']"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='WebDriver']")));

		//		Using Lambda Expression
		WebElement element2 = wait.until(d -> d.findElement(By.xpath("//p[text()='WebDriver']")));
		
		boolean status=element.isDisplayed();
		
		if(status){
			System.out.println("Element is Displayed");
		}else{
			System.out.println("Element is not Displayed");
		}
	}
	

}
