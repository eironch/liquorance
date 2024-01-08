package component;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ComponentFactory {
    public JLabel titleText = new JLabel();
    public ArrayList<JButton> catalogButtons = new ArrayList<>();
    public ComponentFactory() {
        titleText.setText("Liquorance");
        titleText.setFont(toHelvetica(40));
        titleText.setForeground(Color.WHITE);

        for (int i = 0; i < 8; i++) {
            catalogButtons.add(new JButton());
            catalogButtons.get(i).setText("Liquor" + i);
            catalogButtons.get(i).setFocusable(false);
            catalogButtons.get(i).setPreferredSize(new Dimension(50, 50));
        }
    }

    public Font toHelvetica(int size){
        return new Font("Helvetica", Font.BOLD, size);
    }
}
