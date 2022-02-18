Feature: User Form

Scenario: Fill up User form for Training Registration

Given User is on User Registration homepage
When Registration form is visible
Then User enters form details
| name  	| contact    | course |  email     | confirmemail  |  password   | confirmpassword  |
| avishek | 1234567890 | Java   |avi@gm.com | avi@gm.com    | password12  | password12			|

And User accepts terms and submit details