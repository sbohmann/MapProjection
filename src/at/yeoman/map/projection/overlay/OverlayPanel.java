package at.yeoman.map.projection.overlay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;

class OverlayPanel extends JPanel {
    private BufferedImage buffer;

    OverlayPanel() {
        createBuffer();

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                resized();
            }
        });
    }

    private void resized() {
        if (buffer == null || getWidth() != buffer.getWidth() || getHeight() != buffer.getHeight()) {
            createBuffer();
        }
    }

    @Override
    public void paint(Graphics rawContext) {
        Graphics2D g = (Graphics2D) rawContext;
        fillBackgroundIfNecessary(g);
        paintBuffer(g);
    }

    private void fillBackgroundIfNecessary(Graphics g) {
        if (insufficientBufferSize()) {
            g.setColor(Color.darkGray);
            g.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    private boolean insufficientBufferSize() {
        return buffer == null ||
                buffer.getWidth() < getWidth() ||
                buffer.getHeight() < getHeight();
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
            buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        } else {
            buffer = null;
        }
    }
}
