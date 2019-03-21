# new feature
# Tags: optional

Feature: Verify that user's bio is updated

  Scenario: Change bio in my profile
    When I enter "hotbowl258@gmail.com" and "pass123"
    And go to My Addresses
    And update FirstName with "arsensss"
    Then new info is displayed in my profile address box

