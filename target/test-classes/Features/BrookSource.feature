Feature: feature to test Brooksource task

  Scenario Outline: verify search functionality is successful
    Given browser is open
    And user launch Brooksource url
    When user clicks on Search IT Openings
    Then user should see careers page
    When user enters the keyword '<searchKeyword>' and click on Search button
    Then user should see the matching openings
    
    Examples:
    |searchKeyword|
    |Test					 |
    
 
