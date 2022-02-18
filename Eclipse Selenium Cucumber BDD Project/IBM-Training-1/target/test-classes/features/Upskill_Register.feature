Feature: New Users sign up in the Upskill Portal

  Scenario Outline: Verify New User Registration
    Given User is on elearning website homepage
    When User clicks on Sign up button
    And enters details <firstname><lastname><email><username><password><conf_password>
    Then User clicks on Register button
    And User verifies successful registration

    Examples: 
      | firstname | lastname | email        | username   |  password   | conf_password   |
      | "avi" 		|   "roy"  | "avi@gm.com" | "avi102"   |  "roy12345" |     "roy12345"  |
      | "ava"		  |   "roy"  | "ava@gm.com" | "ava102"   |  "roy12345" |     "roy12345"  |
      | "ava2"		  |   "roy"  | "ava2@gm.com" | "ava2102"   |  "roy12345" |     "roy12345"  |
      | "ava3"		  |   "roy"  | "ava3@gm.com" | "ava3102"   |  "roy12345" |     "roy12345"  |
      | "ava4"		  |   "roy"  | "ava4@gm.com" | "ava4102"   |  "roy12345" |     "roy12345"  |
      | "ava5"		  |   "roy"  | "ava5@gm.com" | "ava5102"   |  "roy12345" |     "roy12345"  |
      | "ava6"		  |   "roy"  | "ava6@gm.com" | "ava6102"   |  "roy12345" |     "roy12345"  |
      | "ava7"		  |   "roy"  | "ava7@gm.com" | "ava7102"   |  "roy12345" |     "roy12345"  |
      | "ava8"		  |   "roy"  | "ava8@gm.com" | "ava8102"   |  "roy12345" |     "roy12345"  |
      | "ava9"		  |   "roy"  | "ava9@gm.com" | "ava9102"   |  "roy12345" |     "roy12345"  |
      
