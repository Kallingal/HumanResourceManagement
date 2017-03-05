package com.hrm.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.hrm.common.AutomationConstants;
import com.hrm.common.BaseTest;
import com.hrm.common.HomePage;
import com.hrm.pages.AddEmployeePage;
import com.hrm.pages.AddUserPage;
import com.hrm.pages.EmployeeInformationPage;
import com.hrm.pages.LoginPage;
import com.hrm.pages.SystemUsersPage;
import generics.Excel;

public class VerifyAddDeleteUser extends BaseTest {

	@Test(priority=4)
	
	public void testAddDeleteUser()
	{
		String fn = Excel.getCellValue(INPUT_FILE, "AddEmployee", 1, 0);
		String ln = Excel.getCellValue(INPUT_FILE, "AddEmployee", 1, 1);
		
		String un = Excel.getCellValue(AutomationConstants.INPUT_FILE, "NewUser", 1, 0);
		String pw = Excel.getCellValue(AutomationConstants.INPUT_FILE, "NewUser", 1, 1);
		
		String UN = Excel.getCellValue(INPUT_FILE, "LoginLogout", 1, 0);
		String PW = Excel.getCellValue(INPUT_FILE, "LoginLogout", 1, 1);
		
		String username = fn+" "+ln;
		
		WebElement element1 = driver.findElement(By.id("welcome"));
		WebDriverWait wait1 = new WebDriverWait(driver,15);
		wait1.until(ExpectedConditions.visibilityOf(element1));
		
		HomePage hp = new HomePage(driver);
		hp.clickPIM();
		
		WebElement element2 = driver.findElement(By.id("menu_pim_viewEmployeeList"));
		WebDriverWait wait2 = new WebDriverWait(driver,15);
		wait2.until(ExpectedConditions.visibilityOf(element2));
		
		hp.clickaddEmployee();
		
		WebElement element3 = driver.findElement(By.id("btnSave"));
		WebDriverWait wait3 = new WebDriverWait(driver,15);
		wait3.until(ExpectedConditions.visibilityOf(element3));	
		
		AddEmployeePage aep = new AddEmployeePage(driver);
		aep.setFirstName(fn);
		aep.setLastName(ln);
		aep.clickSaveBtn();
		
		WebElement element4 = driver.findElement(By.id("btnAddAttachment"));
		WebDriverWait wait4 = new WebDriverWait(driver,15);
		wait4.until(ExpectedConditions.visibilityOf(element4));	
		
        hp.clickEmployeeList();	
        
        WebElement element5 = driver.findElement(By.id("btnAdd"));
		WebDriverWait wait5 = new WebDriverWait(driver,15);
		wait5.until(ExpectedConditions.visibilityOf(element5));
		
		EmployeeInformationPage eip = new EmployeeInformationPage(driver);
		eip.verifyEmployeePresentinTable(fn);
		
		hp.clickAdmin();
		
		WebElement element6 = driver.findElement(By.id("btnAdd"));
		WebDriverWait wait6 = new WebDriverWait(driver,15);
		wait6.until(ExpectedConditions.visibilityOf(element6));	
		
		SystemUsersPage sup = new SystemUsersPage(driver);
		sup.clickAddBtn();
		
		WebElement element7 = driver.findElement(By.id("btnSave"));
		WebDriverWait wait7 = new WebDriverWait(driver,15);
		wait7.until(ExpectedConditions.visibilityOf(element7));	
				
		AddUserPage aup = new AddUserPage(driver);
		aup.setEmployee(username);
		aup.setUserName("user7");
		aup.setPassword("admin");
		aup.setConfirmPassword("admin");
		aup.clickSave();
		
		WebElement element8 = driver.findElement(By.id("btnAdd"));
		WebDriverWait wait8 = new WebDriverWait(driver,15);
		wait8.until(ExpectedConditions.visibilityOf(element8));	
				
		sup.verifyUserPresentinTable("user7");
						
		hp.clickWelcome();
		hp.clickLogout();
		
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(un);
		lp.setPassword(pw);
		lp.clickLogin();
		
		WebElement element10 = driver.findElement(By.id("welcome"));
		WebDriverWait wait10 = new WebDriverWait(driver,15);
		wait10.until(ExpectedConditions.visibilityOf(element10));
		lp.verifyURLhas(homepage);
						
		hp.clickWelcome();
		hp.clickLogout();
		
		lp.setUserName(UN);
		lp.setPassword(PW);
		lp.clickLogin();
		
		WebElement element = driver.findElement(By.id("welcome"));
		WebDriverWait wait = new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		lp.verifyURLhas(homepage);
		hp.clickAdmin();
				
		WebElement element12 = driver.findElement(By.id("btnAdd"));
		WebDriverWait wait12 = new WebDriverWait(driver,15);
		wait12.until(ExpectedConditions.visibilityOf(element12));	
				
		sup.clickUserCheckBox("user7");
		sup.clickDeleteButton();
		sup.clickDialogDeleteButton();
		sup.verifyUserNotPresentinTable("user7");
		
		hp.clickPIM();
				
		WebElement element13 = driver.findElement(By.id("menu_pim_viewEmployeeList"));
		WebDriverWait wait13 = new WebDriverWait(driver,15);
		wait13.until(ExpectedConditions.visibilityOf(element13));
		
		eip.clickEmployeeCheckBox(fn);
		eip.clickDeleteButton();
		eip.clickDialogDeleteButton();	
		eip.verifyEmployeeNotPresentinTable(fn);		
	}
}