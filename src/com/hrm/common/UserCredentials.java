package com.hrm.common;

import org.testng.annotations.DataProvider;
import generics.Excel;

public class UserCredentials {
	
	@DataProvider
	
	public static String[][] getData()
	{
		String[][] data = new String[2][2];
		data[0][0] = Excel.getCellValue(AutomationConstants.INPUT_FILE, "MultipleLogin", 1, 0);
		data[0][1] = Excel.getCellValue(AutomationConstants.INPUT_FILE, "MultipleLogin", 1, 1);
		data[1][0] = Excel.getCellValue(AutomationConstants.INPUT_FILE, "MultipleLogin", 2, 0);
		data[1][1] = Excel.getCellValue(AutomationConstants.INPUT_FILE, "MultipleLogin", 2, 1);
				
		return data;		
	}	
}