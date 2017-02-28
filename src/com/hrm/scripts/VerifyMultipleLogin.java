package com.hrm.scripts;

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
		
		lp.verifyURLhas(homepage);
		
		HomePage hp = new HomePage(driver);
		hp.clickWelcome();
		hp.clickLogout();	
		
		hp.verifyURLhas(loginpage);
	
	
	AutoLoginRequired=false;
	AutoLogoutRequired=false;
  }
}	
