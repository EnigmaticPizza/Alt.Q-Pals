package restaurantmanagementsystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TicketManager {
    private List<Ticket> tickets = new ArrayList<>();
    private final String filePath = "restaurantmanagementsystem.data/Ticket.txt";

    public TicketManager() {
        loadTicketsFromFile();
    }

    private void loadTicketsFromFile() {
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs(); // Create parent directories if they don't exist.
                file.createNewFile(); // Create the file.
            } catch (IOException e) {
                System.out.println("Error creating Ticket.txt: " + e.getMessage());
                return;
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                tickets.add(Ticket.fromCsv(line));
            }
        } catch (IOException e) {
            System.out.println("Error reading tickets: " + e.getMessage());
        }
    }

    private void saveTicketsToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Ticket ticket : tickets) {
                bw.write(ticket.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving tickets: " + e.getMessage());
        }
    }

    public void createTicket(int ticketNumber, List<MenuItem> items) {
        Ticket ticket = new Ticket(ticketNumber, items);
        tickets.add(ticket);
        saveTicketsToFile();
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public List<Ticket> getTicketsForKitchen() {
        return tickets.stream()
                .map(ticket -> ticket.filterByCategory("food")) // Filter items by food category
                .filter(ticket -> !ticket.getItems().isEmpty()) // Only include tickets with items
                .collect(Collectors.toList());
    }

    public List<Ticket> getTicketsForBarista() {
        return tickets.stream()
                .map(ticket -> ticket.filterByCategory("drink")) // Filter items by drink category
                .filter(ticket -> !ticket.getItems().isEmpty()) // Only include tickets with items
                .collect(Collectors.toList());
    }

    public void deleteTicket(int ticketNumber) {
        tickets.removeIf(t -> t.getTicketNumber() == ticketNumber);
        saveTicketsToFile();
    }
}

