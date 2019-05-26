package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferGUI extends JFrame {

    private Transfer tf;
    private DbManager db = DbManager.getInstance();

    private JTextField inputId;
    private JTextField inputAmount;
    private JComboBox currencyCb;
    private JLabel idLabel;
    private JLabel amountLabel;
    private JButton submitButton;
    private JButton backButton;

    private String[] currency = {"usd", "thb", "yen"};

    public TransferGUI(final User user, final UserInfoGUI info){
        setTitle("BankApp");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(0, 20, 50));

        idLabel = new JLabel("Transfer to ID:");

        inputId = new JTextField();
        inputId.setPreferredSize(new Dimension(100, 30));

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
                    int id = Integer.parseInt(inputId.getText());
                    double amount = Double.parseDouble(inputAmount.getText());

                    User u = db.findUser(id);

                    if(u != null){

                        setTransferType();
                        tf.transferTo(user, u, amount);

                        amount = u.getMoney();

                        try {
                            db.updateData(id, amount);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid ID! Can not find this ID or input 6 numbers");
                    }
                }catch(NumberFormatException ne){
                    JOptionPane.showMessageDialog(null, "ID and amount much be only number");
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

        add(idLabel);
        add(inputId);
        add(amountLabel);
        add(inputAmount);
        add(currencyCb);
        add(submitButton);
        add(backButton);
        pack();
    }

    public void setTransferType(){
        String curr = (String) currencyCb.getSelectedItem();

        if(curr.equals("usd")) tf = new TransferUSD();
        else if(curr.equals("thb")) tf = new TransferTHB();
        else if(curr.equals("yen")) tf = new TransferYEN();
    }

}
