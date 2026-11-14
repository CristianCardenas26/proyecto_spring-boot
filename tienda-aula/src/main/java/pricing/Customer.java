package pricing;

public class Customer {
    private String id;
    private String customer;
    private String name;
    private String status;

    public Customer() {
    }

    // Constructor
    public Customer(String id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
    }

    // Getters y Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getCustomer() { return customer; }
    public void setCustomer(String customer) { this.customer = customer; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}