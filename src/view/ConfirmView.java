package view;

import asset.AssetFactory;
import component.ComponentFactory;
import database.DatabaseManager;
import main.Main;
import panel.PanelFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.LinkedList;

public class ConfirmView {
    JFrame f;
    DatabaseManager d = new DatabaseManager();
    PanelFactory p = new PanelFactory();
    ComponentFactory c = new ComponentFactory();
    AssetFactory a = new AssetFactory();

    int orderContainerSize = 0;
    public JPanel contentPanel = new JPanel();

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
        p.orderPanel.removeAll();

        for (LinkedList<Object> objects : orderList) {
            addToShownOrder((String) objects.get(1), (Integer) objects.getLast());
        }

        repaint(p.orderScrollPane);
    }

    public void addToShownOrder(String liquorName, int orderCount) {
        Container liquorOrderSectionContainer = new Container();
        Container removeOrderContainer = new Container();
        Container liquorOrderImageContainer = new Container();
        Container liquorOrderNameContainer = new Container();
        Container quantityOrderContainer = new Container();
        Container quantitySelectorContainer = new Container();

        JButton removeLiquorOrder = new JButton();
        JButton liquorOrderImage = new JButton();
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

        removeOrderContainer.add(removeLiquorOrder);
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

        removeLiquorOrder.setText("X");
        removeLiquorOrder.setPreferredSize(new Dimension(60, 60));
        removeLiquorOrder.setFocusable(false);

        liquorOrderImage.setText("Liquor");
        liquorOrderImage.setPreferredSize(new Dimension(80, 80));
        liquorOrderImage.setFocusable(false);

        liquorOrderName.setText(liquorName);
        liquorOrderName.setFont(c.toHelvetica(25));
        liquorOrderName.setForeground(Color.BLACK);

        decreaseQuantityButton.setText("-");
        decreaseQuantityButton.setPreferredSize(new Dimension(60, 60));
        decreaseQuantityButton.setFocusable(false);

        orderQuantityText.setText(String.valueOf(orderCount));
        orderQuantityText.setPreferredSize(new Dimension(100, 60));
        orderQuantityText.setHorizontalAlignment(JLabel.CENTER);
        orderQuantityText.setFont(c.toHelvetica(20));
        orderQuantityText.setForeground(Color.BLACK);

        increaseQuantityButton.setText("+");
        increaseQuantityButton.setPreferredSize(new Dimension(60, 60));
        increaseQuantityButton.setFocusable(false);

        orderContainerSize += 80;

        p.orderPanel.setPreferredSize(new Dimension(Main.WIDTH, orderContainerSize));
        p.orderPanel.add(liquorOrderSectionContainer);
    }

    public void finishOrder(ActionEvent e) {
        Main.showQueueView();
    }

    public void returnToMenuView(ActionEvent e) {
        Main.showMenuView();
    }

    public void repaint(Component component){
        SwingUtilities.invokeLater(() -> {
            component.revalidate();
            component.repaint();
        });
    }
}
