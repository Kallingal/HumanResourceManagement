package com.hrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.hrm.common.BasePage;

public class EmployeeInformationPage extends BasePage{
	
	@FindBy(id = "btnDelete")
	private WebElement deleteBtn;	
	
	@FindBy(id = "dialogDeleteBtn")
	private WebElement dialogDeleteBtn;
	
	public EmployeeInformationPage(WebDriver driver) 
	{
	super(driver);
    PageFactory.initElements(driver, this);
	}
	
	public void verifyEmployeePresentinTable(String fn)
	{
		String xP = "//table[@id = 'resultTable']/..//a[.='"+fn+"']";
		boolean found=false;
		try
		{
		WebElement element = driver.findElement(By.xpath(xP));
		waitForElementPresent(element);
		Reporter.log("Pass: Employee is present in the Table",true);
		found=true;
		}catch (Exception e)
		{
			Reporter.log("Fail: Employee is not present in the Table",true);
			found=false;
		}
		
		Assert.assertTrue(found, "Employee is not Found in the table");		
	}	
	
	public void clickEmployeeCheckBox(String fn)
	{
		String xP = "//a[text() = '"+fn+"']/../..//input[@type = 'checkbox']";
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
	
	public void verifyEmployeeNotPresentinTable(String fn)
	{
		String xP = "//table[@id = 'resultTable']/..//a[.='"+fn+"']";
		boolean found=false;
		try
		{
		WebElement element = driver.findElement(By.xpath(xP));
		waitForElementPresent(element);
		Reporter.log("Fail: Employee is present in the Table",true);
		found=true;
		}catch (Exception e)
		{
			Reporter.log("Pass: Employee is not present in the Table",true);
			found=false;
		}
		
		Assert.assertFalse(found, "Employee is Found in the table");		
	}
}