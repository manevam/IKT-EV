package com.ikt.event.management;

import com.ikt.event.management.entity.Role;
import com.ikt.event.management.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RoleTest {

    private Role role;

    @BeforeEach
    public void setUp() {
        role = new Role();
    }

    @Test
    public void testNoArgsConstructor() {
        assertNotNull(role);
    }

    @Test
    public void testAllArgsConstructor() {
        Role role = new Role("Coordinates the event","Coordinator");
        assertEquals("Coordinates the event", role.getDescription());
        assertEquals("Coordinator", role.getRoleType());
    }


}

