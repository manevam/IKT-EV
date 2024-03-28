package com.ikt.event.management.service.impl;

import com.ikt.event.management.entity.Company;
import com.ikt.event.management.entity.exceptions.InvalidCompanyIdException;
import com.ikt.event.management.repository.CompanyRepository;
import com.ikt.event.management.service.AttendanceService;
import com.ikt.event.management.service.CompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> listAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company create(String name, String email) {
        Company company = new Company(name, email);
        return companyRepository.save(company);
    }

    @Override
    public Company findById(Long id) {
        return companyRepository.findById(id).orElseThrow(InvalidCompanyIdException::new);
    }
}
