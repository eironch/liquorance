package panel;

import main.Main;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.util.ArrayList;

public class PanelFactory {
    public JPanel headerPanel = new JPanel();
    public JPanel bodyPanel = new JPanel();
    public JPanel footerPanel = new JPanel();
    public ArrayList<Container> headerContainerList = new ArrayList<>();

    // ------------- menu view --------------
    public ArrayList<Container> catalogRowContainerList = new ArrayList<>();
    public ArrayList<Container> catalogContainerList = new ArrayList<>();
    public ArrayList<Container> categoryContainerList = new ArrayList<>();


    // ----------- confirm view -------------

    public JScrollPane orderScrollPane;
    public JScrollBar verticalScrollBar;
    public JPanel orderPanel = new JPanel();
    public Container orderTotalContainer = new Container();
    public Container confirmOrderContainer = new Container();

    public PanelFactory() {
        headerPanel.setLayout(new GridLayout(1, 3, 0, 0));
        headerPanel.setBackground(Color.DARK_GRAY);
    }

    public void handleMenuView() {
        headerContainerList.add(new Container());
        headerContainerList.get(0).setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        headerContainerList.add(new Container());
        headerContainerList.get(1).setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        headerContainerList.add(new Container());
        headerContainerList.get(2).setLayout(new FlowLayout(FlowLayout.TRAILING, 10, 10));

        for (int i = 0; i < 2; i++) {
            catalogRowContainerList.add(new Container());
            catalogRowContainerList.get(i).setLayout(new GridLayout(1, 4, 0, 0));
        }

        for (int i = 0; i < 8; i++) {
            catalogContainerList.add(new Container());
            catalogContainerList.get(i).setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        }

        for (int i = 0; i < 5; i++) {
            categoryContainerList.add(new Container());
            categoryContainerList.get(i).setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        }

        bodyPanel.setLayout(new GridLayout(2, 1, 0, 0));
        bodyPanel.setBackground(Color.LIGHT_GRAY);

        footerPanel.setLayout(new GridLayout(1, 4, 0, 0));
        footerPanel.setBackground(Color.DARK_GRAY);
    }

    public void handleConfirmView() {
        headerContainerList.add(new Container());
        headerContainerList.get(0).setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        headerContainerList.add(new Container());
        headerContainerList.get(1).setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        headerContainerList.add(new Container());
        headerContainerList.get(2).setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        bodyPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        bodyPanel.setBackground(Color.LIGHT_GRAY);

        orderPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        orderPanel.setPreferredSize(new Dimension(Main.WIDTH, 0));
        orderPanel.setBackground(Color.LIGHT_GRAY);

        orderScrollPane = new JScrollPane(orderPanel);
        orderScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        orderScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        orderScrollPane.setBackground(Color.LIGHT_GRAY);
        orderScrollPane.getVerticalScrollBar().setUnitIncrement(4);
        orderScrollPane.getVerticalScrollBar().setBackground(Color.LIGHT_GRAY);
        orderScrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        orderScrollPane.getVerticalScrollBar().setBorder(null);
        orderScrollPane.getVerticalScrollBar().setFocusable(false);
        orderScrollPane.setBorder(null);
        verticalScrollBar = orderScrollPane.getVerticalScrollBar();

        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        footerPanel.setBackground(Color.DARK_GRAY);

        orderTotalContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 5));
        orderTotalContainer.setPreferredSize(new Dimension(1080, 60));

        confirmOrderContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        confirmOrderContainer.setPreferredSize(new Dimension(200, 60));
    }

    public void handleLiquorView() {
        bodyPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        bodyPanel.setBackground(Color.BLACK);
    }

    static class CustomScrollBarUI extends BasicScrollBarUI {
        int verticalScrollBarWidth = 12;
        int verticalTrackBoundX = 8;
        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createArrowButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createArrowButton();
        }

        private JButton createArrowButton() {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(0, 0));
            return button;
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            trackBounds.width = verticalScrollBarWidth;
            g.setColor(Color.LIGHT_GRAY);
            g.fillRect(trackBounds.x + verticalTrackBoundX, trackBounds.y, trackBounds.width, trackBounds.height);
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            thumbBounds.width = verticalScrollBarWidth;
            Graphics2D thumbEndGraphic = (Graphics2D) g;

            thumbEndGraphic.setColor(Color.DARK_GRAY);
            thumbEndGraphic.fillRect(thumbBounds.x + verticalTrackBoundX, thumbBounds.y, thumbBounds.width, thumbBounds.height);

            thumbEndGraphic.dispose();
        }
    }
}
