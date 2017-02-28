package com.hrm.common;

public interface AutomationConstants {
	
	public static final String CONFIG_FILE = "./config/config.properties";
	
	public static final String CHROME_KEY = "webdriver.chrome.driver";
	public static final String CHROME_FILE = "./driver/chromedriver.exe";
	
	public static final String FIREFOX_KEY = "webdriver.gecko.driver";
	public static final String FIREFOX_FILE = "./driver/geckodriver.exe";
	
	public static final String INPUT_FILE = "./input/input.xlsx";
		
	public static final String REPORT_PATH = "./report/";
	
	public static final String RESULT_FILE = "./result/result.xlsx";
	public static final String RESULT_SHEET = "Result";
	
	public static final String SCREEN_PATH = "./screenshot/";
	public static final String ABSOLUTE_DESKTOPSCREENSHOT_PATH = "C:\\git\\HumanResourceManagement\\snap\\";
	
	public static String DB_CLASS_NAME = "com.mysql.jdbc.Driver";
	public static String DB_URL = "jdbc:mysql://localhost:3306/bitnami_orangehrm";
	public static String DB_USER = "root";
	public static String DB_PASSWORD = "admin";
	
}

