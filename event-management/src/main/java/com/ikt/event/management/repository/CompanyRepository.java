package com.ikt.event.management.repository;

import com.ikt.event.management.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface CompanyRepository extends JpaRepository<Company, Long> {


    Optional<Company> findByName(String name);

}
