Feature: Login Functionality

  Scenario: User signs up

    Given User opens to Facebook page
    When User clicks on Create new account button
    And Fills in all the mandatory fields
    And Clicks Sign Up button
    Then User signs up successfully
