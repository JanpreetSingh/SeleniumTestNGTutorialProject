package SeleniumTutorial;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


/*In Webdriver, handling keyboard events and mouse events (including actions such as Drag and Drop 
 * or clicking multiple elements With Control key) are done using the advanced user interactions API . 
 * It contains Actions and Action classes which are needed when performing these events. 
 * In order to perform action events, we need to use org.openqa.selenium.interactions.Actions class.
 */

//Actions class to perform advanced keyboard and mouse actions.

/* ROBOT class This class is used to deal with the native system input events associated with Test Automation 
 * where control over the Mouse and Keyboard is needed. 
 */

public class D18_MouseActionsTutorial {
	
	@Test
	public void HoverOnElementTest() {
		
		System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-perform-mouse-hover-in-selenium.html");
		driver.manage().window().maximize();
		System.out.println("page title: " + driver.getTitle());
		
		WebElement hoverOnElement = driver.findElement(By.xpath("//button[@class='dropbtn' and text()='Automation Tools']"));
		
		//Actions class to perform advanced keyboard and mouse actions.
		Actions actions = new Actions(driver);
		
		// perform() method is used to perform desired simple and single action.
		actions.moveToElement(hoverOnElement).perform();
		
		List<WebElement> listElements = driver.findElements(By.xpath("//div[@class='dropdown-content']/a"));
		System.out.println("listElements size --> " + listElements.size());
		
		for (WebElement webElement : listElements) {
			
			String webElementValue = webElement.getAttribute("innerHTML");
			System.out.println("listElements VALUES -->: " + webElementValue);
			
			if (webElementValue.equals("Selenium")) {
				webElement.click();				
			}
			
		}
		
	}
	
	
	@Test
	public void DragAndDropElementTest() {
		
		System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
		driver.manage().window().maximize();
		System.out.println("page title: " + driver.getTitle());
		
		WebElement dragFrom = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement dropAt = driver.findElement(By.xpath("//div[@id='droppable']"));
		
		//Actions class to perform advanced keyboard and mouse actions.
		Actions actions = new Actions(driver);
		
		/*The build() method is used compile all the listed actions into a single step.
		 *We have to use build() when we are performing sequence of operations 
		 *and no need to use only if we are performing single action.
		*/
		actions.dragAndDrop(dragFrom, dropAt).build().perform();		
		
	}
	
	
	@Test
	public void DragAndDropElementAlternateTest() {
		
		System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://dhtmlx.com/docs/products/dhtmlxTree/");
		driver.manage().window().maximize();
		System.out.println("page title: " + driver.getTitle());
		
		WebElement dragFrom = driver.findElement(By.xpath("(//span[text()='Thrillers'])[1]"));
		WebElement dropAt = driver.findElement(By.xpath("(//span[text()='Thrillers'])[2]"));
		
		//Actions class to perform advanced keyboard and mouse actions.
		Actions actions = new Actions(driver);
		
		actions.clickAndHold(dragFrom).pause(2000);
		actions.moveToElement(dropAt).pause(2000);
		actions.release().build().perform();
		
	}
	
	
	@Test
	public void RightClickTest() {
		
		System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
		System.out.println("page title: " + driver.getTitle());
		
		WebElement element = driver.findElement(By.xpath("//a[text()='About']"));
		
		//Actions class to perform advanced keyboard and mouse actions.
		Actions actions = new Actions(driver);
		
		actions.moveToElement(element).contextClick(element).build().perform();

		/* ROBOT class This class is used to deal with the native system input events associated with Test Automation 
		 * where control over the Mouse and Keyboard is needed. 
		 */
		try {
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
			robot.keyPress(KeyEvent.VK_ENTER);
			
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			System.out.println("EXCEPTION--> " + e.getMessage());
		}		
		
	}

}











































