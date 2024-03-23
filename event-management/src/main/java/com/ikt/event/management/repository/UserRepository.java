package com.ikt.event.management.repository;


import com.ikt.event.management.entity.User;
import com.ikt.event.management.repository.views.CoordinatorsOfEventsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT NEW com.ikt.event.management.repository.views.CoordinatorsOfEventsDto(u.id, u.name, c.id, e.id, e.name, c.name) " +
            "FROM User u " +
            "JOIN Company c ON u.company.id = c.id " +
            "JOIN Event e ON e.coordinator.id = u.id")
    List<CoordinatorsOfEventsDto> getUsersWithCompanyAndEventDetails();
}
