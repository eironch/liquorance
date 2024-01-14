package component;

import main.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ComponentFactory {
    public JLabel titleText = new JLabel();

    // ------------- menu view --------------

    public JButton changeViewButton = new JButton();
    public JButton orderButton = new JButton();
    public ArrayList<JButton> liquorMenuButtonList = new ArrayList<>();
    public ArrayList<JLabel> liquorMenuNameList = new ArrayList<>();
    public ArrayList<JButton> categoryButtonList = new ArrayList<>();

    // ----------- confirm view -------------

    public JButton returnButton = new JButton();
    public JButton confirmOrderButton = new JButton();
    public JLabel orderTotalText = new JLabel();

    // ------------ queue view --------------

    public JLabel orderNumberContext = new JLabel();
    public JLabel orderNumberText = new JLabel();
    public JLabel orderTotalContext = new JLabel();

    // ------------ title view --------------

    public JLabel taglineText = new JLabel();
    public JButton openCatalogButton = new JButton();

    // ---------- quantity prompt -----------

    public JLabel orderQuantityContext = new JLabel();
    public JButton decreaseQuantityButton = new JButton();
    public JLabel orderQuantityText = new JLabel();
    public JButton increaseQuantityButton = new JButton();
    public JButton cancelButton = new JButton();
    public JButton confirmButton = new JButton();

    // ---------- removal prompt ------------

    public JLabel removalContext = new JLabel();

    public ComponentFactory() {
        titleText.setText("Liquorance");
        titleText.setFont(toHelvetica(40));
        titleText.setForeground(Color.WHITE);
    }

    public void handleTitleView() {
        titleText.setFont(toHelvetica(150));
        titleText.setPreferredSize(new Dimension(Main.WIDTH, 180));
        titleText.setHorizontalAlignment(JLabel.CENTER);

        taglineText.setText("Have your night.");
        taglineText.setFont(toHelvetica(40));
        taglineText.setForeground(Color.WHITE);

        openCatalogButton.setText("See Catalog");
        openCatalogButton.setPreferredSize(new Dimension(200, 60));
        openCatalogButton.setFocusable(false);
    }

    public void handleMenuView() {
        changeViewButton.setText("View");
        changeViewButton.setPreferredSize(new Dimension(100,60));
        changeViewButton.setFocusable(false);

        orderButton.setText("Order");
        orderButton.setPreferredSize(new Dimension(200,60));
        orderButton.setFocusable(false);

        for (int i = 0; i < 8; i++) {
            liquorMenuButtonList.add(new JButton());
            liquorMenuButtonList.get(i).setPreferredSize(new Dimension(320, 260));
            liquorMenuButtonList.get(i).setFocusable(false);
        }

        for (int i = 0; i < 8; i++) {
            liquorMenuNameList.add(new JLabel());
            liquorMenuNameList.get(i).setFont(toHelvetica(15));
            liquorMenuNameList.get(i).setPreferredSize(new Dimension(320, 60));
            liquorMenuNameList.get(i).setHorizontalAlignment(JLabel.CENTER);
        }

        for (int i = 0; i < 5; i++) {
            categoryButtonList.add(new JButton());
            categoryButtonList.get(i).setText("" + i);
            categoryButtonList.get(i).setPreferredSize(new Dimension(80, 80));
            categoryButtonList.get(i).setFocusable(false);
        }

        orderQuantityContext.setText("Order Quantity");
        orderQuantityContext.setFont(toHelvetica(30));
        orderQuantityContext.setForeground(Color.WHITE);

        decreaseQuantityButton.setText("-");
        decreaseQuantityButton.setPreferredSize(new Dimension(60, 60));
        decreaseQuantityButton.setFocusable(false);

        orderQuantityText.setText("1");
        orderQuantityText.setPreferredSize(new Dimension(100, 60));
        orderQuantityText.setHorizontalAlignment(JLabel.CENTER);
        orderQuantityText.setFont(toHelvetica(20));
        orderQuantityText.setForeground(Color.WHITE);

        increaseQuantityButton.setText("+");
        increaseQuantityButton.setPreferredSize(new Dimension(60, 60));
        increaseQuantityButton.setFocusable(false);

        cancelButton.setText("Cancel");
        cancelButton.setPreferredSize(new Dimension(120,60));
        cancelButton.setFocusable(false);

        confirmButton.setText("Confirm");
        confirmButton.setPreferredSize(new Dimension(120,60));
        confirmButton.setFocusable(false);
    }

    public void handleConfirmView() {
        returnButton.setText("Return");
        returnButton.setPreferredSize(new Dimension(100, 60));
        returnButton.setFocusable(false);

        orderTotalText.setText("Order Total: PHP 10,000.00");
        orderTotalText.setFont(toHelvetica(40));
        orderTotalText.setForeground(Color.WHITE);

        confirmOrderButton.setText("Confirm Order");
        confirmOrderButton.setPreferredSize(new Dimension(180, 60));
        confirmOrderButton.setFocusable(false);
    }

    public void handleQueueView() {
        orderNumberContext.setText("Your Order Number:");
        orderNumberContext.setPreferredSize(new Dimension(Main.WIDTH, 330));
        orderNumberContext.setHorizontalAlignment(JLabel.CENTER);
        orderNumberContext.setVerticalAlignment(JLabel.CENTER);
        orderNumberContext.setFont(toHelvetica(50));
        orderNumberContext.setForeground(Color.BLACK);

        orderNumberText.setText("200");
        orderNumberText.setFont(toHelvetica(250));
        orderNumberText.setBorder(BorderFactory.createEmptyBorder(-55, 0, 0, 0));
        orderNumberText.setForeground(Color.BLACK);

        orderTotalContext.setText("Please Prepare Your Payment Of");
        orderTotalContext.setPreferredSize(new Dimension(Main.WIDTH, 70));
        orderTotalContext.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));
        orderTotalContext.setHorizontalAlignment(JLabel.CENTER);
        orderTotalContext.setFont(toHelvetica(32));
        orderTotalContext.setForeground(Color.BLACK);

        orderTotalText.setText("PHP 10,000.00");
        orderTotalText.setFont(toHelvetica(37));
        orderTotalText.setForeground(Color.BLACK);
    }

    public Font toHelvetica(int size){
        return new Font("Helvetica", Font.BOLD, size);
    }
}
