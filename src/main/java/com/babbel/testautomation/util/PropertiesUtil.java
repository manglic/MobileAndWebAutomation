package com.babbel.testautomation.util;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author AMC
 *Utility class to load default and specified properties file.
 */
public class PropertiesUtil {
	
	private Properties prop =  null;
	
	
	/**
	 *Default constructor 
	 */
	public PropertiesUtil() {
		prop  = new Properties();
		loadTestProperties();
	}
	
	
	/**
	 * Parameterized constructor to load specified file
	 * @param filePath : Path of file to be loaded
	 */
	public PropertiesUtil(String filePath) {
		prop =  new Properties();
		loadPropertiesFile(filePath);
	}
	
	
	public void loadPropertiesFile(String filePath){
		 try {
			 prop.load(new FileInputStream(filePath));
	        }
	        catch(Exception e) {
	        	System.out.println("Exception generated while reading properties file => "+filePath);
	        }
	}
	
	
	/**
	 *Function loads testData file  
	 */
	public void loadTestProperties() {
		try {
			 prop.load(new FileInputStream(new File("src"+File.separator+"test"+File.separator+"resources"+File.separator+"TestData.properties")));
			 System.out.println("loaded default properties file");
	        }
	        catch(Exception e) {
	        	System.out.println("Exception generated while reading properties file => TestData.properties");
	        }
	}
	

	public String getProperty(String key) {
		return prop.getProperty(key);
	}
}
