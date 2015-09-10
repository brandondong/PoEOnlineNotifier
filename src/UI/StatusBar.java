package UI;

import Model.Account;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Brandon on 2015-09-06.
 */
public class StatusBar extends JPanel {

    private static final int WIDTH = 200;
    private static final int HEIGHT = 30;

    private Account account;
    private JLabel status;
    private AppUI appUI;

    public StatusBar(Account account, AppUI appUI) {
        this.account = account;
        status = new JLabel("Filler");
        this.appUI = appUI;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.LIGHT_GRAY);
        setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        remove(status);

        ImageIcon icon;
        if (account.isOnline()) {
            icon = new ImageIcon("online.png");
        } else {
            icon = new ImageIcon("offline.png");
        }
        status = new JLabel(account.getCharName(), icon, JLabel.LEFT);
        add(status);
        validate();
    }

    public Account getAccount() {
        return account;
    }
}
