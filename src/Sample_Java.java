import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;

import utility.Log4jUtility;


public class Sample_Java {

	public static void main(String[] args) throws InterruptedException {
		// Getting logger
		Logger logger = Log4jUtility.createLogger(Sample_Java.class);
		
		WebDriver driver = null;
		
		String browserType="Chrome";
		
		String path = System.getProperty("user.dir");//returns current path.
		System.out.println(path);
		
		if (browserType.equals("Firefox")) {
			//Firefox Profiling.
			ProfilesIni allProfs = new ProfilesIni();
			FirefoxProfile myprof = allProfs.getProfile("CreatedFirefoxProfileNameInLocal");
			driver = new FirefoxDriver();
			logger.info("Firefox Browser Started");
		}else if (browserType.equals("IE")) {
			System.setProperty("webdriver.ie.driver",path + "\\ieDriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			logger.info("IE Browser Started");
		}else if (browserType.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",path + "\\chromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			logger.info("Chrome Browser Started");
			
		}		
		 
		 driver.get("https://accounts.google.com");
		 
		 /*WebElement username = driver.findElement(By.id("Email"));		 
		 username.sendKeys("jsj1833");
		 
		 WebElement next = driver.findElement(By.id("next"));
		 next.click();*/
		 
		 WebElement username = driver.findElement(By.xpath("//input[@id='Email']"));		 
		 username.sendKeys("jsj1833");
		 
		 WebElement next = driver.findElement(By.xpath("//input[@id='next']"));
		 next.click();
		 
		 WebElement password = driver.findElement(By.xpath("//*[@id='Passwd']"));		 
		 password.sendKeys("jsj1833");
		 
		 next = driver.findElement(By.xpath("//input[@id='signIn']"));
		 next.click();
		 
		 //DROPDOWN
		 driver.get("https://www.facebook.com/");
		 driver.manage().window().maximize();
		 
		 WebElement month_drop= driver.findElement(By.id("month"));
		 
		 Select month_dd = new Select(month_drop);
		 
		 WebElement selected_value = month_dd.getFirstSelectedOption();
		 System.out.println("Initial selected value : "+ selected_value.getText());
		 		 
		 month_dd.selectByIndex(3);
		 
		 Thread.sleep(2000);
		 
		 month_dd.selectByVisibleText("Apr");
		 
		 Thread.sleep(2000);
		 
		 month_dd.selectByValue("10");
		 
		selected_value = month_dd.getFirstSelectedOption();
		 System.out.println("Afterwards selected value : "+ selected_value.getText());
		 
		 List<WebElement> month_list = month_dd.getOptions();
		 int listSize = month_list.size();
		 
		 for(WebElement element : month_list){
			 String month_name = element.getText();
			 System.out.println("-----Months are---------"+month_name);
		 }
		 
		 //HANDLING RADIO BUTTONS.
		 driver.get("http://seleniumpractise.blogspot.in/2016/08/how-to-automate-radio-button-in.html");
		 
		 List<WebElement> radio = driver.findElements(By.xpath("//input[@name='lang' and @type='radio']"));
		 
		 for(int i=0;i<radio.size();i++){
			 WebElement local_radio = radio.get(i);
			 String value = local_radio.getAttribute("value");
			 
			 System.out.println(local_radio +"----value is------"+value);
			 
			 if(value.equalsIgnoreCase("RUBY")){
				 local_radio.click();
			 }
		 }
		
		 
	}

}
