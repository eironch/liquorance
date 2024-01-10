package view;

import database.DatabaseManager;
import asset.AssetFactory;
import component.ComponentFactory;
import panel.PanelFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.LinkedList;

public class menuView {
    JFrame f;
    DatabaseManager d;
    PanelFactory p;
    ComponentFactory c;
    AssetFactory a;
    Category currentCategory = Category.BEER;
    String[] categoryList = {"Beer", "Cocktail", "Wine", "Whiskey", "Rum"};
    LinkedList<LinkedList<Object>> catalogList = new LinkedList<>();
    LinkedList<LinkedList<Object>> orderList = new LinkedList<>();

    public menuView(JFrame frame, DatabaseManager databaseManager, PanelFactory panelFactory,
                    ComponentFactory componentFactory, AssetFactory assetFactory) {
        this.f = frame;
        this.d = databaseManager;
        this.p = panelFactory;
        this.c = componentFactory;
        this.a = assetFactory;

        p.handleMenuView();

        c.orderButton.addActionListener(this::confirmOrder);

        p.headerContainerList.get(0).add(c.changeViewButton);
        p.headerContainerList.get(1).add(c.titleText);
        p.headerContainerList.get(2).add(c.orderButton);

        for (int i = 0; i < p.headerContainerList.size(); i++) {
            p.headerPanel.add(p.headerContainerList.get(i));
        }

        handleMenuViewButton();
        updateContent();

        for (int i = 0; i < c.catalogButtonList.size(); i++) {
            c.catalogButtonList.get(i).addActionListener(this::addToOrder);
        }

        p.catalogRowContainerList.get(0).add(p.catalogContainerList.get(0));
        p.catalogRowContainerList.get(0).add(p.catalogContainerList.get(1));
        p.catalogRowContainerList.get(0).add(p.catalogContainerList.get(2));
        p.catalogRowContainerList.get(0).add(p.catalogContainerList.get(3));

        p.catalogRowContainerList.get(1).add(p.catalogContainerList.get(4));
        p.catalogRowContainerList.get(1).add(p.catalogContainerList.get(5));
        p.catalogRowContainerList.get(1).add(p.catalogContainerList.get(6));
        p.catalogRowContainerList.get(1).add(p.catalogContainerList.get(7));

        p.bodyPanel.add(p.catalogRowContainerList.get(0));
        p.bodyPanel.add(p.catalogRowContainerList.get(1));

        for (int i = 0; i < c.categoryButtonList.size(); i++) {
            p.categoryContainerList.get(i).add(c.categoryButtonList.get(i));
            c.categoryButtonList.get(i).addActionListener(this::changeCategory);
        }

        for (int i = 0; i < p.categoryContainerList.size(); i++) {
            p.footerPanel.add(p.categoryContainerList.get(i));
        }

        p.contentPanel.add(p.headerPanel, BorderLayout.NORTH);
        p.contentPanel.add(p.bodyPanel, BorderLayout.CENTER);
        p.contentPanel.add(p.footerPanel, BorderLayout.SOUTH);

        f.add(p.contentPanel);
    }

    public void handleMenuViewButton() {
        for (int i = 0; i < c.catalogButtonList.size(); i++) {
            int catalogID = 0;

            p.catalogContainerList.get(i).add(c.catalogButtonList.get(i));
            p.catalogContainerList.get(i).add(c.catalogNameList.get(i));

            catalogList.add(new LinkedList<>(Arrays.asList(
                    p.catalogContainerList.get(i), // 0
                    c.catalogButtonList.get(i), // 1
                    c.catalogNameList.get(i), // 2
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

        for (LinkedList<Object> catalog : catalogList) {
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

        for (int i = 0; i < c.catalogButtonList.size(); i++) {
            c.catalogButtonList.get(i).setText(categoryName + " " + i + " Button");
            c.catalogNameList.get(i).setText(categoryName + " " + i + " Name");
        }

        repaint(p.contentPanel);
    }

    public void addToOrder(ActionEvent e) {
        Component component = (Component) e.getSource();

        for (int i = 0; i < c.catalogButtonList.size(); i++) {
            if (!catalogList.get(i).contains(component)) {
                continue;
            }

            JLabel catalogName = (JLabel) catalogList.get(i).get(2);

            orderList.add(new LinkedList<>(Arrays.asList(
                    catalogList.get(i).getLast(),
                    catalogName.getText()
            )));

            return;
        }
    }

    public void confirmOrder (ActionEvent e) {
        for (int i = 0; i < orderList.size(); i++) {
            System.out.println(orderList.get(i).getFirst());
            System.out.println(orderList.get(i).getLast());
        }

        orderList.clear();
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
