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
import java.util.*;

public class MenuView {
    JFrame f;
    PanelFactory p = new PanelFactory();
    ComponentFactory c = new ComponentFactory();
    AssetFactory a = new AssetFactory();
    MenuDepot m = new MenuDepot();
    public JPanel contentPanel = new JPanel();
    LinkedList<LinkedList<Object>> liquorMenuList = new LinkedList<>();
    LinkedList<LinkedList<Object>> orderList = new LinkedList<>();

    public MenuView(JFrame frame) {
        this.f = frame;

        p.handleMenuView();
        c.handleMenuView();

        contentPanel.setLayout(new BorderLayout(0, 0));

        c.returnButton.addMouseListener(createUIMouseListener(orderList, c, a));
        c.orderButton.addMouseListener(createUIMouseListener(orderList, c, a));

        p.headerContainerList.get(0).add(c.returnButton);
        p.headerContainerList.get(1).add(c.logoText);
        p.headerContainerList.get(2).add(c.orderButton);

        for (int i = 0; i < p.headerContainerList.size(); i++) {
            p.headerPanel.add(p.headerContainerList.get(i));
        }

        handleMenuViewButton();

        for (int i = 0; i < c.liquorImageList.size(); i++) {
            c.liquorImageList.get(i).setIcon(
                    a.cropTopImageIcon(
                    a.resizeIcon(
                    (ImageIcon) m.cocktailMenuInfoList.get(i).get(5), 230, 230
                    ), 220));
            c.liquorImageList.get(i).addMouseListener(createMenuMouseListener(liquorMenuList, orderList, a));

            c.liquorNameList.get(i).setText((String) m.cocktailMenuInfoList.get(i).get(1));
            c.liquorNameList.get(i).addMouseListener(createMenuMouseListener(liquorMenuList, orderList, a));

            liquorMenuList.get(i).set(3, m.cocktailMenuInfoList.get(i).getFirst());
        }

        p.menuRowContainerList.get(0).add(p.liquorLayeredPaneList.get(0));
        p.menuRowContainerList.get(0).add(p.liquorLayeredPaneList.get(1));
        p.menuRowContainerList.get(0).add(p.liquorLayeredPaneList.get(2));
        p.menuRowContainerList.get(0).add(p.liquorLayeredPaneList.get(3));

        p.menuRowContainerList.get(1).add(p.liquorLayeredPaneList.get(4));
        p.menuRowContainerList.get(1).add(p.liquorLayeredPaneList.get(5));
        p.menuRowContainerList.get(1).add(p.liquorLayeredPaneList.get(6));
        p.menuRowContainerList.get(1).add(p.liquorLayeredPaneList.get(7));

        p.menuSectionContainer.add(p.menuRowContainerList.get(0));
        p.menuSectionContainer.add(p.menuRowContainerList.get(1));

        p.quantitySelectorContainer.add(c.decreaseQuantityButton);
        p.quantitySelectorContainer.add(c.orderQuantityText);
        p.quantitySelectorContainer.add(c.increaseQuantityButton);

        p.bodyPanel.add(p.menuSectionContainer);

        contentPanel.add(p.headerPanel, BorderLayout.NORTH);
        contentPanel.add(p.bodyPanel, BorderLayout.CENTER);
    }

    private void handleMenuViewButton() {
        for (int i = 0; i < c.liquorImageList.size(); i++) {
            int menuID = 0;

            p.liquorButtonContainerList.get(i).add(c.liquorIndicatorList.get(i));

            p.liquorImageTextContainerList.get(i).add(c.liquorImageList.get(i));
            p.liquorImageTextContainerList.get(i).add(c.liquorNameList.get(i));

            p.liquorLayeredPaneList.get(i).add(p.liquorButtonContainerList.get(i), JLayeredPane.DEFAULT_LAYER);
            p.liquorLayeredPaneList.get(i).add(p.liquorImageTextContainerList.get(i), JLayeredPane.PALETTE_LAYER);

            liquorMenuList.add(new LinkedList<>(Arrays.asList(
                    c.liquorIndicatorList.get(i), // 0
                    c.liquorImageList.get(i), // 1
                    c.liquorNameList.get(i), // 2
                    menuID // 3
            )));
        }
    }

    public void updateOrder(LinkedList<LinkedList<Object>> orderInfoList) {
        ArrayList<Integer> removeOrderList = new ArrayList<>();
        for (int x = 0; x < orderList.size(); x++) {

            if (orderInfoList.isEmpty()) {
                orderList.clear();

                return;
            }

            for (int i = 0; i < orderInfoList.size(); i++) {
                if (!orderInfoList.get(i).getFirst().equals(orderList.get(x).getFirst())) {
                    if (i == orderInfoList.size() - 1) {
                        removeOrderList.add((int) orderList.get(x).getFirst());
                    }

                    continue;
                }

                if (orderInfoList.get(i).getLast().equals(orderList.get(x).getLast())) {
                    break;
                }

                orderList.get(i).set(1, orderInfoList.get(i).getLast());

                break;
            }
        }

        for (int id : removeOrderList) {
            for (int i = 0; i < orderList.size(); i++) {
                if (!orderList.get(i).getFirst().equals(id)) {
                    continue;
                }

                orderList.remove(i);

                break;
            }
        }

        removeOrderList.clear();
    }

    public void clearLists() {
        orderList.clear();
    }

    private static MouseListener createUIMouseListener(
            LinkedList<LinkedList<Object>> orderList, ComponentFactory c, AssetFactory a) {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel button = (JLabel) e.getSource();

                if (button == c.returnButton) {
                    Main.showTitleView();

                } else if (button == c.orderButton) {
                    if (orderList.isEmpty()) {
                        return;
                    }

                    Main.showConfirmView(orderList);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

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
                } else if (button == c.orderButton) {
                    button.setIcon(a.resizeIcon(iconList.get(1), 200, 60));
                    button.setForeground(color);
                }
            }
        };
    }

    private static MouseListener createMenuMouseListener(
            LinkedList<LinkedList<Object>> liquorMenuList,
            LinkedList<LinkedList<Object>> orderList,
            AssetFactory a) {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                int menuID = 0;

                // get menu id
                for (LinkedList<Object> objects : liquorMenuList) {
                    if (!objects.contains(e.getSource())) {
                        continue;
                    }

                    menuID = (Integer) objects.getLast();

                    break;
                }

                Main.showLiquorView(orderList, menuID);
            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                Component component = (Component) e.getSource();

                highlightButton(component, a.menuButtonSelectedIcon, a.burgundy);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                Component component = (Component) e.getSource();

                highlightButton(component, a.menuButtonIcon, a.cocoa);
            }

            public void highlightButton(Component component, ImageIcon imageIcon, Color color) {
                for (LinkedList<Object> liquor : liquorMenuList) {
                    if (!liquor.contains(component)) {
                        continue;
                    }

                    JLabel indicator = (JLabel) liquor.getFirst();

                    indicator.setIcon(a.resizeIcon(imageIcon, 280, 280));

                    JLabel name =  (JLabel) liquor.get(2);

                    name.setForeground(color);

                    break;
                }
            }
        };
    }
}
