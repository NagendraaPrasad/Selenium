package com.automation.frameworkUtilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class ReusableComponents {

	
	private WebDriver driver;
/*
 * create constructor
 */
	public ReusableComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	/*
	 * Enter text method
	 */
	public void EnterText(By objId, String value, String desc){
		WebElement element = driver.findElement(objId);
		element.clear();
		element.sendKeys(value);
		Reporter.log("value entered in "+ desc);
	}
	
	/*
	 * Get text method
	 */
	public String GetText(By objId, String desc){
		WebElement element = driver.findElement(objId);
		String value = element.getText();
		Reporter.log("value entered in "+ desc);
		return value;
	}
	
	/*
	 * Select the value from list field
	 */
	public void SelectByVisibleText(By objId, String value, String desc){
		Select sel = new Select(driver.findElement(objId));
		sel.selectByVisibleText(value);
		Reporter.log("value entered in "+ desc);
	}
	
	/*
	 * click element method
	 */
	public void ClickElement(By objId, String desc){
		WebElement element = driver.findElement(objId);
		element.click();
		Reporter.log(desc+" is clicked");
	}
	
	/*
	 * capture screenshot method
	 */
	public void CaptureScreenshot(String desc){
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		
	}
	
	/*
	 * Wait method
	 */
	public void hardDelay(){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * explicit wait method
	 */
	public void ExplicitWait(By objId){
	WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement element = wait.until(ExpectedConditions.elementToBeClickable(objId));
	
	}
}
