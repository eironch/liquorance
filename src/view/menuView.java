package view;

import main.Main;
import database.DatabaseManager;
import asset.AssetFactory;
import component.ComponentFactory;
import panel.PanelFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.LinkedList;

public class menuView extends JFrame {
    DatabaseManager dm;
    PanelFactory pf;
    ComponentFactory cf;
    AssetFactory af;
    Category currentCategory = Category.BEER;
    String[] categoryList = {"Beer", "Cocktail", "Wine", "Whiskey", "Rum"};
    LinkedList<LinkedList<Object>> catalogMenuList = new LinkedList<>();

    public menuView(DatabaseManager databaseManager, PanelFactory panelFactory,
                    ComponentFactory componentFactory, AssetFactory assetFactory) {
        this.dm = databaseManager;
        this.pf = panelFactory;
        this.cf = componentFactory;
        this.af = assetFactory;

        pf.handleMenuView();

        pf.headerContainerList.get(0).add(cf.changeViewButton);
        pf.headerContainerList.get(1).add(cf.titleText);
        pf.headerContainerList.get(2).add(cf.orderButton);

        for (int i = 0; i < pf.headerContainerList.size(); i++) {
            pf.headerPanel.add(pf.headerContainerList.get(i));
        }

        handleMenuViewButton();
        updateContent();

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

        for (int i = 0; i < cf.categoryButtonList.size(); i++) {
            pf.categoryContainerList.get(i).add(cf.categoryButtonList.get(i));
            cf.categoryButtonList.get(i).addActionListener(this::changeCategory);
        }

        for (int i = 0; i < pf.categoryContainerList.size(); i++) {
            pf.footerPanel.add(pf.categoryContainerList.get(i));
        }

        pf.contentPanel.add(pf.headerPanel, BorderLayout.NORTH);
        pf.contentPanel.add(pf.bodyPanel, BorderLayout.CENTER);
        pf.contentPanel.add(pf.footerPanel, BorderLayout.SOUTH);

        this.add(pf.contentPanel);

        this.setBounds(320, 140, Main.WIDTH, Main.HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(true);
        this.setResizable(false);
    }

    public void handleMenuViewButton() {
        for (int i = 0; i < cf.catalogButtonList.size(); i++) {
            int catalogID = 0;

            pf.catalogContainerList.get(i).add(cf.catalogButtonList.get(i));
            pf.catalogContainerList.get(i).add(cf.catalogNameList.get(i));

            catalogMenuList.add(new LinkedList<>(Arrays.asList(
                    pf.catalogContainerList.get(i),
                    cf.catalogButtonList.get(i),
                    cf.catalogNameList.get(i),
                    catalogID
            )));
        }
    }

    public void changeCategory(ActionEvent e) {
        Component component = (Component) e.getSource();

        if(component == cf.categoryButtonList.get(0)) {
            currentCategory = Category.BEER;
        } else if(component == cf.categoryButtonList.get(1)) {
            currentCategory = Category.COCKTAIL;
        } else if(component == cf.categoryButtonList.get(2)) {
            currentCategory = Category.RUM;
        } else if(component == cf.categoryButtonList.get(3)) {
            currentCategory = Category.WHISKEY;
        } else if(component == cf.categoryButtonList.get(4)) {
            currentCategory = Category.WINE;
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

        for (int i = 0; i < cf.catalogButtonList.size(); i++) {
            cf.catalogButtonList.get(i).setText(categoryName + " " + i + " Button");
            cf.catalogNameList.get(i).setText(categoryName + " " + i + " Name");
        }

        repaint(pf.contentPanel);
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
