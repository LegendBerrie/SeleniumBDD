# ://www.selenium.dev/selenium/web/dynamic.html
# Skriv ett cucumber test som klickar på knapparna och kontrollerar att rutorna kommer
  Feature: Test of Selenium dynamic web page

    Background:
      Given I open the web page "https://www.selenium.dev/selenium/web/dynamic.html"

    Scenario:
      When I click on "Add a box!"
      Then A box appears

      Scenario:
        When I click on "Reveal a new input"
        Then A new inputbox appears

