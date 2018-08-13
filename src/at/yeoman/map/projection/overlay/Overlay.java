package at.yeoman.map.projection.overlay;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Overlay {
    public static void main(String[] args) throws Exception {
        new Overlay().run();
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
        new MainWindow(loadMercatorMap()).show();
    }

    private BufferedImage loadMercatorMap() throws IOException {
        return ImageIO.read(new File("big mercator map.jpg"));
    }
}
