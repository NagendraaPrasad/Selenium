package com.automation.elementRepository;

import org.openqa.selenium.By;

public interface PageElements {

	//By DOGS_LINK = By.linkText("dog_supplies.html");
	By DOGS_LINK = By.xpath("//span[@id='dogs']");
	By Food_Link = By.linkText("Dog_Food-DGFD-ct.html");
	By Searchtextbox = By.id("ctl00_Search_SearchTextMainControl");
	By Searchbutton = By.className("searchbutton");
	By SortList = By.id("ctl00__pageBody_ddlSortItemsSLI");
	By LowestPriceProduct = By.id("ctl00__pageBody_rptGridViewRowsSLI_ctl00_rptGridViewCellsSLI_ctl00_lblPrice");
	By HighestPriceProduct = By.id("ctl00__pageBody_rptGridViewRowsSLI_ctl00_rptGridViewCellsSLI_ctl00_lblPrice");
	
	
}
