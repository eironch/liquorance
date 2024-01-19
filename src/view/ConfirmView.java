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

public class ConfirmView {
    JFrame f;
    PanelFactory p = new PanelFactory();
    ComponentFactory c = new ComponentFactory();
    AssetFactory a = new AssetFactory();
    MenuDepot m = new MenuDepot();
    static int orderContainerSize = 0;
    static int orderTotal = 0;
    public JPanel contentPanel = new JPanel();
    static LinkedList<LinkedList<Object>> orderInfoList = new LinkedList<>();

    public ConfirmView(JFrame frame) {
        this.f = frame;

        p.handleConfirmView();
        c.handleConfirmView();

        contentPanel.setLayout(new BorderLayout(0, 0));

        c.returnButton.addMouseListener(createUIMouseListener(c, a));

        p.headerContainerList.get(0).add(c.returnButton);
        p.headerContainerList.get(1).add(c.logoText);
        p.headerContainerList.get(2).add(c.confirmOrderButton);

        for (int i = 0; i < p.headerContainerList.size(); i++) {
            p.headerPanel.add(p.headerContainerList.get(i));
        }

        c.confirmOrderButton.addMouseListener(createUIMouseListener(c, a));

        p.orderTotalContainerList.get(0).add(c.orderTotalContext);
        p.orderTotalContainerList.get(1).add(c.decorImage);
        p.orderTotalContainerList.get(2).add(c.orderTotalText);

        for (int i = 0; i < p.orderTotalContainerList.size(); i++) {
            p.footerPanel.add(p.orderTotalContainerList.get(i));
        }

        contentPanel.add(p.headerPanel, BorderLayout.NORTH);
        contentPanel.add(p.orderScrollPane, BorderLayout.CENTER);
        contentPanel.add(p.footerPanel, BorderLayout.SOUTH);
    }

    // shows the liquor ordered
    public void showOrder(LinkedList<LinkedList<Object>> orderList) {
        int orderQuantity;
        int menuID;

        orderContainerSize = 0;

        orderInfoList.clear();
        p.orderPanel.removeAll();

        for (LinkedList<Object> order : orderList) {
            menuID = (int) order.getFirst();
            orderQuantity = (int) order.getLast();

            for (LinkedList<Object> liquor : m.menuInfoList) {
                if (!liquor.getFirst().equals(menuID)) {
                    continue;
                }

                addToShownOrder(
                        (String) liquor.get(1), orderQuantity,
                        (int) liquor.getLast(), (ImageIcon) liquor.get(6),
                        (Integer) liquor.getFirst()
                );

                break;
            }
        }

        repaint(p.orderScrollPane);
    }

    public void addToShownOrder(String liquorName, int orderQuantity, int price, ImageIcon liquorIcon, int menuID) {
        JLayeredPane orderLayeredPane = new JLayeredPane();
        Container orderSectionIconContainer = new Container();
        Container orderSectionContainer = new Container();
        Container removeOrderContainer = new Container();
        Container orderImageContainer = new Container();
        Container orderNameContainer = new Container();
        Container priceQuantityContainer = new Container();
        Container quantityOrderContainer = new Container();
        Container quantitySelectorContainer = new Container();

        JLabel orderContainerImage = new JLabel();
        JLabel removeOrderButton = new JLabel();
        JLabel liquorImage = new JLabel();
        JLabel liquorNameText = new JLabel();
        JLabel liquorPriceText = new JLabel();
        JLabel decreaseQuantityButton = new JLabel();
        JLabel orderQuantityText = new JLabel();
        JLabel increaseQuantityButton = new JLabel();
        JLabel liquorTotalText = new JLabel();

        orderLayeredPane.setLayout(null);
        orderLayeredPane.setPreferredSize(new Dimension(Main.WIDTH - 220, 80));

        orderSectionIconContainer.setLayout(new GridLayout(1, 1, 0, 0));
        orderSectionIconContainer.setSize(Main.WIDTH - 220, 80);

        orderContainerImage.setIcon(a.resizeIcon(a.orderContainerIcon, Main.WIDTH - 220, 80));

        orderSectionContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        orderSectionContainer.setSize(Main.WIDTH - 220, 80);

        removeOrderContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        removeOrderContainer.setPreferredSize(new Dimension(80, 80));

        orderImageContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        orderImageContainer.setPreferredSize(new Dimension(80, 80));

        orderNameContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 22));
        orderNameContainer.setPreferredSize(new Dimension(300, 80));

        priceQuantityContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        priceQuantityContainer.setPreferredSize(new Dimension(560, 80));

        quantityOrderContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        quantityOrderContainer.setPreferredSize(new Dimension(260, 80));

        quantitySelectorContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        quantitySelectorContainer.setPreferredSize(new Dimension(220, 60));

        removeOrderButton.setIcon(a.resizeIcon(a.removeButtonIcon, 60, 60));
        removeOrderButton.setPreferredSize(new Dimension(60, 60));
        removeOrderButton.setFocusable(false);
        removeOrderButton.addMouseListener(createQuantityMouseListener(p, c, a));

        liquorImage.setIcon(a.resizeIcon(liquorIcon, 75, 75));
        liquorImage.setPreferredSize(new Dimension(80, 80));

        liquorNameText.setText(liquorName);
        liquorNameText.setFont(a.lora.deriveFont(Font.BOLD, 25f));
        liquorNameText.setForeground(a.cocoa);

        liquorPriceText.setText("PHP " + String.format("%,d", price));
        liquorPriceText.setFont(a.lora.deriveFont(Font.BOLD, 20f));
        liquorPriceText.setPreferredSize(new Dimension(120, 80));
        liquorPriceText.setHorizontalAlignment(JLabel.RIGHT);
        liquorPriceText.setVerticalAlignment(JLabel.CENTER);
        liquorPriceText.setForeground(a.cocoa);

        decreaseQuantityButton.setIcon(a.resizeIcon(a.decreaseButtonIcon, 60, 60));
        decreaseQuantityButton.setPreferredSize(new Dimension(60, 60));
        decreaseQuantityButton.setFocusable(false);
        decreaseQuantityButton.addMouseListener(createQuantityMouseListener(p, c, a));

        orderQuantityText.setText(String.valueOf(orderQuantity));
        orderQuantityText.setPreferredSize(new Dimension(100, 60));
        orderQuantityText.setHorizontalAlignment(JLabel.CENTER);
        orderQuantityText.setFont(a.lora.deriveFont(Font.BOLD, 30f));
        orderQuantityText.setForeground(a.cocoa);

        increaseQuantityButton.setIcon(a.resizeIcon(a.increaseButtonIcon, 60, 60));
        increaseQuantityButton.setPreferredSize(new Dimension(60, 60));
        increaseQuantityButton.setFocusable(false);
        increaseQuantityButton.addMouseListener(createQuantityMouseListener(p, c, a));

        liquorTotalText.setText("PHP " + String.format("%,d", price * orderQuantity) + ".00");
        liquorTotalText.setFont(a.lora.deriveFont(Font.BOLD,20f));
        liquorTotalText.setPreferredSize(new Dimension(150, 80));
        liquorTotalText.setHorizontalAlignment(JLabel.CENTER);
        liquorTotalText.setVerticalAlignment(JLabel.CENTER);
        liquorTotalText.setForeground(a.cocoa);

        removeOrderContainer.add(removeOrderButton);

        orderImageContainer.add(liquorImage);
        orderNameContainer.add(liquorNameText);

        quantitySelectorContainer.add(decreaseQuantityButton);
        quantitySelectorContainer.add(orderQuantityText);
        quantitySelectorContainer.add(increaseQuantityButton);

        quantityOrderContainer.add(quantitySelectorContainer);

        priceQuantityContainer.add(liquorPriceText);
        priceQuantityContainer.add(quantityOrderContainer);
        priceQuantityContainer.add(liquorTotalText);

        orderSectionContainer.add(removeOrderContainer);
        orderSectionContainer.add(orderImageContainer);
        orderSectionContainer.add(orderNameContainer);
        orderSectionContainer.add(priceQuantityContainer);

        orderInfoList.add(new LinkedList<>(Arrays.asList(
                menuID, // 0
                orderLayeredPane, // 1
                removeOrderButton, // 2
                decreaseQuantityButton, // 3
                orderQuantityText, // 4
                increaseQuantityButton, // 5
                price, // 6
                price * orderQuantity, // 7
                liquorTotalText, // 8
                liquorName, // 9
                orderQuantity // 10
        )));

        if (orderQuantity == 1) {
            decreaseQuantityButton.setEnabled(false);
        } else if (orderQuantity == 99) {
            increaseQuantityButton.setEnabled(false);
        }

        showOrderTotal();

        orderContainerSize += 100;

        orderSectionIconContainer.add(orderContainerImage);

        orderLayeredPane.add(orderSectionIconContainer, JLayeredPane.DEFAULT_LAYER);
        orderLayeredPane.add(orderSectionContainer, JLayeredPane.PALETTE_LAYER);

        p.orderPanel.setPreferredSize(new Dimension(Main.WIDTH, orderContainerSize));
        p.orderPanel.add(orderLayeredPane);
    }

    private void showOrderTotal() {
        orderTotal = 0;

        for (LinkedList<Object> order : orderInfoList) {
            orderTotal += (int) order.get(7);
        }

        c.orderTotalText.setText("<html><div style='text-align: left;'>" +
                "<font style='font-family:" +
                a.lora.getFamily() +
                "; font-size:39pt; font-weight:normal;'><b>" +
                "PHP " + String.format("%,d", orderTotal) + ".00" +
                "<b></font></div></html>"
        );
    }

    public void clearLists() {
        orderInfoList.clear();
    }

    private void repaint(Component component){
        SwingUtilities.invokeLater(() -> {
            component.revalidate();
            component.repaint();
        });
    }

    // custom button functionality for the quantity selector
    private static MouseListener createQuantityMouseListener(PanelFactory p, ComponentFactory c, AssetFactory a) {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                JLabel button = (JLabel) e.getSource();

                // highlight button
                for (LinkedList<Object> order : orderInfoList) {
                    if (!order.contains(button)) {
                        continue;
                    }

                    if (button == order.get(3)) {
                        button.setIcon(a.resizeIcon(a.decreaseSelectedButtonIcon, 60, 60));
                    } else if (button == order.get(5)) {
                        button.setIcon(a.resizeIcon(a.increaseSelectedButtonIcon, 60, 60));
                    } else if (button == order.get(2)) {
                        button.setIcon(a.resizeIcon(a.removeSelectedButtonIcon, 60, 60));
                    }

                    break;
                }

                // call respective method for the buttons
                for (LinkedList<Object> order : orderInfoList) {
                    if (!order.contains(button)) {
                        continue;
                    }

                    if (button == order.get(3)) {
                        decreaseQuantity(button);
                    } else if (button == order.get(5)) {
                        increaseQuantity(button);
                    } else if (button == order.get(2)) {
                        removeOrder(button);
                    }

                    break;
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                JLabel button = (JLabel) e.getSource();

                // highlight button
                for (LinkedList<Object> order : orderInfoList) {
                    if (!order.contains(button)) {
                        continue;
                    }

                    if (button == order.get(3)) {
                        button.setIcon(a.resizeIcon(a.decreaseSelectedButtonIcon, 60, 60));
                    } else if (button == order.get(5)) {
                        button.setIcon(a.resizeIcon(a.increaseSelectedButtonIcon, 60, 60));
                    } else if (button == order.get(2)) {
                        button.setIcon(a.resizeIcon(a.removeSelectedButtonIcon, 60, 60));
                    }

                    break;
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JLabel button = (JLabel) e.getSource();

                // highlight button
                for (LinkedList<Object> order : orderInfoList) {
                    if (!order.contains(button)) {
                        continue;
                    }

                    if (button == order.get(3)) {
                        button.setIcon(a.resizeIcon(a.decreaseButtonIcon, 60, 60));
                    } else if (button == order.get(5)) {
                        button.setIcon(a.resizeIcon(a.increaseButtonIcon, 60, 60));
                    } else if (button == order.get(2)) {
                        button.setIcon(a.resizeIcon(a.removeButtonIcon, 60, 60));
                    }

                    break;
                }
            }

            private void removeOrder(JLabel button) {
                for (int i = 0; i < orderInfoList.size(); i++) {
                    if (!orderInfoList.get(i).contains(button)) {
                        continue;
                    }

                    p.orderPanel.remove((Component) orderInfoList.get(i).get(1));

                    orderInfoList.remove(i);

                    break;
                }

                showOrderTotal();

                orderContainerSize -= 100;
                p.orderPanel.setPreferredSize(new Dimension(Main.WIDTH, orderContainerSize));

                repaint(p.orderPanel);
            }

            private void decreaseQuantity(JLabel buttonPressed) {
                for (LinkedList<Object> order : orderInfoList) {
                    if (!order.contains(buttonPressed)) {
                        continue;
                    }

                    int orderQuantity = (int) order.getLast();

                    if (orderQuantity == 1) {
                        return;
                    } else if (--orderQuantity == 1) {
                        JLabel button = (JLabel) order.get(3);
                        button.setEnabled(false);
                    }

                    JLabel button = (JLabel) order.get(5);
                    if (!button.isEnabled()) {
                        button.setEnabled(true);
                    }

                    order.set(10, orderQuantity);

                    JLabel orderQuantityText = (JLabel) order.get(4);
                    orderQuantityText.setText(String.valueOf(order.getLast()));

                    JLabel liquorTotalText = (JLabel) order.get(8);
                    liquorTotalText.setText("PHP " + String.format("%,d", (int) order.get(6) * orderQuantity) + ".00");

                    order.set(7, ((int) order.get(6) * orderQuantity));

                    showOrderTotal();
                }
            }

            private void increaseQuantity(JLabel buttonPressed) {
                for (LinkedList<Object> order : orderInfoList) {
                    if (!order.contains(buttonPressed)) {
                        continue;
                    }

                    int orderQuantity = (int) order.getLast();

                    if (orderQuantity == 99) {
                        return;
                    } else if (++orderQuantity == 99) {
                        JLabel button = (JLabel) order.get(5);
                        button.setEnabled(false);
                    }

                    JLabel button = (JLabel) order.get(3);
                    if (!button.isEnabled()) {
                        button.setEnabled(true);
                    }

                    order.set(10, orderQuantity);

                    JLabel orderQuantityText = (JLabel) order.get(4);
                    orderQuantityText.setText(String.valueOf(order.getLast()));

                    JLabel liquorTotalText = (JLabel) order.get(8);
                    liquorTotalText.setText("PHP " + String.format("%,d", (int) order.get(6) * orderQuantity) + ".00");

                    order.set(7, ((int) order.get(6) * orderQuantity));

                    showOrderTotal();
                }
            }

            private void showOrderTotal() {
                orderTotal = 0;

                for (LinkedList<Object> order : orderInfoList) {
                    orderTotal += (int) order.get(7);
                }

                c.orderTotalText.setText("<html><div style='text-align: right;'>" +
                        "PHP " + String.format("%,d", orderTotal) + ".00" +
                        "</div></html>"
                );
            }

            private void repaint(Component component){
                SwingUtilities.invokeLater(() -> {
                    component.revalidate();
                    component.repaint();
                });
            }
        };
    }


    // custom button functionality for the ui
    private static MouseListener createUIMouseListener(ComponentFactory c, AssetFactory a) {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                JLabel button = (JLabel) e.getSource();

                highlightButton(button, a.burgundy, a.uiButtonSelectedIconList);

                // call respective methods for the buttons
                if (button == c.returnButton) {
                    Main.showMenuView(orderInfoList);
                } else if (button == c.confirmOrderButton) {
                    Main.showQueueView(orderInfoList, orderTotal);
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

            public void highlightButton(JLabel button, Color color, LinkedList<ImageIcon> iconList) {
                if (button == c.returnButton) {
                    button.setIcon(a.resizeIcon(iconList.get(0), 200, 60));
                    button.setForeground(color);
                } else if (button == c.confirmOrderButton) {
                    button.setIcon(a.resizeIcon(iconList.get(1), 200, 60));
                    button.setForeground(color);
                }
            }
        };
    }
}
