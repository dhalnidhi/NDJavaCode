@e2e
Feature: AutomationExercise testcases
  All the testcases related to Demo app AutomationExercise


  @regression
  Scenario: Login to AutomationExercise Application
    Given I am Login page
    When I entered user and password
    And Click on Login Button
    Then I should be logged in successfully.

  @smoke
  Scenario: AddToCart function test
    Given I am logged into application
    When Add the item to card
    And Then the item should be added successfully to the cart
    Then I should be logged out of the application
    And I close the application

  Scenario: Remove items from cart
    Given I am logged into application
    Then remove items from the cart
    Then the no of items in the cart should be "0"
#      Then all items should be removed successfully
    And I close the application

  Scenario Outline: Validate Login to AutomationExercise Application with different set of data
    Given I am on Login page
    When I entered "<user>" and "<password>"
    And Click on Login Button
    Then The Login should be "<status>"
    And I close the application
    Examples:
      | user                  | password | status                               |
      | amitkp.2031@gmail.com | Luck2025 |  Logged in as Amit                   |
      | dhalnidhi12@gmail.com | Luck2025 |  Logged in as nidhi                  |
      | amitkp.2031@gmail.com | password | Your email or password is incorrect! |



