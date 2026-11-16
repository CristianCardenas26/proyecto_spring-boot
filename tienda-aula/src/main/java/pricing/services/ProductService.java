package pricing.services;

import pricing.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private final List<Product> productList = new ArrayList<>();

    public List<Product> getAllProducts() {
        return productList;
    }

    public Product addProduct(Product product) {
        // 1. Validar que el SKU no venga vacío o nulo
        if (product.getSku() == null || product.getSku().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El SKU del producto es obligatorio.");
        }

        // 2. Validar que el SKU NO se repita
        boolean skuExists = productList.stream()
                .anyMatch(p -> p.getSku().equals(product.getSku()));

        if (skuExists) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ya existe un producto registrado con el SKU: " + product.getSku());
        }

        // 3. Validar que el precio no sea negativo o nulo
        if (product.getPrice() == null || product.getPrice().signum() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El precio del producto debe ser mayor a cero.");
        }

        // 4. Validar que el stock no sea negativo
        if (product.getStock() < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El stock no puede ser un valor negativo.");
        }

        // 5. Guardar en la lista y retornar
        productList.add(product);
        return product;
    }
    public Product getProductBySku(String sku) {
        return productList.stream()
                .filter(p -> p.getSku().equals(sku))
                .findFirst()
                .orElse(null);
    }
}