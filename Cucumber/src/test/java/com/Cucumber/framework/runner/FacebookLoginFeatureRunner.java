package com.Cucumber.framework.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"classpath:featurefile/FacebookLogin.feature"})
public class FacebookLoginFeatureRunner extends AbstractTestNGCucumberTests{
	
	
}
