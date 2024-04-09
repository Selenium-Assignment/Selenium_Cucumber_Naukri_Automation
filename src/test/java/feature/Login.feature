Feature: Testing Login Functionality
  Scenario Outline: Login experience with valid credential
    Given user is on landing page
    And user proceeds to Login
    And user provides "<email>" and "<password>"
    When user  clicks on LoginButton
    Then user is on Homepage
    Examples:
      | email                        | password  |
      | pranav.kumar.da.na@gmail.com | Puma5532# |