Feature: Sign Up without Data

  Scenario: User tries to sign up without data

    Given User opens to Facebook page
    When User clicks on Create new account button
    And Clicks Sign Up button
    Then User is not signed up and remains on the same page