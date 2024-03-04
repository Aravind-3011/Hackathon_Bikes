Feature: Zig Wheels

Scenario: upcoming bikes
Given to launch the website zigwheels
When hover to new bikes 
Then click upcoming bikes
When click on manufacturers 
Then click on honda
And click see more
And get details of all bikes less than 4 lakhs

Scenario: Used Cars
Given user to navigate homepage
When hover to used cars 
Then click chennai and view results
And get all the popular car models

Scenario: Invalid user
Given user to navigate to home page
When clicks login
Then clicks google
When user enters the invalid mailId
Then shows a error message and take screenshot


