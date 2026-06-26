package com.premit.employee_registry.controller;

import com.premit.employee_registry.dto.ChangePasswordDTO;
import com.premit.employee_registry.dto.EmployeeDTO;
import com.premit.employee_registry.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeRegistryController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(path="/register",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public String registerEmployee(@RequestBody EmployeeDTO employeeDTO) {
        System.out.println("EmployeeRegistryController.registerEmployee::RequestReceived:employeeDTO:"+employeeDTO);
        String result = employeeService.employeeRegistration(employeeDTO);
        return result;
    }

    @PostMapping(path="/change/password/{emailId}")
    public String changePassword(@RequestBody ChangePasswordDTO changePasswordDTO,
                              @PathVariable(name="emailId") String email) {

        int changedPassword = employeeService.changePassword(changePasswordDTO,email);
        if(changedPassword==0) {
            return "Password failed to update!";
        } else if (changedPassword==2) {
            return "Employee not found with email id : "+email;
        } else if (changedPassword==3) {
            return "Old password not entered correctly.";
        } else if(changedPassword==4) {
            return "New password and re-typed password both are not matched!";
        }
        else {
            return "Password updated successfully.";
        }
    }
}
