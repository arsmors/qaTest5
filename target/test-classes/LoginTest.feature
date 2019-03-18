# new feature
# Tags: optional

Feature: TEST login

  Scenario Outline: Login with valid login & password
    Given Open Chrome and go to Homepage
    When I enter valid "<login>" and "<password>"
    Then I should be login successfully
    Examples:
      | login                | password |
      | hotbowl258@gmail.com | pass123  |
      |                      | qwe1234  |



#  Scenario Outline: Login with invalid login & password
#    Given Open Chrome and go to Homepage
#    When I enter invalid "<login>" and "<password>"
#    Then I should be login unsuccessfully
#    Examples:
#      | login                | password |
#      | hotbowl258@gmail.com |          |
#      |                      | qwe1234  |
#      | hotbowl258@gmail.com | qwe123   |






