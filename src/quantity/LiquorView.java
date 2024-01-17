package quantity;

import asset.AssetFactory;
import component.ComponentFactory;
import database.DatabaseManager;
import main.Main;
import menu.MenuDepot;
import panel.PanelFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.LinkedList;

public class LiquorView {
    JFrame f;
    DatabaseManager d = new DatabaseManager();
    PanelFactory p = new PanelFactory();
    ComponentFactory c = new ComponentFactory();
    AssetFactory a = new AssetFactory();
    MenuDepot m = new MenuDepot();
    public JPanel contentPanel = new JPanel();
    int menuID;
    int orderQuantity;
    LinkedList<LinkedList<Object>> orderList = new LinkedList<>();

    public LiquorView(JFrame frame) {
        this.f = frame;

        p.handleLiquorView();
        c.handleLiquorView();

        contentPanel.setLayout(new BorderLayout(0, 0));

        c.orderButton.addActionListener(this::confirmOrder);


        p.headerContainerList.get(0).add(c.changeViewButton);
        p.headerContainerList.get(1).add(c.titleText);
        p.headerContainerList.get(2).add(c.orderButton);

        for (int i = 0; i < p.headerContainerList.size(); i++) {
            p.headerPanel.add(p.headerContainerList.get(i));
        }

        p.liquorNameContainer.add(c.liquorBackgroundName);

        p.liquorImageContainer.add(c.liquorImage);

        p.liquorLeftRowContainer.get(0).add(c.liquorForegroundName);
        p.liquorLeftRowContainer.get(1).add(c.liquorFlavorText);
        p.liquorLeftRowContainer.get(2).add(c.liquorPriceText);

        p.liquorRightRowContainer.get(0).add(c.liquorCategoryText);
        p.liquorRightRowContainer.get(1).add(c.liquorDescriptionText);
        p.liquorRightRowContainer.get(2).add(c.liquorIngredientsText);

        for (int i = 0; i < p.liquorLeftRowContainer.size(); i++) {
            p.liquorColumnContainer.get(0).add(p.liquorLeftRowContainer.get(i));
        }

        for (int i = 0; i < p.liquorLeftRowContainer.size(); i++) {
            p.liquorColumnContainer.get(2).add(p.liquorRightRowContainer.get(i));
        }

        for (int i = 0; i < p.liquorColumnContainer.size(); i++) {
            p.liquorInfoSectionContainer.add(p.liquorColumnContainer.get(i));
        }

        p.layeredPane.add(p.liquorInfoSectionContainer, 0);
        p.layeredPane.add(p.liquorImageContainer, 1);
        p.layeredPane.add(p.liquorNameContainer, 2);


        p.quantitySelectorContainer.add(c.decreaseQuantityButton);
        p.quantitySelectorContainer.add(c.orderQuantityText);
        p.quantitySelectorContainer.add(c.increaseQuantityButton);

        c.cancelButton.addActionListener(this::returnToMenuView);

        c.decreaseQuantityButton.addActionListener(this::decreaseQuantity);
        c.increaseQuantityButton.addActionListener(this::increaseQuantity);

        c.confirmButton.addActionListener(this::addToOrder);

        p.footerColumnContainer.get(0).add(c.cancelButton);
        p.footerColumnContainer.get(1).add(p.quantitySelectorContainer);
        p.footerColumnContainer.get(2).add(c.confirmButton);

        for (int i = 0; i < p.footerColumnContainer.size(); i++) {
            p.footerPanel.add(p.footerColumnContainer.get(i));
        }

        contentPanel.add(p.headerPanel, BorderLayout.NORTH);
        contentPanel.add(p.layeredPane, BorderLayout.CENTER);
        contentPanel.add(p.footerPanel, BorderLayout.SOUTH);
    }

    public void showLiquor(LinkedList<LinkedList<Object>> orderList, int menuID) {
        this.orderList = orderList;
        this.menuID = menuID;
        System.out.println(orderList);
        orderQuantity = 1;

        for (LinkedList<Object> order : orderList) {
            if (!order.getFirst().equals(menuID)) {
                continue;
            }

            orderQuantity = (Integer) order.getLast();

            break;
        }

        c.orderQuantityText.setText(String.valueOf(orderQuantity));

        for (LinkedList<Object> liquor : m.cocktailMenuInfoList) {
            if (!liquor.getFirst().equals(menuID)) {
                continue;
            }

            SwingUtilities.invokeLater(() -> {
                c.liquorBackgroundName.setText((String) liquor.get(1));
                c.liquorBackgroundName.setFont(a.tanGrandeur.deriveFont((Float) liquor.get(7)));

                c.liquorImage.setIcon(a.resizeIcon(
                        (ImageIcon) liquor.get(5), 650, 650)
                );

                c.liquorForegroundName.setText(String.valueOf(liquor.get(1)));

                c.liquorFlavorText.setText("<html><div style='text-align: right;'>" +
                        liquor.get(2) +
                        "</div></html>"
                );

                c.liquorPriceText.setText("PHP " + liquor.getLast());

                c.liquorCategoryText.setText("<html><i>" +
                        "Cocktail" +
                        "</i></html>"
                );

                c.liquorDescriptionText.setText("<html><div style='text-align: left;'><i>" +
                        liquor.get(3) +
                        "</i></div></html>"
                );

                c.liquorIngredientsText.setText("<html><div style='text-align: left;'><i>" +
                        "Ingredients:<br>" +
                        liquor.get(4) +
                        "</i></div></html>"
                );
            });

            break;
        }

        repaint(p.layeredPane);
    }

    private void decreaseQuantity(ActionEvent e) {
        if (orderQuantity == 0) {
            return;
        }

        orderQuantity--;

//        c.liquorBackgroundName.setFont(a.tanGrandeur.deriveFont((float) orderQuantity));
//        repaint(p.layeredPane);

        c.orderQuantityText.setText(String.valueOf(orderQuantity));

        repaint(c.orderQuantityText);
    }

    private void increaseQuantity(ActionEvent e) {
        if (orderQuantity == 99) {
            return;
        }

        orderQuantity++;

//        c.liquorBackgroundName.setFont(a.tanGrandeur.deriveFont((float) orderQuantity));
//        repaint(p.layeredPane);

        c.orderQuantityText.setText(String.valueOf(orderQuantity));

        repaint(c.orderQuantityText);
    }

    private void addToOrder(ActionEvent e) {
        // deletes order if existing and quantity 0
        // else update existing order with new quantity
        for (int i = 0; i < orderList.size(); i++) {
            if (!orderList.get(i).getFirst().equals(menuID)) {
                continue;
            }

            if (orderQuantity == 0) {
                orderList.remove(i);

                returnToMenuView(e);

                return;
            }

            orderList.get(i).set(1, orderQuantity);

            returnToMenuView(e);

            return;
        }

        // add new order
        for (int x = 0; x < m.cocktailMenuInfoList.size(); x++) {
            if (!m.cocktailMenuInfoList.get(x).getFirst().equals(menuID)) {
                continue;
            }

            if (orderQuantity == 0) {
                returnToMenuView(e);

                return;
            }

            orderList.add(new LinkedList<>(Arrays.asList(
                    menuID, // 0
                    orderQuantity // 1
            )));

            break;
        }

        returnToMenuView(e);
    }

    private void confirmOrder (ActionEvent e) {
        if (orderList.isEmpty()) {
            return;
        }

        Main.showConfirmView(orderList);
    }

    public void clearLists() {
        orderList.clear();
    }

    private void returnToMenuView(ActionEvent e) {
        System.out.println(orderList);
        Main.showMenuView(orderList);
    }

    private void repaint(Component component){
        SwingUtilities.invokeLater(() -> {
            component.revalidate();
            component.repaint();
        });
    }

}
