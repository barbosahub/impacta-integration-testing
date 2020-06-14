Feature: CRUD New Process

  Scenario: Simple Get with all process
    Given user is on the Rui Process Page
    When user clicks on find Rui button
    Then  user should see "success" message

  Scenario: Simple Get with one process
    Given user is on the Rui Process Page
    And user would like to see process with id "827"
    When user clicks on find Rui button
    Then  user should see "success" message