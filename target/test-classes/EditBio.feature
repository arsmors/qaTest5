# new feature
# Tags: optional

Feature: A description

  Scenario: Change bio in my profile
    When I enter "hotbowl258@gmail.com" and "pass123"
    And go to My Addresses
    And update City with "arsenss"
    Then new info is displayed in my profile address box

