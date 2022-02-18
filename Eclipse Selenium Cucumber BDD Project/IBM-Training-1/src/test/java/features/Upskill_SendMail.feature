
Feature: Compose and Send mail from profile

  Scenario Outline: Verify sending mail to participants
    Given User is on elearning website homepage
    And User logs in with creds <username><password> and go to Homepage tab
    When User clicks on Compose tab
    And User selects mail recepients <recepient>
    And User enters mail details <subject><body>
    Then User clicks on Send message button
    And User verifies message sent successfully

    Examples: 
      |username		|		password	| recepient  | subject | body  |
      | "avi102"  |  "roy12345" | "ava102" 		| "Hello" | "Hello" |
