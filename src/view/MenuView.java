package view;

import database.DatabaseManager;
import asset.AssetFactory;
import component.ComponentFactory;
import main.Main;
import menu.MenuDepot;
import panel.PanelFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.*;

public class MenuView {
    JFrame f;
    DatabaseManager d = new DatabaseManager();
    PanelFactory p = new PanelFactory();
    ComponentFactory c = new ComponentFactory();
    AssetFactory a = new AssetFactory();
    MenuDepot m = new MenuDepot();
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


        p.quantitySelectorContainer.add(c.decreaseQuantityButton);
        p.quantitySelectorContainer.add(c.orderQuantityText);
        p.quantitySelectorContainer.add(c.increaseQuantityButton);

        p.bodyPanel.add(p.catalogSectionContainer);

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

        if(component == c.categoryButtonList.get(0)) {
            currentCategory = Category.BEER;
        } else if(component == c.categoryButtonList.get(1)) {
            currentCategory = Category.COCKTAIL;
        } else if(component == c.categoryButtonList.get(2)) {
            currentCategory = Category.RUM;
        } else if(component == c.categoryButtonList.get(3)) {
            currentCategory = Category.WHISKEY;
        } else if(component == c.categoryButtonList.get(4)) {
            currentCategory = Category.WINE;
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
            c.liquorMenuButtonList.get(i).setIcon(a.resizeIcon(
                    (ImageIcon) m.cocktailMenuInfoList.get(i).get(5), 250, 250));
            c.liquorMenuNameList.get(i).setText((String) m.cocktailMenuInfoList.get(i).get(1));
            liquorMenuList.get(i).set(3, m.cocktailMenuInfoList.get(i).getFirst());
        }

        repaint(contentPanel);
    }

    public void updateOrder(LinkedList<LinkedList<Object>> orderInfoList) {
        ArrayList<Integer> removeOrderList = new ArrayList<>();
        for (int x = 0; x < orderList.size(); x++) {

            if (orderInfoList.isEmpty()) {
                orderList.clear();

                return;
            }

            for (int i = 0; i < orderInfoList.size(); i++) {
                if (!orderInfoList.get(i).get(5).equals(orderList.get(x).getFirst())) {
                    if (i == orderInfoList.size() - 1) {
                        removeOrderList.add(x);
                    }

                    continue;
                }

                if (orderInfoList.get(i).getLast().equals(orderList.get(x).getLast())) {
                    break;
                }

                orderList.get(i).set(3, orderInfoList.get(i).getLast());

                break;
            }
        }

        for (int index : removeOrderList) {
            orderList.remove(index);
        }

        removeOrderList.clear();
    }

    private void showQuantityPrompt(ActionEvent e) {
        // get menu id
        for (LinkedList<Object> objects : liquorMenuList) {
            if (!objects.contains(e.getSource())) {
                continue;
            }

            menuID = (Integer) objects.getLast();

            break;
        }

        Main.showLiquorView(orderList, liquorMenuList, menuID);
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
