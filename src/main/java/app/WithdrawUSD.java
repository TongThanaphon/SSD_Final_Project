package app;

public class WithdrawUSD implements Withdraw {

    @Override
    public void withdraw(User user, double amount) {
        if(amount >= 0){
            double toThb = amount * 32;
            double left = user.getMoney() - toThb;

            if(left >= 0) {
                user.setMoney(left);
            }
        }
    }

}
