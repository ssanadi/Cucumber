Feature: Login to OrangeHRM
Keywords Summary : This test will verify login related scenarios to facebook.com

Scenario: Login with valid credentials 
Given User navigate to the OrangeHRM.COM
When User enters username as "admin" and password as "admin"
And User click on login button
Then login should be successful


Scenario: Login with Invalid credentials 
Given User navigate to the OrangeHRM.COM
When User enters username as "admin" and password as "admin11"
And User click on login button
Then login should not be successful