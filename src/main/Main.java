package main;

import database.DatabaseManager;
import asset.AssetFactory;
import component.ComponentFactory;
import panel.PanelFactory;
import quantity.LiquorView;
import view.ConfirmView;
import view.MenuView;
import view.QueueView;
import view.TitleView;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Main {
    public static final int WIDTH = 1280;
    public static final int HEIGHT = 800;
    final static DatabaseManager databaseManager = new DatabaseManager();
    final static PanelFactory panelFactory = new PanelFactory();
    final static ComponentFactory componentFactory = new ComponentFactory();
    final static AssetFactory assetFactory = new AssetFactory();
    static MenuView menuView;
    static ConfirmView confirmView;
    static LiquorView liquorView;
    static QueueView queueView;
    static TitleView titleView;
    static JFrame frame = new JFrame();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            menuView = new MenuView(frame);
            confirmView = new ConfirmView(frame);
            liquorView = new LiquorView(frame);
            queueView = new QueueView(frame);
            titleView = new TitleView(frame);

//            showMenuView();
//            showConfirmView();
            showTitleView();

            frame.setBounds(320, 140, Main.WIDTH, Main.HEIGHT);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//          frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setUndecorated(true);
            frame.setResizable(false);
            frame.setVisible(true);
        });
    }

    public static void showTitleView() {
        frame.getContentPane().removeAll();
        frame.add(titleView.contentPanel);
//        titleView.showOrderNumber();
        repaint(frame.getContentPane());
    }

    public static void showMenuView() {
        frame.getContentPane().removeAll();
        frame.add(menuView.contentPanel);
        repaint(frame.getContentPane());
    }

    public static void showMenuView(LinkedList<LinkedList<Object>> orderInfoList) {
        frame.getContentPane().removeAll();
        frame.add(menuView.contentPanel);
        menuView.updateOrder(orderInfoList);
        repaint(frame);
    }

    public static void showLiquorView(LinkedList<LinkedList<Object>> orderList, int menuID) {
        frame.getContentPane().removeAll();
        frame.add(liquorView.contentPanel);
        liquorView.showLiquor(orderList, menuID);
        repaint(frame);
    }

    public static void showConfirmView() {
        frame.getContentPane().removeAll();
        frame.add(confirmView.contentPanel);
        repaint(frame);
    }

    public static void showConfirmView(LinkedList<LinkedList<Object>> orderList) {
        frame.getContentPane().removeAll();
        frame.add(confirmView.contentPanel);
        confirmView.showOrder(orderList);
        repaint(frame);
    }

    public static void showQueueView(LinkedList<LinkedList<Object>> orderInfoList, int orderTotal) {
        frame.getContentPane().removeAll();
        frame.add(queueView.contentPanel);
        queueView.processOrder(orderInfoList, orderTotal);
        repaint(frame);
    }

    public static void clearAllLists() {
        menuView.clearLists();
        liquorView.clearLists();
        confirmView.clearLists();
    }

    public static void repaint(Component component){
        SwingUtilities.invokeLater(() -> {
            component.revalidate();
            component.repaint();
        });
    }
}