package pricing;

import java.math.BigDecimal;

public class Product {
    private String sku;
    private BigDecimal price;
    private int stock;

    // 1. Constructor vacío (Obligatorio para Spring / Jackson)
    public Product() {
    }

    // Constructor con parámetros
    public Product(String sku, BigDecimal price, int stock) {
        this.sku = sku;
        this.price = price;
        this.stock = stock;
    }

    // Getters y Setters
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}