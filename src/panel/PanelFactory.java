package panel;

import main.Main;
import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class PanelFactory {
    public JPanel headerPanel = new JPanel();
    public JPanel bodyPanel = new JPanel();
    public JPanel footerPanel = new JPanel();
    public ArrayList<Container> headerContainerList = new ArrayList<>();


    // ------------- menu view --------------

    public ArrayList<Container> catalogRowContainerList = new ArrayList<>();
    public ArrayList<Container> liquorMenuContainerList = new ArrayList<>();
    public ArrayList<Container> categoryContainerList = new ArrayList<>();
    public Container catalogSectionContainer = new Container();

    // ------------ liquor view -------------

    public JLayeredPane layeredPane = new JLayeredPane();
    public Container liquorNameContainer = new Container();
    public Container liquorImageContainer = new Container();
    public Container liquorInfoSectionContainer = new Container();
    public ArrayList<Container> liquorColumnContainer = new ArrayList<>();
    public ArrayList<Container> liquorLeftRowContainer = new ArrayList<>();
    public ArrayList<Container> liquorRightRowContainer = new ArrayList<>();
    public ArrayList<Container> footerColumnContainer = new ArrayList<>();
    public Container quantitySelectorContainer = new Container();


    // ----------- confirm view -------------

    public JScrollPane orderScrollPane;
    public JScrollBar verticalScrollBar;
    public JPanel orderPanel = new JPanel();
    public Container orderTotalContainer = new Container();
    public Container confirmOrderContainer = new Container();

    // ------------ queue view --------------

    public LinkedList<Container> queueComponentContainerList = new LinkedList<>();

    // ------------ title view --------------

    public LinkedList<Container> titleComponentContainerList = new LinkedList<>();

    public PanelFactory() {
        headerPanel.setLayout(new GridLayout(1, 3, 0, 0));
        headerPanel.setPreferredSize(new Dimension(Main.WIDTH, 80));
        headerPanel.setBackground(Color.DARK_GRAY);
    }

    public void handleTitleView() {
        bodyPanel.setLayout(new GridLayout(3, 1, 0, 0));
        bodyPanel.setBackground(Color.DARK_GRAY);

        for (int i = 0; i < 3; i++) {
            titleComponentContainerList.add(new Container());
            titleComponentContainerList.get(i).setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        }
    }

    public void handleMenuView() {
        headerContainerList.add(new Container());
        headerContainerList.get(0).setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        headerContainerList.add(new Container());
        headerContainerList.get(1).setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        headerContainerList.add(new Container());
        headerContainerList.get(2).setLayout(new FlowLayout(FlowLayout.TRAILING, 10, 10));

        bodyPanel.setLayout(new GridLayout(1, 1, 0, 0));
        bodyPanel.setBackground(Color.LIGHT_GRAY);

        for (int i = 0; i < 2; i++) {
            catalogRowContainerList.add(new Container());
            catalogRowContainerList.get(i).setLayout(new GridLayout(1, 4, 0, 0));
        }

        for (int i = 0; i < 8; i++) {
            liquorMenuContainerList.add(new Container());
            liquorMenuContainerList.get(i).setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        }

        for (int i = 0; i < 5; i++) {
            categoryContainerList.add(new Container());
            categoryContainerList.get(i).setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        }

        catalogSectionContainer.setLayout(new GridLayout(2, 1, 0, 0));

        footerPanel.setLayout(new GridLayout(1, 4, 0, 0));
        footerPanel.setBackground(Color.DARK_GRAY);
    }

    public void handleLiquorView() {
        headerContainerList.add(new Container());
        headerContainerList.get(0).setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        headerContainerList.add(new Container());
        headerContainerList.get(1).setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        headerContainerList.add(new Container());
        headerContainerList.get(2).setLayout(new FlowLayout(FlowLayout.TRAILING, 10, 10));

        layeredPane.setLayout(null);

        liquorNameContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 40));
        liquorNameContainer.setSize(Main.WIDTH, Main.HEIGHT - 160);

        liquorImageContainer.setLayout(new BorderLayout());
        liquorImageContainer.setSize(Main.WIDTH, Main.HEIGHT - 160);

        liquorInfoSectionContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        liquorInfoSectionContainer.setSize(Main.WIDTH, Main.HEIGHT - 160);

        liquorColumnContainer.add(new Container());
        liquorColumnContainer.get(0).setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        liquorColumnContainer.get(0).setPreferredSize(new Dimension(450, Main.HEIGHT - 160));
        liquorColumnContainer.add(new Container());
        liquorColumnContainer.get(1).setLayout(new BorderLayout());
        liquorColumnContainer.get(1).setPreferredSize(new Dimension(300, Main.HEIGHT - 160));
        liquorColumnContainer.add(new Container());
        liquorColumnContainer.get(2).setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        liquorColumnContainer.get(2).setPreferredSize(new Dimension(450, Main.HEIGHT - 160));

        liquorLeftRowContainer.add(new Container());
        liquorLeftRowContainer.get(0).setLayout(new BorderLayout(0, 0));
        liquorLeftRowContainer.get(0).setPreferredSize(new Dimension(450, 320));
        liquorLeftRowContainer.add(new Container());
        liquorLeftRowContainer.get(1).setLayout(new FlowLayout(FlowLayout.TRAILING, 0, 20));
        liquorLeftRowContainer.get(1).setPreferredSize(new Dimension(450, 140));
        liquorLeftRowContainer.add(new Container());
        liquorLeftRowContainer.get(2).setLayout(new BorderLayout(0, 0));
        liquorLeftRowContainer.get(2).setPreferredSize(new Dimension(450, 300));

        liquorRightRowContainer.add(new Container());
        liquorRightRowContainer.get(0).setLayout(new BorderLayout(0, 0));
        liquorRightRowContainer.get(0).setPreferredSize(new Dimension(450, 320));
        liquorRightRowContainer.add(new Container());
        liquorRightRowContainer.get(1).setLayout(new FlowLayout(FlowLayout.TRAILING, 0, 20));
        liquorRightRowContainer.get(1).setPreferredSize(new Dimension(450, 175));
        liquorRightRowContainer.add(new Container());
        liquorRightRowContainer.get(2).setLayout(new BorderLayout(0, 0));
        liquorRightRowContainer.get(2).setPreferredSize(new Dimension(450, 80));

        quantitySelectorContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        footerPanel.setLayout(new GridLayout(1, 3, 0, 0));
        footerPanel.setPreferredSize(new Dimension(Main.WIDTH, 80));
        footerPanel.setBackground(Color.DARK_GRAY);

        footerColumnContainer.add(new Container());
        footerColumnContainer.get(0).setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        footerColumnContainer.add(new Container());
        footerColumnContainer.get(1).setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        footerColumnContainer.add(new Container());
        footerColumnContainer.get(2).setLayout(new FlowLayout(FlowLayout.TRAILING, 10, 10));
    }

    public void handleConfirmView() {
        headerContainerList.add(new Container());
        headerContainerList.get(0).setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        headerContainerList.add(new Container());
        headerContainerList.get(1).setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        headerContainerList.add(new Container());
        headerContainerList.get(2).setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        orderScrollPane = new JScrollPane(orderPanel);
        orderScrollPane.setSize(Main.WIDTH, Main.HEIGHT - 160);
        orderScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        orderScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        orderScrollPane.setBackground(Color.LIGHT_GRAY);
        orderScrollPane.getVerticalScrollBar().setUnitIncrement(7);
        orderScrollPane.getVerticalScrollBar().setBackground(Color.LIGHT_GRAY);
        orderScrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        orderScrollPane.getVerticalScrollBar().setBorder(null);
        orderScrollPane.getVerticalScrollBar().setFocusable(false);
        orderScrollPane.setBorder(null);
        verticalScrollBar = orderScrollPane.getVerticalScrollBar();

        orderPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        orderPanel.setPreferredSize(new Dimension(Main.WIDTH, 0));
        orderPanel.setBackground(Color.LIGHT_GRAY);

        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        footerPanel.setBackground(Color.DARK_GRAY);

        orderTotalContainer.setLayout(new FlowLayout(FlowLayout.LEADING, 20, 5));
        orderTotalContainer.setPreferredSize(new Dimension(1080, 60));

        confirmOrderContainer.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));
        confirmOrderContainer.setPreferredSize(new Dimension(200, 60));
    }

    public void handleQueueView() {
        headerContainerList.add(new Container());
        headerContainerList.get(0).setLayout(new FlowLayout(FlowLayout.LEADING, 10, 10));
        headerContainerList.add(new Container());
        headerContainerList.get(1).setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        headerContainerList.add(new Container());
        headerContainerList.get(2).setLayout(new FlowLayout(FlowLayout.TRAILING, 10, 10));

        bodyPanel.setLayout(new GridLayout(3, 1, 0, 0));
        bodyPanel.setBackground(Color.LIGHT_GRAY);

        queueComponentContainerList.add(new Container());
        queueComponentContainerList.getLast().setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        queueComponentContainerList.add(new Container());
        queueComponentContainerList.getLast().setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        queueComponentContainerList.add(new Container());
        queueComponentContainerList.getLast().setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        footerPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 10));
        footerPanel.setPreferredSize(new Dimension(Main.WIDTH, 80));
        footerPanel.setBackground(Color.LIGHT_GRAY);
    }

    static class CustomScrollBarUI extends BasicScrollBarUI {
        int verticalScrollBarWidth = 12;
        int verticalTrackBoundX = 2;
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
            thumbEndGraphic.fillRect(thumbBounds.x + verticalTrackBoundX, thumbBounds.y + 4, thumbBounds.width, thumbBounds.height - 8);

            thumbEndGraphic.dispose();
        }
    }
}
