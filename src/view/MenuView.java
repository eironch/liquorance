package view;

import database.DatabaseManager;
import asset.AssetFactory;
import component.ComponentFactory;
import main.Main;
import panel.PanelFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.LinkedList;

public class MenuView {
    JFrame f;
    DatabaseManager d = new DatabaseManager();
    PanelFactory p = new PanelFactory();
    ComponentFactory c = new ComponentFactory();
    AssetFactory a = new AssetFactory();
    public JPanel contentPanel = new JPanel();
    Category currentCategory = Category.BEER;
    String[] categoryList = {"Beer", "Cocktail", "Wine", "Whiskey", "Rum"};
    LinkedList<LinkedList<Object>> liquorMenuList = new LinkedList<>();
    LinkedList<LinkedList<Object>> orderList = new LinkedList<>();

    public MenuView(JFrame frame) {
        this.f = frame;

        p.handleMenuView();
        c.handleMenuView();

        contentPanel.setLayout(new BorderLayout(0, 0));

        c.orderButton.addActionListener(this::confirmOrder);

        p.headerContainerList.get(0).add(c.changeViewButton);
        p.headerContainerList.get(1).add(c.titleText);
        p.headerContainerList.get(2).add(c.orderButton);

        for (int i = 0; i < p.headerContainerList.size(); i++) {
            p.headerPanel.add(p.headerContainerList.get(i));
        }

        handleMenuViewButton();
        updateContent();

        for (int i = 0; i < c.liquorMenuButtonList.size(); i++) {
            c.liquorMenuButtonList.get(i).addActionListener(this::addToOrder);
        }

        p.catalogRowContainerList.get(0).add(p.liquorMenuContainerList.get(0));
        p.catalogRowContainerList.get(0).add(p.liquorMenuContainerList.get(1));
        p.catalogRowContainerList.get(0).add(p.liquorMenuContainerList.get(2));
        p.catalogRowContainerList.get(0).add(p.liquorMenuContainerList.get(3));

        p.catalogRowContainerList.get(1).add(p.liquorMenuContainerList.get(4));
        p.catalogRowContainerList.get(1).add(p.liquorMenuContainerList.get(5));
        p.catalogRowContainerList.get(1).add(p.liquorMenuContainerList.get(6));
        p.catalogRowContainerList.get(1).add(p.liquorMenuContainerList.get(7));

        p.bodyPanel.add(p.catalogRowContainerList.get(0));
        p.bodyPanel.add(p.catalogRowContainerList.get(1));

        for (int i = 0; i < c.categoryButtonList.size(); i++) {
            p.categoryContainerList.get(i).add(c.categoryButtonList.get(i));
            c.categoryButtonList.get(i).addActionListener(this::changeCategory);
        }

        for (int i = 0; i < p.categoryContainerList.size(); i++) {
            p.footerPanel.add(p.categoryContainerList.get(i));
        }

        contentPanel.add(p.headerPanel, BorderLayout.NORTH);
        contentPanel.add(p.bodyPanel, BorderLayout.CENTER);
        contentPanel.add(p.footerPanel, BorderLayout.SOUTH);
    }

    public void handleMenuViewButton() {
        for (int i = 0; i < c.liquorMenuButtonList.size(); i++) {
            int catalogID = 0;

            p.liquorMenuContainerList.get(i).add(c.liquorMenuButtonList.get(i));
            p.liquorMenuContainerList.get(i).add(c.liquorMenuNameList.get(i));

            liquorMenuList.add(new LinkedList<>(Arrays.asList(
                    p.liquorMenuContainerList.get(i), // 0
                    c.liquorMenuButtonList.get(i), // 1
                    c.liquorMenuNameList.get(i), // 2
                    catalogID // 3
            )));
        }
    }

    public void changeCategory(ActionEvent e) {
        Component component = (Component) e.getSource();
        int newID = 0;

        if(component == c.categoryButtonList.get(0)) {
            currentCategory = Category.BEER;
            newID = 0;
        } else if(component == c.categoryButtonList.get(1)) {
            currentCategory = Category.COCKTAIL;
            newID = 1;
        } else if(component == c.categoryButtonList.get(2)) {
            currentCategory = Category.RUM;
            newID = 2;
        } else if(component == c.categoryButtonList.get(3)) {
            currentCategory = Category.WHISKEY;
            newID = 3;
        } else if(component == c.categoryButtonList.get(4)) {
            currentCategory = Category.WINE;
            newID = 4;
        }

        for (LinkedList<Object> catalog : liquorMenuList) {
            catalog.set(catalog.size() - 1, newID);
        }

        updateContent();
    }

    public void updateContent() {
        String categoryName;

        switch (currentCategory) {
            case BEER -> categoryName = "Beer";
            case COCKTAIL -> categoryName = "Cocktail";
            case RUM -> categoryName = "Rum";
            case WHISKEY -> categoryName = "Whiskey";
            case WINE -> categoryName = "Wine";
            default -> categoryName = "";
        }

        for (int i = 0; i < c.liquorMenuButtonList.size(); i++) {
            c.liquorMenuButtonList.get(i).setText(categoryName + " " + i + " Button");
            c.liquorMenuNameList.get(i).setText(categoryName + " " + i + " Name");
        }

        repaint(contentPanel);
    }

    public void addToOrder(ActionEvent e) {
        Component component = (Component) e.getSource();
        int orderCount = 0;

        for (int i = 0; i < c.liquorMenuButtonList.size(); i++) {
            if (!liquorMenuList.get(i).contains(component)) {
                continue;
            }

            JLabel liquorName = (JLabel) liquorMenuList.get(i).get(2);

            for (LinkedList<Object> objects : orderList) {
                if (!objects.contains(liquorName.getText())) {
                    continue;
                }

                int newOrderCount = (int) objects.getLast();

                objects.set(2, ++newOrderCount);

                return;
            }

            orderList.add(new LinkedList<>(Arrays.asList(
                    liquorMenuList.get(i).getLast(),
                    liquorName.getText(),
                    ++orderCount
            )));

            return;
        }
    }

    public void confirmOrder (ActionEvent e) {
        f.remove(contentPanel);
        Main.showConfirmView(orderList);
        repaint(f);
    }

    public void repaint(Component component){
        SwingUtilities.invokeLater(() -> {
            component.revalidate();
            component.repaint();
        });
    }

    enum Category {
        BEER,
        COCKTAIL,
        RUM,
        WHISKEY,
        WINE
    }
}
