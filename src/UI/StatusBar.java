package UI;

import Model.Account;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Brandon on 2015-09-06.
 */
public class StatusBar extends JPanel {

    private static final int WIDTH = 200;
    private static final int HEIGHT = 60;

    private Account account;
    private JLabel status;
    private JButton remove;
    private AppUI appUI;

    public StatusBar(Account account, AppUI app) {
        this.account = account;
        status = new JLabel("Filler");
        this.appUI = app;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.LIGHT_GRAY);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        remove = new JButton("Remove");
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appUI.removeBar(StatusBar.this);
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        remove(status);
        remove(remove);

        ImageIcon icon;
        if (account.isOnline()) {
            icon = new ImageIcon("online.png");
        } else {
            icon = new ImageIcon("offline.png");
        }
        status = new JLabel(account.getCharName(), icon, JLabel.LEFT);
        add(status);
        add(remove);
        validate();
    }

    public Account getAccount() {
        return account;
    }
}
