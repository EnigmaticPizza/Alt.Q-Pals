package restaurantmanagementsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CounterActions {
    public static void handleCounterActions(MenuManager menuManager, TicketManager ticketManager, Scanner scanner) {
        while (true) {
            System.out.println("\nCounter Options:");
            System.out.println("1. Enter Order");
            System.out.println("2. Delete Order");
            System.out.println("3. Logout");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    List<MenuItem> orderItems = new ArrayList<>();
                    while (true) {
                        System.out.println("Menu Items:");
                        int index = 0;
                        for (MenuItem item : menuManager.getMenuItems()) {
                            System.out.println(index + ". " + item);
                            index++;
                        }
                        System.out.print("Enter item index to add to order: ");
                        int itemIndex = Integer.parseInt(scanner.nextLine());
                        orderItems.add(menuManager.getMenuItems().get(itemIndex));

                        System.out.print("Add another item? (yes/no): ");
                        String another = scanner.nextLine();
                        if (another.equalsIgnoreCase("no")) {
                            break;
                        }
                    }

                    System.out.println("Order Summary:");
                    double totalPrice = 0;
                    for (MenuItem item : orderItems) {
                        System.out.println(item);
                        totalPrice += item.getPrice();
                    }
                    System.out.println("Total Price: " + totalPrice);

                    // Generate ticket number
                    int ticketNumber = ticketManager.getTickets().size() + 1;

                    // Create the ticket
                    ticketManager.createTicket(ticketNumber, orderItems);

                    System.out.println("Order created and tickets sent!");
                    break;

                case 2:
                    System.out.println("Deleting Order feature will be available soon.");
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

