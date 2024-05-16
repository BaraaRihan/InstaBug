Feature: Login Test

  Scenario Outline: Valid and Invalid Login
    Given User navigates to the login page
    When User enters "<username>" and "<password>"
    And User clicks on the login button
    Then "<outcome>" message is displayed

    Examples:

      | username        | password     | outcome                                         |
      |-----------------|--------------| Epic sadface: Username and password do not match any user in this service|
      | standard_user   | secret_sauce |          |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.|
      | invalid_user    | invalid_pass | Epic sadface: Username and password do not match any user in this service |
      |                 |              | Epic sadface: Username is required |
