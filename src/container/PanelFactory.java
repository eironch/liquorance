package container;

import main.Main;
import javax.swing.*;
import java.awt.*;

public class PanelFactory {
    public JPanel content = new JPanel();
    public JPanel headerContainer = new JPanel();

    public PanelFactory() {
        content.setLayout(new BorderLayout(0, 0));

        headerContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        headerContainer.setPreferredSize(new Dimension(Main.WIDTH, 100));
        headerContainer.setBackground(Color.CYAN);
    }
}
