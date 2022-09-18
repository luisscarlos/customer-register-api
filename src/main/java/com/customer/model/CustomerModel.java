package com.customer.model;

import com.customer.entity.Phone;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Validated
@NoArgsConstructor
public class CustomerModel {

    @JsonProperty("name")
    @NotNull(message = "Campo obrigatório: name")
    @NotEmpty(message = "Campo obrigatório: name")
    private String name;

    @JsonProperty("customerType")
    @NotNull(message = "Campo obrigatório: customerType")
    private CustomerTypeEnum customerType;

    @JsonProperty("cpfCnpj")
    @NotNull(message = "Campo obrigatório: cpfCnpj")
    @NotEmpty(message = "Campo obrigatório: cpfCnpj")
    private String cpfCnpj;

    @JsonProperty("rg")
    private String rg;

    @JsonProperty("ie")
    private String ie;

    @JsonProperty("active")
    private Boolean active;

    @JsonProperty("phoneList")
    private List<Phone> phoneList;
}
