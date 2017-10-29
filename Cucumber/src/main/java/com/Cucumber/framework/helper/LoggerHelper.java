package com.Cucumber.framework.helper;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

@SuppressWarnings("rawtypes")
public class LoggerHelper {
	
	private static boolean root = false;
	public static Logger getLogger(Class cls)
	{			
		if (root)
		{
			return Logger.getLogger(cls);
		}
		PropertyConfigurator.configure(ResourceHelper.getResourcePath("configfile/log4j.properties"));
		root = true;
		return Logger.getLogger(cls);
	
	}

	/*public static void main(String a[]) throws Exception
	{
		Logger log;
		System.out.println(ResourceHelper.getBaseResourcePath());
		System.out.println(ResourceHelper.getResourcePath("configfile/log4j.properties"));
		
	}*/
}
