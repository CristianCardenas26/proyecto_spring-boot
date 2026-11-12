package pricing;

import org.junit.jupiter.api.Test;

import pricing.OrderItem;
import pricing.Product;

import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PricingTest {

    @Test
    public void testVentaValida() {
        Product product = new Product("SKU-001", new BigDecimal("50.00"), 10);
        OrderItem item = new OrderItem(product, 2);
        Order order = new Order(Arrays.asList(item));

        String resultado = order.processOrder();
        assertEquals("Venta exitosa", resultado);
        assertEquals(8, product.getStock()); 
    }

    @Test
    public void testCantidadCero() {
        Product product = new Product("SKU-002", new BigDecimal("20.00"), 10);
        OrderItem item = new OrderItem(product, 0);
        Order order = new Order(Arrays.asList(item));

        String resultado = order.processOrder();
        assertEquals("Error: Cantidad inválida (debe ser mayor a cero)", resultado);
    }

    @Test
    public void testPrecioInvalido() {
        Product product = new Product("SKU-003", new BigDecimal("0.00"), 10);
        OrderItem item = new OrderItem(product, 2);
        Order order = new Order(Arrays.asList(item));

        String resultado = order.processOrder();
        assertEquals("Error: Precio inválido", resultado);
    }

    @Test
    public void testStockInsuficiente() {
        Product product = new Product("SKU-004", new BigDecimal("15.00"), 3);
        OrderItem item = new OrderItem(product, 5);     
        Order order = new Order(Arrays.asList(item));

        String resultado = order.processOrder();
        assertEquals("Error: Stock insuficiente", resultado);
        assertEquals(3, product.getStock()); 
    }
}