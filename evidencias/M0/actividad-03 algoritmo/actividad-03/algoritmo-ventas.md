# Algoritmo para Vender un Producto

# Pasos del proceso:

1. **Leer datos de entrada:**
   - Solicitar y recibir el código del producto (SKU).
   - Solicitar y recibir la cantidad solicitada por el cliente.

2. **Validar inventario (Stock):**
   - Buscar el producto en el sistema usando su SKU.
   - Verificar si la cantidad solicitada es menor o igual al stock disponible en inventario.
   - Si no hay suficiente stock, mostrar un mensaje de error y cancelar la operación.

3. **Calcular subtotal:**
   - Si hay stock suficiente, obtener el precio unitario del producto.
   - Multiplicar el precio unitario por la cantidad solicitada para obtener el subtotal.
   - Actualizar el stock restando la cantidad vendida.

4. **Mostrar resultado:**
   - Mostrar en pantalla el resumen de la compra, el subtotal a pagar y la confirmación exitosa de la venta.