Feature: Login Action
  Scenario: Registration
    Given User is on Home Page
    When User Navigate to registrationPage
    And User enters First Name, Second Name, Last Name
    And User enters "Russia"/ as a Country
    And User enters "1234 Zhelud ave"/ as an Address
    And User enters "6196666666"/ as a Phone number
    And User enters an Email
    And User enters "mudeza123"/ as a Password and retypes that as well
    And User pushes Create account button
    Then User gets redirected to login pages