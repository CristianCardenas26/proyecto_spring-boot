package LapizFeliz; 

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private Customer customer; // Atributo para el cliente ACTIVE
    private List<OrderItem> items;

    public Order(Customer customer, List<OrderItem> items) {
        this.customer = customer;
        this.items = items;
    }

    public String processOrder() {
        // Validaciones del cliente
        if (customer == null || !"ACTIVE".equalsIgnoreCase(customer.getStatus())) {
            return "Error: El cliente no está activo";
        }

        for (OrderItem item : items) {
            Product p = item.getProduct();
            int qty = item.getQuantity();

            // Validaciones de items
            if (qty <= 0) {
                return "Error: Cantidad inválida (debe ser mayor a cero)";
            }
            if (p.getPrice() == null || p.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
                return "Error: Precio inválido";
            }
            if (p.getStock() < qty) {
                return "Error: Stock insuficiente";
            }
        }
        
        // Descuento de stock
        for (OrderItem item : items) {
            Product p = item.getProduct();
            p.setStock(p.getStock() - item.getQuantity());
        }

        return "Venta exitosa";
    }

    // Getters
    public Customer getCustomer() { return customer; }
    public List<OrderItem> getItems() { return items; }
}