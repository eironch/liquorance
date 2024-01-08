package panel;

import main.Main;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelFactory {
    public JPanel contentPanel = new JPanel();
    public JPanel headerPanel = new JPanel();
    public JPanel bodyPanel = new JPanel();
    public JPanel footerPanel = new JPanel();
    public ArrayList<Container> catalogRowContainerList = new ArrayList<>();
    public ArrayList<Container> catalogContainerList = new ArrayList<>();

    public PanelFactory() {
        contentPanel.setLayout(new BorderLayout(0, 0));

        headerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        headerPanel.setPreferredSize(new Dimension(Main.WIDTH, 80));
        headerPanel.setBackground(Color.DARK_GRAY);

        bodyPanel.setLayout(new GridLayout(2, 1, 0,0));
        bodyPanel.setPreferredSize(new Dimension(Main.WIDTH, 200));
        bodyPanel.setBackground(Color.LIGHT_GRAY);

        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        footerPanel.setPreferredSize(new Dimension(Main.WIDTH, 80));
        footerPanel.setBackground(Color.DARK_GRAY);

        for (int i = 0; i < 2; i++) {
            catalogRowContainerList.add(new Container());
            catalogRowContainerList.get(i).setLayout(new GridLayout(1, 4, 0, 0));
        }

        for (int i = 0; i < 8; i++) {
            catalogContainerList.add(new Container());
            catalogContainerList.get(i).setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        }
    }
}
