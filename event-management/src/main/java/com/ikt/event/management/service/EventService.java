package com.ikt.event.management.service;

import com.ikt.event.management.entity.Event;
import com.ikt.event.management.repository.views.CoordinatorsOfEventsDto;
import com.ikt.event.management.repository.views.EventAttendanceDto;
import com.ikt.event.management.repository.views.NumberOfEventsPerCompanyDto;

import java.time.LocalDate;
import java.util.List;

public interface EventService {
    List<Event> listAll();

    Event create(String name, String venue, LocalDate event_date, String eventType, Integer budget, Integer companyId, Integer coordinatorId);

    List<NumberOfEventsPerCompanyDto> numEventsPerCompanyReport();

    List<EventAttendanceDto> findEventAttendanceByEventId(Long eventId);

    List<CoordinatorsOfEventsDto> findAllCoordinators();

}
