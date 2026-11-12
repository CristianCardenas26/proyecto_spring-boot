package LapizFeliz;

public class OrderItem {
    private Product product;
    private int quantity;

// constructor
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
// geters
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
}