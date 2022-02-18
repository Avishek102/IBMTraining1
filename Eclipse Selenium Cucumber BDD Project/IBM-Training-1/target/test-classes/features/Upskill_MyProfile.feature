
Feature: My Profile

  Scenario Outline: Verify Edit Profile details
    Given User is on elearning website homepage
    And User logs in with creds <username><password> and go to Homepage tab
    Then User clicks on Edit Profile tab
    And attaches new image and selects language "Italiano"
    And enters new details "skypeid" "linkedinurl.com"
    Then User clicks on Save Settings 
    And User verifies settings saved successfully

    Examples: 
      | username  | password |
      | "avi102" |     "roy12345" |
