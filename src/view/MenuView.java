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
    int orderQuantity = 0;
    LinkedList<LinkedList<Object>> liquorMenuList = new LinkedList<>();
    LinkedList<LinkedList<Object>> orderList = new LinkedList<>();

    public MenuView(JFrame frame) {
        this.f = frame;

        p.handleMenuView();
        c.handleMenuView();

        contentPanel.setLayout(new BorderLayout(0, 0));
        contentPanel.setBackground(a.burgundy);

        c.returnButton.addMouseListener(createUIMouseListener(orderList, c, a));
        c.orderButton.addMouseListener(createUIMouseListener(orderList, c, a));

        p.headerContainerList.get(0).add(c.returnButton);
        p.headerContainerList.get(1).add(c.logoText);
        p.headerContainerList.get(2).add(c.orderButton);

        for (int i = 0; i < p.headerContainerList.size(); i++) {
            p.headerPanel.add(p.headerContainerList.get(i));
        }

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

        for (int i = 0; i < c.liquorImageList.size(); i++) {
            c.liquorImageList.get(i).setIcon(
                    a.cropTopImageIcon(
                    a.resizeIcon(
                    (ImageIcon) m.menuInfoList.get(i).get(5), 230, 230
                    ), 220));
            c.liquorImageList.get(i).addMouseListener(createMenuMouseListener(liquorMenuList, orderList, a));

            c.liquorNameList.get(i).setText((String) m.menuInfoList.get(i).get(1));
            c.liquorNameList.get(i).addMouseListener(createMenuMouseListener(liquorMenuList, orderList, a));

            liquorMenuList.get(i).set(3, m.menuInfoList.get(i).getFirst());
        }

        p.menuRowContainerList.get(0).add(p.liquorLayeredPaneList.get(0));
        p.menuRowContainerList.get(0).add(p.liquorLayeredPaneList.get(1));
        p.menuRowContainerList.get(0).add(p.liquorLayeredPaneList.get(2));
        p.menuRowContainerList.get(0).add(p.liquorLayeredPaneList.get(3));

        p.menuRowContainerList.get(1).add(p.liquorLayeredPaneList.get(4));
        p.menuRowContainerList.get(1).add(p.liquorLayeredPaneList.get(5));
        p.menuRowContainerList.get(1).add(p.liquorLayeredPaneList.get(6));
        p.menuRowContainerList.get(1).add(p.liquorLayeredPaneList.get(7));

        p.menuRowContainerList.get(2).add(p.liquorLayeredPaneList.get(8));
        p.menuRowContainerList.get(2).add(p.liquorLayeredPaneList.get(9));
        p.menuRowContainerList.get(2).add(p.liquorLayeredPaneList.get(10));
        p.menuRowContainerList.get(2).add(p.liquorLayeredPaneList.get(11));

        p.menuRowContainerList.get(3).add(p.liquorLayeredPaneList.get(12));
        p.menuRowContainerList.get(3).add(p.liquorLayeredPaneList.get(13));
        p.menuRowContainerList.get(3).add(p.liquorLayeredPaneList.get(14));
        p.menuRowContainerList.get(3).add(p.liquorLayeredPaneList.get(15));

        p.menuSectionPanel.add(p.menuRowContainerList.get(0));
        p.menuSectionPanel.add(p.menuRowContainerList.get(1));
        p.menuSectionPanel.add(p.menuRowContainerList.get(2));
        p.menuSectionPanel.add(p.menuRowContainerList.get(3));

        p.quantitySelectorContainer.add(c.decreaseQuantityButton);
        p.quantitySelectorContainer.add(c.orderQuantityText);
        p.quantitySelectorContainer.add(c.increaseQuantityButton);

        contentPanel.add(p.headerPanel, BorderLayout.NORTH);
        contentPanel.add(p.menuScrollPane, BorderLayout.CENTER);
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

        updateOrderQuantity();
    }

    // change total quantity beside the order text
    public void updateOrderQuantity() {
        orderQuantity = 0;

        for (LinkedList<Object> order : orderList) {
            orderQuantity += (int) order.getLast();
        }

        c.orderButton.setText("Order (" + orderQuantity +")");

        repaint(c.orderButton);
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

    // custom button functionality for the ui
    private static MouseListener createUIMouseListener(
            LinkedList<LinkedList<Object>> orderList, ComponentFactory c, AssetFactory a) {
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
                } else if (button == c.orderButton) {
                    button.setIcon(a.resizeIcon(iconList.get(1), 200, 60));
                    button.setForeground(color);
                }
            }
        };
    }

    // custom button functionality for the menu
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
                Component component = (Component) e.getSource();

                highlightButton(component, a.menuButtonSelectedIcon, a.burgundy);

                Main.showLiquorView(orderList, getMenuID(e));
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

            public int getMenuID(MouseEvent e){
                int menuID = 0;

                // get menu id
                for (LinkedList<Object> objects : liquorMenuList) {
                    if (!objects.contains(e.getSource())) {
                        continue;
                    }

                    menuID = (Integer) objects.getLast();

                    break;
                }

                return menuID;
            }

            public void highlightButton(Component component, ImageIcon imageIcon, Color color) {
                for (LinkedList<Object> liquor : liquorMenuList) {
                    if (!liquor.contains(component)) {
                        continue;
                    }

                    // highlight
                    JLabel indicator = (JLabel) liquor.getFirst();
                    indicator.setIcon(a.resizeIcon(imageIcon, 280, 280));

                    // change text color
                    JLabel name =  (JLabel) liquor.get(2);
                    name.setForeground(color);

                    break;
                }
            }
        };
    }
}
