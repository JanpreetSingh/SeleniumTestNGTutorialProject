import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;



public class WindowHandlesTutorial {
	
	@Test
	public void MultipleWindowsTest() {
		
		System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		System.out.println("page title: " + driver.getTitle());
		
		String parentWindow = driver.getWindowHandle();
		System.out.println("Parent Window--> " + parentWindow);
		
		WebElement AbountLinkElement = driver.findElement(By.xpath("//a[text()='About']"));
		WebElement BusinessLinkElement = driver.findElement(By.xpath("//a[text()='Business']"));
		WebElement AdvertisingLinkElement = driver.findElement(By.xpath("//a[text()='Advertising']"));
		
		Actions actions = new Actions(driver);		
		// Open the link in new TAB
		actions.moveToElement(AbountLinkElement).pause(2000).perform();
		actions.keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
		
		actions.moveToElement(BusinessLinkElement).pause(2000).perform();
		actions.keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
		
		actions.moveToElement(AdvertisingLinkElement).pause(2000).perform();
		actions.keyDown(Keys.CONTROL).click().keyUp(Keys.CONTROL).build().perform();
		
		
		Set<String> allWindows = driver.getWindowHandles();
		System.out.println("Total number of windows --> " + allWindows.size());
		System.out.println("Windows SET--> " + allWindows);
		
		ArrayList<String> allWindowsList = new ArrayList<>(allWindows);
		System.out.println("Windows LIST--> " + allWindowsList);
		// The window list after reversing will have windows in the order in which the links were clicked. 
		//But, the parent window will appear at the last index of the list.
		Collections.reverse(allWindowsList);
		System.out.println("Reversed Windows LIST--> " + allWindowsList);
		
		driver.switchTo().window(allWindowsList.get(2));
		System.out.println("CurrentURL --> " + driver.getCurrentUrl());
		System.out.println("Window --> " + driver.getWindowHandle());
		
		
	}
}




















