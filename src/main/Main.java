package main;

import database.DatabaseManager;
import asset.AssetFactory;
import component.ComponentFactory;
import panel.PanelFactory;
import view.ConfirmView;
import view.MenuView;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 800;
    final static DatabaseManager databaseManager = new DatabaseManager();
    final static PanelFactory panelFactory = new PanelFactory();
    final static ComponentFactory componentFactory = new ComponentFactory();
    final static AssetFactory assetFactory = new AssetFactory();
    static MenuView menuView;
    static ConfirmView confirmView;
    static JFrame frame = new JFrame();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            menuView = new MenuView(frame);
            confirmView = new ConfirmView(frame);

//            showMenuView();
            showConfirmView();
            frame.setBounds(320, 140, Main.WIDTH, Main.HEIGHT);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//          frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setUndecorated(true);
            frame.setResizable(false);
            frame.setVisible(true);
        });
    }

    public static void showMenuView() {
        frame.getContentPane().removeAll();
        frame.add(menuView.contentPanel);
        repaint(frame.getContentPane());
    }

    public static void showConfirmView() {
        frame.getContentPane().removeAll();
        frame.add(confirmView.contentPanel);
        repaint(frame.getContentPane());
    }

    public static void repaint(Component component){
        SwingUtilities.invokeLater(() -> {
            component.revalidate();
            component.repaint();
        });
    }
}