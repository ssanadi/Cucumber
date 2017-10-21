package com.Cucumber.framework.helper.TestBase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import com.Cucumber.framework.browserConfiguration.BrowserType;
import com.Cucumber.framework.browserConfiguration.ChromeBrowser;
import com.Cucumber.framework.browserConfiguration.FirefoxBrowser;
import com.Cucumber.framework.browserConfiguration.HtmlUnitBrowser;
import com.Cucumber.framework.browserConfiguration.IExplorerBrowser;
import com.Cucumber.framework.configreader.ObjectRepo;
import com.Cucumber.framework.configreader.PropertyFileReader;

import cucumber.api.java.Before;

public class TestBase {
	
	public static WebDriver driver;
	
	
	public WebDriver getBrowserObject(BrowserType bType) throws Exception
	{
		
		//log
		try {
			switch (bType) {
			case Chrome:
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				return chrome.getChromeDriver(chrome.getChromeCapabilities());
			
			case Firefox:
				FirefoxBrowser firefox = FirefoxBrowser.class.newInstance();
				return firefox.getFirefoxDriver(firefox.getFirefoxCapabilities());
				
			case Iexplorer:
				IExplorerBrowser iExplorer = IExplorerBrowser.class.newInstance();
				return iExplorer.getIExplorerDriver(iExplorer.getIExplorerCapabilities());
				
			case HtmlUnitDriver:
				HtmlUnitBrowser htmlUnit =HtmlUnitBrowser.class.newInstance();
				return htmlUnit.getHtlmUnitDriver(htmlUnit.getHtmlUnitDriverCapabilities());
				
			default:
				throw new Exception("Driver NOT found : "+ new PropertyFileReader().getBrowser());
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// log.
			throw e;
		}
		
	}

	
	public void setUpDriver(BrowserType bType) throws Exception
	{
		
		driver = getBrowserObject(bType);
		//log
		driver.manage().timeouts().pageLoadTimeout(ObjectRepo.reader.getPageLoadTimeOut(), TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(ObjectRepo.reader.getImplicitWait(), TimeUnit.SECONDS);
		driver.manage().window().maximize();		
	}
	
	@Before
	public void before() throws Exception 
	{
		ObjectRepo.reader = new PropertyFileReader();
		System.out.println(ObjectRepo.reader.getBrowser());
		setUpDriver(ObjectRepo.reader.getBrowser());
		driver.get(ObjectRepo.reader.getWebsite());
	}
	
	
	/*public static void main(String a[])
	{
		TestBase t = new TestBase();
		try {
			t.before();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
}
