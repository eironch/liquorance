package view;

import main.Main;
import component.ComponentFactory;
import database.DatabaseManager;
import panel.PanelFactory;
import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.LinkedList;

public class QueueView {
    JFrame f;
    DatabaseManager d = new DatabaseManager();
    PanelFactory p = new PanelFactory();
    ComponentFactory c = new ComponentFactory();
    public JPanel contentPanel = new JPanel();

    public QueueView(JFrame frame) {
        this.f = frame;

        p.handleQueueView();
        c.handleQueueView();

        contentPanel.setLayout(new BorderLayout(0, 0));

        p.headerContainerList.get(1).add(c.logoText);

        for (int i = 0; i < p.headerContainerList.size(); i++) {
            p.headerPanel.add(p.headerContainerList.get(i));
        }

        p.queueComponentContainerList.get(0).add(c.orderNumberContext);
        p.queueComponentContainerList.get(1).add(c.orderNumberText);
        p.queueComponentContainerList.get(2).add(c.orderTotalContext);
        p.queueComponentContainerList.get(2).add(c.orderTotalText);

        for (int i = 0; i < p.queueComponentContainerList.size(); i++) {
            p.bodyPanel.add(p.queueComponentContainerList.get(i));
        }

        p.footerPanel.add(c.decorImage);

        contentPanel.add(p.headerPanel, BorderLayout.NORTH);
        contentPanel.add(p.bodyPanel, BorderLayout.CENTER);
        contentPanel.add(p.footerPanel, BorderLayout.SOUTH);
    }

    // completes the order
    public void processOrder(LinkedList<LinkedList<Object>> orderInfoList, int orderTotal) {
        int orderID;

        try {
            d.insertToOrders(Timestamp.valueOf(LocalDateTime.now()), orderTotal);
            orderID = d.getOrderIdOfLatest();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        for (LinkedList<Object> order : orderInfoList) {
            try {
                d.insertToOrderedItems(orderID,
                        (Integer) order.getFirst(),
                        (String) order.get(9),
                        (Integer) order.getLast(),
                        (Integer) order.get(7)
                );
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        c.orderNumberText.setText(String.valueOf(orderID));

        c.orderTotalText.setText("PHP " + String.format("%,d", orderTotal) + ".00");

        Timer timer = new Timer(5000, e -> {
            Main.showTitleView();
            Main.clearAllLists();
            ((Timer) e.getSource()).stop();
        });

        timer.start();
    }
}
