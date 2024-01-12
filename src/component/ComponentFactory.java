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

    public JLabel queueContext = new JLabel();
    public JLabel queueNumberText = new JLabel();
    public JLabel orderTotalContext = new JLabel();

    public ComponentFactory() {
        titleText.setText("Liquorance");
        titleText.setFont(toHelvetica(40));
        titleText.setForeground(Color.WHITE);
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
        queueContext.setText("Your Queue Number:");
        queueContext.setPreferredSize(new Dimension(Main.WIDTH, 330));
        queueContext.setHorizontalAlignment(JLabel.CENTER);
        queueContext.setVerticalAlignment(JLabel.CENTER);
        queueContext.setFont(toHelvetica(50));
        queueContext.setForeground(Color.BLACK);

        queueNumberText.setText("200");
        queueNumberText.setFont(toHelvetica(250));
        queueNumberText.setBorder(BorderFactory.createEmptyBorder(-55, 0, 0, 0));
        queueNumberText.setForeground(Color.BLACK);

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
