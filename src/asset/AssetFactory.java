package asset;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class AssetFactory {
    public Font tanGrandeur;
    public Font metanoia;
    public Font lora;

    public LinkedList<ImageIcon> cocktailIconList = new LinkedList<>();

    public AssetFactory() {
        cocktailIconList.add(new ImageIcon("media/darkAndStormyIcon.png"));
        cocktailIconList.add(new ImageIcon("media/manhattanIcon.png"));
        cocktailIconList.add(new ImageIcon("media/plantersPunchIcon.png"));
        cocktailIconList.add(new ImageIcon("media/whiteRussianIcon.png"));
        cocktailIconList.add(new ImageIcon("media/screwdriverIcon.png"));
        cocktailIconList.add(new ImageIcon("media/tomCollinsIcon.png"));
        cocktailIconList.add(new ImageIcon("media/zombieIcon.png"));
        cocktailIconList.add(new ImageIcon("media/sangriaIcon.png"));

        tanGrandeur = loadFontFromFile("media/tanGrandeurFont.ttf");
        metanoia = loadFontFromFile("media/metanoiaFont.ttf");
        lora = loadFontFromFile("media/loraFont.ttf");
    }

    public ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        return new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    // creates font and returns a default font if not available
    private static Font loadFontFromFile(String fontFilePath) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File(fontFilePath));
        } catch (IOException | FontFormatException e) {
            return new Font("Helvetica", Font.PLAIN, 20);
        }
    }
}
