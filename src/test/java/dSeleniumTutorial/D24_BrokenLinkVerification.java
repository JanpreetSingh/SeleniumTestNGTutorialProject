package dSeleniumTutorial;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class D24_BrokenLinkVerification {
	
	@Test
	public void BrokenLinks() {
		
		System.setProperty("webdriver.chrome.driver","F:\\workspaceSelenium\\Day1\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.google.co.in/");
		driver.manage().window().maximize();
		System.out.println("page title: " + driver.getTitle());
		
		List<WebElement> linksList = driver.findElements(By.tagName("a"));
		System.out.println("linksList size: " + linksList.size());
		
		for (int i=0;i<linksList.size();i++) {
			
			WebElement ele = linksList.get(i);
			
			String eleHrefValue = ele.getAttribute("href");
			
			boolean isLinkActive = verifyLinkActive(eleHrefValue);
			
			Assert.assertTrue(isLinkActive, "The link is broken: " + eleHrefValue);
		}
		
	}

	public boolean verifyLinkActive(String linkUrl) {
		
		boolean linkActive = false;
		try {
			
			URL url = new URL(linkUrl);
			
			HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
			httpURLConnection.setConnectTimeout(3000);
			httpURLConnection.connect();
			
			if (httpURLConnection.getResponseCode()==200) {
				
				System.out.println(linkUrl + " Active --> " + httpURLConnection.getResponseMessage());
				linkActive = true;
				
			}
			if (httpURLConnection.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND) {
				
				System.out.println(linkUrl + " Broken --> " + httpURLConnection.getResponseMessage());
								
			}
			
		} catch (Exception e) {
			
			System.out.println("EXCEPTION message--> " + e.getMessage());
		
		}
		
		return linkActive;
		
	}
	
}























	
