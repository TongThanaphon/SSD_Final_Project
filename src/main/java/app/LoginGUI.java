package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {

    private JTextField inputId;
    private JButton submitButton;
    private JLabel text;

    private DbManager db = DbManager.getInstance();

    public LoginGUI() throws Exception{
        setResizable(false);
        setTitle("BankApp");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(0, 20, 50));

        db.loadData();

        text = new JLabel("ID: ");

        inputId = new JTextField();
        inputId.setPreferredSize(new Dimension(150, 30));

        submitButton = new JButton("Submit");
        submitButton.setPreferredSize(new Dimension(80, 30));
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(inputId.getText().length() == 6){
                    try{
                        int id = Integer.parseInt(inputId.getText());

                        User user = db.findUser(id);

                        if(user == null){
                            try {
                                user = db.createUser(id);
                                JOptionPane.showMessageDialog(null, "Created New account");
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        UserInfoGUI info = new UserInfoGUI(user);
                        HomeGUI menu = new HomeGUI(user, info);
                        menu.setVisible(true);

                        info.setVisible(true);
                        user.addObserver(info);

                        setVisible(false);
                    }catch(NumberFormatException ne){
                        JOptionPane.showMessageDialog(null, "Invalid ID! Input only numbers.");
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Please input 6 numbers");
                }
            }
        });

        add(text);
        add(inputId);
        add(submitButton);
        pack();
    }

    public static void main(String[] args) throws Exception{
        LoginGUI home = new LoginGUI();
        home.setVisible(true);
    }

}
