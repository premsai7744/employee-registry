package com.premit.employee_registry.dto;
import lombok.Data;

@Data
public class CompanyDTO {
    private String companyName;
    private String designation;
    private int startYear;
    private int endYear;
}
