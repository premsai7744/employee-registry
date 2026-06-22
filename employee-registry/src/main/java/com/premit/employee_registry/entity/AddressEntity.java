package com.premit.employee_registry.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="emp_addr")
public class AddressEntity {

    @SequenceGenerator(name="addr_id_gen",
                       sequenceName = "emp_addr_seq",
                       allocationSize = 1)

    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "addr_id_gen")
    @Id
    @Column(name="addr_id")
    private int addressId;

    @Column(name="city")
    private String city;

    @Column(name="state")
    private String state;

    @Column(name="area")
    private String area;

    @Column(name="pin_code")
    private int pinCode;
}
