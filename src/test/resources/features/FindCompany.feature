Feature: Find company
@test
  Scenario: Find otus company
    Given I open main page
    When I find post "otus"
    And I open hub tab
    Then I check exist "otus" company
    When I click "otus" company
    Then I check open "OTUS. Онлайн-образование" page