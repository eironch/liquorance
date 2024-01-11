package view;

import asset.AssetFactory;
import component.ComponentFactory;
import database.DatabaseManager;
import main.Main;
import panel.PanelFactory;

import javax.swing.*;
import java.awt.*;

public class LiquorView extends JFrame {
    DatabaseManager d;
    PanelFactory p;
    ComponentFactory c;
    AssetFactory a;
    JPanel contentPanel = new JPanel();

    public LiquorView(DatabaseManager databaseManager, PanelFactory panelFactory,
                      ComponentFactory componentFactory, AssetFactory assetFactory) {
        this.d = databaseManager;
        p = new PanelFactory();
        this.c = componentFactory;
        this.a = assetFactory;

        p.handleLiquorView();

        p.headerContainerList.get(0).add(c.changeViewButton);
        p.headerContainerList.get(1).add(c.titleText);
        p.headerContainerList.get(2).add(c.orderButton);

        for (int i = 0; i < p.headerContainerList.size(); i++) {
            p.headerPanel.add(p.headerContainerList.get(i));
        }

        contentPanel.add(p.headerPanel, BorderLayout.NORTH);
        contentPanel.add(p.bodyPanel, BorderLayout.CENTER);

        this.add(contentPanel);

        this.setBounds(320, 140, Main.WIDTH, Main.HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setResizable(false);
    }
}
