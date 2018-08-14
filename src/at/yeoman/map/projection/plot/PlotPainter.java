package at.yeoman.map.projection.plot;

import at.yeoman.map.projection.Painter;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.function.Function;

import static at.yeoman.map.projection.MercatorProjection.latitudeForY;
import static at.yeoman.map.projection.MercatorProjection.yForLatitude;

class PlotPainter extends Painter {
    private static final double ScalingFactor = 250.0;

    PlotPainter(BufferedImage buffer) {
        super(buffer);
    }

    void run() {
        drawLine(0, centerY, width, centerY);
        drawLine(centerX, 0, centerX, height);
        drawGraph(Color.red, x -> yForLatitude(x));
        drawGraph(new Color(0x99ffff00, true), x -> latitudeForY(x));
    }

    private void drawGraph(Color color, Function<Double,Double> function) {
        g.setColor(color);
        double lastX = 0;
        double lastY = 0;
        boolean first = true;
        for (double x = 0.5; x < width; x += 1.0) {
            double fx = (x - centerX) / ScalingFactor;
            double fy = function.apply(fx);
            double y = centerY - ScalingFactor * fy;
            if (!first) {
                drawLine(lastX, lastY, x, y);
            }
            lastX = x;
            lastY = y;
            first = false;
        }
    }
}
