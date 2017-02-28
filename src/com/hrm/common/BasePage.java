package com.hrm.common;

import java.util.List;
import java.util.Set;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import generics.Property;

public class BasePage {
	
	public Logger log = Logger.getLogger(this.getClass());
	public WebDriver driver;
	public String configFile;
	public long timeout;
	
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		configFile = AutomationConstants.CONFIG_FILE;
		timeout = Long.parseLong(Property.getPropertyValue(configFile, "EXPLICIT"));		
	}
	
	public void waitForElementPresent(WebElement element)
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOf(element));		
	}
	
	public void verifyURLis(String eURL)
	{
		new WebDriverWait(driver, timeout).until(ExpectedConditions.urlToBe(eURL));
	}
	
	public void verifyURLhas(String eURL)
	{
		new WebDriverWait(driver,timeout).until(ExpectedConditions.urlContains(eURL));
	}
	
	public void verifyBrowserPresent(String eTitle)
	{
		boolean found=false;
		String parent = driver.getWindowHandle();
		
		log.info("Parent Browser is:"+driver.getTitle());
		
		try
		{
			Set<String> allWh = driver.getWindowHandles();
			
			for(String wh:allWh)
			{
				driver.switchTo().window(wh);
				
				String aTitle=driver.getTitle();
				log.info("Child Browser is:"+aTitle);
				
				if(aTitle.equals(eTitle))
				{
					log.info("Browser Exists:");
					found=true;
					break;					
				}
				
				driver.switchTo().window(parent);
				log.info("Switched to Parent Browser");				
			}		
			
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
		Assert.assertTrue(found, "Browser Does not Exists");		
	}
	
	public void searchListBoxName(WebElement element, String eText)
	{
		boolean found=false;
		
		try
		{
		Select select = new Select(element);
		List<WebElement> allOption = select.getOptions();
		
		for(WebElement option:allOption)
		{
			String aText = option.getText();
			
			if(aText.equals(eText))
			{
				log.info("Name Exists in search List Box");
				found=true;
				break;
			}
		}
		
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		
		Assert.assertTrue(found, "Name does not exists in search List Box");		
	}
}