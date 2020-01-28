Feature: Login Functionality 
@data-driven 
Scenario: Login with valid credentials 
	Given Navigate to Home Page 
	When user enters username and password 
	Then user logged in sucessfully 
@data-driven 
Scenario: 
	The one where user picks different product through search functionality 
	When Larry searches below products in the search box: 
		|Head|
		|Travel|
		|Laptop|
	Then product should be added in the cart if available
	
Scenario Outline: Login with valid credentials 
	Given Navigate to Home Page 
	When user enters "<username>" and "<password>" 
	Then user logged in sucessfully 
	Examples:
	| username   | password       |
	| lalitha    |Password123     |
	| ABC        | XYZ            |