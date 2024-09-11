package com.worpress.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPagePF {
	
	WebDriver driver;
	
	@FindBy(id="user_login")
	@CacheLookup
	WebElement username;
	
	@FindBy(how=How.XPATH,using="//input[@id='user_pass']")
	@CacheLookup
	WebElement password;
	
	@FindBy(how=How.NAME,using="wp-submit")
	@CacheLookup
	WebElement loginButton;
	
	@FindBy(how=How.LINK_TEXT,using="Lost your password")
	@CacheLookup
	WebElement forget_password_link;
	
public LoginPagePF(WebDriver driver){
		
		this.driver=driver;
	}
	
	public void typeUsername(String uid){
		
		username.sendKeys(uid);
	}
	
	public void typePassword(String pswd){
		
		password.sendKeys(pswd);
	}
	
	public void clickLoginButtojn(){
		
		loginButton.click();
	}
	
	public void login(String uid, String pswd){
		
		username.sendKeys(uid);
		password.sendKeys(pswd);
		loginButton.click();


	}
}
