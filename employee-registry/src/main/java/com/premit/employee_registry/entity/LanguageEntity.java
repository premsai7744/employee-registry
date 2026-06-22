package com.premit.employee_registry.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="language")
public class LanguageEntity {

    @SequenceGenerator(name="lang_id_gen",
                       sequenceName = "language_seq",
                       allocationSize = 1)

    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator="lang_id_gen")
    @Id
    @Column(name="lang_id")
    private int langId;
    @Column(name="lang")
    private String language;
}
