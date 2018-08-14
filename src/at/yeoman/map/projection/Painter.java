package at.yeoman.map.projection;

import at.yeoman.map.rendering.HighQualityRenderingHints;

import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

public abstract class Painter {
    protected final int width;
    protected final int height;
    protected final Graphics2D g;
    protected final double centerX;
    protected final double centerY;

    protected Painter(BufferedImage buffer) {
        width = buffer.getWidth();
        height = buffer.getHeight();
        centerX = width / 2.0;
        centerY = height / 2.0;
        g = buffer.createGraphics();
        HighQualityRenderingHints.set(g);
    }

    protected void drawLine(double x1, double y1, double x2, double y2) {
        g.draw(new Line2D.Double(x1, y1, x2, y2));
    }
}
