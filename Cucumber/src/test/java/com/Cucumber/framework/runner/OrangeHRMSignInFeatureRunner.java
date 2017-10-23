package com.Cucumber.framework.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = {"classpath:featurefile/OrangeHRMSignIn.feature"}, glue = {
		"classpath:com.Cucumber.framework.stepdefination",
		"classpath:com.Cucumber.framework.helper"}, plugin = { "pretty",
		"json:target/OrangeHRMSignInFeatureRunner.json"})
public class OrangeHRMSignInFeatureRunner extends AbstractTestNGCucumberTests{
	
	
}
