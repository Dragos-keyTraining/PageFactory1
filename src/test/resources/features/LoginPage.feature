

Feature: Login in KeyFood application

Background:
	Given User is on Login page

  @ValidCredentials
  Scenario: Login with valid credentials

    When User enters correct username and password
    Then User should be able to see success message
    
  @InvalidCredentials
  Scenario Outline: Login with invalid credentials

    When User enters wrong username and password
    Then User should be able to see error message
