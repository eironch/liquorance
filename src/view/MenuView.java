package view;

import database.DatabaseManager;
import asset.AssetFactory;
import component.ComponentFactory;
import main.Main;
import panel.PanelFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
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
    int menuID;
    int orderQuantity;
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
            c.liquorMenuButtonList.get(i).addActionListener(this::showQuantityPrompt);
        }

        p.catalogRowContainerList.get(0).add(p.liquorMenuContainerList.get(0));
        p.catalogRowContainerList.get(0).add(p.liquorMenuContainerList.get(1));
        p.catalogRowContainerList.get(0).add(p.liquorMenuContainerList.get(2));
        p.catalogRowContainerList.get(0).add(p.liquorMenuContainerList.get(3));

        p.catalogRowContainerList.get(1).add(p.liquorMenuContainerList.get(4));
        p.catalogRowContainerList.get(1).add(p.liquorMenuContainerList.get(5));
        p.catalogRowContainerList.get(1).add(p.liquorMenuContainerList.get(6));
        p.catalogRowContainerList.get(1).add(p.liquorMenuContainerList.get(7));

        p.catalogSectionContainer.add(p.catalogRowContainerList.get(0));
        p.catalogSectionContainer.add(p.catalogRowContainerList.get(1));

        c.decreaseQuantityButton.addActionListener(this::decreaseQuantity);
        c.increaseQuantityButton.addActionListener(this::increaseQuantity);

        p.quantitySelectorContainer.add(c.decreaseQuantityButton);
        p.quantitySelectorContainer.add(c.orderQuantityText);
        p.quantitySelectorContainer.add(c.increaseQuantityButton);

        c.cancelButton.addActionListener(this::removeFloatingWindow);
        c.confirmButton.addActionListener(this::addToOrder);

        p.cancelContainer.add(c.cancelButton);
        p.confirmContainer.add(c.confirmButton);

        p.quantityPromptContainerList.get(0).add(c.orderQuantityContext);
        p.quantityPromptContainerList.get(1).add(p.quantitySelectorContainer);
        p.quantityPromptContainerList.get(2).add(p.cancelContainer);
        p.quantityPromptContainerList.get(2).add(p.confirmContainer);

        for (int i = 0; i < p.quantityPromptContainerList.size(); i++) {
            p.quantityPromptPanel.add(p.quantityPromptContainerList.get(i));
        }

        p.layeredPane.add(p.catalogSectionContainer, JLayeredPane.DEFAULT_LAYER);

        p.bodyPanel.add(p.layeredPane);

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

    private void handleMenuViewButton() {
        for (int i = 0; i < c.liquorMenuButtonList.size(); i++) {
            int menuID = 0;

            p.liquorMenuContainerList.get(i).add(c.liquorMenuButtonList.get(i));
            p.liquorMenuContainerList.get(i).add(c.liquorMenuNameList.get(i));

            liquorMenuList.add(new LinkedList<>(Arrays.asList(
                    p.liquorMenuContainerList.get(i), // 0
                    c.liquorMenuButtonList.get(i), // 1
                    c.liquorMenuNameList.get(i), // 2
                    menuID // 3
            )));
        }
    }

    private void changeCategory(ActionEvent e) {
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

    private void updateContent() {
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

    private void addToOrder(ActionEvent e) {
        removeFloatingWindow(e);

        for (int i = 0; i < c.liquorMenuButtonList.size(); i++) {
            if (!liquorMenuList.get(i).contains(menuID)) {
                continue;
            }

            JLabel liquorName = (JLabel) liquorMenuList.get(i).get(2);

            for (int j = 0; j < orderList.size(); j++) {
                if (!orderList.get(i).contains(liquorName.getText())) {
                    continue;
                }

                if (orderQuantity == 0) {
                    orderList.remove(i);

                    return;
                }

                orderList.get(i).set(2, orderQuantity);

                return;
            }

            if (orderQuantity == 0) {
                return;
            }

            orderList.add(new LinkedList<>(Arrays.asList(
                    liquorMenuList.get(i).getLast(), // 0
                    liquorName.getText(), // 1
                    orderQuantity // 2
            )));

            return;
        }
    }

    public void updateOrder(LinkedList<LinkedList<Object>> orderInfoList) {
        ArrayList<Integer> removeOrderList = new ArrayList<>();

        for (int x = 0; x < orderList.size(); x++) {

            if (orderInfoList.isEmpty()) {
                orderList.clear();

                return;
            }

            for (int i = 0; i < orderInfoList.size(); i++) {
                if (!orderInfoList.get(i).get(4).equals(orderList.get(x).getFirst())) {
                    if (i == orderInfoList.size() - 1) {
                        removeOrderList.add(x);
                    }

                    continue;
                }

                if (orderInfoList.get(i).getLast().equals(orderList.get(x).getLast())) {
                    break;
                }

                orderList.get(i).set(2, orderInfoList.get(i).getLast());
            }
        }

        for (int index : removeOrderList) {
            orderList.remove(index);
        }

        removeOrderList.clear();
    }

    private void showQuantityPrompt(ActionEvent e) {
        if (p.layeredPane.isAncestorOf(p.quantityPromptPanel)) {
            return;
        }

        orderQuantity = 1;

        for (LinkedList<Object> objects : liquorMenuList) {
            if (!objects.contains(e.getSource())) {
                continue;
            }

            menuID = (Integer) objects.getLast();

            break;
        }

        for (int i = 0; i < c.liquorMenuButtonList.size(); i++) {
            if (!liquorMenuList.get(i).contains(menuID)) {
                continue;
            }

            JLabel liquorName = (JLabel) liquorMenuList.get(i).get(2);

            for (LinkedList<Object> objects : orderList) {
                if (!objects.contains(liquorName.getText())) {
                    continue;
                }

                orderQuantity = (Integer) objects.getLast();

                break;
            }

            break;
        }

        c.orderQuantityText.setText(String.valueOf(orderQuantity));
        p.layeredPane.add(p.quantityPromptPanel, JLayeredPane.PALETTE_LAYER);

        repaint(p.bodyPanel);
    }

    private void removeFloatingWindow(ActionEvent e){
        p.layeredPane.remove(p.quantityPromptPanel);

        repaint(p.bodyPanel);
    }

    private void decreaseQuantity(ActionEvent e) {
        if (orderQuantity == 0) {
            return;
        }

        orderQuantity--;

        c.orderQuantityText.setText(String.valueOf(orderQuantity));

        repaint(c.orderQuantityText);
    }

    private void increaseQuantity(ActionEvent e) {
        orderQuantity++;

        c.orderQuantityText.setText(String.valueOf(orderQuantity));

        repaint(c.orderQuantityText);
    }

    private void confirmOrder (ActionEvent e) {
        f.remove(contentPanel);
        Main.showConfirmView(orderList);
        repaint(f);
    }

    private void repaint(Component component){
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
