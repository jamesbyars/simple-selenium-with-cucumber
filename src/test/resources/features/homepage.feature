Feature: Homepage

  Background:
    Given I am using chrome
    And I am on the page with url "https://searchwww.sec.gov/EDGARFSClient/jsp/EDGAR_MainAccess.jsp"

  Scenario: I can search for James Byars
    When I search for the text "Byars, James"
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