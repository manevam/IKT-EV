package com.ikt.event.management;

import com.ikt.event.management.entity.Attendance;
import com.ikt.event.management.entity.Event;
import com.ikt.event.management.entity.Role;
import com.ikt.event.management.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class AttendanceTest {

    private Attendance attendance;
    private User user;
    private Event event;

    @BeforeEach
    void setUp() {
        user = new User(); // Assuming a default constructor exists
        event = new Event(); // Assuming a default constructor exists
        attendance = new Attendance();
    }

    @Test
    void testDefaultConstructor() {
        Attendance attendance = new Attendance();
        assertNull(attendance.getRole());
        assertNull(attendance.getPersonAttended());
        assertNull(attendance.getEventAttended());
    }


    @Test
    void testParameterizedConstructor() {
        Attendance attendance = new Attendance(Role.ADMIN, user, event);
        assertEquals(Role.ADMIN, attendance.getRole());
        assertEquals(user, attendance.getPersonAttended());
        assertEquals(event, attendance.getEventAttended());
    }

    @Test
    void testSettersAndGetters() {
        attendance.setRole(Role.USER);
        assertEquals(Role.USER, attendance.getRole());

        attendance.setPersonAttended(user);
        assertEquals(user, attendance.getPersonAttended());

        attendance.setEventAttended(event);
        assertEquals(event, attendance.getEventAttended());
    }






}
