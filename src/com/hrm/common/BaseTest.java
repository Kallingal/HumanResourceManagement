package com.hrm.common;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.hrm.pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import generics.Property;
import generics.Utility;
@Listeners(MyListeners.class)
public class BaseTest implements AutomationConstants
{
    public Logger log;
    public WebDriver driver;
    public ExtentTest testReport;
    
    public static String url;
    public static String un;
    public static String pw;
    public static String homepage;
    public static String loginpage;
    public static long timeout;
    public static ExtentReports eReport;
    public static String browserName;
    public static boolean AutoLoginRequired=true;;
    public static boolean AutoLogoutRequired=true;
        
    public BaseTest()
    {
    	log=Logger.getLogger(this.getClass());
    	Logger.getRootLogger().setLevel(org.apache.log4j.Level.INFO);    	
    }
    
    @BeforeSuite
    
    public void initFramework()
    {
    	log.info("Extent Report Initiated");
    	eReport = new ExtentReports(REPORT_PATH+"/"+Utility.getFormatedDateTime()+".html");
    	url=Property.getPropertyValue(CONFIG_FILE, "URL");
    	un=Property.getPropertyValue(CONFIG_FILE, "UN");
    	pw=Property.getPropertyValue(CONFIG_FILE, "PW");
    	homepage=Property.getPropertyValue(CONFIG_FILE, "HOMEPAGE");
    	loginpage=Property.getPropertyValue(CONFIG_FILE, "LOGINPAGE");
    	timeout=Long.parseLong(Property.getPropertyValue(CONFIG_FILE, "IMPLICIT"));    	
    }
    
    @AfterSuite
    
    public void closeFramework()
    {
    	log.info("Extent Report Closed");
    	eReport.flush();
    }
    
    @Parameters({"browser"})
    @BeforeTest
    
    public void initBrowser(@Optional("firefox") String browser)
    {
    	log.info("Execution Started in browser:"+browser);
    	browserName = browser;
    	browserName = browserName.toUpperCase();
    }
    
    @Parameters({"browser"})
    @AfterTest
    
    public void closeBrowser(@Optional("firefox") String browser)
    {
    	log.info("Execution Ended in browser:"+browser);
    }
	
    @Parameters({"browser"})
    @BeforeClass
    
    public void initApplication(@Optional("firefox") String browser)
    {
    	log.info("Application Opened");
    	
    	if(browser.equals("chrome"))
    	{
    		System.setProperty(CHROME_KEY, CHROME_FILE);
    		driver=new ChromeDriver();
    	}
    	else
    	{
    		System.setProperty(FIREFOX_KEY, FIREFOX_FILE);
    		driver=new FirefoxDriver();    		
    	}
    	driver.navigate().to(url);
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
    	
    	}
    
    @AfterClass
    
    public void closeApplication()
    {
    	log.info("Application Closed");
    	driver.quit();
    }
    
	@BeforeMethod()
	
	public void preCondition(Method method) throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException
	{
		testReport = eReport.startTest(method.getName());
		
		if(AutoLoginRequired)
		{
			log.info("Implicit Login");
			driver.navigate().to(url);
			driver.manage().window().maximize();
	    	driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);  
			LoginPage lp = new LoginPage(driver);
			
			WebElement element = driver.findElement(By.id("txtUsername"));
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(element));
			
			lp.setUserName(un);
			lp.setPassword(pw);
			lp.clickLogin();
			lp.verifyURLhas(homepage);			
		}
		else
		{
			log.warn("Explicit Login");
		}
		AutoLoginRequired=true;
		
	}	
	
	@AfterMethod
	
	public void postCondition(ITestResult result) throws SQLException
	{
		if(AutoLogoutRequired)
		{
			log.info("Implicit Logout");
			HomePage hp = new HomePage(driver);
			
			WebElement element = driver.findElement(By.id("welcome"));
			WebDriverWait wait = new WebDriverWait(driver,30);
			wait.until(ExpectedConditions.visibilityOf(element));
			
			hp.clickWelcome();
			hp.clickLogout();
			hp.verifyURLhas(loginpage);			
		}
		else
		{
			log.warn("Explicit Logout");
		}
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String imgFile = Utility.getDeskTopScreenshot(AutomationConstants.ABSOLUTE_DESKTOPSCREENSHOT_PATH);
			testReport.log(LogStatus.FAIL, "Please refer the log for more details");
			testReport.log(LogStatus.FAIL, result.getThrowable());
			testReport.log(LogStatus.FAIL, "Screenshot Below:" +testReport.addScreenCapture(ABSOLUTE_DESKTOPSCREENSHOT_PATH+imgFile));
			
		}
		else
		{
			testReport.log(LogStatus.PASS, "Step Name", "Details");
		}
		
		eReport.endTest(testReport);		    
   }
}	
