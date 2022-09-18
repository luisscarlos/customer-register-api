package com.customer.exception;

public class CustomerDuplicatedException extends RuntimeException{

    public CustomerDuplicatedException(String cpfCnpj) {
        super("Não é possível salvar o cliente. CPF/CNPJ duplicado: " + cpfCnpj);
    }
}
