package restaurantmanagementsystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MenuManager {
    private List<MenuItem> menuItems = new ArrayList<>();
    private final String filePath = "src/restaurantmanagementsystem/data/Menu.txt";

    public MenuManager(String filePath) {
        //this.filePath = filePath;
        loadMenuFromFile();
    }

    private void loadMenuFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    menuItems.add(new MenuItem(parts[0], parts[1], parts[2], Double.parseDouble(parts[3])));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading menu data: " + e.getMessage());
        }
    }

    private void saveMenuToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (MenuItem item : menuItems) {
                bw.write(item.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving menu data: " + e.getMessage());
        }
    }

    public void addMenuItem(String name, String type, String category, double price) {
        menuItems.add(new MenuItem(name, type, category, price));
        saveMenuToFile();
    }

    public void updateMenuItem(int index, String name, String type, String category, double price) {
        if (index >= 0 && index < menuItems.size()) {
            menuItems.set(index, new MenuItem(name, type, category, price));
            saveMenuToFile();
        }
    }

    public void deleteMenuItem(int index) {
        if (index >= 0 && index < menuItems.size()) {
            menuItems.remove(index);
            saveMenuToFile();
        }
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }
}
