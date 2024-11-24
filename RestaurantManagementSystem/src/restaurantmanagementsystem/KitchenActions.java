package restaurantmanagementsystem;

import java.util.Scanner;

public class KitchenActions {
    public static void handleKitchenActions(TicketManager ticketManager, Scanner scanner) {
        while (true) {
            System.out.println("\nKitchen Options:");
            System.out.println("1. View Tickets");
            System.out.println("2. Delete Ticket");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Tickets for Kitchen:");
                    for (Ticket ticket : ticketManager.getTickets()) {
                        Ticket foodTicket = ticket.filterByCategory("food");
                        if (!foodTicket.getItems().isEmpty()) { // Check if there are food items
                            System.out.println("Ticket #" + foodTicket.getTicketNumber() + ":");
                            for (MenuItem item : foodTicket.getItems()) {
                                System.out.println("  - " + item.getName());
                            }
                        } else {
                            System.out.println("Ticket #" + ticket.getTicketNumber() + " has no food items.");
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
