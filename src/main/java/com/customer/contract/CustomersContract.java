package com.customer.contract;

import com.customer.entity.Customer;
import com.customer.exception.CpfCnpjInvalidException;
import com.customer.model.CustomerModel;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RequestMapping("/api/customer")
@Tag(name = "Customers register", description = "Create, edit, search and delete customers.")
public interface CustomersContract {

    @Operation(summary = "List all Customers.")
    @GetMapping
    ResponseEntity<List<Customer>> getAll();

    @Operation(summary = "Creates a customer.")
    @PostMapping
    ResponseEntity<Customer> saveCustomer(@Valid @RequestBody CustomerModel customerModel) throws CpfCnpjInvalidException;

    @Operation(summary = "Search customers by name.")
    @GetMapping("/search/{name}")
    ResponseEntity<List<Customer>> findCustomersByName(@PathVariable String name);

    @Operation(summary = "Search customer by id.")
    @GetMapping("/{id}")
    ResponseEntity<Customer> findCustomersById(@PathVariable UUID id);

    @Operation(summary = "Delete a customer.")
    @DeleteMapping("/{id}")
    void deleteCustomer(@PathVariable UUID id);

    @Operation(summary = "Edit a customer.")
    @PutMapping("/{id}")
    ResponseEntity<Customer> editCustomer(@PathVariable UUID id, @RequestBody Customer customerToEdit);
}
