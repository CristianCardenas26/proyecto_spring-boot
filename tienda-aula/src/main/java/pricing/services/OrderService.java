package pricing.services;

import pricing.Customer;
import pricing.Order;
import pricing.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final List<Order> orderList = new ArrayList<>();
    private long currentId = 1L;

    private final CustomerService customerService;
    private final ProductService productService;

    public OrderService(CustomerService customerService, ProductService productService) {
        this.customerService = customerService;
        this.productService = productService;
    }

    public Order createOrder(Order order) {
        // 1. Validar que el cliente exista y no esté bloqueado
        Customer customer = customerService.getCustomerById(order.getCustomerId());
        if (customer == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente no encontrado");
        }
        if ("BLOCKED".equalsIgnoreCase(customer.getStatus())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El cliente está bloqueado y no puede realizar pedidos");
        }

        // 2. Validar que la orden tenga un ítem y que el producto exista
        if (order.getItem() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "La orden debe contener un producto");
        }

        Product product = productService.getProductBySku(order.getItem().getSku());
        if (product == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Producto no encontrado");
        }

        // 3. Validar stock disponible
        int requestedQty = order.getItem().getQuantity();
        if (product.getStock() < requestedQty) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Stock insuficiente para el producto solicitado");
        }

        // 4. Descontar stock y guardar la orden
        product.setStock(product.getStock() - requestedQty);
        order.setId(currentId++);
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
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Orden no encontrada"));

        order.setConfirmed(true);
        return order;
    }

    public void deleteOrder(Long id) {
        boolean removed = orderList.removeIf(o -> o.getId().equals(id));
        if (!removed) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Orden no encontrada");
        }
    }
}