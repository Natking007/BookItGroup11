@wip @smoke
Feature:Online Banking Login Feature

  Background: User login
    Given the user is on the login page

  Scenario: Authorized users should be able to login to the application
    When User logins with valid username
    Then the "bookit" title page should be displayed
