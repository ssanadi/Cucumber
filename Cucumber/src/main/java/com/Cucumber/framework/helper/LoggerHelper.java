package com.Cucumber.framework.helper;

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

	/*public static void main(String a[])
	{
		Logger log;
		System.out.println(log = LoggerHelpergetLogger(LoggerHelper.class));
		 log.info(ObjectRepo.reader.getBrowser());
		
	}*/
}
