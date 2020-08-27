package com.babbel.testautomation.pageobjects.mobile;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author AMC
 *Abstract class use to initiate page factory elements of page object classes.
 */
public abstract class AbstractPage{

	AppiumDriver<MobileElement> driver;


	/**
	 * Constructor initiates page object elements.
	 * @param driver
	 */
	public AbstractPage(AppiumDriver<MobileElement> driver) {
		this.driver =  driver;
		//PageFactory.initElements(new AppiumFieldDecorator(driver, 5, TimeUnit.SECONDS), this);
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	/*
	 * Wait for Element(ele) to be visible on screen for provided seconds(sec)
	 * @ Param: ele- WebElement to wait for, sec - no of seconds to wait for element
	 */
	public void waitForElementVisible(WebElement ele, int sec) {
		try {
			System.out.println("Waiting for Element=> " + ele.toString() + " to be visible...");
			new WebDriverWait(driver, sec).until(ExpectedConditions.visibilityOf(ele));
			System.out.println("Element=> " + ele.toString() + " is visible");
		}
		catch(Exception e) {
			System.out.println("Exception generated while waiting for visibility element =>"+ele.toString());
		}
	}
	

	public void waitForElementInVisible(WebElement ele) {
		try {
			System.out.println("Waiting for Element=> " + ele.toString() + " to be invisible...");
			new WebDriverWait(driver, 5).until(ExpectedConditions.invisibilityOf(ele));
			System.out.println("Element=> " + ele.toString() + " is invisible");
		}
		catch(Exception e){
			System.out.println("Exception generated while waiting for invisibility of element =>"+ele.toString());
		}
	}

}
