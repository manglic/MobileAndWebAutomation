package com.babbel.testautomation.pageobjects.mobile;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * @author AMC
 *Class define all the elements on Home page
 */
public class HomePage extends AbstractPage {
	
	public HomePage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	/*
	 * Page Elements
	 */	
	@AndroidFindBy(id = "Picture of a house")
	public WebElement housePicture;
	
	
	/*
	 * Functions associated with Login Page elements
	 */
	public boolean verifyHouseImage() {
		return housePicture.isDisplayed();
	}
}
