import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class LoggerTutorial {
	
	@Test
	public void LoggerTest() {
	
	// Initialize Logger object
	Logger logger = Logger.getLogger(LoggerTutorial.class); 
	PropertyConfigurator.configure("./resources/log4j.properties");
	
	System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	
	logger.info("*********Chrome Browser Initialzed************");
	
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.get("https://www.google.com/");
	
	// Types of Log messages
	logger.info("1*********Google.com home page loaded************");
	logger.warn(" Warning Message");
	logger.error(" Error Message");
	logger.fatal(" Fatal Message");
	logger.debug(" Debug Message");
	logger.info("2*********Google.com home page loaded************");
	logger.warn(" Warning Message");
	logger.error(" Error Message");
	logger.fatal(" Fatal Message");
	logger.debug(" Debug Message");
	logger.info("3*********Google.com home page loaded************");
	logger.warn(" Warning Message");
	logger.error(" Error Message");
	logger.fatal(" Fatal Message");
	logger.debug(" Debug Message");
	logger.info("4*********Google.com home page loaded************");
	logger.warn(" Warning Message");
	logger.error(" Error Message");
	logger.fatal(" Fatal Message");
	logger.debug(" Debug Message");
	logger.info("5*********Google.com home page loaded************");
	logger.warn(" Warning Message");
	logger.error(" Error Message");
	logger.fatal(" Fatal Message");
	logger.debug(" Debug Message");
	logger.info("6*********Google.com home page loaded************");
	logger.warn(" Warning Message");
	logger.error(" Error Message");
	logger.fatal(" Fatal Message");
	logger.debug(" Debug Message");
	logger.info("7*********Google.com home page loaded************");
	logger.warn(" Warning Message");
	logger.error(" Error Message");
	logger.fatal(" Fatal Message");
	logger.debug(" Debug Message");
	
	driver.manage().window().maximize();
	System.out.println("page title: " + driver.getTitle());
	
	}
	
}
























