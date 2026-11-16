package pricing;
// artributos
public class Order {
    private Long id;
    private String customerId;
    private OrderItem item;
    private boolean confirmed = false;

// constructores
    public Order() {}

    public Order(Long id, String customerId, OrderItem item) {
        this.id = id;
        this.customerId = customerId;
        this.item = item;
        this.confirmed = false;
    }
    
// getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public OrderItem getItem() { return item; }
    public void setItem(OrderItem item) { this.item = item; }

    public boolean isConfirmed() { return confirmed; }
    public void setConfirmed(boolean confirmed) { this.confirmed = confirmed; }
}