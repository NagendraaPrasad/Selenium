package com.automation.pages;

import org.openqa.selenium.WebDriver;

import com.automation.elementRepository.PageElements;
import com.automation.frameworkUtilities.DriverFactory;
import com.automation.frameworkUtilities.ExcelFactory;
import com.automation.frameworkUtilities.ReusableComponents;

public class HomePage extends ReusableComponents implements PageElements{
/*
 * create constructor
 */
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	// create object for ExcelFactory
	ExcelFactory objexcel = new ExcelFactory();
	
	public void SearchFood(){
			
		
		//Provide explicit wait command for search box
		ExplicitWait(Searchtextbox);
		
		//Enter text in search box
		EnterText(Searchtextbox, "Dog food", "Search field" );
		
		//Capture screenshot of the current page
		CaptureScreenshot("Search food");
		
		//click Search button
		ClickElement(Searchbutton, "Search Button");
		
		//Capture screenshot of the current page
		CaptureScreenshot("Product page");
		
	}
	
	
}
