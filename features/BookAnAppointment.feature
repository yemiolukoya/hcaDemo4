Feature: Request an appointment

  
  Scenario: Request an appointment as a patient
    Given user launch the browser
    And opens URL "https://www.hcahealthcare.co.uk/"
    When user click book an appointment
    And user choose I am a patient option
    And user fill in patient details
    And user enter appointment details
    And user choose communication Preferences
    When user click submit button
    Then confirm you are not a robot message is displayed
