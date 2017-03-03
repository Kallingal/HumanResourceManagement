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
	
	@FindBy(id ="menu_pim_addEmployee")
	private WebElement addEmployee;	
	
	@FindBy(id ="menu_pim_viewEmployeeList")
	private WebElement employeeList;
	
	@FindBy(id ="menu_admin_viewAdminModule")
	private WebElement Admin;
	

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
	
	public void clickaddEmployee()
	{
		waitForElementPresent(addEmployee);
		addEmployee.click();
	}
	
	public void clickEmployeeList()
	{
		waitForElementPresent(employeeList);
		employeeList.click();
	}
	
	public void clickAdmin()
	{
		waitForElementPresent(Admin);
		Admin.click();
	}
	
}