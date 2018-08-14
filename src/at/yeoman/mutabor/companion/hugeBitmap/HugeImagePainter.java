package at.yeoman.mutabor.companion.hugeBitmap;

import at.yeoman.map.projection.Painter;

import java.awt.image.BufferedImage;

class HugeImagePainter extends Painter {
    HugeImagePainter(BufferedImage buffer) {
        super(buffer);
    }

    void run() {
        int steps = Math.min(width, height) / 25;
        for (double step = 0; step <= steps; ++step) {
            double x = (double) width / steps * step;
            double y = (double) height / steps * step;
            drawLine(x, 0, width, y);
            drawLine(x, height, width, height - y);
            drawLine(x, 0, 0, height - y);
            drawLine(x, height, 0, y);
        }
    }
}
