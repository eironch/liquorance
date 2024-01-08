package page;

import main.Main;
import asset.AssetFactory;
import component.ComponentFactory;
import panel.PanelFactory;
import javax.swing.*;
import java.awt.*;

public class LandingPage extends JFrame {
    PanelFactory pf;
    ComponentFactory cf;
    AssetFactory af;

    public LandingPage(PanelFactory panelFactory,
                       ComponentFactory componentFactory,
                       AssetFactory assetFactory) {
        this.pf = panelFactory;
        this.cf = componentFactory;
        this.af = assetFactory;

        pf.headerPanel.add(cf.titleText);

        for (int i = 0; i < cf.catalogButtonList.size(); i++) {
            pf.catalogContainerList.get(i).add(cf.catalogButtonList.get(i));
            pf.catalogContainerList.get(i).add(cf.catalogNameList.get(i));
        }

        pf.catalogRowContainerList.get(0).add(pf.catalogContainerList.get(0));
        pf.catalogRowContainerList.get(0).add(pf.catalogContainerList.get(1));
        pf.catalogRowContainerList.get(0).add(pf.catalogContainerList.get(2));
        pf.catalogRowContainerList.get(0).add(pf.catalogContainerList.get(3));

        pf.catalogRowContainerList.get(1).add(pf.catalogContainerList.get(4));
        pf.catalogRowContainerList.get(1).add(pf.catalogContainerList.get(5));
        pf.catalogRowContainerList.get(1).add(pf.catalogContainerList.get(6));
        pf.catalogRowContainerList.get(1).add(pf.catalogContainerList.get(7));

        pf.bodyPanel.add(pf.catalogRowContainerList.get(0));
        pf.bodyPanel.add(pf.catalogRowContainerList.get(1));

        pf.content.add(pf.headerPanel, BorderLayout.NORTH);
        pf.content.add(pf.bodyPanel, BorderLayout.CENTER);
        pf.content.add(pf.footerPanel, BorderLayout.SOUTH);

        this.add(pf.content);

        this.setBounds(320, 140, Main.WIDTH, Main.HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setVisible(true);
    }
}
