package com.ikt.event.management.controller;

import com.ikt.event.management.entity.Company;
import com.ikt.event.management.entity.Event;
import com.ikt.event.management.repository.views.CoordinatorsOfEventsDto;
import com.ikt.event.management.repository.views.EventAttendanceDto;
import com.ikt.event.management.repository.views.NumberOfEventsPerCompanyDto;
import com.ikt.event.management.service.EventService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/v1/event")
public class EventController {
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Event>> getAllEvents(){
        try {
            List<Event> events = eventService.listAll();
            return ResponseEntity.ok(events);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Event> create(@RequestBody Event event){
        Event newEvent = this.eventService.create(event.getName(), event.getVenue(), event.getDate(), event.getEventType(), event.getBudget(), event.getCompany().getName(), event.getCoordinator().getId().intValue());
        return ResponseEntity.ok(newEvent);
    }

    @GetMapping("/company")
    public ResponseEntity<List<NumberOfEventsPerCompanyDto>> getEventsPerCompany() {
        List<NumberOfEventsPerCompanyDto> report = eventService.numEventsPerCompanyReport();
        return ResponseEntity.ok(report);
    }

    @GetMapping("/coordinators")
    public ResponseEntity<List<CoordinatorsOfEventsDto>> getAllCoordinators(){
        return ResponseEntity.ok(eventService.findAllCoordinators());
    }

    @GetMapping("/attendance/{id}")
    public ResponseEntity<List<EventAttendanceDto>> getAttendanceForEvent(@PathVariable Integer id) {
        return ResponseEntity.ok(eventService.findEventAttendanceByEventId(id.longValue()));
    }

}
