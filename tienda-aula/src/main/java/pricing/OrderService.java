package pricing;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {
    private List<Order> orderList = new ArrayList<>();
    private long currentId = 1L;

    // Inventario simulado para validar SKU y stock
    private List<Product> availableProducts = new ArrayList<>(List.of(
        new Product("PROD-001", new BigDecimal("150.00"), 10)
    ));

    public Order createOrder(Order order) {
        // 1. Validar que exista la línea de producto
        if (order.getItem() == null || order.getItem().getSku() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El SKU del producto es obligatorio.");
        }

        // 2. Validar si el SKU existe en el inventario
        Product product = availableProducts.stream()
                .filter(p -> p.getSku().equals(order.getItem().getSku()))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "SKU no encontrado en inventario."));

        // 3. Validar cantidad vs Stock
        if (order.getItem().getQuantity() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La cantidad debe ser mayor a cero.");
        }
        if (order.getItem().getQuantity() > product.getStock()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Stock insuficiente para la cantidad solicitada.");
        }

        // 4. Precargar datos por defecto y guardar
        order.setId(currentId++);
        order.setClientStatus("ACTIVE");
        order.setConfirmed(false);
        orderList.add(order);

        return order;
    }

    public List<Order> getAllOrders() {
        return orderList;
    }

    public Order confirmOrder(Long id) {
        Order order = orderList.stream()
                .filter(o -> o.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido no encontrado con ID: " + id));

        order.setConfirmed(true);
        return order;
    }
    
    public void deleteOrder(Long id) {
    boolean removed = orderList.removeIf(o -> o.getId().equals(id));
    if (!removed) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pedido no encontrado para eliminar con ID: " + id);
    }
 }

}
