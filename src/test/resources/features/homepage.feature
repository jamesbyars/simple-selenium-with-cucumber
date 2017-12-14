Feature: Homepage

  Background:
    Given I am using chrome
    And I am on the page with url "https://stackoverflow.com/"

  Scenario: Homepage navigation bar has Tag tab
    When I get the element with id "nav-tags"
    Then I should see the text "Tags"

  Scenario: Homepage navigation bar has Questions tab
    When I get the element with id "nav-questions"
    Then I should see the text "Questions"

  Scenario: Homepage navigation bar has Users tab
    When I get the element with id "nav-users"
    Then I should see the text "Users"

  Scenario: Homepage navigation bar has Developer Jobs tab
    When I get the element with id "nav-jobs"
    Then I should see the text "Developer Jobs"