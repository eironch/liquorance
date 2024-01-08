package component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ComponentFactory {
    public JLabel titleText = new JLabel();
    public ArrayList<JButton> catalogButtonList = new ArrayList<>();
    public ArrayList<JLabel> catalogNameList = new ArrayList<>();

    public ComponentFactory() {
        titleText.setText("Liquorance");
        titleText.setFont(toHelvetica(40));
        titleText.setForeground(Color.WHITE);

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
    }

    public Font toHelvetica(int size){
        return new Font("Helvetica", Font.BOLD, size);
    }
}
