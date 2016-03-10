Feature: Launch Project Dashboard
As a User
I need to login to project dashboard application

Scenario: Launch Project Dashboard Home Page
Given Launch Url
When user enter email for User authentication
And user enter Password for User authentication
And user click on SignIn
Then user should be on Project Dashboard Page