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
        SwingUtilities.invokeLater(() -> {
            new menuView(
                    databaseManager, panelFactory, componentFactory,
                    assetFactory).setVisible(true);
//            new liquorView(
//                    databaseManager, panelFactory, componentFactory,
//                    assetFactory).setVisible(true);
        });
    }
}