package com.wordpress.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.worpress.Pages.LoginPage;

public class VerifyWordpressLogin {
	
	@Test
	public void verifyValidLogin(){
		
		WebDriver driver=null;
		
		String browserType="Chrome";
		
		String path = System.getProperty("user.dir");//returns current path.
		System.out.println(path);
		
		if (browserType.equals("Firefox")) {
			//Firefox Profiling.
			ProfilesIni allProfs = new ProfilesIni();
			FirefoxProfile myprof = allProfs.getProfile("CreatedFirefoxProfileNameInLocal");
			driver = new FirefoxDriver();
		}else if (browserType.equals("IE")) {
			System.setProperty("webdriver.ie.driver",path + "\\ieDriver\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}else if (browserType.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver",path + "\\chromeDriver\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.get("http://demosite.center/wordpress/wp-login.php");
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.login("admin","demo123");
	}

}
