package com.customer.service;

import com.customer.entity.Customer;
import com.customer.exception.CpfCnpjInvalidException;
import com.customer.exception.CustomerDuplicatedException;
import com.customer.model.CustomerModel;
import com.customer.repository.CustomerRepository;
import lombok.NoArgsConstructor;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@NoArgsConstructor
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    public Customer saveCustomer(@Valid CustomerModel customerModel) throws CpfCnpjInvalidException {
        Optional<Customer> customerDuplicated = repository.findByCpfCnpj(customerModel.getCpfCnpj());
        customerDuplicated.ifPresent(found -> { throw new CustomerDuplicatedException(customerDuplicated.get().getCpfCnpj()); });

        checkCpfCnpj(customerModel.getCpfCnpj());

        Customer customer = new Customer(customerModel);

        return repository.save(customer);
    }

    public List<Customer> findByName(String name) {
        return repository.findByNameContaining(name);
    }

    public List<Customer> getAll() {
        return repository.findAll();
    }

    public void deleteCustomer(UUID id) {
        Customer customer = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não localizado para remoção."));

        repository.deleteById(customer.getId());
    }

    private void checkCpfCnpj(String cpfCnpj) throws CpfCnpjInvalidException {
        if (cpfCnpj.length() < 11 || cpfCnpj.length() > 14) {
            throw new CpfCnpjInvalidException(cpfCnpj);
        }
    }

    public Customer editCustomer(UUID id, Customer customerToEdit) {
        Customer customerById = repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não localizado."));

        customerToEdit.setId(id);
        customerToEdit.setCreated(LocalDateTime.now());
        customerToEdit.setCustomerType(customerById.getCustomerType());
        customerToEdit.setPhone(customerById.getPhone());
        return repository.save(customerToEdit);
    }
}
