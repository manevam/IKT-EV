package com.ikt.event.management.repository;

import com.ikt.event.management.entity.Attendance;
import com.ikt.event.management.repository.views.AllTimeAttendanceView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface AttendanceRepository extends JpaRepository<Attendance, UUID> {
    @Query("SELECT NEW com.ikt.event.management.repository.views.AllTimeAttendanceView(c.name, COUNT(a.id)) " +
            "FROM Company c " +
            "JOIN Event e ON e.company.id = c.id " +
            "JOIN Attendance a ON e.id = e.id " +
            "GROUP BY c.name " +
            "ORDER BY COUNT(a.id) DESC")
    List<AllTimeAttendanceView> allTimeAttendancePerCompanyReport();
}
