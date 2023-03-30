package com.worpress.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	By username = By.id("user_login");
	By password= By.xpath("//input[@id='user_pass']");
	By loginButton = By.name("wp-submit");
	
	public LoginPage(WebDriver driver){
		
		this.driver=driver;
	}
	
	public void typeUsername(String uid){
		
		driver.findElement(username).sendKeys(uid);
	}
	
	public void typePassword(String pswd){
		
		driver.findElement(password).sendKeys(pswd);
	}
	
	public void clickLoginButtojn(){
		
		driver.findElement(loginButton).click();
	}
	
	public void login(String uid, String pswd){
		
		driver.findElement(username).sendKeys(uid);
		driver.findElement(password).sendKeys(pswd);
		driver.findElement(loginButton).click();


	}

}
