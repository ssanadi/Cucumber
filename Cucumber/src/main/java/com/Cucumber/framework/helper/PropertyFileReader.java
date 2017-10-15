package com.Cucumber.framework.helper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.Cucumber.framework.configreader.ResourceHelper;

public class PropertyFileReader {

	Properties prop = null;
	
	public PropertyFileReader(String resource)
	{
		prop = new Properties();
		try {
			prop.load(ResourceHelper.getResourcePathInputStream(resource));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
	public String getUserName()
	{
		return prop.getProperty("Username");
	}
	
	public String getPassword()
	{
		return prop.getProperty("Password");
	}
	
	public String getBrowser()
	{
		return prop.getProperty("Browser");
	}
	public String getWebsite()
	{
		return prop.getProperty("website");
	}
	
	public int getPageLoadTimeOut()
	{
		return Integer.parseInt(prop.getProperty("PageLoadTimeOut"));
	}
	
	public int getImplicitWait()
	{
		return Integer.parseInt(prop.getProperty("ImplicitWait"));
	}
	
	public int getExplicitWait()
	{
		return Integer.parseInt(prop.getProperty("ExplicitWait"));
	}
	
	
	
	
	
}
