package com.Cucumber.framework.stepdefination;

import org.openqa.selenium.By;
import org.testng.Assert;

import com.Cucumber.framework.helper.TestBase.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginToOrangeHRM {

	
	@Given("^User navigate to the OrangeHRM\\.COM$")
	public void user_navigate_to_the_OrangeHRM_COM() throws Throwable {
	    TestBase.driver.get("https://orangehrm-demo-6x.orangehrmlive.com/");
	}

	@When("^User enters username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void user_enters_username_as_and_password_as(String arg1, String arg2) throws Throwable {
	    TestBase.driver.findElement(By.id("txtUsername")).sendKeys(arg1);
	    TestBase.driver.findElement(By.id("txtPassword")).sendKeys(arg2);
	}

	@When("^User click on login button$")
	public void user_click_on_login_button() throws Throwable {
	   TestBase.driver.findElement(By.id("btnLogin")).click();
	}

	@Then("^login should be successful$")
	public void login_should_be_successful() throws Throwable {
	  boolean visible =  TestBase.driver.findElement(By.xpath(".//*[@id='primary-header']/div/nav/div/ul[1]/li[2]/span[1]")).isDisplayed();
	  Assert.assertEquals(visible, 1);
	}

	@Then("^login should not be successful$")
	public void login_should_not_be_successful() throws Throwable {
		boolean visible =  TestBase.driver.findElement(By.id("btnLogin")).isDisplayed();
		  Assert.assertEquals(visible, 1);
	}


}
