package UI;

import Model.Account;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Brandon on 2015-09-06.
 */
public class StatusBar extends JPanel {

    private static final int WIDTH = 130;
    private static final int HEIGHT = 30;

    private Account account;

    public StatusBar(Account account) {
        this.account = account;
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.LIGHT_GRAY);
        add(new JLabel(account.getCharName()));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (account.isOnline()) {
            g.setColor(Color.GREEN);
        } else {
            g.setColor(Color.RED);
        }
        g.fillOval(100, 0, 30, 30);
    }
}
