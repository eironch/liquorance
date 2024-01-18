package view;

import asset.AssetFactory;
import component.ComponentFactory;
import database.DatabaseManager;
import main.Main;
import menu.MenuDepot;
import panel.PanelFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.LinkedList;

public class ConfirmView {
    JFrame f;
    DatabaseManager d = new DatabaseManager();
    PanelFactory p = new PanelFactory();
    ComponentFactory c = new ComponentFactory();
    AssetFactory a = new AssetFactory();
    MenuDepot m = new MenuDepot();
    int orderContainerSize = 0;
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
//        p.orderTotalContainerList.get(1).add();
        p.orderTotalContainerList.get(2).add(c.orderTotalText);

        for (int i = 0; i < p.orderTotalContainerList.size(); i++) {
            p.footerPanel.add(p.orderTotalContainerList.get(i));
        }

        contentPanel.add(p.headerPanel, BorderLayout.NORTH);
        contentPanel.add(p.orderScrollPane, BorderLayout.CENTER);
        contentPanel.add(p.footerPanel, BorderLayout.SOUTH);
    }

    public void showOrder(LinkedList<LinkedList<Object>> orderList) {
        int orderQuantity;
        int menuID;

        orderContainerSize = 0;

        orderInfoList.clear();
        p.orderPanel.removeAll();

        for (LinkedList<Object> order : orderList) {
            menuID = (int) order.getFirst();
            orderQuantity = (int) order.getLast();

            for (LinkedList<Object> liquor : m.cocktailMenuInfoList) {
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

    public void addToShownOrder(String liquorName, int orderQuantity, int price, ImageIcon liquorImage, int menuID) {
        Container liquorOrderSectionContainer = new Container();
        Container removeOrderContainer = new Container();
        Container liquorOrderImageContainer = new Container();
        Container liquorOrderNameContainer = new Container();
        Container priceQuantityContainer = new Container();
        Container quantityOrderContainer = new Container();
        Container quantitySelectorContainer = new Container();

        JButton removeOrderButton = new JButton();
        JLabel liquorOrderImage = new JLabel();
        JLabel liquorOrderName = new JLabel();
        JLabel liquorPriceText = new JLabel();
        JButton decreaseQuantityButton = new JButton();
        JLabel orderQuantityText = new JLabel();
        JButton increaseQuantityButton = new JButton();
        JLabel liquorTotalText = new JLabel();

        liquorOrderSectionContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        liquorOrderSectionContainer.setPreferredSize(new Dimension(Main.WIDTH, 80));

        removeOrderContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        removeOrderContainer.setPreferredSize(new Dimension(80, 80));

        liquorOrderImageContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        liquorOrderImageContainer.setPreferredSize(new Dimension(80, 80));

        liquorOrderNameContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 10, 20));
        liquorOrderNameContainer.setPreferredSize(new Dimension(300, 80));

        priceQuantityContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        priceQuantityContainer.setPreferredSize(new Dimension(560, 80));

        quantityOrderContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        quantityOrderContainer.setPreferredSize(new Dimension(260, 80));

        quantitySelectorContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        quantitySelectorContainer.setPreferredSize(new Dimension(220, 60));

        removeOrderButton.setText("X");
        removeOrderButton.setPreferredSize(new Dimension(60, 60));
        removeOrderButton.setFocusable(false);
        removeOrderButton.addActionListener(this::removeOrder);

        liquorOrderImage.setIcon(a.resizeIcon(liquorImage, 75, 75));
        liquorOrderImage.setPreferredSize(new Dimension(80, 80));

        liquorOrderName.setText(liquorName);
        liquorOrderName.setFont(a.lora.deriveFont(Font.BOLD, 25f));
        liquorOrderName.setForeground(a.cocoa);

        liquorPriceText.setText("PHP " + String.format("%,d", price));
        liquorPriceText.setFont(a.lora.deriveFont(Font.BOLD, 20f));
        liquorPriceText.setPreferredSize(new Dimension(120, 80));
        liquorPriceText.setHorizontalAlignment(JLabel.RIGHT);
        liquorPriceText.setVerticalAlignment(JLabel.CENTER);
        liquorPriceText.setForeground(a.cocoa);

        decreaseQuantityButton.setIcon(a.resizeIcon(a.decreaseButtonIcon, 60, 60));
        decreaseQuantityButton.setPreferredSize(new Dimension(60, 60));
        decreaseQuantityButton.setFocusable(false);
        decreaseQuantityButton.addMouseListener(createQuantityMouseListener(c, a));

        orderQuantityText.setText(String.valueOf(orderQuantity));
        orderQuantityText.setPreferredSize(new Dimension(100, 60));
        orderQuantityText.setHorizontalAlignment(JLabel.CENTER);
        orderQuantityText.setFont(a.lora.deriveFont(Font.BOLD, 30f));
        orderQuantityText.setForeground(a.cocoa);

        increaseQuantityButton.setIcon(a.resizeIcon(a.increaseButtonIcon, 60, 60));
        increaseQuantityButton.setPreferredSize(new Dimension(60, 60));
        increaseQuantityButton.setFocusable(false);
        increaseQuantityButton.addMouseListener(createQuantityMouseListener(c, a));

        liquorTotalText.setText("PHP " + String.format("%,d", price * orderQuantity) + ".00");
        liquorTotalText.setFont(a.lora.deriveFont(Font.BOLD,20f));
        liquorTotalText.setPreferredSize(new Dimension(150, 80));
        liquorTotalText.setHorizontalAlignment(JLabel.CENTER);
        liquorTotalText.setVerticalAlignment(JLabel.CENTER);
        liquorTotalText.setForeground(a.cocoa);

        removeOrderContainer.add(removeOrderButton);

        liquorOrderImageContainer.add(liquorOrderImage);
        liquorOrderNameContainer.add(liquorOrderName);

        quantitySelectorContainer.add(decreaseQuantityButton);
        quantitySelectorContainer.add(orderQuantityText);
        quantitySelectorContainer.add(increaseQuantityButton);

        quantityOrderContainer.add(quantitySelectorContainer);

        priceQuantityContainer.add(liquorPriceText);
        priceQuantityContainer.add(quantityOrderContainer);
        priceQuantityContainer.add(liquorTotalText);

        liquorOrderSectionContainer.add(removeOrderContainer);
        liquorOrderSectionContainer.add(liquorOrderImageContainer);
        liquorOrderSectionContainer.add(liquorOrderNameContainer);
        liquorOrderSectionContainer.add(priceQuantityContainer);

        orderInfoList.add(new LinkedList<>(Arrays.asList(
                menuID, // 0
                liquorOrderSectionContainer, // 1
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

        orderContainerSize += 80;

        p.orderPanel.setPreferredSize(new Dimension(Main.WIDTH, orderContainerSize));
        p.orderPanel.add(liquorOrderSectionContainer);
    }

    private void removeOrder(ActionEvent e) {
        for (int i = 0; i < orderInfoList.size(); i++) {
            if (!orderInfoList.get(i).contains(e.getSource())) {
                continue;
            }

            p.orderPanel.remove((Component) orderInfoList.get(i).get(1));

            orderInfoList.remove(i);

            repaint(p.orderPanel);

            return;
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

    public void clearLists() {
        orderInfoList.clear();
    }

    private void repaint(Component component){
        SwingUtilities.invokeLater(() -> {
            component.revalidate();
            component.repaint();
        });
    }

    private static MouseListener createQuantityMouseListener(ComponentFactory c, AssetFactory a) {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                JLabel button = (JLabel) e.getSource();

                if (button == c.decreaseQuantityButton) {
                    decreaseQuantity(button);
                } else if (button == c.increaseQuantityButton) {
                    increaseQuantity(button);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                JLabel button = (JLabel) e.getSource();

                if (button == c.decreaseQuantityButton) {
                    button.setIcon(a.resizeIcon(a.decreaseSelectedButtonIcon, 60, 60));
                } else if (button == c.increaseQuantityButton) {
                    button.setIcon(a.resizeIcon(a.increaseSelectedButtonIcon, 60, 60));
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                JLabel button = (JLabel) e.getSource();

                if (button == c.decreaseQuantityButton) {
                    button.setIcon(a.resizeIcon(a.decreaseButtonIcon, 60, 60));
                } else if (button == c.increaseQuantityButton) {
                    button.setIcon(a.resizeIcon(a.increaseButtonIcon, 60, 60));
                }
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
                        JButton button = (JButton) order.get(3);
                        button.setEnabled(false);
                    }

                    JButton button = (JButton) order.get(5);

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
                        JButton button = (JButton) order.get(5);
                        button.setEnabled(false);
                    }

                    JButton button = (JButton) order.get(3);

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
        };
    }

    private static MouseListener createUIMouseListener(ComponentFactory c, AssetFactory a) {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                JLabel button = (JLabel) e.getSource();

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
