package LapizFeliz;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.util.Arrays;

@RestController
public class OrderController {

    @GetMapping("/probar-pedido")
    public String probarPedido() {
        // 1. Crear cliente sintético ACTIVE
        Customer cliente = new Customer("1", "Carlos Pérez", "ACTIVE");
        
        // 2. Crear producto con precio y stock
        Product producto = new Product("SKU-001", new BigDecimal("50.0"), 10);
        
        // 3. Crear ítem y pedido
        OrderItem item = new OrderItem(producto, 2);
        Order pedido = new Order(cliente, Arrays.asList(item));
        
        // 4. Procesar regla de negocio
        return pedido.processOrder();
    }
}   