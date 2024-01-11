package component;

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

        orderTotalText.setText("Order Total: PHP 10,000");
        orderTotalText.setFont(toHelvetica(40));
        orderTotalText.setForeground(Color.WHITE);

        confirmOrderButton.setText("Confirm Order");
        confirmOrderButton.setPreferredSize(new Dimension(180, 60));
        confirmOrderButton.setFocusable(false);
    }

    public Font toHelvetica(int size){
        return new Font("Helvetica", Font.BOLD, size);
    }
}
