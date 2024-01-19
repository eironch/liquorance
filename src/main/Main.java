package main;

import asset.AssetFactory;
import view.LiquorView;
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
    static MenuView menuView;
    static ConfirmView confirmView;
    static LiquorView liquorView;
    static QueueView queueView;
    static TitleView titleView;
    static AssetFactory a = new AssetFactory();
    static JFrame frame = new JFrame();
    static JPanel views = new JPanel();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            frame.add(views);
            frame.setIconImage(a.logoIcon.getImage());
            frame.setBounds(320, 140, Main.WIDTH, Main.HEIGHT);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//          frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setUndecorated(true);
            frame.setResizable(false);
            frame.setVisible(true);

            menuView = new MenuView(frame);
            confirmView = new ConfirmView(frame);
            liquorView = new LiquorView(frame);
            queueView = new QueueView(frame);
            titleView = new TitleView(frame);

            views.setLayout(new CardLayout());
            views.add(titleView.contentPanel, "title");
            views.add(menuView.contentPanel, "menu");
            views.add(confirmView.contentPanel, "confirm");
            views.add(liquorView.contentPanel, "liquor");
            views.add(queueView.contentPanel, "queue");

            showTitleView();
        });
    }

    public static void showTitleView() {
        CardLayout cardLayout = (CardLayout) views.getLayout();
        cardLayout.show(views, "title");
    }

    public static void showMenuView() {
        CardLayout cardLayout = (CardLayout) views.getLayout();
        cardLayout.show(views, "menu");
    }

    public static void showMenuView(LinkedList<LinkedList<Object>> orderInfoList) {
        CardLayout cardLayout = (CardLayout) views.getLayout();
        cardLayout.show(views, "menu");

        menuView.updateOrder(orderInfoList);
    }

    public static void showLiquorView(LinkedList<LinkedList<Object>> orderList, int menuID) {
        CardLayout cardLayout = (CardLayout) views.getLayout();

        liquorView.showLiquor(orderList, menuID);

        cardLayout.show(views, "liquor");
    }

    public static void showConfirmView(LinkedList<LinkedList<Object>> orderList) {
        CardLayout cardLayout = (CardLayout) views.getLayout();

        confirmView.showOrder(orderList);

        cardLayout.show(views, "confirm");
    }

    public static void showQueueView(LinkedList<LinkedList<Object>> orderInfoList, int orderTotal) {
        CardLayout cardLayout = (CardLayout) views.getLayout();

        queueView.processOrder(orderInfoList, orderTotal);

        cardLayout.show(views, "queue");
    }

    public static void clearAllLists() {
        menuView.clearLists();
        liquorView.clearLists();
        confirmView.clearLists();
    }
}