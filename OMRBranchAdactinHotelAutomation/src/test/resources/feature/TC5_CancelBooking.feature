@CancelPage
Feature: Verifying Adactin Hotel CancelBooking Page

  Scenario Outline: 
    Verifying Adactin Hotel CancelBooking page by Cancelling the Booked OrderId

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
    And User should Cancel OrderId
    Then User should Verify after Cancelling OrderId success message "The booking has been cancelled."

    Examples: 
      | username  | password | Location | Hotel       | Room Type | Number of Room | Checkin Date | Checkout Date | Adults Per Room | Childres Per Room | First Name | Last Name | Billing Address |
      | prakashsk | ready123 | London   | Hotel Creek | Double    | 3 - Three      | 20/09/2022   | 21/09/2022    | 3 - Three       | 3 - Three         | prakash    | sk        | cbe             |

  Scenario Outline: 
    Verifying Adactin Hotel CancelBooking page by Cancelling Booking using Existing OrderId

    Given User is in Login page
    When User login with valid "<username>", "<password>"
    Then User should verify after login "Hello prakashsk!"
    And User should Cancel Existing "<OrderId>"
    Then User should Verify after Cancelling OrderId success message "The booking has been cancelled."

    Examples: 
      | username  | password | OrderId    |
      | prakashsk | ready123 | N65L4F1Q7A |
