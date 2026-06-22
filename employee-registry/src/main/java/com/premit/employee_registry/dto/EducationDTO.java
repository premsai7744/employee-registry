package com.premit.employee_registry.dto;

import lombok.Data;

@Data
public class EducationDTO {
    private String standard;
    private String nameOfOrg;
    private int passedYear;
    private float avgPecentage;
}
