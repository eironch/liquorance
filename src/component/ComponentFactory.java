package component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ComponentFactory {
    public JLabel titleText = new JLabel();
    public JButton changeViewButton = new JButton();
    public JButton orderButton = new JButton();
    public ArrayList<JButton> catalogButtonList = new ArrayList<>();
    public ArrayList<JLabel> catalogNameList = new ArrayList<>();
    public ArrayList<JButton> categoryButtonList = new ArrayList<>();

    public ComponentFactory() {
        titleText.setText("Liquorance");
        titleText.setFont(toHelvetica(40));
        titleText.setForeground(Color.WHITE);

        changeViewButton.setText("View");
        changeViewButton.setPreferredSize(new Dimension(100,60));
        changeViewButton.setFocusable(false);

        orderButton.setText("Order");
        orderButton.setPreferredSize(new Dimension(200,60));
        orderButton.setFocusable(false);

        for (int i = 0; i < 8; i++) {
            catalogButtonList.add(new JButton());
            catalogButtonList.get(i).setText("Liquor " + i + " Button");
            catalogButtonList.get(i).setPreferredSize(new Dimension(320, 260));
            catalogButtonList.get(i).setFocusable(false);
        }

        for (int i = 0; i < 8; i++) {
            catalogNameList.add(new JLabel());
            catalogNameList.get(i).setText("Liquor " + i + " Name");
            catalogNameList.get(i).setFont(toHelvetica(15));
            catalogNameList.get(i).setPreferredSize(new Dimension(320, 60));
            catalogNameList.get(i).setHorizontalAlignment(JLabel.CENTER);
        }

        for (int i = 0; i < 5; i++) {
            categoryButtonList.add(new JButton());
            categoryButtonList.get(i).setText("" + i);
            categoryButtonList.get(i).setPreferredSize(new Dimension(80, 80));
            categoryButtonList.get(i).setFocusable(false);
        }
    }

    public Font toHelvetica(int size){
        return new Font("Helvetica", Font.BOLD, size);
    }
}
