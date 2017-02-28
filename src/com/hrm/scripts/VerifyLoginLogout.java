package com.hrm.scripts;

import org.testng.annotations.Test;
import com.hrm.common.BaseTest;
import com.hrm.common.HomePage;
import com.hrm.pages.LoginPage;
import generics.Excel;

public class VerifyLoginLogout extends BaseTest
{
   	public VerifyLoginLogout()
	{
		AutoLoginRequired=false;
		AutoLogoutRequired=false;
	}
	
	@Test(priority=2)
	
	public void testLoginLogout()
	{
		String UN = Excel.getCellValue(INPUT_FILE, "LoginLogout", 1, 0);
		String PW = Excel.getCellValue(INPUT_FILE, "LoginLogout", 1, 1);
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(UN);
		lp.setPassword(PW);
		lp.clickLogin();
		lp.verifyURLhas(homepage);
		
		HomePage hp = new HomePage(driver);
		hp.clickWelcome();
		hp.clickLogout();
		hp.verifyURLhas(loginpage);		
	}	
}