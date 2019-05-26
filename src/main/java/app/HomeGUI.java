package app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeGUI extends JFrame {

    private JButton transferMenu;
    private JButton appMenu;
    private JButton logoutBtn;

    public HomeGUI(final User user, final UserInfoGUI info){
        setTitle("BankApp");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(0, 20, 50));

        transferMenu = new JButton("Transfer");
        transferMenu.setPreferredSize(new Dimension(120, 30));
        transferMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                TransferGUI transfer = new TransferGUI(user, info);
                transfer.setVisible(true);

                setVisible(false);
            }
        });

        appMenu = new JButton("Deposit / Withdraw");
        appMenu.setPreferredSize(new Dimension(160, 30));
        appMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AppGUI app = new AppGUI(user, info);
                app.setVisible(true);

                setVisible(false);
            }
        });

        logoutBtn = new JButton("Logout");
        logoutBtn.setPreferredSize(new Dimension(80, 30));
        logoutBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    LoginGUI home = new LoginGUI();
                    home.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                info.setVisible(false);
                setVisible(false);
            }
        });

        add(transferMenu);
        add(appMenu);
        add(logoutBtn);
        pack();
    }

}
