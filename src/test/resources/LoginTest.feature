# new feature
# Tags: optional

Feature: Facebook login

  Scenario Outline: Login with valid login & password
    Given Open Chrome and go to Facebook page
    When I enter valid "<login>" and "<password>"
    Then I should be login successfully
    Examples:
      | login               | password |





