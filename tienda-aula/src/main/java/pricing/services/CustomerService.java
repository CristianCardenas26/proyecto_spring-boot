package pricing.services;

import pricing.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerService {
    private final List<Customer> customerList = new ArrayList<>();

    public List<Customer> getAllCustomers() {
        return customerList;
    }

    public Customer createCustomer(Customer customer) {
        if (customer.getId() == null || customer.getId().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El ID del cliente es obligatorio.");
        }

        boolean idExists = customerList.stream()
                .anyMatch(c -> c.getId().equals(customer.getId()));

        if (idExists) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Ya existe un cliente registrado con el ID: " + customer.getId());
        }

        if (customer.getName() == null || customer.getName().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El nombre del cliente es obligatorio.");
        }

        if (customer.getStatus() == null || customer.getStatus().isBlank()) {
            customer.setStatus("ACTIVE");
        } else {
            String status = customer.getStatus().toUpperCase();
            if (!status.equals("ACTIVE") && !status.equals("BLOCKED")) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El estado del cliente debe ser ACTIVE o BLOCKED.");
            }
            customer.setStatus(status);
        }

        customerList.add(customer);
        return customer;
    }
    public Customer getCustomerById(String id) {
        return customerList.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}