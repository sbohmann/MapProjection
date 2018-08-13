package at.yeoman.map.projection.overlay;

import javax.swing.*;

public class Overlay {
    public static void main(String[] args) throws Exception {
        new Overlay().run();
    }

    private void run() throws Exception {
        SwingUtilities.invokeAndWait(this::setup);
    }

    private void setup() {
        new MainWindow().show();
    }
}
