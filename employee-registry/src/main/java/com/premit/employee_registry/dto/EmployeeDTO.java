package com.premit.employee_registry.dto;

import lombok.Data;

import java.util.List;

@Data
public class EmployeeDTO {
    private String ename;
    private String email;
    private String password;
    private long contact;
    private AddressDTO address;
    private List<EducationDTO> education;
    private List<CompanyDTO> employement;
    private List<String> languages;
}

