@SearchHotel
Feature: Verifying Adactin Hotel Search Page

  Scenario Outline: 
    Verifying Adactin Search Hotel page by Selecting all Fields

    Given User is in Login page
    When User login with valid "<username>", "<password>"
    Then User should verify after login "Hello prakashsk!"
    And User Search hotel with "<Location>", "<Hotel>","<Room Type>", "<Number of Room>", "<Checkin Date>", "<Checkout Date>", "<Adults Per Room>" and "<Childres Per Room>"
    Then User after Search should verify "Select Hotel"

    Examples: 
      | username  | password | Location | Hotel       | Room Type | Number of Room | Checkin Date | Checkout Date | Adults Per Room | Childres Per Room |
      | prakashsk | ready123 | London   | Hotel Creek | Double    | 3 - Three      | 20/09/2022   | 21/09/2022    | 3 - Three       | 3 - Three         |

  Scenario Outline: 
    Verifying Adactin Search Hotel page by Selecting only Mandatory fields

    Given User is in Login page
    When User login with valid "<username>", "<password>"
    Then User should verify after login "Hello prakashsk!"
    And User Search hotel only with mandatory fields "<Location>", "<Number of Room>", "<Checkin Date>", "<Checkout Date>" and "<Adults Per Room>"
    Then User after Search should verify "Select Hotel"

    Examples: 
      | username  | password | Location | Number of Room | Checkin Date | Checkout Date | Adults Per Room |
      | prakashsk | ready123 | London   | 3 - Three      | 20/09/2022   | 21/09/2022    | 3 - Three       |

  Scenario Outline: 
     Verifying Adactin Search Hotel page by Selecting Check-In and Check-Out Date

    Given User is in Login page
    When User login with valid "<username>", "<password>"
    Then User should verify after login "Hello prakashsk!"
    And User Search hotel with "<Location>", "<Hotel>","<Room Type>", "<Number of Room>", "<Checkin Date>", "<Checkout Date>", "<Adults Per Room>" and "<Childres Per Room>"
    Then User after Search should verify the error message "Check-In Date shall be before than Check-Out Date" and "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | username  | password | Location | Hotel       | Room Type | Number of Room | Checkin Date | Checkout Date | Adults Per Room | Childres Per Room |
      | prakashsk | ready123 | London   | Hotel Creek | Double    | 3 - Three      | 20/09/2022   | 19/09/2022    | 3 - Three       | 3 - Three         |

  Scenario Outline: 
    Verifying Adactin Search Hotel page without Entering any Field

    Given User is in Login page
    When User login with valid "<username>", "<password>"
    Then User should verify after login "Hello prakashsk!"
    And User Search hotel without selecting any field
    Then User should Verify error message "Please Select a Location"

    Examples: 
      | username  | password |
      | prakashsk | ready123 |
