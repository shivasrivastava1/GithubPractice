package com.crm.qa.testcase;

import static org.testng.Assert.assertEquals;

import org.apache.xerces.util.SynchronizedSymbolTable;
import org.junit.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	//Logger log=Logger.getLogger(LoginPageTest.class);
	
	public LoginPageTest() throws InterruptedException {
		super();
		Thread.sleep(3000);
	}

	@BeforeMethod()
	public void setup() throws InterruptedException
	{
		Thread.sleep(6000);
		initialization();
		//log.info("Launching the chrome browser");
		 loginpage = new LoginPage();
//		 log.info("entering application url");
//		 log.warn("This is just a warning");
//		 log.error("This is just a error");
//		 log.fatal("This is just a fatal error");
//		 log.debug("This is a debug message");
	}
	@Test(priority=1)
	public void loginPageTitleTest() throws InterruptedException {
	Thread.sleep(2000);	
	
	//log.info("*********Statting Test Case************");
	//log.info("*********Free CRM Title Test************");
	String title=loginpage.validateLoginPageTitle();
	//String title=driver.getTitle();
	System.out.println(title);
	Assert.assertEquals("Free CRM software in the cloud powers sales and customer service",title);
		 
		}
	@Test(priority=2)
	public void CRMLogoTest() {
	
		boolean flag=loginpage.validateCRMImage();
		Assert.assertTrue(flag);
		
		}
	@Test(priority=3)
	public void loginTest() {
		
	homepage = loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		
	//log.info("*********Ending Test Case************");
	}
	 
	@AfterMethod
	public void tearDown()
	{
 		driver.quit();
		//log.info("*********Browser is close************");

	}
	
	
}
