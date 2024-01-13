package view;

import asset.AssetFactory;
import component.ComponentFactory;
import database.DatabaseManager;
import main.Main;
import panel.PanelFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QueueView {
    JFrame f;
    DatabaseManager d = new DatabaseManager();
    PanelFactory p = new PanelFactory();
    ComponentFactory c = new ComponentFactory();
    AssetFactory a = new AssetFactory();
    public JPanel contentPanel = new JPanel();

    public QueueView(JFrame frame) {
        this.f = frame;

        p.handleQueueView();
        c.handleQueueView();

        contentPanel.setLayout(new BorderLayout(0, 0));

        p.headerContainerList.get(1).add(c.titleText);

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

        contentPanel.add(p.headerPanel, BorderLayout.NORTH);
        contentPanel.add(p.bodyPanel, BorderLayout.CENTER);
        contentPanel.add(p.footerPanel, BorderLayout.SOUTH);
    }

    public void showOrderNumber() {
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showTitleView();
                ((Timer) e.getSource()).stop();
            }
        });

        timer.start();
    }
}
