package com.Cucumber.framework.helper;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.Cucumber.framework.configreader.ObjectRepo;
import com.Cucumber.framework.configreader.PropertyFileReader;
import com.Cucumber.framework.helper.TestBase.TestBase;

public class AssertionHelper extends TestBase{
	
	private static final Logger log = LoggerHelper.getLogger(AssertionHelper.class);
	
	public static String getPageTitle(){
		return driver.getTitle();
	}
	
	public static synchronized boolean verifyPageTitle(String expectedTitle){
		String actualTitle = getPageTitle();
		//boolean isEquals = false;
		if(actualTitle.equals(expectedTitle)){
			log.info("actual Title - "+actualTitle);
			return true;
		}else{
			log.error(expectedTitle+" Title not matched with actual title "+actualTitle);
			return false;
		}
				
	}
	
	public static synchronized boolean verifyElementIsPresent(WebElement element){
		boolean isDisplay = false;
		try {
			isDisplay = element.isDisplayed();
			log.info(element+" is "+isDisplay);
		} catch (Exception e) {
			log.error("WebElement is not found "+e);
		}
		return isDisplay;
	}
	
	public static synchronized boolean verifyElementisNotPresent(WebElement element){
		boolean isDisplay = false;
		try {
			element.isDisplayed();
					
		} catch (Exception e) {
			log.info(element+" is not present");
			isDisplay = true;
		}
		return isDisplay;
	}
	
	public static synchronized boolean verifyElementTextEquals(WebElement element, String expectedText){
		boolean flag = false;
		
		try {
			String text = element.getText();
			if(text.equals(expectedText)){
				log.info(expectedText +" is equlas to actual text "+text);
				return flag=true;
			}else{
				log.error(expectedText +" is NOT equlas to actual text "+text);
				return flag;
			}
			
		} catch (NoSuchElementException e) {
			log.error("Element not found "+ e);
			return flag;
		}
		
		
	}
		
	public static synchronized boolean verifyElementPartialTextEquals(WebElement element, String expectedText){
		boolean flag = false;
		
		try {
			String text = element.getText();
			if(text.contains(expectedText)){
				log.info(expectedText +" this partial content is present in actual text "+text);
				return flag=true;
			}else{
				log.error(expectedText +" this partial content NOT present in actual text "+text);
				return flag;
			}
			
		} catch (NoSuchElementException e) {
			log.error("Element not found "+ e);
			return flag;
		}
		
		
	}
	
	
}
