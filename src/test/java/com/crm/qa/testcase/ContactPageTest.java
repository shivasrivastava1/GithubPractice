package com.crm.qa.testcase;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Testutil;

public class ContactPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	Testutil testutil;
    ContactsPage contactpage;
    
    String sheetname="contacts";
   
	public ContactPageTest() throws InterruptedException {
		super();
		Thread.sleep(3000);
		}

	@BeforeMethod()
	public void setup() throws InterruptedException
	{
		Thread.sleep(2000);
		initialization();
		testutil=new Testutil();
		 loginpage = new LoginPage();
		 homepage =  loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		testutil.switchtoframe();
		contactpage= new ContactsPage();
		contactpage =  homepage.clickoncontactlinks();
	}
	
	@Test
	public void verifycontactpagelabel() {
		
		Assert.assertEquals( contactpage.verifycontactlabel(), "contact label is missing on the page");
		}
	@DataProvider
	public Object[][] getCRMTestData() throws EncryptedDocumentException, InvalidFormatException, IOException {
	Object data[][] =	Testutil.getTestData(sheetname);
		return data;
		
	}
	
	@Test(priority=1, dataProvider = "getCRMTestData")
	public void validateCreateNewContact(String title,String firstname, String lastname,String company){
		
		homepage.clickonNewContactLink();
		//contactpage.createNewContact("Mr.", "Tom", "Peter", "Google");
		contactpage.createNewContact(title, firstname, lastname, company);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		
		driver.quit();
	}
	
	}
