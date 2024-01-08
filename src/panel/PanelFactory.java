package panel;

import main.Main;
import javax.swing.*;
import java.awt.*;

public class PanelFactory {
    public JPanel content = new JPanel();
    public JPanel headerContainer = new JPanel();

    public PanelFactory() {
        content.setLayout(new BorderLayout(0, 0));
        content.setBackground(Color.LIGHT_GRAY);

        headerContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        headerContainer.setPreferredSize(new Dimension(Main.WIDTH, 80));
        headerContainer.setBackground(Color.DARK_GRAY);
    }
}
