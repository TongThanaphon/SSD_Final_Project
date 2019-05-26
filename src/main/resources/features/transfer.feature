Feature: Transfer money to other account
  As a user
  I can transfer money to other account

  Background:
    Given a user id 999999 has money 2200.0 THB in the account
    And a user id 123123 has money 100.0 THB in the account

  Scenario: Transfer money
    When a user login with id 999999
    Then a user transfer money to id 123123 with 2.5 USD
    Then a user transfer money to id 123123 with 10 YEN
    Then a user transfer money to id 123123 with 1000 THB
    Then a user id 999999 has 1117.1 THB in account
    Then a target user id 123123 has 1182.92 THB in account

  Scenario: Transfer money with negative
    When a user login with id 999999
    Then a user transfer money to id 123123 with -100.0 USD
    Then a user transfer money to id 123123 with -20 YEN
    Then a user transfer money to id 123123 with -1000 THB
    Then a user id 999999 has 2200.0 THB in account
    Then a target user id 123123 has 100.0 THB in account