package Observers;

import Model.Observer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Brandon on 2015-09-08.
 */
public class TrayNotification implements Observer {

    @Override
    public void update(String charName, boolean status) {
        if (SystemTray.isSupported()) {
            Image icon = null;
            String message = null;
            try {
                if (status) {
                    icon = ImageIO.read(new File("online.png"));
                    message = "in";
                } else {
                    icon = ImageIO.read(new File("offline.png"));
                    message = "out";
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

            TrayIcon trayIcon = new TrayIcon(icon);
            SystemTray tray = SystemTray.getSystemTray();

            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                System.out.println("Tray notification could not be added");
            }

            trayIcon.displayMessage("PoEOnlineNotifier", charName + " has logged " + message + ".",
                    TrayIcon.MessageType.INFO);
        } else {
            System.out.println("Tray notifications are not supported");
        }
    }
}
