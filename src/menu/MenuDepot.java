package menu;

import asset.AssetFactory;

import java.util.Arrays;
import java.util.LinkedList;

public class MenuDepot {
    public LinkedList<LinkedList<Object>> cocktailMenuInfoList = new LinkedList<>();
    AssetFactory a = new AssetFactory();
    public MenuDepot() {
        cocktailMenuInfoList.add(new LinkedList<>(Arrays.asList(
                0, // 0
                "Dark and Stormy", // 1
                "Embrace the bold clash of ginger beer and dark rum under a stormy sky with our Dark and Stormy, a timeless classic that sweeps you into a whirlwind of flavor.",
                "A harmonious blend of rich dark rum and fiery ginger beer, the Dark and Stormy is a cocktail that embodies the power and intensity of a storm, balanced with a touch of sweetness.",
                "Dark Rum,  Ginger Beer", // 4
                a.cocktailIconList.get(0), // 5
                171f, // 6
                280 // 7
        )));
        cocktailMenuInfoList.add(new LinkedList<>(Arrays.asList(
                1,
                "Manhattan",
                "Immerse yourself in the sophistication of the city with our Manhattan Cocktail. A timeless blend of rye whiskey and vermouth, garnished to perfection for the urban connoisseur.",
                "The Manhattan Cocktail is a classic concoction that marries the robustness of rye whiskey with the subtle notes of vermouth, creating a smooth and elegant sip reminiscent of city lights.",
                "Rye Whiskey, Sweet Vermouth, Angostura Bitters, Maraschino Cherry (for garnish)",
                a.cocktailIconList.get(1),
                260f,
                320
        )));

        cocktailMenuInfoList.add(new LinkedList<>(Arrays.asList(
                2,
                "Planter’s Punch",
                "Transport yourself to the tropics with our Planter’s Punch - a vibrant burst of fruity flavors, blended harmoniously to create a taste of paradise in every sip.",
                "The Planter’s Punch is a tropical escape in a glass, blending the sweetness of fruit juices with the kick of dark rum, making it the perfect drink to unwind and relax.",
                "Dark Rum, Orange Juice, Pineapple Juice, Grenadine, Angostura Bitters",
                a.cocktailIconList.get(2),
                174f,
                300
        )));

        cocktailMenuInfoList.add(new LinkedList<>(Arrays.asList(
                3,
                "White Russian",
                "Indulge in the creamy decadence of our White Russian. A luscious fusion of vodka, coffee liqueur, and velvety cream that's sure to leave a lasting impression.",
                "The White Russian is a luxurious treat that brings together the boldness of vodka, the richness of coffee liqueur, and the smoothness of cream, creating a drink that's as sophisticated as it is delicious.",
                "Vodka, Coffee Liqueur, Cream",
                a.cocktailIconList.get(3),
                199f,
                340
        )));

        cocktailMenuInfoList.add(new LinkedList<>(Arrays.asList(
                4,
                "Screwdriver",
                "Simple yet satisfying, our Screwdriver is a classic citrus delight. Vodka and fresh orange juice come together for a refreshingly uncomplicated experience.",
                "The Screwdriver is an uncomplicated and refreshing blend of vodka and orange juice, perfect for those who appreciate the beauty of simplicity in a cocktail.",
                "Vodka, Orange Juice",
                a.cocktailIconList.get(4),
                220f,
                260
        )));

        cocktailMenuInfoList.add(new LinkedList<>(Arrays.asList(
                5,
                "Tom Collins",
                "Embrace the effervescence of summer with our Tom Collins. A delightful mix of gin, lemon juice, and simple syrup, served over ice, creating a crisp and invigorating sensation.",
                "The Tom Collins is a timeless classic that captures the essence of summer. Crisp and citrusy, it combines the botanical notes of gin with the tartness of lemon, making it an irresistible choice for any occasion.",
                "Gin, Lemon Juice, Simple Syrup, Soda Water",
                a.cocktailIconList.get(5),
                233f,
                300
        )));

        cocktailMenuInfoList.add(new LinkedList<>(Arrays.asList(
                6,
                "Zombie",
                "Unleash the undead with our Zombie cocktail - a potent concoction of dark and light rums, fruit juices, and a dash of mystery. It's a drink that'll wake the dead.",
                "The Zombie is a powerful and mysterious blend of dark and light rums, tropical fruit juices, and a hint of intrigue. Sip with caution, as this cocktail has the power to resurrect your taste buds.",
                "Dark Rum, Light Rum, Pineapple Juice, Orange Juice, Grenadine, Angostura Bitters",
                a.cocktailIconList.get(6),
                267f,
                380
        )));

        cocktailMenuInfoList.add(new LinkedList<>(Arrays.asList(
                7,
                "Sangria",
                "Experience the fiesta in every sip with our Sangria. A festive fusion of red wine, brandy, and a medley of fruits, creating a lively and vibrant celebration for your palate.",
                "Sangria is a celebration in a glass, combining the boldness of red wine with the spirited kick of brandy and an assortment of fresh fruits, delivering a burst of flavors that dance on your taste buds.",
                "Red Wine, Brandy, Orange Juice, Mixed Fruits (Oranges, Lemons, Berries)",
                a.cocktailIconList.get(7),
                267f,
                320
        )));
    }
}
