package com.premit.employee_registry.repository;

import com.premit.employee_registry.entity.AddressEntity;
import com.premit.employee_registry.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity,Integer> {
}
