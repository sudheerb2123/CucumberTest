Feature: feature to test gmail login

  Scenario: Check login is successful with valid credentials
    Given browser is open
    And user is on login page
    When user enters valid mail id 
    And clicks on next button
    When user enters valid password 
    And clicks on next button again
    Then user navigates to the corresponding page
    
 
