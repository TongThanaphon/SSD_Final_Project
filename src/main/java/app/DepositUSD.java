package app;

public class DepositUSD implements Deposit {

    @Override
    public void deposit(User user, double amount) {
        double toThb = amount * 32;
        double have = user.getMoney();

        if(amount >= 0) user.setMoney(have + toThb);
    }

}
