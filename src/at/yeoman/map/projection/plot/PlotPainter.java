package at.yeoman.map.projection.plot;

import java.awt.*;
import java.awt.image.BufferedImage;

class PlotPainter {
    private BufferedImage mercatorMap;
    private final int width;
    private final int height;
    private final Graphics2D g;

    PlotPainter(BufferedImage buffer) {
        width = buffer.getWidth();
        height = buffer.getHeight();
        g = buffer.createGraphics();
    }

    void run() {
        g.drawImage(mercatorMap, 0, 0, width, height, null);
    }
}
