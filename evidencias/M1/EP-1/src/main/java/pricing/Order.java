package pricing;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private List<OrderItem> items;

    public Order(List<OrderItem> items) {
        this.items = items;
    }

    
    public String processOrder() {
        for (OrderItem item : items) {
            Product p = item.getProduct();
            int qty = item.getQuantity();

            // Validaciones
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

       // descuento de stock
        for (OrderItem item : items) {
            Product p = item.getProduct();
            p.setStock(p.getStock() - item.getQuantity());
        }

        return "Venta exitosa";
    }
}