package UI;

import Model.Account;
import Model.App;
import Model.Exceptions.NoCharacterExistsException;
import Model.Observer;
import Observers.TrayNotification;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brandon on 2015-09-06.
 */
public class AppUI extends JFrame implements Observer {

    public static final int TIME_TO_UPDATE = 60000;

    private App app;
    private boolean keepRunning;

    public AppUI() {
        super("Path of Exile Online Notifier");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(new FlowLayout());

        app = new App();
        app.addObserver(this);
        keepRunning = false;
        try {
            addAccount("WTBsurvivability");
            addAccount("Havoc");
        } catch (NoCharacterExistsException e) {
            e.printStackTrace();
        }

        pack();
        centreOnScreen();
        setVisible(true);
    }

    public void removeBar(StatusBar bar) {
        remove(bar);
        app.removeAccount(bar.getAccount());
        repaint();
        validate();
    }

    // Modifies: this
    // Effects: adds the account to the model app and creates a status bar,
    // throws NoCharacterExistsException if invalid character
    private void addAccount(String charName) throws NoCharacterExistsException {
        Account acc = app.addAccount(charName);
        add(new StatusBar(acc, this));
        repaint();
        validate();
    }

    private void runBackground() {
        keepRunning = true;
        while (keepRunning) {
            try {
                wait(TIME_TO_UPDATE);
            } catch (InterruptedException e) {
                System.out.println("Unexpected interruption");
            }
            app.update();
        }
    }

    // Modifies: this
    // Effects: location of frame is set so frame is centred on desktop
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    public static void main(String[] args) {
        TrayNotification notify = new TrayNotification();
        notify.update("Havoc", false);
        new AppUI();
    }

    @Override
    public void update(String charName, boolean status) {
        repaint();
    }
}
