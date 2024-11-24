package restaurantmanagementsystem;


public class MenuItem {
    private String name;
    private String type; // "food" or "drink"
    private String category;
    private double price;

    public MenuItem(String name, String type, String category, double price) {
        this.name = name;
        this.type = type;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public String toCsv() {
        return name + "," + type + "," + category + "," + price;
    }

    public static MenuItem fromCsv(String csv) {
        String[] parts = csv.split(",");
        return new MenuItem(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
    }

    @Override
    public String toString() {
        return name + " (" + type + ", " + category + ") - $" + price;
    }
}
