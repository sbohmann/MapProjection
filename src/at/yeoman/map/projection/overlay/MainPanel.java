package at.yeoman.map.projection.overlay;

import java.awt.*;
import java.awt.image.BufferedImage;

class MainPanel extends Container {
    private OverlayPanel mainView;

    MainPanel() {
        mainView = new OverlayPanel();
        mainView.setPreferredSize(new Dimension(1200, 1200));
    }

    Container getView() {
        return mainView;
    }
}
