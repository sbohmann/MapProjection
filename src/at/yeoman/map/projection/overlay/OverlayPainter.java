package at.yeoman.map.projection.overlay;

import at.yeoman.map.projection.Painter;

import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

class OverlayPainter extends Painter {
    private BufferedImage mercatorMap;

    OverlayPainter(BufferedImage mercatorMap, BufferedImage buffer) {
        super(buffer);
        this.mercatorMap = mercatorMap;
    }

    void run() {
        g.drawImage(mercatorMap, 0, 0, width, height, null);
        int angleSteps = 6;
        for (int angleStep = 0; angleStep < angleSteps; ++angleStep) {
            double angle = angleStep * Math.PI / 2.0 / angleSteps;
            //drawLine()
        }
    }
}
