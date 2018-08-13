package at.yeoman.map.projection.overlay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;

class OverlayPanel extends JPanel {
    private final BufferedImage mercatorMap;
    private BufferedImage buffer;

    OverlayPanel(BufferedImage mercatorMap) {
        this.mercatorMap = mercatorMap;
        createBuffer();
    }

    @Override
    public void paint(Graphics rawContext) {
        Graphics2D g = (Graphics2D) rawContext;
        recreateBufferIfNecessary();
        paintBuffer(g);
    }

    private void recreateBufferIfNecessary() {
        if (buffer == null || getWidth() != buffer.getWidth() || getHeight() != buffer.getHeight()) {
            createBuffer();
        }
    }

    private void paintBuffer(Graphics2D g) {
        if (buffer != null) {
            paintExistingBuffer(g);
        }
    }

    private void paintExistingBuffer(Graphics2D g) {
        RenderingHints.set(g);
        int x = (getWidth() - buffer.getWidth()) / 2;
        int y = (getHeight() - buffer.getHeight()) / 2;
        g.drawImage(buffer, x, y, null);
    }

    private void createBuffer() {
        if (getWidth() > 0 && getHeight() > 0) {
            SwingUtilities.invokeLater(this::createAndPaintBuffer);
        } else {
            buffer = null;
        }
    }

    private void createAndPaintBuffer() {
        buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        new OverlayPainter(mercatorMap, buffer).run();
        repaint();
    }
}
