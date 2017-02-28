package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.common.BasePage;

public class LoginPage extends BasePage
{
	@FindBy(id = "txtUsername")
	private WebElement userName;
	
	@FindBy(id = "txtPassword")
	private WebElement passW0rd;
	
	@FindBy(id = "btnLogin")
	private WebElement loginButton;	

	public LoginPage(WebDriver driver) 
	{
	super(driver);
	PageFactory.initElements(driver, this);
	}
	
	public void setUserName(String UN)
	{
		waitForElementPresent(userName);
		userName.sendKeys(UN);
	}
	
	public void setPassword(String PW)
	{
		waitForElementPresent(passW0rd);
		passW0rd.sendKeys(PW);
	}
	
	public void clickLogin()
	{
		waitForElementPresent(loginButton);
		loginButton.click();
	}
}