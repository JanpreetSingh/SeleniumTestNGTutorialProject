import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;


public class TestFacebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		/*System.setProperty("webdriver.gecko.driver","F:\\workspaceSelenium\\Day1\\firefoxDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();*/
		
		/*System.setProperty("webdriver.ie.driver","F:\\workspaceSelenium\\Day1\\ieDriver\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();*/
		
		driver.manage().window().maximize();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.get("https://www.facebook.com/");
		
		
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("Apple Email");
		driver.findElement(By.xpath("//*[@id='u_0_j']")).sendKeys("Apple Firstname");
		
		// Getting elements of the drop-down list month.
		Select droplistMonth = new Select(driver.findElement(By.xpath("//*[@id='month']")));
		// Selecting particular elements from the drop-down.
		droplistMonth.selectByIndex(2);
		// Alternate ways of Selecting particular elements from the drop-down.
/*		droplistMonth.selectByValue("5");
		droplistMonth.selectByVisibleText("Nov");
*/		
		// Go to Cookie Use page.
		driver.findElement(By.xpath("//*[@id='cookie-use-link']")).click();
		
		// Navigate back from current page.
		driver.navigate().back();
		
		
		
	}

}
