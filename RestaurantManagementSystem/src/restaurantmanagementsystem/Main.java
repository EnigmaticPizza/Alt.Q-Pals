package restaurantmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    public static void main(String[] args) {
        // Start the GUI application
        SwingUtilities.invokeLater(() -> {
            new MainFrame();
        });
    }

    // JFrame for the main window
    static class MainFrame extends JFrame {
        private JTextField nameField;
        private JPasswordField passwordField;

        public MainFrame() {
            setTitle("Welcome to COS");
            setSize(400, 250);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            // Set up the layout
            setLayout(new BorderLayout());

            // Welcome message
            JLabel welcomeLabel = new JLabel("Welcome to COS!", JLabel.CENTER);
            welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
            add(welcomeLabel, BorderLayout.NORTH);

            // Create a panel for the form
            JPanel formPanel = new JPanel();
            formPanel.setLayout(new GridLayout(3, 2, 10, 10));

            // Add Name label and text field
            formPanel.add(new JLabel("Enter Name:"));
            nameField = new JTextField();
            formPanel.add(nameField);

            // Add Password label and text field
            formPanel.add(new JLabel("Enter Password:"));
            passwordField = new JPasswordField();
            formPanel.add(passwordField);

            // Add Submit button
            JButton submitButton = new JButton("Submit");
            submitButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String name = nameField.getText();
                    String password = new String(passwordField.getPassword());
                    authenticateEmployee(name, password);
                }
            });

            formPanel.add(submitButton);

            // Add the form panel to the center of the frame
            add(formPanel, BorderLayout.CENTER);

            setVisible(true);
        }

        // Authenticate the employee based on the entered name and password
        private void authenticateEmployee(String name, String password) {
            EmployeeManager employeeManager = new EmployeeManager("restaurantmanagementsystem.data/EmployeeAccount.txt");
            EmployeeAccount loggedInEmployee = employeeManager.authenticate(name, password);  // Removed (error)

            if (loggedInEmployee == null) {
                // Invalid credentials - show error message
                JOptionPane.showMessageDialog(this, "Invalid credentials. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Valid credentials - show success message
                JOptionPane.showMessageDialog(this, "Welcome, " + loggedInEmployee.getName() + "!", "Success", JOptionPane.INFORMATION_MESSAGE);
                // Proceed to the next step based on the employee's role
                handleRoleActions(loggedInEmployee);
            }
        }

        // Handle role-based actions after successful login
        private void handleRoleActions(EmployeeAccount employee) {
            MenuManager menuManager = new MenuManager("restaurantmanagementsystem.data/Menu.txt");
            TicketManager ticketManager = new TicketManager();

            switch (employee.getPosition().toUpperCase()) {
                case "MANAGER":
                    ManagerActions.handleManagerActions(menuManager, ticketManager);  // Removed (error)
                    break;
                case "COUNTER":
                    CounterActions.handleCounterActions(menuManager, ticketManager);  // Removed (error)
                    break;
                case "KITCHEN STAFF":
                    KitchenActions.handleKitchenActions(ticketManager);  // Removed (error)
                    break;
                case "BARISTA":
                    BaristaActions.handleBaristaActions(ticketManager);  // Removed (error)
                    break;
                default:
                    JOptionPane.showMessageDialog(this, "Invalid position assigned to the employee.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
