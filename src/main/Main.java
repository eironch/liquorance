package main;

import asset.AssetFactory;
import component.ComponentFactory;
import panel.PanelFactory;
import page.LandingPage;

import javax.swing.*;

public class Main {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 800;
    final static PanelFactory panelFactory = new PanelFactory();
    final static ComponentFactory componentFactory = new ComponentFactory();
    final static AssetFactory assetFactory = new AssetFactory();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LandingPage(panelFactory, componentFactory, assetFactory));
    }
}