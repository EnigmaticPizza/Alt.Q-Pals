package restaurantmanagementsystem;

import java.util.Scanner;

public class ManagerActions {
    public static void handleManagerActions(MenuManager menuManager, EmployeeManager employeeManager, Scanner scanner) {
        while (true) {
            System.out.println("\nManager Options:");
            System.out.println("1. Add a Menu Item");
            System.out.println("2. Edit a Menu Item");
            System.out.println("3. Delete a Menu Item");
            System.out.println("4. Add an Employee Account");
            System.out.println("5. Delete an Employee Account");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter type (Food/Drink): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = Double.parseDouble(scanner.nextLine());
                    menuManager.addMenuItem(name, type, category, price);
                    System.out.println("Menu item added successfully.");
                    break;

                case 2:
                    System.out.println("Menu Items:");
                    int index = 0;
                    for (MenuItem item : menuManager.getMenuItems()) {
                        System.out.println(index + ". " + item);
                        index++;
                    }
                    System.out.print("Enter item index to edit: ");
                    int editIndex = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new type: ");
                    String newType = scanner.nextLine();
                    System.out.print("Enter new category: ");
                    String newCategory = scanner.nextLine();
                    System.out.print("Enter new price: ");
                    double newPrice = Double.parseDouble(scanner.nextLine());
                    menuManager.updateMenuItem(editIndex, newName, newType, newCategory, newPrice);
                    System.out.println("Menu item updated successfully.");
                    break;

                case 3:
                    System.out.println("Menu Items:");
                    int delIndex = 0;
                    for (MenuItem item : menuManager.getMenuItems()) {
                        System.out.println(delIndex + ". " + item);
                        delIndex++;
                    }
                    System.out.print("Enter item index to delete: ");
                    int deleteIndex = Integer.parseInt(scanner.nextLine());
                    menuManager.deleteMenuItem(deleteIndex);
                    System.out.println("Menu item deleted successfully.");
                    break;

                case 4:
                    System.out.print("Enter employee name: ");
                    String empName = scanner.nextLine();
                    System.out.print("Enter employee ID: ");
                    String empId = scanner.nextLine();
                    System.out.print("Enter position: ");
                    String position = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String empPassword = scanner.nextLine();
                    employeeManager.addEmployee(empName, empId, position, empPassword);
                    System.out.println("Employee account added successfully.");
                    break;

                case 5:
                    System.out.print("Enter employee ID to delete: ");
                    String deleteEmpId = scanner.nextLine();
                    employeeManager.deleteEmployee(deleteEmpId);
                    System.out.println("Employee account deleted successfully.");
                    break;

                case 6:
                    System.out.println("Logging out...");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
