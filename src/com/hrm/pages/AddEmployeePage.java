package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.common.BasePage;

public class AddEmployeePage extends BasePage {

	@FindBy(id ="firstName")
	private WebElement firstName;	
	
	@FindBy(id ="lastName")
	private WebElement lastName;	
	
	@FindBy(id ="btnSave")
	private WebElement saveBtn;	
	
	public AddEmployeePage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void setFirstName(String fn)
	{
		waitForElementPresent(firstName);
		firstName.sendKeys(fn);
	}
	
	public void setLastName(String ln)
	{
		waitForElementPresent(lastName);
		lastName.sendKeys(ln);
	}
	
	public void clickSaveBtn()
	{
		waitForElementPresent(saveBtn);
		saveBtn.click();
	}
}