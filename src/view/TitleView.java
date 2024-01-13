package view;

import asset.AssetFactory;
import component.ComponentFactory;
import database.DatabaseManager;
import main.Main;
import panel.PanelFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TitleView {
    JFrame f;
    DatabaseManager d = new DatabaseManager();
    PanelFactory p = new PanelFactory();
    ComponentFactory c = new ComponentFactory();
    AssetFactory a = new AssetFactory();
    public JPanel contentPanel = new JPanel();

    public TitleView(JFrame frame) {
        this.f = frame;

        p.handleTitleView();
        c.handleTitleView();

        contentPanel.setLayout(new BorderLayout(0, 0));

        c.taglineText.setBorder(BorderFactory.createEmptyBorder(-10, 0, 0, 0));
        c.openCatalogButton.addActionListener(this::showMenuView);

        p.titleComponentContainerList.get(1).add(c.titleText);
        p.titleComponentContainerList.get(1).add(c.taglineText);
        p.titleComponentContainerList.get(2).add(c.openCatalogButton);

        p.bodyPanel.add(p.titleComponentContainerList.get(0));
        p.bodyPanel.add(p.titleComponentContainerList.get(1));
        p.bodyPanel.add(p.titleComponentContainerList.get(2));

        contentPanel.add(p.bodyPanel, BorderLayout.CENTER);
    }

    public void showMenuView(ActionEvent e) {
        Main.showMenuView();
    }
}
