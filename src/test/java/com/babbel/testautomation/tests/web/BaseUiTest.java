package com.babbel.testautomation.tests.web;

import org.testng.annotations.BeforeClass;

import com.babbel.testautomation.framework.WebDriverSetup;
import com.babbel.testautomation.util.PropertiesUtil;

import org.testng.annotations.AfterClass;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


/**
 * Class WebDriverStep class to initiate WebDriver object based on browse value
 * @author AMC
 *
 */
public class BaseUiTest {
	
	static Logger log = Logger.getLogger(BaseUiTest.class.getName());
	
	public WebDriver webDriver;
	
	/**
	 * Functions initializes WebDriver object based on browser value
	 * @param browserType - browser on which tests are to be executed
	 * @param url - Environment / URL of website on which tests are to be performed
	 * Both the parameter are read from TestData.properties file
	 */
	@BeforeClass
	public void initializeTestBaseSetup() {
			PropertiesUtil pUtil = new PropertiesUtil();
			webDriver = WebDriverSetup.getWebDriver(pUtil.getProperty("browserType"), pUtil.getProperty("url"));
	}
	
	
	/**
	 * return WebDriver reference
	 * @return
	 */
	public WebDriver getDriver() {
		return webDriver;
	}

	
	/**
	 * Tear Down method to close and quit webdriver browser and session.
	 * It is executed at end of test
	 */
	@AfterClass
	public void tearDown() {
		log.debug("Clocing WebDriver");
		webDriver.quit();
	}

}