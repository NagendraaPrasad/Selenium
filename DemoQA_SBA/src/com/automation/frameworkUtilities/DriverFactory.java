package com.automation.frameworkUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {
	
	public WebDriver driver;
	String userdirectory = System.getProperty("user.dir");
	String chromedriverpath = userdirectory + "\\resources\\BrowserDrivers\\chromedriver.exe";
	String iedriverpath = userdirectory + "\\resources\\BrowserDrivers\\IEDriverServer.exe";
	
	public void initializeDriver(String browserName){
		switch (browserName.toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", chromedriverpath);
			driver = new ChromeDriver();
			break;
		case "internetexplorer":
			System.setProperty("webdriver.ie.driver", iedriverpath);
			driver = new InternetExplorerDriver();
			break;
		case "firefox":
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Browser not found");
		}
	}
	
	public WebDriver getDriver(){
		return driver;
		
	}
	
	public void quitDriver(){
		driver.quit();
	}

}
