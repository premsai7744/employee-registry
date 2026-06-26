package com.premit.employee_registry.service;

import com.premit.employee_registry.dto.ChangePasswordDTO;
import com.premit.employee_registry.dto.EmployeeDTO;

public interface EmployeeService{
    public abstract String employeeRegistration(EmployeeDTO employeeDTO);
    public abstract int changePassword(ChangePasswordDTO changePasswordDTO, String email);
}
