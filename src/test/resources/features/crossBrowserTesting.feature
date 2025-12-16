Feature: Cross browser testing

  Scenario Outline:
    Given I use the browser "<browser>"
    When I search for "regnjacka" on the web page "https://duckduckgo.com/"
    And I click on the first result
    Then I see a page with raincoats

    Examples:
    | browser |
    | Chrome  |
    | Firefox |
    | Edge    |