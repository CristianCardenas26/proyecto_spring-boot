package pricing;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PricingTest {

    @Test
    public void testVentaValida() {
        Product product = new Product("PROD-001", new BigDecimal("50.00"), 10);
        OrderItem item = new OrderItem(product, 2);
        Order order = new Order(Arrays.asList(item));

        String resultado = order.processOrder();
        assertEquals("Venta exitosa", resultado);
        assertEquals(8, product.getStock()); // Verifica que el stock se descontó correctamente (10 - 2)
    }

    @Test
    public void testCantidadCero() {
        Product product = new Product("PROD-001", new BigDecimal("50.00"), 10);
        OrderItem item = new OrderItem(product, 0);
        Order order = new Order(Arrays.asList(item));

        String resultado = order.processOrder();
        assertEquals("Error: Cantidad inválida", resultado);
        assertEquals(10, product.getStock()); // El stock no debe modificarse
    }

    @Test
    public void testPrecioInvalido() {
        Product product = new Product("PROD-002", new BigDecimal("0.00"), 10);
        OrderItem item = new OrderItem(product, 2);
        Order order = new Order(Arrays.asList(item));

        String resultado = order.processOrder();
        assertEquals("Error: Precio inválido", resultado);
        assertEquals(10, product.getStock()); // El stock no debe modificarse
    }

    @Test
    public void testStockInsuficiente() {
        Product product = new Product("PROD-003", new BigDecimal("25.00"), 3);
        OrderItem item = new OrderItem(product, 5);
        Order order = new Order(Arrays.asList(item));

        String resultado = order.processOrder();
        assertEquals("Error: Stock insuficiente", resultado);
        assertEquals(3, product.getStock()); 
    }
    @Test
public void testClienteBloqueadoRechazado() {
    Customer clienteBloqueado = new Customer("CUST-002", "Cliente Bloqueado", "BLOCKED");
    Product product = new Product("PROD-001", new BigDecimal("50.00"), 10);
    OrderItem item = new OrderItem(product, 2);
    
    // Creamos la orden con el cliente bloqueado
    Order order = new Order(clienteBloqueado, Arrays.asList(item));

    String resultado = order.processOrder();
    assertEquals("Error: Cliente no válido o bloqueado", resultado);
}
    // Caso límite exitoso: Comprar exactamente las 10 unidades disponibles
@Test
    public void testCasoLimiteStockExacto() {
        
        Product product = new Product("PROD-09", new BigDecimal("20.00"), 10);
        OrderItem item = new OrderItem(product, 10);
        Order order = new Order(Arrays.asList(item));

        String resultado = order.processOrder();
        assertEquals("Venta exitosa", resultado);
        assertEquals(0, product.getStock()); // El stock debe quedar en 0 exactos
    }

    // Caso límite de fallo: Intentar comprar 11 unidades cuando solo hay 10
    @Test
    public void testCasoLimiteStockInsuficiente() {
        
        Product product = new Product("PROD-09", new BigDecimal("20.00"), 10);
        OrderItem item = new OrderItem(product, 11);
        Order order = new Order(Arrays.asList(item));

        String resultado = order.processOrder();
        assertEquals("Error: Stock insuficiente", resultado);
        assertEquals(10, product.getStock()); // El stock no debe sufrir cambios (sin cambios parciales)
    }

}