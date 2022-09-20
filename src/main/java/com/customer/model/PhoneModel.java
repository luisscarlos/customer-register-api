package com.customer.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PhoneModel {

    @JsonProperty("phone")
    private String phone;
}
