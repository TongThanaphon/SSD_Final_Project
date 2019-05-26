package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AppGUI extends JFrame {

    private Deposit d;
    private Withdraw w;
    private DbManager db = DbManager.getInstance();

    private JTextField inputAmount;
    private JComboBox currencyCb;
    private JComboBox typeCb;
    private JButton submitButton;
    private JButton backButton;
    private JLabel amountLabel;

    private String[] currency = {"usd", "thb", "yen"};
    private String[] types = {"deposit", "withdraw"};

    public AppGUI(final User user, final UserInfoGUI info){
        setTitle("BankApp");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(0, 20 ,50));

        typeCb = new JComboBox(types);
        typeCb.setPreferredSize(new Dimension(100, 30));

        amountLabel = new JLabel("Amount:");

        inputAmount = new JTextField();
        inputAmount.setPreferredSize(new Dimension(150, 30));

        currencyCb = new JComboBox(currency);
        currencyCb.setPreferredSize(new Dimension(100, 30));

        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(80, 30));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try{
                    double amount = Double.parseDouble(inputAmount.getText());
                    String type = (String) typeCb.getSelectedItem();

                    if(type.equals("deposit")){
                        setDepositType(user, amount);
                    }else if(type.equals("withdraw")){
                        setWithdrawType(user, amount);
                    }

                    try {
                        db.updateData(user.getId(), user.getMoney());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }catch(NumberFormatException ne){
                    JOptionPane.showMessageDialog(null, "Input onely numbers.");
                }
            }
        });

        backButton = new JButton("Back");
        backButton.setPreferredSize(new Dimension(80, 30));
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                HomeGUI menu = new HomeGUI(user, info);
                menu.setVisible(true);

                setVisible(false);
            }
        });

        add(typeCb);
        add(amountLabel);
        add(inputAmount);
        add(currencyCb);
        add(submitButton);
        add(backButton);
        pack();
    }

    public void setDepositType(User user, double amount){
        String cur = (String) currencyCb.getSelectedItem();

        if(cur.equals("usd")){
            d = new DepositUSD();
        }else if(cur.equals("thb")){
            d = new DepositTHB();
        }else if(cur.equals("yen")){
            d = new DepositYEN();
        }

        d.deposit(user, amount);
    }

    public void setWithdrawType(User user, double amount){
        String cur = (String) currencyCb.getSelectedItem();

        if(cur.equals("usd")){
            w = new WithdrawUSD();
        }else if(cur.equals("thb")){
            w = new WithdrawTHB();
        }else if(cur.equals("yen")){
            w  = new WithdrawYEN();
        }

        w.withdraw(user, amount);
    }

}
