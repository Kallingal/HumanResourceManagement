package com.hrm.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.hrm.common.BaseTest;
import com.hrm.common.HomePage;
import com.hrm.common.UserCredentials;
import com.hrm.pages.LoginPage;

public class VerifyMultipleLogin extends BaseTest
{
	
public VerifyMultipleLogin()
{
	AutoLoginRequired=false;
	AutoLogoutRequired=false;	
}	
	
	@Test(priority=1,dataProviderClass=UserCredentials.class, dataProvider="getData")
	
	public void testMultipleLogin(String UN, String PW)
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(UN);
		lp.setPassword(PW);		
		lp.clickLogin();
		
		WebElement element1 = driver.findElement(By.id("welcome"));
		WebDriverWait wait1 = new WebDriverWait(driver,15);
		wait1.until(ExpectedConditions.visibilityOf(element1));		
		lp.verifyURLhas(homepage);
		
		HomePage hp = new HomePage(driver);
		hp.clickWelcome();		
		hp.clickLogout();	
		hp.verifyURLhas(loginpage);
		
	AutoLoginRequired=false;
	AutoLogoutRequired=false;
  }
}	