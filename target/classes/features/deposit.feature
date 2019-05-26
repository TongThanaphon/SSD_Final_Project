Feature: Deposit money
    As a user
    I can deposit money with from the account

  Background:
    Given a user id 111111 has money 0.0 THB in the account

  Scenario: Deposit 3 type of currency
    When a user login with id 111111
    Then a user deposit money 99.0 THB
    Then a user deposit money 200.0 YEN
    Then a user deposit money 1.25 USD
    Then a user id 111111 has 197.0 THB in account

  Scenario: Deposit with negative value
    When a user login with id 111111
    Then a user deposit money -100.0 THB
    Then a user deposit money 200.0 YEN
    Then a user deposit money -1.5 USD
    Then a user id 111111 has 58.0 THB in account