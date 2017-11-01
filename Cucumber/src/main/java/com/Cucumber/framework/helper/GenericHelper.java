package com.Cucumber.framework.helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericHelper{
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(GenericHelper.class);
	
	public String readValueFromElement(WebElement element){
		if(element == null){
			log.info("webelement is null");
			return null;
		}
		
		try {
			element.isDisplayed();
		} catch (Exception e) {
			log.error(e);
			return null;
		}
		
		String text = element.getText();
		log.info("webElement value is - "+text);
		return text;
		
	}
	
	

}
