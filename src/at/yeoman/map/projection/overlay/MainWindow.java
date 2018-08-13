package at.yeoman.map.projection.overlay;

import javax.swing.*;
import java.awt.image.BufferedImage;

class MainWindow {
    private JFrame jframe;

    MainWindow(BufferedImage mercatorMap) {
        jframe = new JFrame();
        jframe.setContentPane(new MainPanel(mercatorMap).getView());
    }

    void show() {
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}
