import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;



public class D14_AlertTutorial {
	
	@Test
	public void handleAlertTest() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");
		driver.manage().window().maximize();
		System.out.println("page title: " + driver.getTitle());
		
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		// Bring control on the alert
		Alert alert = driver.switchTo().alert();
		
		String alertText = alert.getText();
		System.out.println("alerText -->" + alertText);
		String alertText_expected = "I am an alert box!";
		
		Assert.assertEquals(alertText, alertText_expected);
		
		Thread.sleep(3000);
		// Use dismiss() method to cancel the alert.
		alert.accept();
	
		
	}
}
