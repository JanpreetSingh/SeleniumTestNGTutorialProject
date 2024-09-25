package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactoryUtility {
	
	static WebDriver driver;
	
	public static WebDriver startBrowser(String browserName, String url){
		
		
		String path = System.getProperty("user.dir");//returns current path.
		System.out.println("Current Path --> " + path);
		
		if (browserName.equalsIgnoreCase("Firefox")) {
			System.setProperty("webdriver.gecko.driver","F:\\workspaceSelenium\\Day1\\firefoxDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}else if (browserName.equalsIgnoreCase("IE")) {
			
			System.setProperty("webdriver.ie.driver",path + "\\ieDriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			
		}else if (browserName.equalsIgnoreCase("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver",path + "\\chromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		
		return driver;
	}

}
