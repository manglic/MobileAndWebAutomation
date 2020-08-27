package com.babbel.testautomation.framework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

/**
 * @author AMC
 *Class AppiumServer facilitates starting to appium and stopping of server.
 *
 */
public class AppiumServer {

	private AppiumDriverLocalService service;
	private AppiumServiceBuilder builder;
	private DesiredCapabilities cap;

	
	/**
	 * Function startServer starts appium server on ip and port provided.
	 * @param ip 
	 * @param port
	 */
	public void startServer(String ip, int port) {
		// Set Capabilities
		cap = new DesiredCapabilities();
		cap.setCapability("noReset", "false");

		// Build the Appium service
		builder = new AppiumServiceBuilder();
		builder.withIPAddress(ip);
		builder.usingPort(port);
		builder.usingAnyFreePort();
		builder.withCapabilities(cap);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

		// Start the server with the builder
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
		System.out.println("Appium server started @ " + ip + ":" + port);
	}

	
	/**
	 * Function startServer : starts appium server on default ip 0.0.0.0 and port 4723
	 */
	public void startServer() {
		int port = 4723;
		String ip = "0.0.0.0";

		if (!checkIfServerIsRunnning(port)) {
			// Set Capabilities
			cap = new DesiredCapabilities();
			cap.setCapability("noReset", "false");

			// Build the Appium service
			builder = new AppiumServiceBuilder();
			builder.withIPAddress(ip);
			builder.usingPort(port);
			builder.withCapabilities(cap);
			builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
			builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");

			// Start the server with the builder
			service = AppiumDriverLocalService.buildService(builder);
			service.start();
			System.out.println("Appium server started @ " + ip + ":" + port);
		} else {
			System.out.println("Appium server started @ " + ip + ":" + port);
		}
	}

	
	/**
	 * Function stops appium server on the specified port
	 * @param port
	 */
	public void stopServer(int port) {
		if (checkIfServerIsRunnning(port)) {
			service.stop();
			System.out.println("Appium server stopped");
		} else {
			System.out.println("Appium server stopped");
		}
	}
	
	
	/**
	 * Function checks if appium sever is running on stated port
	 * @param port
	 * @return
	 */
	public boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public URL getUrl() {
		return service.getUrl();
	}

}
