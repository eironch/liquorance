package component;

import main.Main;
import asset.AssetFactory;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ComponentFactory {
    AssetFactory a = new AssetFactory();
    public JLabel logoText = new JLabel();

    // ------------ title view --------------

    public JLabel logoImage = new JLabel();
    public JLabel touchImage = new JLabel();

    // ------------- menu view --------------

    public JLabel orderButton = new JLabel();
    public ArrayList<JLabel> liquorImageList = new ArrayList<>();
    public ArrayList<JLabel> liquorNameList = new ArrayList<>();
    public ArrayList<JLabel> liquorIndicatorList = new ArrayList<>();

    // ------------ liquor view -------------

    public JLabel liquorBackgroundName = new JLabel();
    public JLabel liquorImage = new JLabel();
    public JLabel liquorForegroundName = new JLabel();
    public JLabel liquorFlavorText = new JLabel();
    public JLabel liquorPriceText = new JLabel();
    public JLabel liquorCategoryText = new JLabel();
    public JLabel liquorDescriptionText = new JLabel();
    public JLabel liquorIngredientsText = new JLabel();
    public JLabel decreaseQuantityButton = new JLabel();
    public JLabel orderQuantityText = new JLabel();
    public JLabel increaseQuantityButton = new JLabel();
    public JLabel cancelButton = new JLabel();
    public JLabel confirmButton = new JLabel();

    // ----------- confirm view -------------

    public JLabel returnButton = new JLabel();
    public JLabel confirmOrderButton = new JLabel();
    public JLabel orderTotalContext = new JLabel();
    public JLabel orderTotalText = new JLabel();
    public JLabel decorImage = new JLabel();


    // ------------ queue view --------------

    public JLabel orderNumberContext = new JLabel();
    public JLabel orderNumberText = new JLabel();

    public ComponentFactory() {
        logoText.setText("Liquorance");
        logoText.setFont(a.metanoia.deriveFont(55f));
        logoText.setForeground(a.cocoa);
    }

    public void handleTitleView() {
        logoImage.setText("");
        logoImage.setIcon(a.resizeIcon(a.logoTextIcon, 800, 800));
        logoImage.setPreferredSize(new Dimension(Main.WIDTH, 200));
        logoImage.setHorizontalAlignment(JLabel.CENTER);

        touchImage.setIcon(a.resizeIcon(a.touchIcon, 70, 70));
    }

    public void handleMenuView() {
        returnButton.setText("Exit");
        returnButton.setIcon(a.resizeIcon(a.uiButtonIconList.get(0), 200, 60));
        returnButton.setPreferredSize(new Dimension(200,60));
        returnButton.setFont(a.lora.deriveFont(Font.BOLD, 20f));
        returnButton.setHorizontalTextPosition(JLabel.CENTER);
        returnButton.setVerticalTextPosition(JLabel.CENTER);
        returnButton.setBackground(a.burgundy);
        returnButton.setForeground(a.cocoa);

        orderButton.setText("Order (0)");
        orderButton.setIcon(a.resizeIcon(a.uiButtonIconList.get(1), 200, 60));
        orderButton.setPreferredSize(new Dimension(200,60));
        orderButton.setFont(a.lora.deriveFont(Font.BOLD, 20f));
        orderButton.setHorizontalTextPosition(JLabel.CENTER);
        orderButton.setVerticalTextPosition(JLabel.CENTER);
        orderButton.setBackground(a.burgundy);
        orderButton.setForeground(a.cocoa);

        for (int i = 0; i < 8; i++) {
            liquorIndicatorList.add(new JLabel());
            liquorIndicatorList.get(i).setIcon(a.resizeIcon(a.menuButtonIcon, 280, 280));
        }

        for (int i = 0; i < 8; i++) {
            liquorImageList.add(new JLabel());
            liquorImageList.get(i).setFocusable(false);
            liquorImageList.get(i).setBorder(null);
        }

        for (int i = 0; i < 8; i++) {
            liquorNameList.add(new JLabel());
            liquorNameList.get(i).setFont(a.lora.deriveFont(Font.BOLD, 18f));
            liquorNameList.get(i).setPreferredSize(new Dimension(320, 60));
            liquorNameList.get(i).setHorizontalAlignment(JLabel.CENTER);
            liquorNameList.get(i).setForeground(a.cocoa);
        }
    }

    public void handleLiquorView() {
        returnButton.setText("Exit");
        returnButton.setIcon(a.resizeIcon(a.uiButtonIconList.get(0), 200, 60));
        returnButton.setPreferredSize(new Dimension(200,60));
        returnButton.setFont(a.lora.deriveFont(Font.BOLD, 20f));
        returnButton.setHorizontalTextPosition(JLabel.CENTER);
        returnButton.setVerticalTextPosition(JLabel.CENTER);
        returnButton.setBackground(a.burgundy);
        returnButton.setForeground(a.cocoa);
        returnButton.setFocusable(false);
        returnButton.setBorder(null);

        orderButton.setText("Order (0)");
        orderButton.setIcon(a.resizeIcon(a.uiButtonIconList.get(1), 200, 60));
        orderButton.setPreferredSize(new Dimension(200,60));
        orderButton.setFont(a.lora.deriveFont(Font.BOLD, 20f));
        orderButton.setHorizontalTextPosition(JLabel.CENTER);
        orderButton.setVerticalTextPosition(JLabel.CENTER);
        orderButton.setBackground(a.burgundy);
        orderButton.setForeground(a.cocoa);
        orderButton.setFocusable(false);
        orderButton.setBorder(null);

        liquorBackgroundName.setForeground(a.cocoa);

        liquorImage.setPreferredSize(new Dimension(300, Main.HEIGHT - 160));
        liquorImage.setBorder(BorderFactory.createEmptyBorder(-120, 0, 0, 0));
        liquorImage.setHorizontalAlignment(JLabel.CENTER);
        liquorImage.setForeground(a.burgundy);

        liquorForegroundName.setFont(a.lora.deriveFont(Font.BOLD, 24f));
        liquorForegroundName.setHorizontalAlignment(JLabel.RIGHT);
        liquorForegroundName.setVerticalAlignment(JLabel.BOTTOM);
        liquorForegroundName.setForeground(a.cocoa);

        liquorFlavorText.setPreferredSize(new Dimension(450, 120));
        liquorFlavorText.setHorizontalAlignment(JLabel.RIGHT);
        liquorFlavorText.setVerticalAlignment(JLabel.TOP);
        liquorFlavorText.setForeground(a.cocoa);

        liquorPriceText.setFont(a.lora.deriveFont(100f));
        liquorPriceText.setHorizontalAlignment(JLabel.RIGHT);
        liquorPriceText.setVerticalAlignment(JLabel.TOP);
        liquorPriceText.setForeground(a.cocoa);

        liquorCategoryText.setHorizontalAlignment(JLabel.LEFT);
        liquorCategoryText.setVerticalAlignment(JLabel.BOTTOM);
        liquorCategoryText.setForeground(a.cocoa);

        liquorDescriptionText.setPreferredSize(new Dimension(450, 120));
        liquorDescriptionText.setHorizontalAlignment(JLabel.LEFT);
        liquorDescriptionText.setVerticalAlignment(JLabel.TOP);
        liquorDescriptionText.setForeground(a.cocoa);

        liquorIngredientsText.setPreferredSize(new Dimension(450, 120));
        liquorIngredientsText.setHorizontalAlignment(JLabel.LEFT);
        liquorIngredientsText.setVerticalAlignment(JLabel.TOP);
        liquorIngredientsText.setForeground(a.cocoa);

        cancelButton.setText("Cancel");
        cancelButton.setIcon(a.resizeIcon(a.uiButtonIconList.get(2), 200, 60));
        cancelButton.setPreferredSize(new Dimension(200,60));
        cancelButton.setFont(a.lora.deriveFont(Font.BOLD, 20f));
        cancelButton.setHorizontalTextPosition(JLabel.CENTER);
        cancelButton.setVerticalTextPosition(JLabel.CENTER);
        cancelButton.setBackground(a.burgundy);
        cancelButton.setForeground(a.cocoa);
        cancelButton.setFocusable(false);
        cancelButton.setBorder(null);

        decreaseQuantityButton.setIcon(a.resizeIcon(a.decreaseButtonIcon, 60, 60));
        decreaseQuantityButton.setPreferredSize(new Dimension(60, 60));

        orderQuantityText.setPreferredSize(new Dimension(100, 60));
        orderQuantityText.setHorizontalAlignment(JLabel.CENTER);
        orderQuantityText.setFont(a.lora.deriveFont(Font.BOLD, 30f));
        orderQuantityText.setForeground(a.cocoa);

        increaseQuantityButton.setIcon(a.resizeIcon(a.increaseButtonIcon, 60, 60));
        increaseQuantityButton.setPreferredSize(new Dimension(60, 60));

        confirmButton.setText("Confirm");
        confirmButton.setIcon(a.resizeIcon(a.uiButtonIconList.get(3), 200, 60));
        confirmButton.setPreferredSize(new Dimension(200,60));
        confirmButton.setFont(a.lora.deriveFont(Font.BOLD, 20f));
        confirmButton.setHorizontalTextPosition(JLabel.CENTER);
        confirmButton.setVerticalTextPosition(JLabel.CENTER);
        confirmButton.setBackground(a.burgundy);
        confirmButton.setForeground(a.cocoa);
        confirmButton.setFocusable(false);
        confirmButton.setBorder(null);
    }

    public void handleConfirmView() {
        returnButton.setText("Return");
        returnButton.setIcon(a.resizeIcon(a.uiButtonIconList.get(0), 200, 60));
        returnButton.setPreferredSize(new Dimension(200,60));
        returnButton.setFont(a.lora.deriveFont(Font.BOLD, 20f));
        returnButton.setHorizontalTextPosition(JLabel.CENTER);
        returnButton.setVerticalTextPosition(JLabel.CENTER);
        returnButton.setBackground(a.burgundy);
        returnButton.setForeground(a.cocoa);

        orderTotalContext.setText("Order Total:");
        orderTotalContext.setFont(a.lora.deriveFont(40f));
        orderTotalContext.setForeground(a.cocoa);

        orderTotalText.setForeground(a.cocoa);

        confirmOrderButton.setText("Confirm Order");
        confirmOrderButton.setIcon(a.resizeIcon(a.uiButtonIconList.get(1), 200, 60));
        confirmOrderButton.setPreferredSize(new Dimension(200,60));
        confirmOrderButton.setFont(a.lora.deriveFont(Font.BOLD, 20f));
        confirmOrderButton.setHorizontalTextPosition(JLabel.CENTER);
        confirmOrderButton.setVerticalTextPosition(JLabel.CENTER);
        confirmOrderButton.setBackground(a.burgundy);
        confirmOrderButton.setForeground(a.cocoa);

        decorImage.setIcon(a.resizeIcon(a.decor0Icon, 425, 2));
        decorImage.setPreferredSize(new Dimension(425, 60));
    }

    public void handleQueueView() {
        orderNumberContext.setText("Your Order Number:");
        orderNumberContext.setPreferredSize(new Dimension(Main.WIDTH, 330));
        orderNumberContext.setHorizontalAlignment(JLabel.CENTER);
        orderNumberContext.setVerticalAlignment(JLabel.CENTER);
        orderNumberContext.setFont(a.lora.deriveFont(50f));
        orderNumberContext.setForeground(a.cocoa);

        orderNumberText.setFont(a.lora.deriveFont(Font.BOLD, 250f));
        orderNumberText.setBorder(BorderFactory.createEmptyBorder(-55, 0, 0, 0));
        orderNumberText.setForeground(a.cocoa);

        orderTotalContext.setText("Please prepare your payment of");
        orderTotalContext.setPreferredSize(new Dimension(Main.WIDTH, 70));
        orderTotalContext.setBorder(BorderFactory.createEmptyBorder(25, 0, 0, 0));
        orderTotalContext.setHorizontalAlignment(JLabel.CENTER);
        orderTotalContext.setFont(a.lora.deriveFont(32f));
        orderTotalContext.setForeground(a.cocoa);

        orderTotalText.setFont(a.lora.deriveFont(Font.BOLD, 37f));
        orderTotalText.setForeground(a.cocoa);

        decorImage.setIcon(a.resizeIcon(a.decor0Icon, 425, 2));
        decorImage.setPreferredSize(new Dimension(425, 60));
    }
}
