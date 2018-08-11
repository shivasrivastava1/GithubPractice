package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslabel;
	
	@FindBy(xpath="//input[@id='first_name']")
	WebElement FirstName;
	
	@FindBy(xpath="//input[@id='surname']")
	WebElement LastName;

	@FindBy(xpath=" //input[@name='client_lookup']")
	WebElement companyName;
	
	@FindBy(xpath="//input[@value='Load From Company']//following::input[@value='Save']")
	WebElement savebutton;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver,this);
		
		
	}
	
	public boolean verifycontactlabel()
	{
		return contactslabel.isDisplayed();
		
		}
	
	
	public void createNewContact(String title,String ftname,String ltname,String comp) {
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		FirstName.sendKeys(ftname);
		LastName.sendKeys(ltname);
		companyName.sendKeys(comp);
		savebutton.click();
		
		
		}
	
	
	
	
	

}
