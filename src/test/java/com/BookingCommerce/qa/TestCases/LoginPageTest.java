package com.BookingCommerce.qa.TestCases; 
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.BookingCom.qa.base.TestBase;
import com.bookingCommerce.qa.pages.HomePage;
import com.bookingCommerce.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void Setup()
	{
		initilization();
		loginpage=new LoginPage();
	}
	@Test(priority=1)
	public void LoginPageTitleTest()
	{
		String title=loginpage.validateLoginPageTitle();
		System.out.println(title);
		Assert.assertEquals( "Login", title);
		
	}
	@Test(priority=2)
	public void logintest()
	{
		homepage=loginpage.login(prop.getProperty("username"),prop.getProperty("password"));
		String s=driver.getTitle();
		System.out.println(s);
		Assert.assertEquals( "Dashbord", s);
		
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}

}
