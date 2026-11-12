package com.example.restservice;
// artributos
public class Order {
    private Long id;
    private String clientStatus = "ACTIVE";
    private OrderItem item;
    private boolean confirmed = false;

// constructores
    public Order() {}

    public Order(Long id, OrderItem item) {
        this.id = id;
        this.item = item;
        this.clientStatus = "ACTIVE";
        this.confirmed = false;
    }
    
// getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getClientStatus() { return clientStatus; }
    public void setClientStatus(String clientStatus) { this.clientStatus = clientStatus; }

    public OrderItem getItem() { return item; }
    public void setItem(OrderItem item) { this.item = item; }

    public boolean isConfirmed() { return confirmed; }
    public void setConfirmed(boolean confirmed) { this.confirmed = confirmed; }
}