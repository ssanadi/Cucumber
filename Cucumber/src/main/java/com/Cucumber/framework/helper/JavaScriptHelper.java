package com.Cucumber.framework.helper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.Cucumber.framework.configreader.ObjectRepo;
import com.Cucumber.framework.configreader.PropertyFileReader;
import com.Cucumber.framework.helper.TestBase.TestBase;

public class JavaScriptHelper{
	
	private WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(JavaScriptHelper.class);
	
	public JavaScriptHelper(WebDriver driver)
	{
		this.driver=driver;
		log.info("JavaScriptHelper Class " +this.driver);
	}
	
	
		
	public Object executeScript(String script){
		
	JavascriptExecutor exe= (JavascriptExecutor)driver;
	log.info(script);
	return exe.executeScript(script);
	}
	
	public Object executeScript(String script, Object... args)
	{
		
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		log.info(script);
		return exe.executeScript(script, args);
		
	}
	
	public void scrollToElement(WebElement element)
	{
		executeScript("window.scrollTo(argument[0],argument[1]", element.getLocation().x,element.getLocation().y);
		log.info("Scrolling to -"+element);
	}
	
	public void scrollToElementAndClick(WebElement element){
		scrollToElement(element);
		element.click();
		log.info("clicking - "+element);
		
	}
	
	public void scrollToView(WebElement element)
	{
		executeScript("argument[0].scrollIntoView()", element);
		log.info("scrolling to view -" +element);
	}
	
	public void scrollToViewAndClick(WebElement element){
		scrollToElement(element);
		element.click();
		log.info("clicking on - "+element);
	}
	
	public void scrollDownVertically(){
		executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void scrollUpVertically(){
		 executeScript("window.scrollTo(0, -document.body.scrollHeight)");
	}
	
	public void zoomInAndOutByPercentage(String zoomPercentage){
		executeScript("document.body.style.zoom='"+zoomPercentage+"%'");
	}
	
	public void safeJavaScriptClick(WebElement element)
	{
		executeScript("arguments[0].click();", element);
		log.info("clicking on - "+element);
	}
	/*@SuppressWarnings({ "static-access", "unused" })
	public static void main(String[] args) throws Exception {
		//WebDriver driver = null ;
		
		
		//TestBase b = new TestBase();
		jSObject.abc();
	}
	*/
	
	/*public void abc(){
		try {
			ObjectRepo.reader = new PropertyFileReader();
			testBaseObject.setUpDriver(ObjectRepo.reader.getBrowser());
			testBaseObject.driver.get("http://amazon.com");
			//JavaScriptHelper js = new JavaScriptHelper(b.driver);
			testBaseObject.driver.findElement(By.id("twotabsearchtextbox")).sendKeys("abc");
			WebElement go = testBaseObject.driver.findElement(By.id("nav-search-submit-text"));
			//JavaScriptHelper js1 = new JavaScriptHelper(b.driver);
			jSObject.safeJavaScriptClick(go);
			jSObject.scrollDownVertically();
			jSObject.scrollUpVertically();
			jSObject.zoomInAndOutByPercentage("50");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/
	}
}
