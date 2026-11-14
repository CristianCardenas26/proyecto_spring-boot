package pricing;

import java.math.BigDecimal;

public class Product {
    private String sku;
    private BigDecimal price;
    private int stock;
    private String status;

    //constrictor 
    public Product(String sku, BigDecimal price, int stock) {
        this.sku = sku;
        this.price = price;
        this.stock = stock;
        this.status = "ACTIVE"; // Por defecto, el producto está activo
    }
// getters y setters
   public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}