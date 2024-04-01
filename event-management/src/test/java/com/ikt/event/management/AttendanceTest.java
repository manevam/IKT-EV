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

    @BeforeEach
    public void setUp() {
        attendance = new Attendance();
    }

    //Checks if the getters and setters work as expected
    @Test
    public void testGettersAndSetters() {
        Role role = new Role();
        User user = new User();
        Event event = new Event();

        attendance.setAttendedAsRole(role);
        attendance.setPersonAttended(user);
        attendance.setEventAttended(event);

        assertEquals(role, attendance.getAttendedAsRole());
        assertEquals(user, attendance.getPersonAttended());
        assertEquals(event, attendance.getEventAttended());
    }

   // Ensures that the no-argument constructor initializes the object properly.
    @Test
    public void testNoArgsConstructor() {
        assertNotNull(attendance);
    }


    //Checks if the all-argument constructor initializes the object properly with provided values.
    @Test
    public void testAllArgsConstructor() {
        Role role = new Role();
        User user = new User();
        Event event = new Event();

        Attendance attendance = new Attendance(role, user, event);

        assertEquals(role, attendance.getAttendedAsRole());
        assertEquals(user, attendance.getPersonAttended());
        assertEquals(event, attendance.getEventAttended());
    }
}
