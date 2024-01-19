package menu;

import asset.AssetFactory;
import java.util.Arrays;
import java.util.LinkedList;

public class MenuDepot {
    public LinkedList<LinkedList<Object>> menuInfoList = new LinkedList<>();
    AssetFactory a = new AssetFactory();

    public MenuDepot() {
        menuInfoList.add(new LinkedList<>(Arrays.asList(
                0, // 0 menu ID
                "Dark and Stormy", // 1 name
                "Embrace the bold clash of ginger beer and dark rum under a stormy sky with our Dark and Stormy, a timeless classic that sweeps you into a whirlwind of flavor.",
                "A harmonious blend of rich dark rum and fiery ginger beer, the Dark and Stormy is a cocktail that embodies the power and intensity of a storm, balanced with a touch of sweetness.",
                "Dark Rum,  Ginger Beer", // 4 ingredients
                a.cocktailIconList.get(0), // 5 icon
                a.cocktailCenteredIconList.get(0), // 6 centered icon
                "Rum Cocktail", // 7 category
                170f, // 8 font size
                280 // 9 price
        )));

        menuInfoList.add(new LinkedList<>(Arrays.asList(
                1,
                "Manhattan",
                "Immerse yourself in the sophistication of the city with our Manhattan Cocktail. A timeless blend of rye whiskey and vermouth, garnished to perfection for the urban connoisseur.",
                "The Manhattan Cocktail is a classic concoction that marries the robustness of rye whiskey with the subtle notes of vermouth, creating a smooth and elegant sip reminiscent of city lights.",
                "Rye Whiskey, Sweet Vermouth, Angostura Bitters, Maraschino Cherry (for garnish)",
                a.cocktailIconList.get(1),
                a.cocktailCenteredIconList.get(1),
                "Whiskey Cocktail",
                260f,
                320
        )));

        menuInfoList.add(new LinkedList<>(Arrays.asList(
                2,
                "Planter’s Punch",
                "Transport yourself to the tropics with our Planter’s Punch - a vibrant burst of fruity flavors, blended harmoniously to create a taste of paradise in every sip.",
                "The Planter’s Punch is a tropical escape in a glass, blending the sweetness of fruit juices with the kick of dark rum, making it the perfect drink to unwind and relax.",
                "Dark Rum, Orange Juice, Pineapple Juice, Grenadine, Angostura Bitters",
                a.cocktailIconList.get(2),
                a.cocktailCenteredIconList.get(2),
                "Rum Cocktail",
                174f,
                300
        )));

        menuInfoList.add(new LinkedList<>(Arrays.asList(
                3,
                "White Russian",
                "Indulge in the creamy decadence of our White Russian. A luscious fusion of vodka, coffee liqueur, and velvety cream that's sure to leave a lasting impression.",
                "The White Russian is a luxurious treat that brings together the boldness of vodka, the richness of coffee liqueur, and the smoothness of cream, creating a drink that's as sophisticated as it is delicious.",
                "Vodka, Coffee Liqueur, Cream",
                a.cocktailIconList.get(3),
                a.cocktailCenteredIconList.get(3),
                "Vodka Cocktail",
                199f,
                340
        )));

        menuInfoList.add(new LinkedList<>(Arrays.asList(
                4,
                "Screwdriver",
                "Simple yet satisfying, our Screwdriver is a classic citrus delight. Vodka and fresh orange juice come together for a refreshingly uncomplicated experience.",
                "The Screwdriver is an uncomplicated and refreshing blend of vodka and orange juice, perfect for those who appreciate the beauty of simplicity in a cocktail.",
                "Vodka, Orange Juice",
                a.cocktailIconList.get(4),
                a.cocktailCenteredIconList.get(4),
                "Vodka Cocktail",
                221f,
                260
        )));

        menuInfoList.add(new LinkedList<>(Arrays.asList(
                5,
                "Tom Collins",
                "Embrace the effervescence of summer with our Tom Collins. A delightful mix of gin, lemon juice, and simple syrup, served over ice, creating a crisp and invigorating sensation.",
                "The Tom Collins is a timeless classic that captures the essence of summer. Crisp and citrusy, it combines the botanical notes of gin with the tartness of lemon, making it an irresistible choice for any occasion.",
                "Gin, Lemon Juice, Simple Syrup, Soda Water",
                a.cocktailIconList.get(5),
                a.cocktailCenteredIconList.get(5),
                "Gin Cocktail",
                234f,
                300
        )));

        menuInfoList.add(new LinkedList<>(Arrays.asList(
                6,
                "Sangria",
                "Experience the fiesta in every sip with our Sangria. A festive fusion of red wine, brandy, and a medley of fruits, creating a lively and vibrant celebration for your palate.",
                "Sangria is a celebration in a glass, combining the boldness of red wine with the spirited kick of brandy and an assortment of fresh fruits, delivering a burst of flavors that dance on your taste buds.",
                "Red Wine, Brandy, Orange Juice, Mixed Fruits (Oranges, Lemons, Berries)",
                a.cocktailIconList.get(6),
                a.cocktailCenteredIconList.get(6),
                "Wine Cocktail",
                267f,
                320
        )));

        menuInfoList.add(new LinkedList<>(Arrays.asList(
                7,
                "Mojito",
                "Escape to the tropics with our Mojito. A refreshing fusion of mint, lime, and sugar muddled with white rum, creating a cool and invigorating sensation.",
                "The Mojito is a classic Cuban cocktail that brings together the crispness of mint, the tanginess of lime, and the sweetness of sugar, all perfectly balanced with white rum.",
                "White Rum, Mint Leaves, Lime, Sugar, Soda Water",
                a.cocktailIconList.get(7),
                a.cocktailCenteredIconList.get(7),
                "Rum Cocktail",
                267f,
                340
        )));

        menuInfoList.add(new LinkedList<>(Arrays.asList(
                8,
                "French 75",
                "Elevate your evening with our French 75. A sparkling concoction of gin, champagne, lemon juice, and sugar, creating an effervescent and sophisticated sip.",
                "The French 75 is a timeless classic that marries the botanical essence of gin with the bubbly charm of champagne, elevated by the citrusy notes of lemon and a hint of sweetness.",
                "Gin, Champagne, Lemon Juice, Sugar",
                a.cocktailIconList.get(8),
                a.cocktailCenteredIconList.get(8),
                "Gin Cocktail",
                267f,
                360
        )));

        menuInfoList.add(new LinkedList<>(Arrays.asList(
                9,
                "Margarita",
                "Savor the bold flavors of our Margarita. A perfect balance of tequila, triple sec, and lime juice, served with a salted rim for a delightful combination of sweet and salty.",
                "The Margarita is a classic Mexican cocktail that tantalizes the taste buds with the zing of tequila, the citrusy punch of triple sec, and the tartness of fresh lime juice, all complemented by a salted rim.",
                "Tequila, Triple Sec, Lime Juice, Salt (for rim)",
                a.cocktailIconList.get(9),
                a.cocktailCenteredIconList.get(9),
                "Tequila Cocktail",
                267f,
                340
        )));

        menuInfoList.add(new LinkedList<>(Arrays.asList(
                10,
                "Old Fashioned",
                "Step back in time with our Old Fashioned. A sophisticated blend of bourbon, sugar, and bitters, garnished with an orange twist for a timeless and refined experience.",
                "The Old Fashioned is a classic cocktail that pays homage to the origins of mixology. It combines the richness of bourbon with the sweetness of sugar, a dash of bitters, and an orange twist for a drink that stands the test of time.",
                "Bourbon, Sugar, Angostura Bitters, Orange Twist (for garnish)",
                a.cocktailIconList.get(10),
                a.cocktailCenteredIconList.get(10),
                "Whiskey Cocktail",
                200f,
                360
        )));

        menuInfoList.add(new LinkedList<>(Arrays.asList(
                11,
                "Mint Julep",
                "Sip on the southern charm of our Mint Julep. A delightful fusion of bourbon, fresh mint, sugar, and crushed ice, creating a cool and minty indulgence.",
                "The Mint Julep is a Southern classic that marries the warmth of bourbon with the coolness of fresh mint and the sweetness of sugar, served over crushed ice for a refreshing and aromatic experience.",
                "Bourbon, Fresh Mint, Sugar, Crushed Ice",
                a.cocktailIconList.get(11),
                a.cocktailCenteredIconList.get(11),
                "Whiskey Cocktail",
                267f,
                320
        )));

        menuInfoList.add(new LinkedList<>(Arrays.asList(
                12,
                "Rob Roy",
                "Embrace the Scottish heritage with our Rob Roy. A rich and smoky blend of Scotch whisky, sweet vermouth, and a dash of bitters, creating a bold and flavorful sip.",
                "The Rob Roy is a Scotch variation of the Manhattan, combining the peaty and smoky notes of Scotch whisky with the sweetness of vermouth and a hint of bitters for a drink that exudes sophistication.",
                "Scotch Whisky, Sweet Vermouth, Angostura Bitters, Maraschino Cherry (for garnish)",
                a.cocktailIconList.get(12),
                a.cocktailCenteredIconList.get(12),
                "Whiskey Cocktail",
                267f,
                340
        )));

        menuInfoList.add(new LinkedList<>(Arrays.asList(
                13,
                "Daiquiri",
                "Transport yourself to the beaches with our Daiquiri. A tropical blend of white rum, lime juice, and simple syrup, served chilled for a refreshing and delightful experience.",
                "The Daiquiri is a Cuban classic that captures the essence of the tropics. It combines the crispness of white rum with the tartness of lime juice and the sweetness of simple syrup, creating a well-balanced and rejuvenating cocktail.",
                "White Rum, Lime Juice, Simple Syrup",
                a.cocktailIconList.get(13),
                a.cocktailCenteredIconList.get(13),
                "Rum Cocktail",
                267f,
                280
        )));

        menuInfoList.add(new LinkedList<>(Arrays.asList(
                14,
                "Boulevardier",
                "Embark on a sophisticated journey with our Boulevardier. A bold and bitter blend of bourbon, sweet vermouth, and Campari, creating a complex and intriguing flavor profile.",
                "The Boulevardier is a classic cocktail that brings together the robustness of bourbon with the sweetness of vermouth and the bitter complexity of Campari, resulting in a drink that's both daring and delightful.",
                "Bourbon, Sweet Vermouth, Campari, Orange Twist (for garnish)",
                a.cocktailIconList.get(14),
                a.cocktailCenteredIconList.get(14),
                "Whiskey Cocktail",
                206f,
                360
        )));

        menuInfoList.add(new LinkedList<>(Arrays.asList(
                15,
                "Bee’s Knees",
                "Savor the sweetness of our Bee’s Knees. A delightful mix of gin, honey, and lemon juice, creating a balanced and honey-infused cocktail that's as pleasing as it is sophisticated.",
                "The Bee’s Knees is a Prohibition-era cocktail that showcases the harmonious blend of gin with the natural sweetness of honey and the tartness of lemon juice, resulting in a drink that's both smooth and refreshing.",
                "Gin, Honey Syrup, Lemon Juice",
                a.cocktailIconList.get(15),
                a.cocktailCenteredIconList.get(15),
                "Gin Cocktail",
                247f,
                320
        )));

    }
}
