package com.Cucumber.framework.browserConfiguration;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class HtmlUnitBrowser {

	public Capabilities getHtmlUnitDriverCapabilities()
	{
		DesiredCapabilities cap = DesiredCapabilities.htmlUnit();
		return cap;
	}
	
	public WebDriver getHtlmUnitDriver(Capabilities cap)
	{
		return new HtmlUnitDriver(cap);
	}
}
