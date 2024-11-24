package restaurantmanagementsystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager {
    private List<EmployeeAccount> employees = new ArrayList<>();
    private final String filePath = "src/restaurantmanagementsystem/data/EmployeeAccount.txt";

    public EmployeeManager(String filePath) {
        //this.filePath = filePath;
        loadEmployeesFromFile();
    }

    private void loadEmployeesFromFile() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 4) {
                    employees.add(new EmployeeAccount(parts[0], parts[1], parts[2], parts[3]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading employee data: " + e.getMessage());
        }
    }

    private void saveEmployeesToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (EmployeeAccount emp : employees) {
                bw.write(emp.toCsv());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving employee data: " + e.getMessage());
        }
    }

    public EmployeeAccount authenticate(String name, String id, String password) {
        for (EmployeeAccount emp : employees) {
            if (emp.getName().equalsIgnoreCase(name) &&
                emp.getId().equalsIgnoreCase(id) &&
                emp.getPassword().equals(password)) {
                return emp;
            }
        }
        return null;
    }

    public void addEmployee(String name, String id, String position, String password) {
        employees.add(new EmployeeAccount(name, id, position, password));
        saveEmployeesToFile();
    }

    public void deleteEmployee(String id) {
        employees.removeIf(emp -> emp.getId().equalsIgnoreCase(id));
        saveEmployeesToFile();
    }
}

