Feature: Homepage


  Scenario: Homepage navigation bar has Tag tab
    Given I am on the page with url "https://stackoverflow.com/"
    When I get the "text" of the element with "id" "nav-tags"
    Then I should see the "text" "Tags"