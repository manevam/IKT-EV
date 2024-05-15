package com.ikt.event.management.controller;

import com.ikt.event.management.entity.Company;
import com.ikt.event.management.entity.Event;
import com.ikt.event.management.service.CompanyService;
import com.ikt.event.management.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/v1/public")
@RequiredArgsConstructor
public class PublicEventManagementEndpoints {
    private final CompanyService companyService;
    private final EventService eventService;
    @GetMapping("/companies")
    public ResponseEntity<List<Company>> getAllCompanies() {
        try {
            List<Company> companies = companyService.listAll();
            return ResponseEntity.ok(companies);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/events")
    public ResponseEntity<List<Event>> getAllEvents(){
        try {
            List<Event> events = eventService.listAll();
            return ResponseEntity.ok(events);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
