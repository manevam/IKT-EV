package com.ikt.event.management;

import com.ikt.event.management.entity.Company;
import com.ikt.event.management.entity.User;
import com.ikt.event.management.entity.Event;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;



public class EventTest {

    private Event event;
    private Company company;
    private User coordinator;

    @BeforeEach
    void setUp() {
        company = new Company();
        coordinator = new User(); 
        event = new Event();
    }

    @Test
    void testDefaultConstructor() {
        Event event = new Event();
        assertNull(event.getName());
        assertNull(event.getVenue());
        assertNull(event.getDate());
        assertNull(event.getEventType());
        assertNull(event.getBudget());
        assertNull(event.getCompany());
        assertNull(event.getCoordinator());
    }

    @Test
    void testParameterizedConstructor() {
        LocalDate eventDate = LocalDate.of(2024, 5, 15);
        Event event = new Event("Annual Meeting", "Conference Hall", eventDate, "Corporate", 5000, company, coordinator);
        assertEquals("Annual Meeting", event.getName());
        assertEquals("Conference Hall", event.getVenue());
        assertEquals(eventDate, event.getDate());
        assertEquals("Corporate", event.getEventType());
        assertEquals(5000, event.getBudget());
        assertEquals(company, event.getCompany());
        assertEquals(coordinator, event.getCoordinator());
    }

    @Test
    void testSettersAndGetters() {
        LocalDate eventDate = LocalDate.of(2024, 6, 18);
        event.setName("Tech Conference");
        assertEquals("Tech Conference", event.getName());

        event.setVenue("Tech Park");
        assertEquals("Tech Park", event.getVenue());

        event.setDate(eventDate);
        assertEquals(eventDate, event.getDate());

        event.setEventType("Technology");
        assertEquals("Technology", event.getEventType());

        event.setBudget(10000);
        assertEquals(10000, event.getBudget());

        event.setCompany(company);
        assertEquals(company, event.getCompany());

        event.setCoordinator(coordinator);
        assertEquals(coordinator, event.getCoordinator());
    }




}
