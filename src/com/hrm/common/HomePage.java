package com.hrm.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
	
	@FindBy(id = "welcome")
	private WebElement welCome;
	
	@FindBy(xpath ="//a[. = 'Logout']")
	private WebElement logOut;	
	
	@FindBy(id ="menu_pim_viewPimModule")
	private WebElement PIM;

	public HomePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickWelcome()
	{
		waitForElementPresent(welCome);
		welCome.click();
	}
	public void clickLogout()
	{
		waitForElementPresent(logOut);
		logOut.click();
	}
	public void clickPIM()
	{
		waitForElementPresent(PIM);
		PIM.click();
	}	
}