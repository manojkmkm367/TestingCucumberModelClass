@BookingPage
Feature: Verifying Adactin Hotel Booking Page

  Scenario Outline: 
    Verifying Adactin Hotel Book page by Entering all fileds

    Given User is in Login page
    When User login with valid "<username>", "<password>"
    Then User should verify after login "Hello prakashsk!"
    And User Search hotel with "<Location>", "<Hotel>","<Room Type>", "<Number of Room>", "<Checkin Date>", "<Checkout Date>", "<Adults Per Room>" and "<Childres Per Room>"
    Then User after Search should verify "Select Hotel"
    And User should select Hotel Name
    Then User should Verify after Select Hotel success message  "Book A Hotel"
    And User should book Hotel "<First Name>", "<Last Name>" and "<Billing Address>"
      | Credit Card No   | Credit Card Type | Expiry Month | Expiry Year | CVV Number |
      | 1236547895214687 | VISA             | December     |        2022 |        123 |
      | 1236547895214699 | MASTER CARD      | May          |        2022 |        153 |
      | 1236547895224666 | VISA             | December     |        2022 |        553 |
    Then User should Verify after Booking success message "Booking Confirmation"

    Examples: 
      | username  | password | Location | Hotel       | Room Type | Number of Room | Checkin Date | Checkout Date | Adults Per Room | Childres Per Room | First Name | Last Name | Billing Address |
      | prakashsk | ready123 | London   | Hotel Creek | Double    | 3 - Three      | 20/09/2022   | 21/09/2022    | 3 - Three       | 3 - Three         | prakash    | sk        | cbe             |

  Scenario Outline: 
    Verifying Adactin Hotel Book page without Entering any fileds

    Given User is in Login page
    When User login with valid "<username>", "<password>"
    Then User should verify after login "Hello prakashsk!"
    And User Search hotel with "<Location>", "<Hotel>","<Room Type>", "<Number of Room>", "<Checkin Date>", "<Checkout Date>", "<Adults Per Room>" and "<Childres Per Room>"
    Then User after Search should verify "Select Hotel"
    And User should select Hotel Name
    Then User should Verify after Select Hotel success message  "Book A Hotel"
    And User should Click Book now button without entering any fileds
    Then User should Verify after click book now button error message  "Please Enter your First Name", "Please Enter you Last Name", "Please Enter your Address", "Please Enter your 16 Digit Credit Card Number", "Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | username  | password | Location | Hotel       | Room Type | Number of Room | Checkin Date | Checkout Date | Adults Per Room | Childres Per Room |
      | prakashsk | ready123 | London   | Hotel Creek | Double    | 3 - Three      | 20/09/2022   | 21/09/2022    | 3 - Three       | 3 - Three         |
