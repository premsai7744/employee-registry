package com.premit.employee_registry.dto;

import lombok.Data;

@Data
public class AddressDTO {
    private String city;
    private String state;
    private String area;
    private int pinCode;
}
