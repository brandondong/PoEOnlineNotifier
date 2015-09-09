package UI;

import Model.Account;
import Model.App;
import Model.Exceptions.NoCharacterExistsException;
import Observers.TrayNotification;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brandon on 2015-09-06.
 */
public class AppUI extends JFrame {

    public static final int TIME_TO_UPDATE = 60000;

    private App app;
    private List<StatusBar> bars;
    private boolean keepRunning;

    public AppUI() {
        super("Path of Exile Online Notifier");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);

        app = new App();
        bars = new ArrayList<>();
        keepRunning = false;
        try {
            add(new StatusBar(new Account("WTBsurvivability")));
        } catch (NoCharacterExistsException e) {
            e.printStackTrace();
        }

        pack();
        centreOnScreen();
        setVisible(true);
    }

    // Modifies: this
    // Effects: location of frame is set so frame is centred on desktop
    private void centreOnScreen() {
        Dimension scrn = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((scrn.width - getWidth()) / 2, (scrn.height - getHeight()) / 2);
    }

    public static void main(String[] args) {
        //new AppUI();
        TrayNotification notify = new TrayNotification();
        notify.update("Havoc", false);
        new AppUI();
    }
}
