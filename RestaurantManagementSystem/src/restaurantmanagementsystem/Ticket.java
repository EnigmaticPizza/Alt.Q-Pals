package restaurantmanagementsystem;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Ticket {
    private int ticketNumber;
    private List<MenuItem> items;

    public Ticket(int ticketNumber, List<MenuItem> items) {
        this.ticketNumber = ticketNumber;
        this.items = items;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public boolean containsFood() {
        return items.stream().anyMatch(item -> item.getType().equalsIgnoreCase("food"));
    }

    public boolean containsDrinks() {
        return items.stream().anyMatch(item -> item.getType().equalsIgnoreCase("drink"));
    }

    public Ticket filterByCategory(String category) {
        List<MenuItem> filteredItems = items.stream()
                .filter(item -> item.getType().equalsIgnoreCase(category))
                .collect(Collectors.toList());
        return new Ticket(ticketNumber, filteredItems);
    }

    public String toCsv() {
        String itemsData = items.stream()
                .map(MenuItem::toCsv)
                .collect(Collectors.joining(";"));
        return ticketNumber + "|" + itemsData;
    }

    public static Ticket fromCsv(String csv) {
        String[] parts = csv.split("\\|", 2);
        int ticketNumber = Integer.parseInt(parts[0]);
        List<MenuItem> items = new ArrayList<>();
        if (parts.length > 1) {
            for (String itemData : parts[1].split(";")) {
                items.add(MenuItem.fromCsv(itemData));
            }
        }
        return new Ticket(ticketNumber, items);
    }

    @Override
    public String toString() {
        return "Ticket #" + ticketNumber + ":\n" + items;
    }
}
