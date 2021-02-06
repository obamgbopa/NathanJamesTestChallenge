@LoginProfile
Feature: Login to Supply Brain via user details
  As a user of the Supply Brain ERP Software for eCommerce for Nathan James
  I want to login to the software using my credentials

  Background: User navigates to Supply Brain URL
    Given I am on the Supply Brain ERP system page on URL "https://api-demo.supplybrain.io/login"
    Then I should see Login text/banner

  Scenario: Successful login
    When I fill in Email field with "njdemo@njtest.com"
    And I fill in Password field with "njdemo1234"
    And I click on the Log In button
    Then I am on the Dashboard page on URL "https://api-demo.supplybrain.io/"
    And I should see "You are logged in!" message

  Scenario Outline: Failed login using wrong credentials
    When I fill in Email with "<emails>"
    And I fill in Password with "<passwords>"
    And I click on the Login button
    And I should see an error "<warning>" message
    Examples:
      | emails                    | passwords      | warning                           |
      | njdemo@njtest.com        | njdemo        | These credentials do not match our records. |
      | njdeo@njtest.com         | njdemo1234    | These credentials do not match our records. |
      | njdeo@njtest.com         | njdemo        | These credentials do not match our records. |
   #   | njdemo@njtest.com        |               | Please fill out this field.            |
   #  |                          | njdemo1234    | Please fill out this field.            |
   #   |                          |               | Please fill out this field.    |