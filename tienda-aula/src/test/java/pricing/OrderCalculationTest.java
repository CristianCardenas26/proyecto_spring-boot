package pricing;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import static org.junit.jupiter.api.Assertions.*;

public class OrderCalculationTest {

    @Test
    void testSubtotalValido() {

        OrderItem item = new OrderItem("PROD-01", 3, new BigDecimal("50.00"));
  
        BigDecimal subtotalEsperado = new BigDecimal("150.00");
        BigDecimal subtotalCalculado = item.getPrice().multiply(new BigDecimal(item.getQuantity()));
        
        assertEquals(0, subtotalEsperado.compareTo(subtotalCalculado));
    }

    @Test
    void testCantidadCero() {
        OrderItem item = new OrderItem("PROD-01", 0, new BigDecimal("50.00"));
        assertEquals(0, item.getQuantity(), "La cantidad debería ser cero");
    }

    @Test
    void testPrecioInvalido() {
        Product product = new Product("PROD-02", new BigDecimal("-10.00"), 5);
        assertTrue(product.getPrice().signum() <= 0, "El precio debería considerarse inválido (negativo)");
    }

    @Test
    void testStockInsuficiente() {
        Product product = new Product("PROD-03", new BigDecimal("20.00"), 5);
        int cantidadSolicitada = 10;
        
        boolean stockInsuficiente = cantidadSolicitada > product.getStock();
        assertTrue(stockInsuficiente, "Debería detectar que el stock es insuficiente para la cantidad solicitada");
    }
}