package com.crm.qa.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.crm.qa.util.Testutil;

public class TestBase {
public static WebDriver driver;
public static Properties prop;
	
	
public TestBase()
{
	try {
		
	
	prop=new Properties();
	FileInputStream fis= new FileInputStream("C:/Users/User/eclipse-workspace/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
	prop.load(fis);
	}
	catch (Exception e) {
		e.getMessage();
	}
}


public static void initialization() {
	String browserName=prop.getProperty("browser");
	if(browserName.equals("chrome"))
	{
		System.setProperty("webdriver.chrome.driver", "C:/Users/User/eclipse-workspace/FreeCRMTest/src/main/resources/chromedriver.exe");
		driver= new ChromeDriver();
	}else if(browserName.equals("IE"))
	{
		System.setProperty("webdriver.ie.driver", "");
		driver= new InternetExplorerDriver();
	}


	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Testutil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(Testutil.IMPLICIT_WAIT,TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	
}

}
	

