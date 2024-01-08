package component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ComponentFactory {
    public JLabel titleText = new JLabel();
    public ArrayList<JButton> catalogButtonList = new ArrayList<>();

    public ComponentFactory() {
        titleText.setText("Liquorance");
        titleText.setFont(toHelvetica(40));
        titleText.setForeground(Color.WHITE);

        for (int i = 0; i < 8; i++) {
            catalogButtonList.add(new JButton());
            catalogButtonList.get(i).setText("Liquor " + i);
            catalogButtonList.get(i).setPreferredSize(new Dimension(320, 200));
            catalogButtonList.get(i).setFocusable(false);
        }
    }

    public Font toHelvetica(int size){
        return new Font("Helvetica", Font.BOLD, size);
    }
}
