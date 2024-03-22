package com.ikt.event.management.repository;

import com.ikt.event.management.entity.Event;
import com.ikt.event.management.repository.views.EventAttendanceDto;
import com.ikt.event.management.repository.views.NumberOfEventsPerCompanyDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    @Query("SELECT NEW com.ikt.event.management.repository.views.EventAttendanceDto(a.id, u.name, u.id, e.name, e.id) " +
            "FROM Event e " +
            "JOIN User u ON u.id = e.coordinator.id " +
            "JOIN Attendance a ON a.eventAttended.id = e.id")
    List<EventAttendanceDto> findAttendancePerEvent();

    @Query("SELECT NEW com.ikt.event.management.repository.views.EventAttendanceDto(a.id, u.name, u.id, e.name, e.id) " +
            "FROM Event e " +
            "JOIN User u ON u.id = e.coordinator.id " +
            "JOIN Attendance a ON a.eventAttended.id = e.id " +
            "WHERE e.id = :eventId")
    List<EventAttendanceDto> findEventAttendanceViewByEventId(Long eventId);

    @Query("SELECT NEW com.ikt.event.management.repository.views.EventAttendanceDto(e.name, e.id, c.id, c.name) " +
            "FROM Event e " +
            "JOIN Company c ON c.id = e.company.id")
    List<EventAttendanceDto> findAllEventsPerCompany();

    @Query("SELECT NEW com.ikt.event.management.repository.views.EventAttendanceDto(e.name, e.id, c.id, c.name) " +
            "FROM Event e " +
            "JOIN Company c ON c.id = e.company.id " +
            "WHERE c.id = :companyId")
    List<EventAttendanceDto> findEventsViewedByCompanyByCompanyId(Long companyId);


    @Query("SELECT NEW com.ikt.event.management.repository.views.NumberOfEventsPerCompanyDto(c.name, COUNT(e.id), MONTH(e.date), YEAR(e.date)) " +
            "FROM Event e " +
            "JOIN e.company c " +
            "GROUP BY c.name, MONTH(e.date), YEAR(e.date) " +
            "ORDER BY MONTH(e.date) DESC")
    List<NumberOfEventsPerCompanyDto> getNumberOfEventsPerCompanyReport();
}