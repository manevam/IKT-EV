package com.ikt.event.management.service.impl;

import com.ikt.event.management.entity.Company;
import com.ikt.event.management.entity.Event;
import com.ikt.event.management.entity.User;
import com.ikt.event.management.entity.exceptions.InvalidCompanyIdException;
import com.ikt.event.management.entity.exceptions.InvalidPersonIdException;
import com.ikt.event.management.repository.CompanyRepository;
import com.ikt.event.management.repository.EventRepository;
import com.ikt.event.management.repository.UserRepository;
import com.ikt.event.management.repository.views.NumberOfEventsPerCompanyDto;
import com.ikt.event.management.service.AttendanceService;
import com.ikt.event.management.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    public EventServiceImpl(EventRepository eventRepository, UserRepository userRepository, CompanyRepository companyRepository) {
        this.eventRepository = eventRepository;
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Event> listAll() {
        return eventRepository.findAll();
    }

    @Override
    public Event create(String name, String venue, LocalDate event_date, String eventType, Integer budget, Integer companyId, Integer coordinatorId) {
        Company company = companyRepository.findById(companyId.longValue()).orElseThrow(InvalidCompanyIdException::new);
        User coordinator = userRepository.findById(coordinatorId.longValue()).orElseThrow(InvalidPersonIdException::new);
        Event event = new Event(name, venue, event_date, eventType, budget, company, coordinator);
        return eventRepository.save(event);
    }

    @Override
    public List<NumberOfEventsPerCompanyDto> numEventsPerCompanyReport() {
        List<NumberOfEventsPerCompanyDto> result = eventRepository.getNumberOfEventsPerCompanyReport();
        List<NumberOfEventsPerCompanyDto> reports = new ArrayList<>();
        for (NumberOfEventsPerCompanyDto row : result) {
            String companyName = row.getCompanyName();
            Long numEvents = row.getNumberOfEvents();
            int eventMonth = row.getEventMonth();
            int eventYear =  row.getEventYear();
            NumberOfEventsPerCompanyDto n = new NumberOfEventsPerCompanyDto(companyName, numEvents, eventMonth, eventYear);
            reports.add(n);
        }
        return reports;
    }
}

