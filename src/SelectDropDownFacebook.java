import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SelectDropDownFacebook {
	
	@Test
	public void selectDropDownValues() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");		
		driver.manage().window().maximize();
		
		WebElement dd_month_element = driver.findElement(By.id("month"));
		System.out.println("dd_month_element: " + dd_month_element.getText());
		
		Select dd_month_selectList = new Select(dd_month_element);
		List<WebElement> dd_month_list= dd_month_selectList.getOptions();
		System.out.println("dd_month_list size: " + dd_month_list.size());
		
		Assert.assertEquals(dd_month_list.size(), 13);
		
		for (WebElement dd_webElement : dd_month_list) {
			System.out.println("Month List values: " + dd_webElement.getText());
		}
		
		
		// Various ways to select a value for month drop-down list.
		dd_month_selectList.selectByIndex(2);
		Thread.sleep(3000);
		
		dd_month_selectList.selectByValue("4");
		Thread.sleep(3000);
		
		dd_month_selectList.selectByVisibleText("Dec");
		
		WebElement selectedOption_element = dd_month_selectList.getFirstSelectedOption(); //The first selected option in this select tag (or the currently selected option in a normal select).
		System.out.println("selectedOption_element value: " + selectedOption_element.getText());
		
		Assert.assertEquals(selectedOption_element.getText(), "Dec");
		
		
		// Handle DROP-DOWN LIST that are not associated with SELECT tag.
		driver.get("http://seleniumpractise.blogspot.com/2016/08/bootstrap-dropdown-example-for-selenium.html");
		driver.manage().window().maximize();
		System.out.println("page title: " + driver.getTitle());
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[@id='menu1']")).click();
		
		List<WebElement> dd_elementList = driver.findElements(By.xpath("//ul[@class='dropdown-menu']//li/a"));
		System.out.println("dd_elementList size: " + dd_elementList.size());
		
		for (int i = 0; i < dd_elementList.size(); i++) {
			
			WebElement dd_element = dd_elementList.get(i);
			String innerHtml = dd_element.getAttribute("innerHTML");
			
			System.out.println("dd_element value: " + innerHtml);
			
			if(innerHtml.contentEquals("JavaScript")){
				dd_element.click();
				break; //Otherwise will throw exception --> org.openqa.selenium.StaleElementReferenceException: stale element reference: element is not attached to the page document.
			}
		}
		
	}

}
