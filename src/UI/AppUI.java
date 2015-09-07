package UI;

import Model.App;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brandon on 2015-09-06.
 */
public class AppUI extends JFrame {

    private App app;
    private List<StatusBar> bars;
    private boolean keepRunning;

    public AppUI() {
        app = new App();
        bars = new ArrayList<>();
        keepRunning = false;
    }
}
