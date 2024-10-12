
package test.customerordersegmentationproj;

public class CustomerOrderSegmentationProj {

    public static void main(String[] args) {
        String[] foods = {
            "Pork Sisig w/ Egg",
            "Chicken Cordon Bleu",
            "Sizzling Beef Lengua",
            "Garlic Parmesan Chicken",
            "Lemon Pepper Chicken",
            "Baby Back Ribs"
        };

        String[] hdrinks = {
            "Cafe Latte",
            "Special Cafe Mocha",
            "Caramel Macchiato",
            "Cinnamon Dolce Latte",
            "Special BARAKO Brew"
        };

        String[] cdrinks = {
            "Iced Coffee",
            "Iced Latte",
            "Iced Cinnamon Dolce",
            "Iced Caramel Macchiato",
            "Iced Mocha"
        };

        String[] drinks = {
            "Cucumber Lemonade",
            "House Blend Iced Tea",
            "Lychee Lemonade",
            "Strawberry Lemonade",
            "Blueberry Lemonade"
        };

        System.out.printf("%-30s %-30s %-30s %-30s%n", "Foods", "Hot Drinks", "Cold Drinks", "Drinks");

        int maxLength = Math.max(Math.max(foods.length, hdrinks.length), Math.max(cdrinks.length, drinks.length));

        for (int i = 0; i < maxLength; i++) {
            System.out.printf("%-30s %-30s %-30s %-30s%n",
                (i < foods.length ? foods[i] : ""),
                (i < hdrinks.length ? hdrinks[i] : ""),
                (i < cdrinks.length ? cdrinks[i] : ""),
                (i < drinks.length ? drinks[i] : ""));
        }
    }
}
