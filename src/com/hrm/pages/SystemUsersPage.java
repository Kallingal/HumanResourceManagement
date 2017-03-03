package com.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.hrm.common.BasePage;

public class SystemUsersPage extends BasePage{
	
	@FindBy(id ="btnAdd")
	private WebElement addBtn;
	
	@FindBy(id ="btnDelete")
	private WebElement deleteBtn;
	
	@FindBy(id = "dialogDeleteBtn")
	private WebElement dialogDeleteBtn;
	
	public SystemUsersPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void clickAddBtn()
	{
		waitForElementPresent(addBtn);
		addBtn.click();
	}
	
	public void verifyUserPresentinTable(String uname)
	{
		String xP = "//table[@id = 'resultTable']/..//a[.='"+uname+"']";
		boolean found=false;
		try
		{
		WebElement element = driver.findElement(By.xpath(xP));
		waitForElementPresent(element);
		Reporter.log("Pass: User is present in the Table",true);
		found=true;
		}catch (Exception e)
		{
			Reporter.log("Fail: User is not present in the Table",true);
			found=false;
		}		
		Assert.assertTrue(found, "User is not Found in the table");		
	}	
	
	public void clickUserCheckBox(String user)
	{
		String xP = "//a[.='"+user+"']/../..//input[@type='checkbox']";
		driver.findElement(By.xpath(xP)).click();		
	}
	
	public void clickDeleteButton()
	{
		waitForElementPresent(deleteBtn);
		deleteBtn.click();
	}
	
	public void clickDialogDeleteButton()
	{
		waitForElementPresent(dialogDeleteBtn);
		dialogDeleteBtn.click();
	}
	
	public void verifyUserNotPresentinTable(String uname)
	{
		String xP = "//table[@id = 'resultTable']/..//a[.='"+uname+"']";
		boolean found=false;
		try
		{
		WebElement element = driver.findElement(By.xpath(xP));
		waitForElementPresent(element);
		Reporter.log("Fail: User is present in the Table",true);
		found=true;
		}catch (Exception e)
		{
			Reporter.log("Pass: User is not present in the Table",true);
			found=false;
		}
		
		Assert.assertFalse(found, "User is Found in the table");		
	}	
}