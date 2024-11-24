package restaurantmanagementsystem;

public class EmployeeAccount {
    private String name;
    private String id;
    private String position;
    private String password;

    public EmployeeAccount(String name, String id, String position, String password) {
        this.name = name;
        this.id = id;
        this.position = position;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getPosition() {
        return position;
    }

    public String getPassword() {
        return password;
    }

    public String toCsv() {
        return String.join(",", name, id, position, password);
    }

    @Override
    public String toString() {
        return "EmployeeAccount{" +
               "name='" + name + '\'' +
               ", id='" + id + '\'' +
               ", position='" + position + '\'' +
               ", password='***'}";
    }
}


