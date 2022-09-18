package com.customer.controller;

import com.customer.contract.CustomersContract;
import com.customer.entity.Customer;
import com.customer.exception.CpfCnpjInvalidException;
import com.customer.model.CustomerModel;
import com.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
public class CustomerController implements CustomersContract {

    @Autowired
    CustomerService service;

    @Override
    public ResponseEntity<List<Customer>> getAll() {
        return new ResponseEntity<List<Customer>>(service.getAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody CustomerModel customerModel) throws CpfCnpjInvalidException {
        return new ResponseEntity<Customer>(service.saveCustomer(customerModel), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<Customer>> findCustomersByName(@PathVariable String name) {
        return new ResponseEntity<>(service.findByName(name), HttpStatus.OK);
    }

    @Override
    public void deleteCustomer(UUID id) {
        service.deleteCustomer(id);
    }

    @Override
    public ResponseEntity<Customer> editCustomer(UUID id, Customer customerToEdit) {
        return new ResponseEntity<Customer>(service.editCustomer(id, customerToEdit), HttpStatus.OK);
    }
}
