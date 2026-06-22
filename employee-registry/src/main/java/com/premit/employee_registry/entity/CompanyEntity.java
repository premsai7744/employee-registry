package com.premit.employee_registry.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="company")
@Data
public class CompanyEntity {

    @SequenceGenerator(name="comp_id_gen",
                       sequenceName = "company_seq",
                       allocationSize = 1)

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "comp_id_gen")
    @Column(name="comp_id")
    private int companyId;

    @Column(name="comp_name")
    private String companyName;

    @Column(name="desg")
    private String designation;

    @Column(name="start_year")
    private int startYear;

    @Column(name="end_year")
    private int endYear;
}

