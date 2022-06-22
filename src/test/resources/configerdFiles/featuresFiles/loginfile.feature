Feature: Actitime Login Feature

  Scenario: ActiTime Login Page title
    Given User is on the login page
    When User gets the title of the page
    Then Title of login page should be "actiTIME - Login"