package view;

import main.Main;
import component.ComponentFactory;
import panel.PanelFactory;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TitleView {
    JFrame f;
    PanelFactory p = new PanelFactory();
    ComponentFactory c = new ComponentFactory();
    public JPanel contentPanel = new JPanel();

    public TitleView(JFrame frame) {
        this.f = frame;

        p.handleTitleView();
        c.handleTitleView();

        contentPanel.setLayout(new BorderLayout(0, 0));

        p.titleComponentContainerList.get(1).add(c.logoImage);
        p.titleComponentContainerList.get(2).add(c.touchImage);

        p.bodyPanel.add(p.titleComponentContainerList.get(0));
        p.bodyPanel.add(p.titleComponentContainerList.get(1));
        p.bodyPanel.add(p.titleComponentContainerList.get(2));

        contentPanel.add(p.bodyPanel, BorderLayout.CENTER);

        c.logoImage.addMouseListener(createMouseListener());
        c.touchImage.addMouseListener(createMouseListener());
        contentPanel.addMouseListener(createMouseListener());
    }

    private static MouseListener createMouseListener() {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Main.showMenuView();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
    }

}
