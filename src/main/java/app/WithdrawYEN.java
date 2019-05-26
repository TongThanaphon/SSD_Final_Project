package app;

public class WithdrawYEN implements Withdraw {

    @Override
    public void withdraw(User user, double amount) {
        if(amount >= 0){
            double toThb = amount * 0.29;
            double left = user.getMoney() - toThb;

            if(left >= 0) {
                user.setMoney(left);
            }
        }
    }

}
