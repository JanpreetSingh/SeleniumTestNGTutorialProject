package DDT;

import org.openqa.selenium.By;
import org.testng.Assert;
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
