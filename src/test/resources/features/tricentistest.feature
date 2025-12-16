Feature: Test of Tricentis demo webshop

  Background:
    Given I open the webpage "https://demowebshop.tricentis.com/"

  Scenario Outline: Open webpage and categories
    When I click on the category "<category>"
    Then I am sent to the page with the title "<pageTitle>"

    Examples:
    |      category     |    pageTitle      |
    |       Books       |      Books        |
    |     Computers     |     Computers     |
    |    Electronics    |    Electronics    |
    |  Apparel & Shoes  |  Apparel & Shoes  |
    | Digital downloads | Digital downloads |
    |     Jewelry       |      Jewelry      |
    |    Gift cards     |    Gift cards     |