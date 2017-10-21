package com.Cucumber.framework.configreader;

import java.util.Properties;

import com.Cucumber.framework.browserConfiguration.BrowserType;
import com.Cucumber.framework.helper.ResourceHelper;


public class PropertyFileReader implements ConfigReader {

	Properties prop = null;
	
	public PropertyFileReader()
	{
		prop = new Properties();
		try {
			prop.load(ResourceHelper.getResourcePathInputStream("configfile/config.properties"));
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
	
	public BrowserType getBrowser() {
		return BrowserType.valueOf(prop.getProperty("Browser"));
	}
	
	/*	public static void main(String arg[])
		{
			ObjectRepo.reader =new PropertyFileReader();
			System.out.println(ObjectRepo.reader.getBrowser());
		}*/
}
