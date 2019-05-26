package app;

public class DepositTHB implements Deposit {

    @Override
    public void deposit(User user, double amount) {
        double have = user.getMoney();

        if(amount >= 0) user.setMoney(have + amount);
    }

}
