package asset;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class AssetFactory {
    public Font tanGrandeur;
    public Font metanoia;
    public Font lora;

    public Color burgundy;
    public Color cocoa;

    public ImageIcon logoIcon;
    public ImageIcon touchIcon;
    public LinkedList<ImageIcon> cocktailIconList = new LinkedList<>();
    public LinkedList<ImageIcon> cocktailCenteredIconList = new LinkedList<>();
    public LinkedList<ImageIcon> uiButtonIconList = new LinkedList<>();
    public LinkedList<ImageIcon> uiButtonSelectedIconList = new LinkedList<>();
    public ImageIcon menuButtonIcon;
    public ImageIcon menuButtonSelectedIcon;
    public ImageIcon decreaseButtonIcon;
    public ImageIcon increaseButtonIcon;
    public ImageIcon decreaseSelectedButtonIcon;
    public ImageIcon increaseSelectedButtonIcon;

    public AssetFactory() {
        tanGrandeur = loadFontFromFile("media/font/tanGrandeurFont.ttf");
        metanoia = loadFontFromFile("media/font/metanoiaFont.ttf");
        lora = loadFontFromFile("media/font/loraFont.ttf");

        burgundy = createColor(0x2E1412);
        cocoa = createColor(0xBC9F7C);

        logoIcon = new ImageIcon("media/uiIcon/logoIcon.png");
        touchIcon = new ImageIcon("media/uiIcon/touchIcon.png");

        cocktailIconList.add(new ImageIcon("media/menuIcon/darkAndStormyIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/manhattanIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/plantersPunchIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/whiteRussianIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/screwdriverIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/tomCollinsIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/zombieIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/sangriaIcon.png"));

        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/darkAndStormyCenteredIcon.png")
        );
        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/manhattanCenteredIcon.png")
        );
        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/plantersPunchCenteredIcon.png")
        );
        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/whiteRussianCenteredIcon.png")
        );
        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/screwdriverCenteredIcon.png")
        );
        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/tomCollinsCenteredIcon.png")
        );
        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/zombieCenteredIcon.png")
        );
        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/sangriaCenteredIcon.png")
        );

        uiButtonIconList.add(new ImageIcon("media/uiIcon/uiButton0Icon.png"));
        uiButtonIconList.add(new ImageIcon("media/uiIcon/uiButton1Icon.png"));
        uiButtonIconList.add(new ImageIcon("media/uiIcon/uiButton2Icon.png"));
        uiButtonIconList.add(new ImageIcon("media/uiIcon/uiButton3Icon.png"));

        uiButtonSelectedIconList.add(
                new ImageIcon("media/uiIcon/uiButtonSelected0Icon.png"
        ));
        uiButtonSelectedIconList.add(
                new ImageIcon("media/uiIcon/uiButtonSelected1Icon.png"
        ));
        uiButtonSelectedIconList.add(
                new ImageIcon("media/uiIcon/uiButtonSelected2Icon.png"
        ));
        uiButtonSelectedIconList.add(
                new ImageIcon("media/uiIcon/uiButtonSelected3Icon.png"
        ));

        menuButtonIcon = new ImageIcon("media/uiIcon/menuButtonIcon.png");
        menuButtonSelectedIcon = new ImageIcon("media/uiIcon/menuButtonSelectedIcon.png");

        decreaseButtonIcon = new ImageIcon("media/uiIcon/decreaseButtonIcon.png");
        increaseButtonIcon = new ImageIcon("media/uiIcon/increaseButtonIcon.png");

        decreaseSelectedButtonIcon = new ImageIcon(
                "media/uiIcon/decreaseSelectedButtonIcon.png"
        );
        increaseSelectedButtonIcon = new ImageIcon(
                "media/uiIcon/increaseSelectedButtonIcon.png"
        );
    }

    public ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        return new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    private Color createColor(int hexCode) {
        return new Color(hexCode);
    }

    public ImageIcon cropTopImageIcon(ImageIcon originalIcon, int heightToCrop) {
        BufferedImage bufferedImage = new BufferedImage(originalIcon.getIconWidth(), originalIcon.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
        bufferedImage.getGraphics().drawImage(originalIcon.getImage(), 0, 0, null);

        int heightToKeep = Math.max(0, bufferedImage.getHeight() - heightToCrop);

        return new ImageIcon(bufferedImage.getSubimage(0, heightToKeep,
                bufferedImage.getWidth(), bufferedImage.getHeight() - heightToKeep));
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
