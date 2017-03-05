package com.hrm.scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import com.hrm.common.BaseTest;
import com.hrm.common.HomePage;
import com.hrm.pages.AddEmployeePage;
import com.hrm.pages.EmployeeInformationPage;

import generics.Excel;

public class VerifyAddDeleteEmployee extends BaseTest {
	
	@Test(priority=3)
	
	public void testAddDeleteEmployee()
	{
		String fn = Excel.getCellValue(INPUT_FILE, "AddEmployee", 2, 0);
		String ln = Excel.getCellValue(INPUT_FILE, "AddEmployee", 2, 1);
		
		WebElement element1 = driver.findElement(By.id("welcome"));
		WebDriverWait wait1 = new WebDriverWait(driver,15);
		wait1.until(ExpectedConditions.visibilityOf(element1));
		
		HomePage hp = new HomePage(driver);
		hp.clickPIM();
		hp.clickaddEmployee();
		
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
		eip.clickEmployeeCheckBox(fn);
		eip.clickDeleteButton();
		eip.clickDialogDeleteButton();	
		eip.verifyEmployeeNotPresentinTable(fn);
	}
}