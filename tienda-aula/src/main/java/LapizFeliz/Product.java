package LapizFeliz;

import java.math.BigDecimal;

public class Product {
    private String sku;
    private BigDecimal price;
    private int stock;

    //constrictor 
    public Product(String sku, BigDecimal price, int stock) {
        this.sku = sku;
        this.price = price;
        this.stock = stock;
    }
// getters y setters
    public String getSku() { return sku; }
    public BigDecimal getPrice() { return price; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}