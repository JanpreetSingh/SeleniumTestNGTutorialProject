import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


public class D13_IframeTutorial {
	
	@Test
	public void iframeSwitch() {
		
		System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.goibibo.com/");
		driver.manage().window().maximize();
		System.out.println("page title: " + driver.getTitle());
		
		List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
		System.out.println("Total iframes in the page --> " + iframeList.size());
		
		
		driver.findElement(By.xpath("//a[@id='get_sign_up']")).click();
		
		//Switch to the iframe.
		driver.switchTo().frame("authiframe");
		
		driver.findElement(By.id("authMobile")).sendKeys("9999999996");
		
		//Explicit  Wait.
		WebDriverWait explicitlyWait = new WebDriverWait(driver, 10);
		boolean elementValueEntered = explicitlyWait.until(ExpectedConditions.textToBePresentInElementValue(By.id("authMobile"),"9999999996"));
		System.out.println(elementValueEntered);				
		
		
		
		// Returns the driver focused on the top window/first frame
		driver.switchTo().defaultContent();
		
		//Close the iframe.
		driver.findElement(By.xpath("//a[contains(@class,'fr icon-close font12Lt popClose')]")).click();
		
		driver.findElement(By.xpath("//span[text()='Round trip']")).click();
		
	}	

}
