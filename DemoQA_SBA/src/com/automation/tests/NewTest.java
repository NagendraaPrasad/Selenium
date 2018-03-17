package com.automation.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

import com.automation.frameworkUtilities.DriverFactory;
import com.automation.frameworkUtilities.ExcelFactory;
import com.automation.pages.HomePage;
import com.automation.pages.ProductPage;

public class NewTest {
	WebDriver driver;
	DriverFactory objDriverFactory = new DriverFactory();
	ExcelFactory objExcelFactory = new ExcelFactory();
	String BrowserName = "chrome";
	String applicationURL = "http://www.petstore.com";
	
/*
 * @Before test - initialize driver and navigate to the application url.
 */
 @BeforeTest
 public void beforeTest() {
	 objDriverFactory.initializeDriver(BrowserName);
	 driver = objDriverFactory.getDriver();
	 //maximize window
	 driver.manage().window().maximize();
	 //provide implicit wait
	 driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	 //navigate to URL
	 driver.get(applicationURL);
	  }	
/*
 * @Test - Executes	the test cases
 */
  @Test
  public void Test() {
	  //Create object for HomePage and call SearchFood() method
	  HomePage objHomePage = new HomePage(driver);
	  objHomePage.SearchFood();
	  
	//Create object for ProductPage and call SortFoodByLowestPrice() method and SortFoodByHighestPrice() method
	  ProductPage objProductPage = new ProductPage(driver);
	  objProductPage.SortFoodByLowestPrice();
	  objProductPage.SortFoodByHighestPrice();
	  	  
  }
 
/*
 * @afterTest - quits the browser driver
 */
  @AfterTest
  public void afterTest() {
	  //quit driver
	  objDriverFactory.quitDriver();
  }

}
