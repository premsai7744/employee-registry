package com.premit.employee_registry.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="education")
@Data
public class EducationEntity {

    @SequenceGenerator(name="education_id_gen",
                       sequenceName = "education_seq",
                       allocationSize = 1)

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    @Column(name="education_id_gen")
    private int educationId;

    @Column(name="standard")
    private String standard;

    @Column(name="name_of_org")
    private String nameOfOrg;

    @Column(name="passed_year")
    private int passedYear;

    @Column(name="avg_percentage")
    private float avgPecentage;
}
