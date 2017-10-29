package com.Cucumber.framework.helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.Cucumber.framework.configreader.ObjectRepo;
import com.Cucumber.framework.configreader.PropertyFileReader;
import com.Cucumber.framework.helper.TestBase.TestBase;

public class AlertHelper {
	
	private WebDriver driver;
	private Logger log = LoggerHelper.getLogger(AlertHelper.class);
	
	public AlertHelper(WebDriver driver){
		this.driver=driver;
		log.info(driver);
	}
	
	public Alert getAlert(){
		log.debug("");
		return driver.switchTo().alert();
	}
	
	public void accceptAlert(){
		log.info("");
		getAlert().accept();
	}
	
	public void declineAlert(){
		log.info("");
		getAlert().dismiss();
	}
	
	public String getAlertText(){
		String text = getAlert().getText();
		log.info(text);
		return text;
	}
	
	public boolean isAlertPresent(){
		try{
			getAlert();
			log.info("true");
			return true;
			
		}catch(NoAlertPresentException e){
			log.error("false");
			return false;
		}
	}
	
	public void acceptAlertIfPresent(){
		if(!isAlertPresent()) return;
		accceptAlert();
		log.info("");
	}
	
	public void dismissAlertIfPresent(){
		if(!isAlertPresent()) return;
		declineAlert();
		log.info("");
	}

	public void acceptPrompt(String text){
		if(!isAlertPresent())return;
		
		Alert alt = getAlert();
		alt.sendKeys(text);
		alt.accept();
		log.info(text);
	}
	
}
