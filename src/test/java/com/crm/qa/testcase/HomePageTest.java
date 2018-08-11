package com.crm.qa.testcase;

import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Testutil;

public class HomePageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	Testutil testutil;
	ContactsPage contactpage;

	public HomePageTest() throws InterruptedException {
		super();
		Thread.sleep(2000);
		}
	
	@BeforeMethod()
	public void setup() throws InterruptedException
	{
		Thread.sleep(2000);
		initialization();
		testutil=new Testutil();
		contactpage=new ContactsPage();
		 loginpage = new LoginPage();
		homepage =  loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		 
	}
	
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homepageTitle=homepage.verifyHomePageTitle();
		Assert.assertEquals("CRMPRO", homepageTitle);
		
		}
	
	@Test(priority=2)
	public void verifyusernameTest() throws InterruptedException {
//		Thread.sleep(3000);
//		boolean flag=homepage.verifycorrectusername();
//		Assert.assertTrue(true);
		
		testutil.switchtoframe();
		Assert.assertTrue(homepage.verifycorrectusername());
		}
	
	@Test(priority=3)
	public void verifycontactslinkTest() {
		testutil.switchtoframe();
		contactpage = homepage.clickoncontactlinks();
		
		
	}
	@AfterMethod
	public void tearDown()
	{
		
		driver.quit();
	}
	
	
	
	

}
