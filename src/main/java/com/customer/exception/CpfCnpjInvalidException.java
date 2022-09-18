package com.customer.exception;

public class CpfCnpjInvalidException extends RuntimeException {
    public CpfCnpjInvalidException(String cpfCnpj) {
        super("Não é possível salvar o cliente. CPF/CNPJ com quantidade de dígitos inválido: " + cpfCnpj);
    }
}
