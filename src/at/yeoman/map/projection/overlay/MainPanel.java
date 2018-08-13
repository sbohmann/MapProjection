package at.yeoman.map.projection.overlay;

import java.awt.*;
import java.awt.image.BufferedImage;

class MainPanel extends Container {
    private OverlayPanel mainView;

    MainPanel(BufferedImage mercatorMap) {
        mainView = new OverlayPanel(mercatorMap);
        mainView.setPreferredSize(new Dimension(800, 600));
    }

    Container getView() {
        return mainView;
    }
}
