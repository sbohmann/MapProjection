package at.yeoman.map.projection.plot;

import javax.swing.*;
import java.awt.image.BufferedImage;

class MainWindow {
    private JFrame jframe;

    MainWindow() {
        jframe = new JFrame();
        jframe.setContentPane(new MainPanel().getView());
    }

    void show() {
        jframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        jframe.pack();
        jframe.setLocationRelativeTo(null);
        jframe.setVisible(true);
    }
}
