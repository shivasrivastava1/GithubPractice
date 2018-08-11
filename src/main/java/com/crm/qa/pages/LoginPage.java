package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(xpath="//input[@placeholder='Password']")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement LoginBtn;
	
	@FindBy(xpath="//button[text()='Sign Up']")
	WebElement signupBtn;
	
	
	@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement CRMLogo;
	
	 //intiliaze page objects
	public LoginPage() {
		
		PageFactory.initElements(driver,this);
		
	}
	//Action
	public String validateLoginPageTitle() throws InterruptedException {
		Thread.sleep(2000);
		return driver.getTitle();
		}
	
	public boolean validateCRMImage() {
	  return CRMLogo.isDisplayed();
		
	}
	
public HomePage Login(String un,String pwd) {
	
	username.sendKeys(un);
	password.sendKeys(pwd);
	LoginBtn.click();
	
	return new HomePage();
	
	
}
}
