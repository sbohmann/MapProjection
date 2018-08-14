package at.yeoman.map.projection.overlay;

import at.yeoman.map.projection.Painter;

import java.awt.*;
import java.awt.image.BufferedImage;

import static at.yeoman.map.projection.MercatorProjection.yForLatitude;

class OverlayPainter extends Painter {
    private BufferedImage mercatorMap;

    OverlayPainter(BufferedImage mercatorMap, BufferedImage buffer) {
        super(buffer);
        this.mercatorMap = mercatorMap;
    }

    void run() {
        g.drawImage(mercatorMap, 0, 0, width, height, null);
        g.setColor(Color.red);
        int angleSteps = 6;
        double scale = 0.1863;
        for (int angleStep = 0; angleStep < angleSteps; ++angleStep) {
            double angle = angleStep * Math.PI / 2.0 / angleSteps;
            double fy = yForLatitude(angle);
            double yOffset = fy * scale * height;
            double y = centerY - yOffset;
            drawLine(0, y, width, y);
            if (angleStep > 0) {
                y = centerY + yOffset;
                drawLine(0, y, width, y);
            }
        }
    }
}
