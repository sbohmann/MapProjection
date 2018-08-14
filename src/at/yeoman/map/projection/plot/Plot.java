package at.yeoman.map.projection.plot;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Plot {
    public static void main(String[] args) throws Exception {
        new Plot().run();
    }

    private void run() throws Exception {
        SwingUtilities.invokeAndWait(this::setup);
    }

    private void setup() {
        try {
            setupThrowing();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    private void setupThrowing() throws IOException {
        new MainWindow().show();
    }
}
