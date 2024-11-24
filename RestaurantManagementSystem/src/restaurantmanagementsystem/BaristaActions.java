package restaurantmanagementsystem;

import restaurantmanagementsystem.MenuItem;
import java.util.Scanner;

public class BaristaActions {
    public static void handleBaristaActions(TicketManager ticketManager, Scanner scanner) {
        while (true) {
            System.out.println("\nBarista Options:");
            System.out.println("1. View Tickets");
            System.out.println("2. Delete Ticket");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Tickets for Barista:");
                    for (Ticket ticket : ticketManager.getTicketsForBarista()) {
                        System.out.println("Ticket #" + ticket.getTicketNumber() + ":");
                        for (MenuItem item : ticket.getItems()) {
                            if (item.getType().equalsIgnoreCase("drink")) {
                                System.out.println("  - " + item.getName());
                            }
                        }
                    }
                    break;

                case 2:
                    System.out.print("Enter ticket number to delete: ");
                    int ticketNo = Integer.parseInt(scanner.nextLine());
                    ticketManager.deleteTicket(ticketNo);
                    System.out.println("Ticket deleted successfully.");
                    break;

                case 3:
                    System.out.println("Logging out...");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
