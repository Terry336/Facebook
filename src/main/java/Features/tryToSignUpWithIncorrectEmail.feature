Feature: Try to sign up with incorrect email

  Scenario: User tries to sign up with incorrect email

    Given User opens to Facebook page
    When User clicks on Create new account button
    And Fills in all the mandatory fields but with incorrect email
    Then User is not signed up and remains on the same page