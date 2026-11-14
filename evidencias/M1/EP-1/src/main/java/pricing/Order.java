package pricing;

import java.math.BigDecimal;
import java.util.List;

public class Order {
    private Long id;
    private Customer customer;
    private List<OrderItem> items;
    private boolean confirmed = false;
    private BigDecimal total = BigDecimal.ZERO;

    // Constructor por defecto que carga el cliente sintético ACTIVE
    public Order() {
        this.customer = new Customer("CUST-001", "Cliente Sintético", "ACTIVE");
    }

    public Order(List<OrderItem> items) {
        this.customer = new Customer("CUST-001", "Cliente Sintético", "ACTIVE");
        this.items = items;
    }

    public Order(Customer customer, List<OrderItem> items) {
        this.customer = (customer != null) ? customer : new Customer("CUST-001", "Cliente Sintético", "ACTIVE");
        this.items = items;
    }

    // Método pequeño de validación y cálculo de subtotal (M1)
    public BigDecimal calculateLineSubtotal(BigDecimal price, int qty) {
        if (price == null || price.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Precio inválido");
        }
        if (qty <= 0) {
            throw new IllegalArgumentException("Cantidad inválida");
        }
        return price.multiply(BigDecimal.valueOf(qty));
    }

    // Método principal de procesamiento de la orden
    public String processOrder() {

        // RN-01: Validar si la referencia del cliente falta o está BLOCKED
        if (customer == null || "BLOCKED".equals(customer.getStatus())) {
            return "Error: Cliente no válido o bloqueado";
        }

        if (items == null || items.isEmpty()) {
            return "Error: Orden sin ítems";
        }

        // Inicializamos el total en cero al empezar a procesar
        this.total = BigDecimal.ZERO;

        // Primer ciclo: Validaciones de productos, subtotales y stock
        for (OrderItem item : items) {
            Product product = item.getProduct();
            int qty = item.getQuantity();

            // RN-02: No se admiten productos inactivos
            if (product == null || !"ACTIVE".equals(product.getStatus())) {
                return "Error: Producto inactivo";
            }

           BigDecimal subtotalLinea;
            try {
                // RN-03: Subtotal por línea = cantidad × precio (y lo guardamos en subtotalLinea)
                subtotalLinea = calculateLineSubtotal(product.getPrice(), qty);
            } catch (IllegalArgumentException e) {
                return "Error: " + e.getMessage();
            }

            // Validar stock (una sola vez)
            if (product.getStock() < qty) {
                return "Error: Stock insuficiente";
            }

            // RN-03: Subtotal pedido = suma de líneas
            this.total = this.total.add(subtotalLinea);
        }

        // Segundo ciclo: Descuenta el stock si todo es correcto
        for (OrderItem item : items) {
            Product prod = item.getProduct();
            prod.setStock(prod.getStock() - item.getQuantity());
        }

        this.confirmed = true;
        return "Venta exitosa";
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }

    public boolean isConfirmed() { return confirmed; }
    public void setConfirmed(boolean confirmed) { this.confirmed = confirmed; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}