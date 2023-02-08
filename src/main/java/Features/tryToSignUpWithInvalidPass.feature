Feature: Try to sign up with invalid pass

  Scenario: User tries to sign up with invalid password

    Given User opens to Facebook page
    When User clicks on Create new account button
    And Fills in all the mandatory fields but with invalid password
    And User is not signed up and remains on the same page