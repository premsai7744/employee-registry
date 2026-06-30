package com.premit.employee_registry.service;

import com.premit.employee_registry.dto.ChangePasswordDTO;
import com.premit.employee_registry.dto.EmployeeDTO;
import com.premit.employee_registry.entity.*;
import com.premit.employee_registry.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplClass implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public String employeeRegistration(EmployeeDTO employeeDTO) {
        System.out.println("EmployeeServiceImplClass.employeeRegistration::employeeDTO:"+employeeDTO);
        EmployeeEntity employeeEntity = new EmployeeEntity();

        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setArea(employeeDTO.getAddress().getArea());
        addressEntity.setCity(employeeDTO.getAddress().getCity());
        addressEntity.setState(employeeDTO.getAddress().getState());
        addressEntity.setPinCode(employeeDTO.getAddress().getPinCode());

        List<EducationEntity> educationEntityList = new ArrayList<>();

        employeeDTO.getEducation().forEach(dto->{
            EducationEntity educationEntity = new EducationEntity();
            educationEntity.setAvgPecentage(dto.getAvgPecentage());
            educationEntity.setStandard(dto.getStandard());
            educationEntity.setPassedYear(dto.getPassedYear());
            educationEntity.setNameOfOrg(dto.getNameOfOrg());
            educationEntityList.add(educationEntity);
        });

        List<CompanyEntity> companyEntityList = new ArrayList<>();
        employeeDTO.getEmployement().forEach(dto->{
            CompanyEntity companyEntity = new CompanyEntity();
            companyEntity.setCompanyName(dto.getCompanyName());
            companyEntity.setDesignation(dto.getDesignation());
            companyEntity.setEndYear(dto.getEndYear());
            companyEntity.setStartYear(dto.getStartYear());
            companyEntityList.add(companyEntity);
        });

        employeeEntity.setAddress(addressEntity);
        employeeEntity.setEducation(educationEntityList);
        employeeEntity.setEmail(employeeDTO.getEmail());
        employeeEntity.setContact(employeeDTO.getContact());
        employeeEntity.setEname(employeeDTO.getEname());

        List<LanguageEntity> languageEntities = new ArrayList<>();

        employeeDTO.getLanguages().forEach(lang->{
            LanguageEntity languageEntity = new LanguageEntity();
            languageEntity.setLanguage(lang);
            languageEntities.add(languageEntity);
        });

        employeeEntity.setListOfLanguageEntities(languageEntities);
        employeeEntity.setPassword(employeeDTO.getPassword());
        employeeEntity.setEmployement(companyEntityList);

        System.out.println("EmployeeServiceImplClass.employeeRegistration::Data transferred from dto to entity :: employeeEntity : "+employeeEntity);

        if(employeeRepository.findByEmail(employeeEntity.getEmail()).isPresent()){
            return "Registration failed!, Because "+employeeEntity.getEname()+" employee already registered.";
        } else {
           EmployeeEntity savedEntity = employeeRepository.save(employeeEntity);
            if(savedEntity!=null){
                return "Employee registered successfully, Please login with your credentials.";
            } else {
                return "Employee registration failed.";
            }
        }
    }

    @Override
    public int changePassword(ChangePasswordDTO changePasswordDTO, String email) {
       String oldPassword = changePasswordDTO.getOldPassword();
       String newPassword = changePasswordDTO.getNewPassword();
       String retypedPassword = changePasswordDTO.getRetypedPassword();
       Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findByEmail(email);
       if(optionalEmployeeEntity.isPresent()){
          EmployeeEntity employeeEntity = optionalEmployeeEntity.get();
          String retrievedOldPassword = employeeEntity.getPassword();
          if(oldPassword.equals(retrievedOldPassword)) {
              if(newPassword.equals(retypedPassword)){
                  employeeEntity.setPassword(newPassword);
                  EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
                  if(savedEmployee!=null){
                      return 1;
                  } else {
                      return 0;
                  }
              } else {
                  return 4;
              }
          } else {
              return 3;
          }
       } else {
           return 2;
       }
    }
}
