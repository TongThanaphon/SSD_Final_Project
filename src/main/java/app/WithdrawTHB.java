package app;

public class WithdrawTHB implements Withdraw{

    @Override
    public void withdraw(User user, double amount) {
        if(amount >= 0){
            double left = user.getMoney() - amount;

            if(left >= 0) {
                user.setMoney(left);
            }
        }
    }

}
