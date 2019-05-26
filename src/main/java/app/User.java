package app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Observable;

public class User extends Observable {

    private int id;
    private double money;

    public User(int id, double money){
        this.id = id;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setMoney(double money) {
        BigDecimal bd = new BigDecimal(money).setScale(2, RoundingMode.CEILING);

        this.money = bd.doubleValue();
        setChanged();
        notifyObservers();
    }

    public double getMoney() {
        return money;
    }

}
