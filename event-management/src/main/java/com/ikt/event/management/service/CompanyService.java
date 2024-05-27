package com.ikt.event.management.service;

import com.ikt.event.management.entity.Company;
import com.ikt.event.management.entity.Rating;

import java.util.List;

public interface CompanyService {

    List<Company> listAll();

    Company create(String name, String email);

    Company findById(Long id);

    Company updateRatings(Integer id, List<Rating> ratings);
}
