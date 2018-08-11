package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: shiva srivastva')]")
	WebElement usernamelabel;
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactlinks;
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement Dealslinks;
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement Tasklinks;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement NewContactlink;
	

	//Initializing the page objects
	public HomePage()
	{
		PageFactory.initElements(driver,this);
		
		
	}
	//Actions
	public String verifyHomePageTitle(){
		
		return  driver.getTitle();
	}
	
	public boolean verifycorrectusername() {
		
		return usernamelabel.isDisplayed();
		
	}
	public ContactsPage clickoncontactlinks() {
		contactlinks.click();
		return new ContactsPage();
		
}
	public DealsPage clickonDealslink() {
		
		Dealslinks.click();
		return new DealsPage();
	}
	public TaskPage clickonTasklinks() {
		
		Tasklinks.click();
		return  new TaskPage();
		
	}

	public void clickonNewContactLink() {
		Actions action=new Actions(driver);
		action.moveToElement(contactlinks).build().perform();
		NewContactlink.click();
		
		
	}
	
	
	
	
	
	
	
	
}
