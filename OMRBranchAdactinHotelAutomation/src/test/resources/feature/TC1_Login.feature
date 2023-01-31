@Login
Feature: Verifying Adactin Hotel Login Page


  Scenario Outline: 
    Verifying Adactin Hotel Login

    Given User is in Login page
    When User login with valid "<username>", "<password>"
    Then User should verify after login "Hello prakashsk!"

    Examples: 
      | username  | password |
      | prakashsk | ready123 |

  Scenario Outline: 
    Verifying Adactin Hotel Login using enter

    Given User is in Login page
    When User login with valid "<username>", "<password>" with enter key
    Then User should verify after login "Hello prakashsk!"

    Examples: 
      | username  | password |
      | prakashsk | ready123 |

  Scenario Outline: 
    Verifying Adactin Hotel Login using invalid credential

    Given User is in Login page
    When User login with valid "<username>", "<password>"
    Then User should verify after login with invalid credeential error message contains "Invalid Login details or Your Password might have expired."

    Examples: 
      | username     | password      |
      | prakashskvcg | ready12314558 |
