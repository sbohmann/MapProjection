package at.yeoman.map.projection.plot;

import java.awt.*;
import java.awt.image.BufferedImage;

class MainPanel extends Container {
    private PlotPanel mainView;

    MainPanel() {
        mainView = new PlotPanel();
        mainView.setPreferredSize(new Dimension(1600, 1200));
    }

    Container getView() {
        return mainView;
    }
}
