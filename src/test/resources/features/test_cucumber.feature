Feature: My first cucumber feature
  This is my first cucumber feature

  Scenario: My first scenario-1
    Given Cucumber is setup in my project
    When I try to execute
    Then I executed successfully



  @smoke
  Scenario: My second scenario-2
    Given Cucumber is setup in my project
    When I try to execute my second scenario
    Then I executed successfully
    And I try to execute my third step
    Then I executed successfully
