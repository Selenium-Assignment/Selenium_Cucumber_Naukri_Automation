Feature:  Profile Update
@smoke
  Scenario Outline: Updating User Profile
    Given User is on landing Page
    And User provides "<username>" and "<password>" and logsIn
    Then User moves to profile Section
    And user updates the profile
    Then User verifies profile is successfully updated

    Examples:
      | username                     | password  |
      | pranav.kumar.da.na@gmail.com | puma5532# |