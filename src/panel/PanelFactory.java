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
    public ArrayList<Container> headerContainerList = new ArrayList<>();
    public ArrayList<Container> catalogRowContainerList = new ArrayList<>();
    public ArrayList<Container> catalogContainerList = new ArrayList<>();
    public ArrayList<Container> categoryContainerList = new ArrayList<>();

    public PanelFactory() {
        contentPanel.setLayout(new BorderLayout(0, 0));

        headerPanel.setLayout(new GridLayout(1, 3, 0, 0));
        headerPanel.setPreferredSize(new Dimension(Main.WIDTH, 80));
        headerPanel.setBackground(Color.DARK_GRAY);

        bodyPanel.setLayout(new GridLayout(2, 1, 0,0));
        bodyPanel.setPreferredSize(new Dimension(Main.WIDTH, 200));
        bodyPanel.setBackground(Color.LIGHT_GRAY);

        footerPanel.setLayout(new GridLayout(1, 4, 0, 0));
        footerPanel.setPreferredSize(new Dimension(Main.WIDTH, 80));
        footerPanel.setBackground(Color.DARK_GRAY);

        headerContainerList.add(new Container());
        headerContainerList.get(0).setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        headerContainerList.add(new Container());
        headerContainerList.get(1).setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        headerContainerList.add(new Container());
        headerContainerList.get(2).setLayout(new FlowLayout(FlowLayout.TRAILING, 10, 10));

        for (int i = 0; i < 2; i++) {
            catalogRowContainerList.add(new Container());
            catalogRowContainerList.get(i).setLayout(new GridLayout(1, 4, 0, 0));
        }

        for (int i = 0; i < 8; i++) {
            catalogContainerList.add(new Container());
            catalogContainerList.get(i).setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        }

        for (int i = 0; i < 5; i++) {
            categoryContainerList.add(new Container());
            categoryContainerList.get(i).setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        }
    }
}
