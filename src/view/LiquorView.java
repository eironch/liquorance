package view;

import main.Main;
import asset.AssetFactory;
import component.ComponentFactory;
import menu.MenuDepot;
import panel.PanelFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.LinkedList;

public class LiquorView {
    JFrame f;
    PanelFactory p = new PanelFactory();
    ComponentFactory c = new ComponentFactory();
    AssetFactory a = new AssetFactory();
    MenuDepot m = new MenuDepot();
    static int menuID;
    static int orderQuantity;
    static int orderTotalQuantity;
    public JPanel contentPanel = new JPanel();
    static LinkedList<LinkedList<Object>> orderList = new LinkedList<>();

    public LiquorView(JFrame frame) {
        this.f = frame;

        p.handleLiquorView();
        c.handleLiquorView();

        contentPanel.setLayout(new BorderLayout(0, 0));
        contentPanel.setBackground(a.burgundy);

        c.orderButton.addMouseListener(createUIMouseListener(m.menuInfoList, c, a));
        c.returnButton.addMouseListener(createUIMouseListener(m.menuInfoList, c, a));

        p.headerContainerList.get(0).add(c.returnButton);
        p.headerContainerList.get(1).add(c.logoText);
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

        p.liquorLayeredPane.add(p.liquorInfoSectionContainer, 0);
        p.liquorLayeredPane.add(p.liquorImageContainer, 1);
        p.liquorLayeredPane.add(p.liquorNameContainer, 2);

        p.quantitySelectorContainer.add(c.decreaseQuantityButton);
        p.quantitySelectorContainer.add(c.orderQuantityText);
        p.quantitySelectorContainer.add(c.increaseQuantityButton);

        c.cancelButton.addMouseListener(createUIMouseListener(m.menuInfoList, c, a));

        c.decreaseQuantityButton.addMouseListener(createQuantityMouseListener(c, a));
        c.increaseQuantityButton.addMouseListener(createQuantityMouseListener(c, a));

        c.confirmButton.addMouseListener(createUIMouseListener(m.menuInfoList, c, a));

        p.footerColumnContainer.get(0).add(c.cancelButton);
        p.footerColumnContainer.get(1).add(p.quantitySelectorContainer);
        p.footerColumnContainer.get(2).add(c.confirmButton);

        for (int i = 0; i < p.footerColumnContainer.size(); i++) {
            p.footerPanel.add(p.footerColumnContainer.get(i));
        }

        contentPanel.add(p.headerPanel, BorderLayout.NORTH);
        contentPanel.add(p.liquorLayeredPane, BorderLayout.CENTER);
        contentPanel.add(p.footerPanel, BorderLayout.SOUTH);
    }

    // shows the components to the specified liquor
    public void showLiquor(LinkedList<LinkedList<Object>> orderList, int menuID) {
        LiquorView.orderList = orderList;
        LiquorView.menuID = menuID;

        orderQuantity = 1;

        for (LinkedList<Object> order : orderList) {
            if (!order.getFirst().equals(menuID)) {
                continue;
            }

            orderQuantity = (Integer) order.getLast();

            break;
        }

        c.orderQuantityText.setText(String.valueOf(orderQuantity));

        for (LinkedList<Object> liquor : m.menuInfoList) {
            if (!liquor.getFirst().equals(menuID)) {
                continue;
            }

            c.liquorBackgroundName.setText((String) liquor.get(1));
            c.liquorBackgroundName.setFont(a.tanGrandeur.deriveFont((Float) liquor.get(8)));

            c.liquorImage.setIcon(a.resizeIcon(
                    (ImageIcon) liquor.get(5), 650, 650)
            );

            repaint(p.liquorLayeredPane);

            c.liquorForegroundName.setText(String.valueOf(liquor.get(1)));

            c.liquorFlavorText.setText("<html><div style='text-align: right;'>" +
                    "<font style='font-family:" +
                    a.lora.getFamily() +
                    "; font-size:17pt; font-weight:normal;'>" +
                    liquor.get(2) +
                    "</font></div></html>"
            );

            c.liquorPriceText.setText("PHP " + liquor.getLast());

            c.liquorCategoryText.setText("<html><div style='text-align: left;'>" +
                    "<font style='font-family:" +
                    a.lora.getFamily() +
                    "; font-size:24pt; font-weight:normal;'><i>" +
                    liquor.get(7) +
                    "</i></font></html>"
            );

            c.liquorDescriptionText.setText("<html><div style='text-align: left;'>" +
                    "<font style='font-family:" +
                    a.lora.getFamily() +
                    "; font-size:17pt; font-weight:normal;'><i>" +
                    liquor.get(3) +
                    "</i></font></div></html>"
            );

            c.liquorIngredientsText.setText("<html><div style='text-align: left;'>" +
                    "<font style='font-family:" +
                    a.lora.getFamily() +
                    "; font-size:17pt; font-weight:normal;'><i>" +
                    "Ingredients:<br>" +
                    liquor.get(4) +
                    "</i></font></div></html>"
            );

            repaint(p.liquorLayeredPane);

            break;
        }

        updateOrderQuantity();

        repaint(p.liquorLayeredPane);
    }

    public void updateOrderQuantity() {
        orderTotalQuantity = 0;

        for (LinkedList<Object> order : orderList) {
            orderTotalQuantity += (int) order.getLast();
        }

        c.orderButton.setText("Order (" + orderTotalQuantity +")");
    }


    public void clearLists() {
        orderList.clear();
    }

    private void repaint(Component component){
        SwingUtilities.invokeLater(() -> {
            component.revalidate();
            component.repaint();
        });
    }

    // custom button functionality for the quantity selector
    private static MouseListener createQuantityMouseListener(ComponentFactory c, AssetFactory a) {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                JLabel button = (JLabel) e.getSource();

                // highlight button
                if (button == c.decreaseQuantityButton) {
                    button.setIcon(a.resizeIcon(a.decreaseSelectedButtonIcon, 60, 60));
                } else if (button == c.increaseQuantityButton) {
                    button.setIcon(a.resizeIcon(a.increaseSelectedButtonIcon, 60, 60));
                }

                // call respective methods for the buttons
                if (button == c.decreaseQuantityButton) {
                    decreaseQuantity();
                } else if (button == c.increaseQuantityButton) {
                    increaseQuantity();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                JLabel button = (JLabel) e.getSource();

                // highlight button
                if (button == c.decreaseQuantityButton) {
                    button.setIcon(a.resizeIcon(a.decreaseSelectedButtonIcon, 60, 60));
                } else if (button == c.increaseQuantityButton) {
                    button.setIcon(a.resizeIcon(a.increaseSelectedButtonIcon, 60, 60));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JLabel button = (JLabel) e.getSource();

                // remove highlight on button
                if (button == c.decreaseQuantityButton) {
                    button.setIcon(a.resizeIcon(a.decreaseButtonIcon, 60, 60));
                } else if (button == c.increaseQuantityButton) {
                    button.setIcon(a.resizeIcon(a.increaseButtonIcon, 60, 60));
                }
            }

            private void decreaseQuantity() {
                if (orderQuantity == 0) {
                    return;
                }

                orderQuantity--;

                c.orderQuantityText.setText(String.valueOf(orderQuantity));
            }

            private void increaseQuantity() {
                if (orderQuantity == 99) {
                    return;
                }

                orderQuantity++;

                c.orderQuantityText.setText(String.valueOf(orderQuantity));
            }
        };
    }

    // custom button functionality for the ui
    private static MouseListener createUIMouseListener(
            LinkedList<LinkedList<Object>> cocktailMenuInfoList,
            ComponentFactory c, AssetFactory a) {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                JLabel button = (JLabel) e.getSource();

                highlightButton(button, a.burgundy, a.uiButtonSelectedIconList);

                // call respective method for the buttons
                if (button == c.returnButton) {
                    Main.showTitleView();
                } else if (button == c.orderButton) {
                    if (orderList.isEmpty()) {
                        return;
                    }

                    Main.showConfirmView(orderList);
                } else if (button == c.cancelButton) {
                    Main.showMenuView(orderList);
                } else if (button == c.confirmButton) {
                    addToOrder();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                JLabel button = (JLabel) e.getSource();

                highlightButton(button, a.burgundy, a.uiButtonSelectedIconList);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JLabel button = (JLabel) e.getSource();

                highlightButton(button, a.cocoa, a.uiButtonIconList);
            }

            private void addToOrder() {
                // deletes order if existing and quantity 0
                // else update existing order with new quantity
                for (int i = 0; i < orderList.size(); i++) {
                    if (!orderList.get(i).getFirst().equals(menuID)) {
                        continue;
                    }

                    if (orderQuantity == 0) {
                        orderList.remove(i);

                        returnToMenuView(orderList);

                        return;
                    }

                    orderList.get(i).set(1, orderQuantity);

                    returnToMenuView(orderList);

                    return;
                }

                // add new order
                for (LinkedList<Object> objects : cocktailMenuInfoList) {
                    if (!objects.getFirst().equals(menuID)) {
                        continue;
                    }

                    if (orderQuantity == 0) {
                        returnToMenuView(orderList);

                        return;
                    }

                    orderList.add(new LinkedList<>(Arrays.asList(
                            menuID, // 0
                            orderQuantity // 1
                    )));

                    break;
                }

                returnToMenuView(orderList);
            }

            private void returnToMenuView(LinkedList<LinkedList<Object>> orderList) {
                Main.showMenuView(orderList);
            }

            public void highlightButton(JLabel button, Color color, LinkedList<ImageIcon> iconList) {
                if (button == c.returnButton) {
                    button.setIcon(a.resizeIcon(iconList.get(0), 200, 60));
                    button.setForeground(color);
                } else if (button == c.orderButton) {
                    button.setIcon(a.resizeIcon(iconList.get(1), 200, 60));
                    button.setForeground(color);
                } else if (button == c.cancelButton) {
                    button.setIcon(a.resizeIcon(iconList.get(2), 200, 60));
                    button.setForeground(color);
                } else if (button == c.confirmButton) {
                    button.setIcon(a.resizeIcon(iconList.get(3), 200, 60));
                    button.setForeground(color);
                }
            }
        };
    }
}
