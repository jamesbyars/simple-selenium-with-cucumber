Feature: Homepage

#  Background:
#    Given I am using chrome
#    And I am on the page with url "https://searchwww.sec.gov/EDGARFSClient/jsp/EDGAR_MainAccess.jsp?search_text=%22Miller%2C%20Charles%22&isAdv=false"

#  Scenario: I can search for James Byars
#    When I enter "Byars, James" in the search field with quotes
#    And I submit the search form
#    Then I should wait 10 seconds

# I could also build the search URL based on input
  # https://searchwww.sec.gov/EDGARFSClient/jsp/EDGAR_MainAccess.jsp?search_text=%22Miller%2C%20Charles%22&isAdv=false

  Scenario Outline: Lookup user
    Given I am using chrome
    And I am on the page with url "https://searchwww.sec.gov/EDGARFSClient/jsp/EDGAR_MainAccess.jsp"
    When When I enter "<lastFirst>" in the search field with quotes
    And I submit the search form
    When I get the element with xpath "//*[@id='ifrm2']/table[2]"
    Then I should wait 10 seconds

    Examples:
      | lastFirst |
      | Byars, James |
      | Miller, Charles |
