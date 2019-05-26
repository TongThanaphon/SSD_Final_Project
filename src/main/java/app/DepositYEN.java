package app;

public class DepositYEN implements Deposit {

    @Override
    public void deposit(User user, double amount) {
        double toThb = amount * 0.29;
        double have = user.getMoney() + toThb;

        if(amount >= 0) user.setMoney(have);
    }

}
