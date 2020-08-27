package com.babbel.testautomation.pageobjects.web;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * HomPage Class contains web elements available on result page and their corresponding actions.
 * @author AMC
 * 
 */
public class ResultPage extends BasePage {
	
	static Logger log = Logger.getLogger(ResultPage.class.getName());

	/**
	 * Parameterized Constructor for initializing ResultPage class object 
	 * @param webDriver : reference of WebDriver class
	 */
	public ResultPage(WebDriver webDriver) {		
		super(webDriver);
		log.debug("In ResultPage class contructor");
	}
	
	/** Variables to identify Web Elements On Result Page UI**/
	@FindBy(xpath = "//h3[contains(text(),'Babbel.com: Language for Life')]")
	private WebElement babbelPortal;
	
	
	/** Functions/Actions that could be performed on Web Elements **/
	
	/*
	 * Function verifies for Babbel result presence on result page
	 */
	public boolean verifyBabbelPortal() {
		return babbelPortal.isDisplayed();
	}
	
	/*
	 * Function clicks on Babbel result link on result page
	 */
	public void clickBabelPortal() {
		babbelPortal.click();
	}
	
	/*
	 * Function returns the page title
	 */
	public String getPageTitle() {
		return webDriver.getTitle();
	}
	
}
