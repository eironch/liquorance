package component;

import asset.AssetFactory;
import main.Main;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ComponentFactory {
    AssetFactory a = new AssetFactory();
    public JLabel titleText = new JLabel();

    // ------------- menu view --------------

    public JButton changeViewButton = new JButton();
    public JButton orderButton = new JButton();
    public ArrayList<JButton> liquorMenuButtonList = new ArrayList<>();
    public ArrayList<JLabel> liquorMenuNameList = new ArrayList<>();
    public ArrayList<JButton> categoryButtonList = new ArrayList<>();

    // ---------- quantity view -------------

    public JLabel liquorBackgroundName = new JLabel();
    public JLabel liquorImage = new JLabel();
    public JLabel liquorForegroundName = new JLabel();
    public JLabel liquorFlavorText = new JLabel();
    public JLabel liquorPriceText = new JLabel();
    public JLabel liquorCategoryText = new JLabel();
    public JLabel liquorDescriptionText = new JLabel();
    public JLabel liquorIngredientsText = new JLabel();

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

    public JButton decreaseQuantityButton = new JButton();
    public JLabel orderQuantityText = new JLabel();
    public JButton increaseQuantityButton = new JButton();
    public JButton cancelButton = new JButton();
    public JButton confirmButton = new JButton();

    // ---------- removal prompt ------------

    public JLabel removalContext = new JLabel();

    public ComponentFactory() {
        titleText.setText("Liquorance");
        titleText.setFont(a.metanoia.deriveFont(55f));
        titleText.setForeground(Color.WHITE);
    }

    public void handleTitleView() {
        titleText.setFont(a.metanoia.deriveFont(150f));
        titleText.setPreferredSize(new Dimension(Main.WIDTH, 180));
        titleText.setHorizontalAlignment(JLabel.CENTER);

        taglineText.setText("Have your night.");
        taglineText.setFont(a.lora.deriveFont(40f));
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
            liquorMenuButtonList.get(i).setPreferredSize(new Dimension(260, 260));
            liquorMenuButtonList.get(i).setBackground(Color.LIGHT_GRAY);
            liquorMenuButtonList.get(i).setFocusable(false);
            liquorMenuButtonList.get(i).setBorder(null);
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
    }

    public void handleLiquorView() {
        changeViewButton.setText("View");
        changeViewButton.setPreferredSize(new Dimension(100,60));
        changeViewButton.setFocusable(false);

        orderButton.setText("Order");
        orderButton.setPreferredSize(new Dimension(200,60));
        orderButton.setFocusable(false);

        liquorBackgroundName.setForeground(Color.BLACK);

        liquorImage.setPreferredSize(new Dimension(300, Main.HEIGHT - 160));
        liquorImage.setBorder(BorderFactory.createEmptyBorder(-120, 0, 0, 0));
        liquorImage.setHorizontalAlignment(JLabel.CENTER);
        liquorImage.setForeground(Color.DARK_GRAY);

        liquorForegroundName.setFont(a.lora.deriveFont(Font.BOLD, 24f));
        liquorForegroundName.setHorizontalAlignment(JLabel.RIGHT);
        liquorForegroundName.setVerticalAlignment(JLabel.BOTTOM);

        liquorFlavorText.setFont(a.lora.deriveFont(17f));
        liquorFlavorText.setPreferredSize(new Dimension(450, 120));
        liquorFlavorText.setHorizontalAlignment(JLabel.RIGHT);
        liquorFlavorText.setVerticalAlignment(JLabel.TOP);

        liquorPriceText.setFont(a.lora.deriveFont(100f));
        liquorPriceText.setHorizontalAlignment(JLabel.RIGHT);
        liquorPriceText.setVerticalAlignment(JLabel.TOP);

        liquorCategoryText.setFont(a.lora.deriveFont(Font.BOLD, 24f));
        liquorCategoryText.setHorizontalAlignment(JLabel.LEFT);
        liquorCategoryText.setVerticalAlignment(JLabel.BOTTOM);

        liquorDescriptionText.setFont(a.lora.deriveFont(17f));
        liquorDescriptionText.setPreferredSize(new Dimension(450, 120));
        liquorDescriptionText.setHorizontalAlignment(JLabel.LEFT);
        liquorDescriptionText.setVerticalAlignment(JLabel.TOP);

        liquorIngredientsText.setFont(a.lora.deriveFont(17f));
        liquorIngredientsText.setPreferredSize(new Dimension(450, 120));
        liquorIngredientsText.setHorizontalAlignment(JLabel.LEFT);
        liquorIngredientsText.setVerticalAlignment(JLabel.TOP);

        cancelButton.setText("Cancel");
        cancelButton.setPreferredSize(new Dimension(120,60));
        cancelButton.setFocusable(false);

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

        confirmButton.setText("Confirm");
        confirmButton.setPreferredSize(new Dimension(120,60));
        confirmButton.setFocusable(false);
    }

    public void handleConfirmView() {
        returnButton.setText("Return");
        returnButton.setPreferredSize(new Dimension(100, 60));
        returnButton.setFocusable(false);

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
        orderNumberContext.setFont(a.lora.deriveFont(50f));
        orderNumberContext.setForeground(Color.BLACK);

        orderNumberText.setFont(a.lora.deriveFont(Font.BOLD, 250f));
        orderNumberText.setBorder(BorderFactory.createEmptyBorder(-55, 0, 0, 0));
        orderNumberText.setForeground(Color.BLACK);

        orderTotalContext.setText("Please prepare your payment of");
        orderTotalContext.setPreferredSize(new Dimension(Main.WIDTH, 70));
        orderTotalContext.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));
        orderTotalContext.setHorizontalAlignment(JLabel.CENTER);
        orderTotalContext.setFont(a.lora.deriveFont(32f));
        orderTotalContext.setForeground(Color.BLACK);

        orderTotalText.setFont(a.lora.deriveFont(Font.BOLD, 37f));
        orderTotalText.setForeground(Color.BLACK);
    }

    public Font toHelvetica(int size){
        return new Font("Helvetica", Font.BOLD, size);
    }
}
