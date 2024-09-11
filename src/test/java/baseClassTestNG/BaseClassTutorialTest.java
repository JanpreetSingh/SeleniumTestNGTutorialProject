package baseClassTestNG;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class BaseClassTutorialTest extends BaseClass{
		
		@Test(description="This test case will perform Valid Login")
		public void loginToApplication() throws InterruptedException {
			
			driver.findElement(By.id("user_login")).sendKeys("admin");
			driver.findElement(By.id("user_pass")).sendKeys("demo123");
			driver.findElement(By.xpath("//*[@id='wp-submit']")).click();
			 
			Thread.sleep(2000);
			 
			Assert.assertTrue(driver.getTitle().contains("Dashboard"), "Cannot login -invalid credentials");
			System.out.println("Page title verified - User logged in.");
			
		}
		
		
		@Test(description="This test case will perform Invalid Login")
		public void inValidloginToApplication() throws InterruptedException {
			
			driver.findElement(By.id("user_login")).sendKeys("admi");
			driver.findElement(By.id("user_pass")).sendKeys("demo1");
			driver.findElement(By.xpath("//*[@id='wp-submit']")).click();
			 
			Thread.sleep(2000);
			 
			Assert.assertTrue(!driver.getTitle().contains("Dashboard"), "logged in with invalid credentials");
			System.out.println("Page title verified - User logged in.");
			
		}
}
