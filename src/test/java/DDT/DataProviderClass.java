package DDT;

import java.util.concurrent.TimeUnit;

import lib.ExcelDataConfig;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public class DataProviderClass {
	
	WebDriver driver;
	
	@DataProvider(name="wordpressData")
	public Object[][] passData(){
		
		ExcelDataConfig config = new ExcelDataConfig("F:\\workspaceSelenium\\Day1\\TestData\\InputData.xlsx");
		
		XSSFSheet sheet = config.getSheet(0);
		
		Object[][] data =config.getAllDataFromSheet(sheet);
		
		return data;
	}
	
	
	@BeforeMethod
	public void browserSetUp() {
		
		String path = System.getProperty("user.dir");//returns current path.
		System.out.println(path);		
		
		System.setProperty("webdriver.chrome.driver",path + "\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();					
		 
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		 driver.get("http://demosite.center/wordpress/wp-login.php");
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
