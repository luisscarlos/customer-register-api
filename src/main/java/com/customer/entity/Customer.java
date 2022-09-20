package com.customer.entity;

import com.customer.model.CustomerModel;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column
    @CreationTimestamp
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private LocalDateTime created;

    @Column
    private String name;

    @Column
    private String customerType;

    @Column
    @Size(min = 11, max = 14, message = "CPF/CNPJ com quantidade de dígitos inválido.")
    private String cpfCnpj;

    @Column
    private String rgIe;

    @Column
    private Boolean active;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Phone> phone = new ArrayList<>();

    public Customer(CustomerModel customerModel) {
        this.name = customerModel.getName();
        this.customerType = customerModel.getCustomerType().getDescription();
        this.cpfCnpj = customerModel.getCpfCnpj();
        this.rgIe = customerModel.getRgIe();
        this.active = customerModel.getActive();
        this.phone = customerModel.getPhoneList();

        customerModel.getPhoneList().forEach(phone -> phone.setCustomer(this));
    }

}
