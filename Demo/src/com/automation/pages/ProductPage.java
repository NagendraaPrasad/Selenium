package com.automation.pages;

import org.openqa.selenium.WebDriver;

import com.automation.elementRepository.PageElements;
import com.automation.frameworkUtilities.ReusableComponents;

public class ProductPage extends ReusableComponents implements PageElements {

	/*
	 * Create constructor
	 */
	public ProductPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	/*
	 * Method - sort by lowest price
	 */
	public void SortFoodByLowestPrice(){
		
		SelectByVisibleText(SortList, "Lowest Price", "Sort by Lowest price");
		
		String strLowestPrice = GetText(LowestPriceProduct, "Lowest price product");
				
		System.out.println("Lowest product pice starts " + strLowestPrice);
		
		CaptureScreenshot("Lowest price product");
		
	}

	/*
	 * Method - sort by highest price
	 */
	public void SortFoodByHighestPrice(){
		
		SelectByVisibleText(SortList, "Highest Price", "Sort by Lowest price");
		
		String strHighestPrice = GetText(HighestPriceProduct, "Lowest price product");
		
		System.out.println("Highest product price " + strHighestPrice);
		
		CaptureScreenshot("Highest product price");
	}
}
