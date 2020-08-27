package com.babbel.testautomation.tests.mobile;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.babbel.testautomation.framework.AppiumDriverSetup;
import com.babbel.testautomation.pageobjects.mobile.HomePage;
import com.babbel.testautomation.pageobjects.mobile.LoginPage;
import com.babbel.testautomation.util.PropertiesUtil;

/**
 * Test Class Perform 2 basic tests:-
 * 1. Verify Login is failed with wrong credentials.
 * 2. Verify successful login with correct credentials.
 * @author AMC
 *
 */
public class MobileTests {
	
	/** Page class references**/
	AppiumDriverSetup driver;
	LoginPage loginPage;
	HomePage homePage;
	
	PropertiesUtil propUtil;
	
	/*
	 * Setup function- created driver object
	 */
	@BeforeClass
	public void setup() {
		System.out.println("In Test Before Class");
		propUtil =  new PropertiesUtil();
		driver = new AppiumDriverSetup();
	}
	
	
	/**
	 * Test Method 1
	 */
	@Test(priority=1)
	public void negativeLoginTest() {
		LoginPage loginPage = new LoginPage(driver.mobileDriver);
		homePage = loginPage.login(propUtil.getProperty("mobileLoginUsername"), "");
		Assert.assertFalse(homePage.verifyHouseImage());		
	}
	
	/**
	 * Test Method 2
	 */
	@Test(priority=2)
	public void positiveLoginTest() {
		LoginPage loginPage = new LoginPage(driver.mobileDriver);
		homePage = loginPage.login(propUtil.getProperty("mobileLoginUsername"), propUtil.getProperty("mobileLoginPassword"));
		Assert.assertTrue(homePage.verifyHouseImage());		
	}

}
