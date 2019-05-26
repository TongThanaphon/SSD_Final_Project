package app;

public class TransferUSD implements Transfer {

    @Override
    public void transferTo(User uFrom, User uTarget, double amount) {
        if(amount >= 0){
            double toThb = amount * 32;
            double uFromHave = uFrom.getMoney();
            double uTargetHave = uTarget.getMoney();
            double left = uFromHave - toThb;

            if(left >= 0){
                uFrom.setMoney(left);
                uTarget.setMoney(uTargetHave + toThb);
            }
        }
    }

}
