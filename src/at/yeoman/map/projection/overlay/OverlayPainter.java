package at.yeoman.map.projection.overlay;

import java.awt.*;
import java.awt.image.BufferedImage;

class OverlayPainter {
    private BufferedImage mercatorMap;
    private final int width;
    private final int height;
    private final Graphics2D g;

    OverlayPainter(BufferedImage mercatorMap, BufferedImage buffer) {
        this.mercatorMap = mercatorMap;
        width = buffer.getWidth();
        height = buffer.getHeight();
        g = buffer.createGraphics();
    }

    void run() {
        g.drawImage(mercatorMap, 0, 0, width, height, null);
    }
}
