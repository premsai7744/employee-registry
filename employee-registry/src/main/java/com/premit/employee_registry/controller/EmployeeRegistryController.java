package com.premit.employee_registry.controller;

import com.premit.employee_registry.dto.ChangePasswordDTO;
import com.premit.employee_registry.dto.EmployeeDTO;
import com.premit.employee_registry.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeRegistryController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(path="/register",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> registerEmployee(@RequestBody EmployeeDTO employeeDTO) {
        System.out.println("EmployeeRegistryController.registerEmployee::RequestReceived:employeeDTO:"+employeeDTO);
        String result = employeeService.employeeRegistration(employeeDTO);
        if(result.equals("Employee registered successfully, Please login with your credentials.")){
            return new ResponseEntity<>(result, HttpStatusCode.valueOf(201));
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
    }

    @PostMapping(path="/change/password/{emailId}")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordDTO changePasswordDTO,
                              @PathVariable(name="emailId") String email) {

        int changedPassword = employeeService.changePassword(changePasswordDTO,email);
        if(changedPassword==0) {
            return new ResponseEntity<String>("Password failed to update!",HttpStatus.INTERNAL_SERVER_ERROR);
        } else if (changedPassword==2) {
            return new ResponseEntity<String>("Employee not found with email id : "+email,HttpStatus.NOT_FOUND);
        } else if (changedPassword==3) {
            return new ResponseEntity<String>("Old password not entered correctly.",HttpStatus.BAD_REQUEST);
        } else if(changedPassword==4) {
            return new ResponseEntity<String>("New password and re-typed password both are not matched!",HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<String>("Password updated successfully.",HttpStatus.OK);
        }
    }
}
