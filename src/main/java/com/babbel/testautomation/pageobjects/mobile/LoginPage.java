package com.babbel.testautomation.pageobjects.mobile;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * @author AMC
 *Class define all the elements on Login page
 */
public class LoginPage extends AbstractPage {
	
	public LoginPage(AppiumDriver<MobileElement> driver) {
		super(driver);
	}

	/*
	 * Page Elements
	 */	
	@AndroidFindBy(id = "com.github.fgoncalves.qa:id/email")
	public WebElement emailTextField;
	
	@AndroidFindBy(id = "com.github.fgoncalves.qa:id/password")
	public WebElement passwordTextField;
	
	@AndroidFindBy(id = "com.github.fgoncalves.qa:id/email_sign_in_button")
	public WebElement loginButton;

	@AndroidFindBy(uiAutomator = "new UiSelector().textContains(\"QA\")")
	public WebElement qaLabel;
	
	
	/*
	 * Functions associated with Login Page elements
	 */
	
	/*
	 * @verifyQaLabel verifies the presence of QA label on Login Page
	 */
	public boolean verifyQaLabel() {
		return qaLabel.isDisplayed();
	}
	
	/*
	 * @setUsername enters username string in username text box.
	 */
	public void setUsername(String username) {
		emailTextField.sendKeys(username);
	}
	
	/*
	 * @setPassword enters password string in password text box.
	 */
	public void setPassword(String password) {
		passwordTextField.sendKeys(password);
	}

	/*
	 * @clickLoginButton function clicks on login button
	 */
	public void clickLoginButton() {
		loginButton.click();
	}
	
	/*
	 *@login function perform all the activities required to login into app and returns HomePage object 
	 */
	public HomePage login(String username, String password) {
		setUsername(username);
		setPassword(password);
		clickLoginButton();
		return new HomePage(driver);
	}
}
