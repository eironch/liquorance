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
    public LinkedList<ImageIcon> cocktailCenteredIconList = new LinkedList<>();
    public AssetFactory() {
        tanGrandeur = loadFontFromFile("media/font/tanGrandeurFont.ttf");
        metanoia = loadFontFromFile("media/font/metanoiaFont.ttf");
        lora = loadFontFromFile("media/font/loraFont.ttf");

        cocktailIconList.add(new ImageIcon("media/menuIcon/darkAndStormyIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/manhattanIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/plantersPunchIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/whiteRussianIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/screwdriverIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/tomCollinsIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/zombieIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/sangriaIcon.png"));

        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/darkAndStormyCenteredIcon.png"
        ));
        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/manhattanCenteredIcon.png"
        ));
        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/plantersPunchCenteredIcon.png"
        ));
        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/whiteRussianCenteredIcon.png"
        ));
        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/screwdriverCenteredIcon.png"
        ));
        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/tomCollinsCenteredIcon.png"
        ));
        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/zombieCenteredIcon.png"
        ));
        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/sangriaCenteredIcon.png"
        ));
    }

    public ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        return new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    // returns a new font, returns a default font if not available
    private static Font loadFontFromFile(String fontFilePath) {
        try {
            return Font.createFont(Font.TRUETYPE_FONT, new File(fontFilePath));
        } catch (IOException | FontFormatException e) {
            return new Font("Helvetica", Font.PLAIN, 20);
        }
    }
}
