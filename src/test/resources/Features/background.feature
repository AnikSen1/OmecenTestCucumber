
Feature: Login test in the background

Background:
Given app is open
When user enter userName and Password
Then click on submit button


Scenario: As a user I want to see New Invoice page
When user click on invoice page
Then user validate the invoice title
And user close the app


Scenario: As a user I want to see Payments  page
When user click on payement page
Then user validate payment title
And user close the app


Scenario: As a user I want to see Receipts  page
When user click on purches page
Then user validate the purches title
And user close the app
