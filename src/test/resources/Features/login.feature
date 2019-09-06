Feature: Login page for web app

  Background: 
    Given I browse to the web app and I am not logged in  Scenario: Login page displayed

  Scenario: I try to login with a valid user
    When I login with a valid user
    Then I see a "home" page
