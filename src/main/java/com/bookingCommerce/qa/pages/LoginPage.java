package com.bookingCommerce.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.BookingCom.qa.base.TestBase;

public class LoginPage extends TestBase{
	//Page Factory//Page objects//object repo
	@FindBy(xpath="(//input[contains(@class,'form-control')])[1]") 
	WebElement username;
	
	@FindBy(xpath="(//input[contains(@class,'form-control')])[2]") 
	WebElement password;
	
	@FindBy(xpath="//button[contains(@class,'ui-btn-lg')]") 
	WebElement login;
	
	//Initialization of page objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	//Actions 
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
				
	}
	public HomePage login(String un,String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		login.click();
		return new HomePage();
		
	}

}
  