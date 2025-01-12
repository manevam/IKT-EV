package com.ikt.event.management.controller;


import com.ikt.event.management.entity.Company;
import com.ikt.event.management.entity.Rating;
import com.ikt.event.management.entity.exceptions.InvalidCompanyIdException;
import com.ikt.event.management.repository.views.AllTimeAttendanceDto;
import com.ikt.event.management.repository.views.AverageAttendancePerCompanyDto;
import com.ikt.event.management.repository.views.CreateCompanyDto;
import com.ikt.event.management.service.AttendanceService;
import com.ikt.event.management.service.CompanyService;
import com.ikt.event.management.service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/mgmt/companies")
public class CompanyController {
    private final CompanyService companyService;
    private final AttendanceService attendanceService;

    private final RatingService ratingService;

    public CompanyController(CompanyService companyService, AttendanceService attendanceService, RatingService ratingService) {
        this.companyService = companyService;
        this.attendanceService = attendanceService;
        this.ratingService = ratingService;
    }

    // Create a new company
    @PostMapping("/create")
    public ResponseEntity<Company> createCompany(@RequestBody CreateCompanyDto createCompanyRequest) {
        try {
            Company company = companyService.create(createCompanyRequest.getName(), createCompanyRequest.getEmail());
            return ResponseEntity.ok(company);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Get all companies
//    @GetMapping("/all")
//    public ResponseEntity<List<Company>> getAllCompanies() {
//        try {
//            List<Company> companies = companyService.listAll();
//            return ResponseEntity.ok(companies);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }

    // Get company by ID
    @GetMapping("/{companyId}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long companyId) {
        try {
            Company company = companyService.findById(companyId);
            return ResponseEntity.ok(company);
        } catch (InvalidCompanyIdException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/attendance/all-time")
    public ResponseEntity<List<AllTimeAttendanceDto>> getAllTimeAttendancePerCompany() {
        try {
            List<AllTimeAttendanceDto> attendanceList = attendanceService.listAllTimeAttendancePerCompany();
            return ResponseEntity.ok(attendanceList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/attendance/average")
    public ResponseEntity<List<AverageAttendancePerCompanyDto>> getAverageAttendancePerCompany() {
        try {
            List<AverageAttendancePerCompanyDto> attendanceList = attendanceService.avgAttendancePerCompany();
            return ResponseEntity.ok(attendanceList);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PostMapping("/{id}/rate")
    public ResponseEntity<Company> rateCompany(@PathVariable Integer id,
                              @RequestBody Integer rating) {
        Company company = this.companyService.findById(Long.valueOf(id));
        Rating rating1 = this.ratingService.addRating(rating);
        List<Rating> companyRatings = company.getRatings();
        companyRatings.add(rating1);
        this.companyService.updateRatings(id, companyRatings);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}
