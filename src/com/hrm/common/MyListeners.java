package com.hrm.common;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import generics.Excel;
import generics.Utility;

public class MyListeners implements ITestListener{
	
	public WebDriver driver;
	public static int passCount=0;
	public static int failCount=0;
	public static int skipCount=0;

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		try
		{
			Utility.getDeskTopScreenshot(AutomationConstants.SCREEN_PATH);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
				
		String name = result.getName();
		Excel.setCellValue(name, "FAIL", Utility.getFormatedDateTime(), BaseTest.browserName);
		failCount++;		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getName();
		Excel.setCellValue(name, "SKIP", Utility.getFormatedDateTime(), BaseTest.browserName);
		skipCount++;		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getName();
		Excel.setCellValue(name, "PASS", Utility.getFormatedDateTime(), BaseTest.browserName);
		passCount++;		
	}
	
	@Override
	public void onFinish(ITestContext arg0) {
		Reporter.log("PassCount:"+passCount, true);
		Reporter.log("FailCount:"+failCount, true);
		Reporter.log("SkipCount:"+skipCount, true);		
	}
}