package com.example.restservice;

import java.math.BigDecimal;

public class OrderItem {
    private String sku;
    private int quantity;
    private BigDecimal price;

    // constructores 
    public OrderItem() {}

    public OrderItem(String sku, int quantity, BigDecimal price) {
        this.sku = sku;
        this.quantity = quantity;
        this.price = price;
    }

    // getters y setters
    public String getSku() { return sku; }
    public void setSku(String sku) { this.sku = sku; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}