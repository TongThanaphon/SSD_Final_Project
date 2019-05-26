import app.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BankAppStepdefs {

    private List<User> users = new ArrayList<>();
    private User user;
    private Deposit d;
    private Withdraw w;
    private Transfer tf;

    @Given("a user id (.+) has money (.+) THB in the account")
    public void create_user(int id, double money){
        User user = new User(id, money);
        users.add(user);
    }

    @When("a user login with id (.+)")
    public void login(int id){
        for(User u: users){
            if(u.getId() == id) {
                user = u;
                assertEquals(id, user.getId());
                break;
            }
        }
    }

    @Then("a user deposit money (.+) USD")
    public void deposit_with_usd(double amount){
        d = new DepositUSD();
        d.deposit(user, amount);
    }

    @Then("a user deposit money (.+) THB")
    public void deposit_with_thb(double amount){
        d = new DepositTHB();
        d.deposit(user, amount);
    }

    @Then("a user deposit money (.+) YEN")
    public void deposit_with_yen(double amount){
        d = new DepositYEN();
        d.deposit(user, amount);
    }

    @Then("a user withdraw money (.+) USD")
    public void withdraw_with_usd(double amount){
        w = new WithdrawUSD();
        w.withdraw(user, amount);
    }

    @Then("a user withdraw money (.+) THB")
    public void withdraw_with_thb(double amount){
        w = new WithdrawTHB();
        w.withdraw(user, amount);
    }

    @Then("a user withdraw money (.+) YEN")
    public void withdraw_with_yen(double amount){
        w = new WithdrawYEN();
        w.withdraw(user, amount);
    }

    @Then("a user transfer money to id (.+) with (.+) USD")
    public void transfer_with_usd(int id, double amount){
        tf = new TransferUSD();
        for(User u2: users){
            if(u2.getId() == id){
                tf.transferTo(user, u2, amount);
                break;
            }
        }
    }

    @Then("a user transfer money to id (.+) with (.+) THB")
    public void transfer_with_thb(int id, double amount){
        tf = new TransferTHB();
        for(User u2: users){
            if(u2.getId() == id){
                tf.transferTo(user, u2, amount);
                break;
            }
        }
    }

    @Then("a user transfer money to id (.+) with (.+) YEN")
    public void transfer_with_yen(int id, double amount){
        tf = new TransferYEN();
        for(User u2: users){
            if(u2.getId() == id){
                tf.transferTo(user, u2, amount);
                break;
            }
        }
    }

    @Then("a user id (.+) has (.+) THB in account")
    public void total_money_in_account(int id, double money){
        double actualMoney = user.getMoney();
        assertEquals(money, actualMoney);
    }

    @Then("a target user id (.+) has (.+) THB in account")
    public void total_target_money_in_account(int id, double money){
        for(User u: users){
            if(u.getId() == id){
                assertEquals(money, u.getMoney());
                break;
            }
        }
    }

}
