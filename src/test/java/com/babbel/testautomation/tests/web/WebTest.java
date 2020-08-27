package com.babbel.testautomation.tests.web;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.babbel.testautomation.pageobjects.web.HomePage;
import com.babbel.testautomation.pageobjects.web.ResultPage;
import com.babbel.testautomation.util.PropertiesUtil;


/**
 * Test Class Perform 2 basic tests:-
 * 1. Search on Goolge home Page for 'Babbel' and verify search result.
 * 2. Click on 'Babbel' search result and verify web portal is opened with correct page title of Babbel.
 * @author AMC
 *
 */
public class WebTest extends BaseUiTest{
	
	/** Page class references**/
	HomePage homePage;
	ResultPage resultPage;

	PropertiesUtil propUtil;   
	
	/**
	 * Test Method 1
	 */
	@Test(priority=1)
	public void SearchBabbelTest(Method method) {
		propUtil = new PropertiesUtil();
		homePage = new HomePage(webDriver);
		resultPage = homePage.performSearch(propUtil.getProperty("searchTerm"));
		Assert.assertTrue(resultPage.verifyBabbelPortal());
	}
	
	/**
	 * Test Method 2
	 */
	@Test(priority=2)
	public void navigateToBabbelPortal(Method method) {
		resultPage.clickBabelPortal();
		Assert.assertEquals(resultPage.getPageTitle(), propUtil.getProperty("babbelPageTitle"));
	}
}