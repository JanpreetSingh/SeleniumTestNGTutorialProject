package dSeleniumTutorial;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class D16_RadioButtonHandling {
	
	@Test
	public void handleRadioButtons() throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-automate-radio-button-in.html");
		driver.manage().window().maximize();
		System.out.println("page title: " + driver.getTitle());
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//Get List of land radio buttons
		List<WebElement> radioBtn_lang_elementList = driver.findElements(By.xpath("//input[@name='lang' and @type='radio']"));
		System.out.println("radioBtn_lang_elementList size: " + radioBtn_lang_elementList.size());
		
		for (int i = 0; i < radioBtn_lang_elementList.size(); i++) {
			
			WebElement radioBtn_lang_element = radioBtn_lang_elementList.get(i);
			String radioBtn_lang_elementValue = radioBtn_lang_element.getAttribute("value");
			
			System.out.println("dd_elementListItem value: " + radioBtn_lang_elementValue);
			
			if(radioBtn_lang_elementValue.equals("RUBY")) {
				radioBtn_lang_element.click();
				
				Assert.assertTrue(radioBtn_lang_element.isSelected());
			}		
			
		}
		
		
	}

}
