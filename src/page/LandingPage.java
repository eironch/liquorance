package page;

import main.Main;
import asset.AssetFactory;
import component.ComponentFactory;
import container.PanelFactory;
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

        pf.content.add(pf.headerContainer, BorderLayout.NORTH);

        this.add(pf.content);

        this.setBounds(-10, 140, Main.WIDTH, Main.HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setVisible(true);
    }
}
