package com.hrm.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrm.common.BasePage;

public class AddUserPage extends BasePage{

	@FindBy(id ="systemUser_employeeName_empName")
	private WebElement employeeName;
	
	@FindBy(id ="systemUser_userName")
	private WebElement userName;
	
	@FindBy(id ="systemUser_password")
	private WebElement passWord;
	
	@FindBy(id ="systemUser_confirmPassword")
	private WebElement confirmPassword;
	
	@FindBy(id ="btnSave")
	private WebElement saveBtn;	
	
	public AddUserPage(WebDriver driver) 
	{
	super(driver);
	PageFactory.initElements(driver, this);	
	}
	
	public void setEmployee(String empName)
	{
		waitForElementPresent(employeeName);
		employeeName.sendKeys(empName);
	}
	
	public void setUserName(String username)
	{
		waitForElementPresent(userName);
		userName.sendKeys(username);
	}
	
	public void setPassword(String password)
	{
		waitForElementPresent(passWord);
		passWord.sendKeys(password);
	}
	
	public void setConfirmPassword(String cpassword)
	{
		waitForElementPresent(confirmPassword);
		confirmPassword.sendKeys(cpassword);
	}
	
	public void clickSave()
	{
		waitForElementPresent(saveBtn);
		saveBtn.click();
	}
}