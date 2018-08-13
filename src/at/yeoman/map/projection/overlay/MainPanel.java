package at.yeoman.map.projection.overlay;

import javax.swing.*;
import java.awt.*;

class MainPanel extends Container {
    private OverlayPanel mainView;

    MainPanel() {
        mainView = new OverlayPanel();

    }

    Container getView() {
        return mainView;
    }
}
