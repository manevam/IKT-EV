package com.ikt.event.management.repository;

import com.ikt.event.management.entity.Attendance;
import com.ikt.event.management.repository.views.AllTimeAttendanceDto;
import com.ikt.event.management.repository.views.AverageAttendancePerCompanyDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    @Query("SELECT NEW com.ikt.event.management.repository.views.AllTimeAttendanceDto(c.name, COUNT(a.id)) " +
            "FROM Company c " +
            "JOIN Event e ON e.company.id = c.id " +
            "JOIN Attendance a ON e.id = e.id " +
            "GROUP BY c.name " +
            "ORDER BY COUNT(a.id) DESC")
    List<AllTimeAttendanceDto> allTimeAttendancePerCompanyReport();

    @Query("SELECT NEW com.ikt.event.management.repository.views.AverageAttendancePerCompanyDto(c.name, AVG(a.personAttended.id)) " +
            "FROM Company c " +
            "JOIN Event e ON e.company.id = e.id " +
            "JOIN Attendance a ON a.eventAttended.id = e.id " +
            "GROUP BY c.name")
    List<AverageAttendancePerCompanyDto> avgAttendancePerCompanyReport();
}