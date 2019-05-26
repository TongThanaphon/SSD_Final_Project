package app;

public class TransferTHB implements Transfer {

    @Override
    public void transferTo(User uFrom, User uTarget, double amount) {
        if(amount >= 0){
            double uFromHave = uFrom.getMoney();
            double uTargetHave = uTarget.getMoney();
            double left = uFromHave - amount;

            if(left >= 0){
                uFrom.setMoney(left);
                uTarget.setMoney(uTargetHave + amount);
            }
        }
    }

}
