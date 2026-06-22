package com.premit.employee_registry.entity;

import com.premit.employee_registry.dto.CompanyDTO;
import com.premit.employee_registry.dto.EducationDTO;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name="emp_registry")
public class EmployeeEntity {

    @SequenceGenerator(name="emp_id_gen",
                       sequenceName = "emp_addr_seq",
                       allocationSize = 1)

    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "emp_id_gen")
    @Id
    @Column(name="emp_id")
    private int empId;

    @Column(name="emp_name")
    private String ename;

    @Column(name="email_id")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="contact")
    private long contact;

    @JoinColumn(name="emp_id")
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<LanguageEntity> listOfLanguageEntities;

    @JoinColumn(name="addr_id")
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private AddressEntity address;

    @JoinColumn(name="emp_id")
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<EducationEntity> education;

    @JoinColumn(name="emp_id")
    @OneToMany(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<CompanyEntity> employement;
}
