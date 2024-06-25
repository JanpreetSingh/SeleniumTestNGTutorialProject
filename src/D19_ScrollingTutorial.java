import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class D19_ScrollingTutorial {
	
	@Test
	public void scrollPageTest() {
		
		System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.youtube.com/");
		driver.manage().window().maximize();
		System.out.println("page title: " + driver.getTitle());
		
		//Create instance of Javascript Executor.
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		// window.scrollBy(HScroll,VScroll) and scroll(HScroll,VScroll) both method can be used to scroll.
		// -ve parameter value means up or left scroll.
		js.executeScript("window.scrollBy(0,10000)");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		js.executeScript("scroll(0,5000)");
	}
	
	
	
	@Test
	public void scrollToElementTest() {
		
		System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.youtube.com/watch?v=l4U76CIntPw&list=PL6flErFppaj2ArNxLyR4nQ4JV8qFc56-M&index=40");
		driver.manage().window().maximize();
		System.out.println("page title: " + driver.getTitle());
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement element = driver.findElement(By.xpath("//span[contains(text(),'How to Generate XSLT Report in Selenium Webdriver')]"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		// Scroll till the element is reached.
		js.executeScript("arguments[0].scrollIntoView(true)", element);
		
	}
	
	
	
	@Test
	public void scrollToBottomOfPageTest() {
		
		System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://learn-automation.com/javascript-in-selenium-webdriver-and-different-usage/");
		driver.manage().window().maximize();
		System.out.println("page title: " + driver.getTitle());
		
		//Create instance of Javascript Executor.
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		// window.scrollBy(HScroll,VScroll) and scroll(HScroll,VScroll) both method can be used to scroll.
		// -ve parameter value means up or left scroll.
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Scroll back to top of the page.
		js.executeScript("window.scrollTo(0,0)");
		
		
	}
	
	
}




















































