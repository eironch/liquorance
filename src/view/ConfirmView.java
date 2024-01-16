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
    public JPanel contentPanel = new JPanel();
    LinkedList<LinkedList<Object>> orderInfoList = new LinkedList<>();

    public ConfirmView(JFrame frame) {
        this.f = frame;

        p.handleConfirmView();
        c.handleConfirmView();

        contentPanel.setLayout(new BorderLayout(0, 0));

        c.returnButton.addActionListener(this::returnToMenuView);

        p.headerContainerList.get(0).add(c.returnButton);
        p.headerContainerList.get(1).add(c.titleText);

        for (int i = 0; i < p.headerContainerList.size(); i++) {
            p.headerPanel.add(p.headerContainerList.get(i));
        }

        c.confirmOrderButton.addActionListener(this::finishOrder);

        p.orderTotalContainer.add(c.orderTotalText);

        p.confirmOrderContainer.add(c.confirmOrderButton);

        p.footerPanel.add(p.orderTotalContainer);
        p.footerPanel.add(p.confirmOrderContainer);

        contentPanel.add(p.headerPanel, BorderLayout.NORTH);
        contentPanel.add(p.orderScrollPane, BorderLayout.CENTER);
        contentPanel.add(p.footerPanel, BorderLayout.SOUTH);
    }

    public void showOrder(LinkedList<LinkedList<Object>> orderList) {
        orderContainerSize = 0;

        orderInfoList.clear();
        p.orderPanel.removeAll();

        for (LinkedList<Object> order : orderList) {
            addToShownOrder((String) order.get(1), (Integer) order.getLast(),
                    (ImageIcon) order.get(2), (Integer) order.getFirst());
        }

        repaint(p.orderScrollPane);
    }

    public void addToShownOrder(String liquorName, int orderQuantity, ImageIcon liquorImage, int menuID) {
        Container liquorOrderSectionContainer = new Container();
        Container removeOrderContainer = new Container();
        Container liquorOrderImageContainer = new Container();
        Container liquorOrderNameContainer = new Container();
        Container quantityOrderContainer = new Container();
        Container quantitySelectorContainer = new Container();

        JButton removeOrderButton = new JButton();
        JLabel liquorOrderImage = new JLabel();
        JLabel liquorOrderName = new JLabel();
        JButton decreaseQuantityButton = new JButton();
        JLabel orderQuantityText = new JLabel();
        JButton increaseQuantityButton = new JButton();

        liquorOrderSectionContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        liquorOrderSectionContainer.setPreferredSize(new Dimension(Main.WIDTH, 80));

        removeOrderContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        removeOrderContainer.setPreferredSize(new Dimension(80, 80));

        liquorOrderImageContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        liquorOrderImageContainer.setPreferredSize(new Dimension(80, 80));

        liquorOrderNameContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 20));
        liquorOrderNameContainer.setPreferredSize(new Dimension(500, 80));

        quantityOrderContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        quantityOrderContainer.setPreferredSize(new Dimension(240, 80));

        quantitySelectorContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        quantitySelectorContainer.setPreferredSize(new Dimension(220, 60));

        removeOrderButton.setText("X");
        removeOrderButton.setPreferredSize(new Dimension(60, 60));
        removeOrderButton.setFocusable(false);
        removeOrderButton.addActionListener(this::removeOrder);

        liquorOrderImage.setIcon(a.resizeIcon(liquorImage, 75, 75));
        liquorOrderImage.setPreferredSize(new Dimension(80, 80));

        liquorOrderName.setText(liquorName);
        liquorOrderName.setFont(c.toHelvetica(25));
        liquorOrderName.setForeground(Color.BLACK);

        decreaseQuantityButton.setText("-");
        decreaseQuantityButton.setPreferredSize(new Dimension(60, 60));
        decreaseQuantityButton.setFocusable(false);
        decreaseQuantityButton.addActionListener(this::decreaseQuantity);

        orderQuantityText.setText(String.valueOf(orderQuantity));
        orderQuantityText.setPreferredSize(new Dimension(100, 60));
        orderQuantityText.setHorizontalAlignment(JLabel.CENTER);
        orderQuantityText.setFont(c.toHelvetica(20));
        orderQuantityText.setForeground(Color.BLACK);

        increaseQuantityButton.setText("+");
        increaseQuantityButton.setPreferredSize(new Dimension(60, 60));
        increaseQuantityButton.setFocusable(false);
        increaseQuantityButton.addActionListener(this::increaseQuantity);

        removeOrderContainer.add(removeOrderButton);

        liquorOrderImageContainer.add(liquorOrderImage);
        liquorOrderNameContainer.add(liquorOrderName);

        quantitySelectorContainer.add(decreaseQuantityButton);
        quantitySelectorContainer.add(orderQuantityText);
        quantitySelectorContainer.add(increaseQuantityButton);

        quantityOrderContainer.add(quantitySelectorContainer);

        liquorOrderSectionContainer.add(removeOrderContainer);
        liquorOrderSectionContainer.add(liquorOrderImageContainer);
        liquorOrderSectionContainer.add(liquorOrderNameContainer);
        liquorOrderSectionContainer.add(quantityOrderContainer);

        orderInfoList.add(new LinkedList<>(Arrays.asList(
                liquorOrderSectionContainer, // 0
                removeOrderButton, // 1
                decreaseQuantityButton, // 2
                orderQuantityText, // 3
                increaseQuantityButton, // 4
                menuID, // 5
                orderQuantity // 6
        )));

        orderContainerSize += 80;

        p.orderPanel.setPreferredSize(new Dimension(Main.WIDTH, orderContainerSize));
        p.orderPanel.add(liquorOrderSectionContainer);
    }

    private void removeOrder(ActionEvent e) {
        for (int i = 0; i < orderInfoList.size(); i++) {
            if (!orderInfoList.get(i).contains(e.getSource())) {
                continue;
            }

            p.orderPanel.remove((Component) orderInfoList.get(i).getFirst());

            orderInfoList.remove(i);

            repaint(p.layeredPane);

            return;
        }
    }

    private void decreaseQuantity(ActionEvent e) {
        for (int i = 0; i < orderInfoList.size(); i++) {
            if (!orderInfoList.get(i).contains(e.getSource())) {
                continue;
            }

            int orderQuantity = (int) orderInfoList.get(i).getLast();

            if (orderQuantity == 1) {
                return;
            }

            orderInfoList.get(i).set(6, --orderQuantity);

            JLabel orderQuantityText = (JLabel) orderInfoList.get(i).get(3);
            orderQuantityText.setText(String.valueOf(orderInfoList.get(i).getLast()));

            repaint(orderQuantityText);
        }
    }

    private void increaseQuantity(ActionEvent e) {
        for (LinkedList<Object> object : orderInfoList) {
            if (!object.contains(e.getSource())) {
                continue;
            }

            int orderQuantity = (int) object.getLast();

            if (orderQuantity == 99) {
                return;
            }

            object.set(6, ++orderQuantity);
            JLabel orderQuantityText = (JLabel) object.get(3);

            orderQuantityText.setText(String.valueOf(object.getLast()));

            repaint(orderQuantityText);
        }
    }

    private void finishOrder(ActionEvent e) {
        Main.showQueueView();
    }

    private void returnToMenuView(ActionEvent e) {
        Main.showMenuView(orderInfoList);
    }

    private void repaint(Component component){
        SwingUtilities.invokeLater(() -> {
            component.revalidate();
            component.repaint();
        });
    }
}
