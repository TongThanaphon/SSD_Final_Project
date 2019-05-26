$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/withdraw.feature");
formatter.feature({
  "line": 1,
  "name": "Withdraw money",
  "description": "  As a user\n  I can withdraw money from the account",
  "id": "withdraw-money",
  "keyword": "Feature"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "a user id 123456 has money 1500.0 THB in the account",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "123456",
      "offset": 10
    },
    {
      "val": "1500.0",
      "offset": 27
    }
  ],
  "location": "BankAppStepdefs.create_user(int,double)"
});
formatter.result({
  "duration": 93929958,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Withdraw money",
  "description": "",
  "id": "withdraw-money;withdraw-money",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "a user login with id 123456",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "a user withdraw money 2.0 USD",
  "keyword": "Then "
});
formatter.step({
  "line": 11,
  "name": "a user withdraw money 50.0 YEN",
  "keyword": "Then "
});
formatter.step({
  "line": 12,
  "name": "a user withdraw money 250.0 THB",
  "keyword": "Then "
});
formatter.step({
  "line": 13,
  "name": "a user id 123456 has 1171.5 THB in account",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "123456",
      "offset": 21
    }
  ],
  "location": "BankAppStepdefs.login(int)"
});
formatter.result({
  "duration": 3015931,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2.0",
      "offset": 22
    }
  ],
  "location": "BankAppStepdefs.withdraw_with_usd(double)"
});
formatter.result({
  "duration": 2495412,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "50.0",
      "offset": 22
    }
  ],
  "location": "BankAppStepdefs.withdraw_with_yen(double)"
});
formatter.result({
  "duration": 222689,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "250.0",
      "offset": 22
    }
  ],
  "location": "BankAppStepdefs.withdraw_with_thb(double)"
});
formatter.result({
  "duration": 220927,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "123456",
      "offset": 10
    },
    {
      "val": "1171.5",
      "offset": 21
    }
  ],
  "location": "BankAppStepdefs.total_money_in_account(int,double)"
});
formatter.result({
  "duration": 1803221,
  "status": "passed"
});
formatter.background({
  "line": 5,
  "name": "",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 6,
  "name": "a user id 123456 has money 1500.0 THB in the account",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "123456",
      "offset": 10
    },
    {
      "val": "1500.0",
      "offset": 27
    }
  ],
  "location": "BankAppStepdefs.create_user(int,double)"
});
formatter.result({
  "duration": 151965,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "Withdraw money with negative",
  "description": "",
  "id": "withdraw-money;withdraw-money-with-negative",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 16,
  "name": "a user login with id 123456",
  "keyword": "When "
});
formatter.step({
  "line": 17,
  "name": "a user withdraw money -100.0 USD",
  "keyword": "Then "
});
formatter.step({
  "line": 18,
  "name": "a user withdraw money 0.0 YEN",
  "keyword": "Then "
});
formatter.step({
  "line": 19,
  "name": "a user withdraw money 250.0 THB",
  "keyword": "Then "
});
formatter.step({
  "line": 20,
  "name": "a user id 123456 has 1250.0 THB in account",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "123456",
      "offset": 21
    }
  ],
  "location": "BankAppStepdefs.login(int)"
});
formatter.result({
  "duration": 155003,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "-100.0",
      "offset": 22
    }
  ],
  "location": "BankAppStepdefs.withdraw_with_usd(double)"
});
formatter.result({
  "duration": 141567,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "0.0",
      "offset": 22
    }
  ],
  "location": "BankAppStepdefs.withdraw_with_yen(double)"
});
formatter.result({
  "duration": 151575,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "250.0",
      "offset": 22
    }
  ],
  "location": "BankAppStepdefs.withdraw_with_thb(double)"
});
formatter.result({
  "duration": 164779,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "123456",
      "offset": 10
    },
    {
      "val": "1250.0",
      "offset": 21
    }
  ],
  "location": "BankAppStepdefs.total_money_in_account(int,double)"
});
formatter.result({
  "duration": 202062,
  "status": "passed"
});
});