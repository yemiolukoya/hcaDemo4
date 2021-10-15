Feature: How to pay for your treatment

  Scenario: Make payment with valid details
    Given user launch the browser
    And opens URL "https://www.hcahealthcare.co.uk/"
    And user click on How to pay for your treatment tab
    And user fill in Patient details
    And user fill in Billing details
    When user fill in Payment details
    And user click pay securely now
    Then user should be navigated to payment page