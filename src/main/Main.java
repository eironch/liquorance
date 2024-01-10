package main;

import database.DatabaseManager;
import asset.AssetFactory;
import component.ComponentFactory;
import view.liquorView;
import panel.PanelFactory;
import view.menuView;

import javax.swing.*;

public class Main {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 800;
    final static DatabaseManager databaseManager = new DatabaseManager();
    final static PanelFactory panelFactory = new PanelFactory();
    final static ComponentFactory componentFactory = new ComponentFactory();
    final static AssetFactory assetFactory = new AssetFactory();

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        SwingUtilities.invokeLater(() -> {
            new menuView(frame, databaseManager,
                    panelFactory, componentFactory,
                    assetFactory);
//            new liquorView(
//                    databaseManager, panelFactory, componentFactory,
//                    assetFactory).setVisible(true);

            frame.setBounds(320, 140, Main.WIDTH, Main.HEIGHT);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//          frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setUndecorated(true);
            frame.setResizable(false);
            frame.setVisible(true);
        });
    }
}