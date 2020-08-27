package com.babbel.testautomation.framework;

import java.io.File;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.babbel.testautomation.util.PropertiesUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

/**
 * @author AMC
 *Class sets desired capabilities for specified platform and initiate mobile driver.
 */
public class AppiumDriverSetup {

	public AppiumDriver<MobileElement> mobileDriver;

	private AppiumServer appiumServer;
	private String appiumServerUrl;
	private int appiumServerPort;
	public String platformName;
	private String platformVersion;
	private String deviceName;
	private String app;
	private PropertiesUtil propUtil;
	
	
	/**
	 * Default constructor
	 */
	public AppiumDriverSetup(){
		propUtil =  new PropertiesUtil();
		try {
			setup();
		}
		catch(Exception e) {
		}
	}
	
	
	/**
	 *Functions reads appium server and mobile properties from properties file.
	 */
	public void setup() {
		appiumServerUrl = propUtil.getProperty("appiumServerUrl");
		appiumServerPort = Integer.parseInt(propUtil.getProperty("appiumPort"));
		platformName = propUtil.getProperty("platformName");
		platformVersion = propUtil.getProperty("platformVersion");
		deviceName = propUtil.getProperty("deviceName");
		try {
			String appPath = new File("src"+File.separator+"test"+File.separator+"resources"+File.separator+""+propUtil.getProperty("app")).toString();
			System.out.println(appPath);
			app = appPath;
		}
		catch(Exception e) {
			System.out.println("Exception while reading apk file. Error->"+e);
		}
		appiumServer = new AppiumServer();
		initMobileDriver();
	}
	
	
	/**
	 * Function set appium capabilities and initiate mobile driver
	 */
	public void initMobileDriver() {
		startAppiumServer();
		try {
			if (platformName.equalsIgnoreCase("android")) {

				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
				cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME ,  "UiAutomator2");
				cap.setCapability(MobileCapabilityType.APP, app);
				cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "4000");
				mobileDriver = new AndroidDriver<MobileElement>(new URL(appiumServer.getUrl().toString()), cap);
				System.out.println("returning android driver");
			}

			else if (platformName.equalsIgnoreCase("ios")) {
				DesiredCapabilities cap = new DesiredCapabilities();
				cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
				cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
				cap.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
				cap.setCapability(MobileCapabilityType.AUTOMATION_NAME ,  "XCUITest");
				cap.setCapability(MobileCapabilityType.APP, app);
				cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "4000");
				mobileDriver = new IOSDriver<MobileElement>(new URL(appiumServer.getUrl().toString()), cap);
				System.out.println("returning iOs driver");
			}
			else {
				System.out.println("Wrong Choice: Enter android for AndroidDriver and ios for IOSDRiver");
			}
			mobileDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			System.out.println("Could not initiate the driver. Exception--> " + e);
		}
	}
	
	
	public void startAppiumServer(){
		appiumServer.startServer(appiumServerUrl, appiumServerPort);
		System.out.println("Appium Server Started");
	}
	
	public void stopAppiumServer() {
		appiumServer.stopServer(appiumServerPort);
		System.out.println("Appium Server Stopped");
	}

}
