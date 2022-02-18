Feature: Google Search

#Scenario: Verify Google search
#
#Given User is on google homepage
#When Google search bar is visible
#Then User enters name avishek
#And User clicks on Search button


Scenario Outline: Verify Google search with multiple entries

Given User is on google homepage
When Google search bar is visible
Then User enters <name>
And User clicks on Search button

Examples:
|		name		|
|	"avishek" |
|	"amit"		|
| "manipal" |