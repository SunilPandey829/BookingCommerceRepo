package com.BookingCom.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase()
	{
		try
		{
			prop=new Properties();
			FileInputStream ip=new FileInputStream("G:/WorkSpace/BookingCommerceTest/src/main/java/com/bookingCommerce/qa/config/config.properties");
			prop.load(ip);	
																				 }
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	public static void initilization()
	{	 
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "G:/WorkSpace/BookingCommerceTest/Drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver","G:\\WorkSpace\\BookingCommerceTest\\Drivers\\gecko.exe");
			driver=new FirefoxDriver();
			
		}
		else if(browserName.equals("Safari")) 
		{
			driver=new SafariDriver();
		}
		else if(browserName.equals("IE"))
		{
			driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("No browser value given");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}

}
