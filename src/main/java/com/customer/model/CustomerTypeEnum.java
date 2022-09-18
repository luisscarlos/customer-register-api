package com.customer.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CustomerTypeEnum {
    
    PF ("Pessoa Física"),
    PJ ("Pessoa Jurídica");

    private final String description;

    CustomerTypeEnum(String customerType) { this.description = customerType; }

    public String getDescription() { return this.description.toUpperCase(); }
}
