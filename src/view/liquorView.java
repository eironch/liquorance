package view;

import asset.AssetFactory;
import component.ComponentFactory;
import database.DatabaseManager;
import main.Main;
import panel.PanelFactory;

import javax.swing.*;
import java.awt.*;

public class liquorView extends JFrame {
    DatabaseManager dm;
    PanelFactory pf;
    ComponentFactory cf;
    AssetFactory af;

    public liquorView(DatabaseManager databaseManager, PanelFactory panelFactory,
                      ComponentFactory componentFactory, AssetFactory assetFactory) {
        this.dm = databaseManager;
        this.pf = panelFactory;
        this.cf = componentFactory;
        this.af = assetFactory;

        pf.handleLiquorView();

        pf.headerContainerList.get(0).add(cf.changeViewButton);
        pf.headerContainerList.get(1).add(cf.titleText);
        pf.headerContainerList.get(2).add(cf.orderButton);

        for (int i = 0; i < pf.headerContainerList.size(); i++) {
            pf.headerPanel.add(pf.headerContainerList.get(i));
        }

        pf.contentPanel.add(pf.headerPanel, BorderLayout.NORTH);
        pf.contentPanel.add(pf.bodyPanel, BorderLayout.CENTER);

        this.add(pf.contentPanel);

        this.setBounds(320, 140, Main.WIDTH, Main.HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setResizable(false);
    }
}
