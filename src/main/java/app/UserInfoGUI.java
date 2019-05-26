package app;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class UserInfoGUI extends JFrame implements Observer {

    private User user;

    private JLabel idLabel;
    private JLabel moneyLabel;

    public UserInfoGUI(User user){
        this.user = user;

        setTitle("User Info");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        idLabel = new JLabel();
        idLabel.setText("ID: " + user.getId());
        idLabel.setFont(new Font("Serif", Font.BOLD, 20));
        idLabel.setBounds(50, 10, 100, 100);

        moneyLabel = new JLabel();
        moneyLabel.setText("Money: " + user.getMoney()+ " THB");
        moneyLabel.setFont(new Font("Serif", Font.BOLD, 20));
        moneyLabel.setBounds(50, 60, 200, 100);

        getContentPane().add(idLabel);
        getContentPane().add(moneyLabel);
    }

    @Override
    public void update(Observable observable, Object o) {
        moneyLabel.setText("Money: " + user.getMoney() + " THB");
    }
}
