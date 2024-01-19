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
    public ImageIcon logoTextIcon;
    public ImageIcon touchIcon;
    public LinkedList<ImageIcon> cocktailIconList = new LinkedList<>();
    public LinkedList<ImageIcon> cocktailCenteredIconList = new LinkedList<>();
    public LinkedList<ImageIcon> uiButtonIconList = new LinkedList<>();
    public LinkedList<ImageIcon> uiButtonSelectedIconList = new LinkedList<>();
    public ImageIcon orderContainerIcon;
    public ImageIcon menuButtonIcon;
    public ImageIcon menuButtonSelectedIcon;
    public ImageIcon removeButtonIcon;
    public ImageIcon removeSelectedButtonIcon;
    public ImageIcon decreaseButtonIcon;
    public ImageIcon increaseButtonIcon;
    public ImageIcon decreaseSelectedButtonIcon;
    public ImageIcon increaseSelectedButtonIcon;
    public ImageIcon decor0Icon;

    public AssetFactory() {
        tanGrandeur = loadFontFromFile("media/font/tanGrandeurFont.ttf");
        metanoia = loadFontFromFile("media/font/metanoiaFont.ttf");
        lora = loadFontFromFile("media/font/loraFont.ttf");

        burgundy = createColor(0x2E1412);
        cocoa = createColor(0xBC9F7C);

        logoIcon = new ImageIcon("media/logoIcon.png");
        logoTextIcon = new ImageIcon("media/uiIcon/logoTextIcon.png");
        touchIcon = new ImageIcon("media/uiIcon/touchIcon.png");

        cocktailIconList.add(new ImageIcon("media/menuIcon/darkAndStormyIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/manhattanIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/plantersPunchIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/whiteRussianIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/screwdriverIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/tomCollinsIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/sangriaIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/mojitoIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/french75Icon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/margaritaIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/oldFashionedIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/mintJulepIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/robRoyIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/daiquiriIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/boulevardierIcon.png"));
        cocktailIconList.add(new ImageIcon("media/menuIcon/beesKneesIcon.png"));

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
                new ImageIcon("media/menuCenteredIcon/sangriaCenteredIcon.png")
        );

        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/mojitoCenteredIcon.png")
        );
        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/french75CenteredIcon.png")
        );
        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/margaritaCenteredIcon.png")
        );
        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/oldFashionedCenteredIcon.png")
        );
        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/mintJulepCenteredIcon.png")
        );
        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/robRoyCenteredIcon.png")
        );
        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/daiquiriCenteredIcon.png")
        );
        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/boulevardierCenteredIcon.png")
        );
        cocktailCenteredIconList.add(
                new ImageIcon("media/menuCenteredIcon/beesKneesCenteredIcon.png")
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

        orderContainerIcon = new ImageIcon("media/uiIcon/orderContainerIcon.png");

        menuButtonIcon = new ImageIcon("media/uiIcon/menuButtonIcon.png");
        menuButtonSelectedIcon = new ImageIcon("media/uiIcon/menuButtonSelectedIcon.png");

        removeButtonIcon = new ImageIcon("media/uiIcon/removeButtonIcon.png");
        removeSelectedButtonIcon = new ImageIcon("media/uiIcon/removeSelectedButtonIcon.png");

        decreaseButtonIcon = new ImageIcon("media/uiIcon/decreaseButtonIcon.png");
        increaseButtonIcon = new ImageIcon("media/uiIcon/increaseButtonIcon.png");

        decreaseSelectedButtonIcon = new ImageIcon(
                "media/uiIcon/decreaseSelectedButtonIcon.png"
        );
        increaseSelectedButtonIcon = new ImageIcon(
                "media/uiIcon/increaseSelectedButtonIcon.png"
        );

        decor0Icon = new ImageIcon("media/uiIcon/decor0Icon.png");
    }

    public ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
        return new ImageIcon(icon.getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }

    private Color createColor(int hexCode) {
        return new Color(hexCode);
    }

    // crops image from the bottom
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
