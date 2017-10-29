package com.Cucumber.framework.helper;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
	
		
	public static void main(String[] args) throws Exception {
		//WebDriver driver = null ;
		
		
		TestBase b = new TestBase();
		ObjectRepo.reader = new PropertyFileReader();
		b.setUpDriver(ObjectRepo.reader.getBrowser());
		b.driver.get("http://amazon.com");
		JavaScriptHelper js = new JavaScriptHelper(b.driver);
		b.driver.findElement(By.id("twotabsearchtextbox")).sendKeys("abc");
		WebElement go = b.driver.findElement(By.id("nav-search-submit-text"));
		System.out.println( go.getSize());
		//AssertionHelper as = new AssertionHelper();
		System.out.println(getPageTitle());
		System.out.println(verifyPageTitle("Amazon.com: Online"));
	
	}
}
