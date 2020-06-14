@ignore
Feature: Json Placeholder CRUD

  Background:
    Given user would like to see all json placeholder

  Scenario: User save a register with post
    And user goes to main menu
    When user clicks on find button
    Then user should see "success" message

  Scenario Outline: User save a register with post outline
    Given user fills the follwind id equal "<id>"
    When user clicks on find button
    Then user should see "<response>" message

    Examples:
      | response  | id      |
      | success   |         |
      | not found | /123123 |
      | success   | /827    |
