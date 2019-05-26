Feature: Withdraw money
    As a user
    I can withdraw money from the account

Background:
    Given a user id 123456 has money 1500.0 THB in the account

Scenario: Withdraw money
    When a user login with id 123456
    Then a user withdraw money 2.0 USD
    Then a user withdraw money 50.0 YEN
    Then a user withdraw money 250.0 THB
    Then a user id 123456 has 1171.5 THB in account

    Scenario: Withdraw money with negative
        When a user login with id 123456
        Then a user withdraw money -100.0 USD
        Then a user withdraw money 0.0 YEN
        Then a user withdraw money 250.0 THB
        Then a user id 123456 has 1250.0 THB in account