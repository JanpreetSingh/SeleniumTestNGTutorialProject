package com.wordpress.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.worpress.Pages.LoginPagePF;

import utility.BrowserFactoryUtility;

public class VerifyWordpressLoginPF {
	
	@Test
	public void verifyValidLogin(){
		
		String url="http://demosite.center/wordpress/wp-login.php";
		WebDriver driver = BrowserFactoryUtility.startBrowser("firefox", url);
		
		LoginPagePF loginPagePF = PageFactory.initElements(driver, LoginPagePF.class);
		
		loginPagePF.login("admin", "demo123");
	}

}
