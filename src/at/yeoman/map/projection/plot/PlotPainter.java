package at.yeoman.map.projection.plot;

import at.yeoman.map.rendering.HighQualityRenderingHints;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.util.function.Function;

class PlotPainter {
    private static final double ScalingFactor = 250.0;

    private final int width;
    private final int height;
    private final Graphics2D g;
    private final double centerX;
    private final double centerY;

    PlotPainter(BufferedImage buffer) {
        width = buffer.getWidth();
        height = buffer.getHeight();
        centerX = width / 2.0;
        centerY = height / 2.0;
        g = buffer.createGraphics();
        HighQualityRenderingHints.set(g);
    }

    void run() {
        drawLine(0, centerY, width, centerY);
        drawLine(centerX, 0, centerX, height);
        drawGraph(Color.red, x -> Math.log(1.0 / Math.cos(x) + Math.sin(x) / Math.cos(x)));
        drawGraph(new Color(0x99ffff00, true), x -> Math.atan(Math.sinh(x)));
    }

    private void drawLine(double x1, double y1, double x2, double y2) {
        g.draw(new Line2D.Double(x1, y1, x2, y2));
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
