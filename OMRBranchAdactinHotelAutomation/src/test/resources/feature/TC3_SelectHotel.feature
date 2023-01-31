@SelectHotel
Feature: Verifying Adactin Hotel Select Page

  Scenario Outline: 
    Verifying Adactin Select Hotel page by Selecting Hotel Name

    Given User is in Login page
    When User login with valid "<username>", "<password>"
    Then User should verify after login "Hello prakashsk!"
    And User Search hotel with "<Location>", "<Hotel>","<Room Type>", "<Number of Room>", "<Checkin Date>", "<Checkout Date>", "<Adults Per Room>" and "<Childres Per Room>"
    Then User after Search should verify "Select Hotel"
    And User should select Hotel Name
    Then User should Verify after Select Hotel success message  "Book A Hotel"

    Examples: 
      | username  | password | Location | Hotel       | Room Type | Number of Room | Checkin Date | Checkout Date | Adults Per Room | Childres Per Room |
      | prakashsk | ready123 | London   | Hotel Creek | Double    | 3 - Three      | 20/09/2022   | 21/09/2022    | 3 - Three       | 3 - Three         |

  Scenario Outline: 
    Verifying Adactin Select Hotel page by without Selecting Hotel Name

    Given User is in Login page
    When User login with valid "<username>", "<password>"
    Then User should verify after login "Hello prakashsk!"
    And User Search hotel with "<Location>", "<Hotel>","<Room Type>", "<Number of Room>", "<Checkin Date>", "<Checkout Date>", "<Adults Per Room>" and "<Childres Per Room>"
    Then User after Search should verify "Select Hotel"
    And User should Click Continue without Selecting any Hotel
    Then User should Verify without Selecting any Hotel error message  "Please Select a Hotel"

    Examples: 
      | username  | password | Location | Hotel       | Room Type | Number of Room | Checkin Date | Checkout Date | Adults Per Room | Childres Per Room |
      | prakashsk | ready123 | London   | Hotel Creek | Double    | 3 - Three      | 20/09/2022   | 21/09/2022    | 3 - Three       | 3 - Three         |
