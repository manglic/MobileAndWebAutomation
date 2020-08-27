package com.babbel.testautomation.pageobjects.web;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * HomPage Class contains web elements available on landing page and their corresponding actions.
 * @author AMC
 * 
 */
public class HomePage extends BasePage {
	
	static Logger log = Logger.getLogger(HomePage.class.getName());

	/**
	 * Parameterized Constructor for initializing HomePage class object 
	 * @param webDriver : reference of WebDriver class
	 */
	public HomePage(WebDriver webDriver) {		
		super(webDriver);
		log.debug("In HomePage class contructor");
	}
	
	/** Variables to identify Web Elements On Home Page UI**/
	@FindBy(name = "q")
	private WebElement searchInputBox;
	
	@FindBy(name = "btnK")
	private WebElement searchButton;
	
	
	/** Functions/Actions that could be performed on Web Elements **/

	/*
	 * Function enter string in search box
	 * @Param - searchText : string to be searched
	 */
	public void enterSearchText(String searchText) {
		searchInputBox.sendKeys(searchText);
	}
	
	/*
	 * Function clicks on search button
	 */
	public void clickSearchButton() {
		searchButton.click();
	}
	
	/*
	 * Function search for particular string
	 * @Param - searchText : string to be searched
	 */
	public ResultPage performSearch(String searchText) {
		enterSearchText(searchText);
		clickSearchButton();
		return new ResultPage(webDriver);
	}
	
}
