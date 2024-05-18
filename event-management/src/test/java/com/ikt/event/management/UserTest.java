package com.ikt.event.management;

import com.ikt.event.management.entity.Company;
import com.ikt.event.management.entity.Role;
import com.ikt.event.management.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;
    private Company company;

    @BeforeEach
    void setUp() {
        company = new Company();
        user = new User();
    }

    @Test
    void testDefaultConstructor() {
        User user = new User();
        assertNull(user.getName());
        assertNull(user.getEmail());
        assertNull(user.getPhone_number());
        assertNull(user.getCompany());
        assertNull(user.getRole());
        assertNull(user.getUsername());
        assertNull(user.getPassword());
    }

    @Test
    void testParameterizedConstructor() {
        User user = new User("Viktorija Serafimovska", "serafimovskaviktorija5@gmail.com", "1234567890", Role.USER);
        assertEquals("Viktorija Serafimovska", user.getName());
        assertEquals("serafimovskaviktorija5@gmail.com", user.getEmail());
        assertEquals("1234567890", user.getPhone_number());
        assertEquals(Role.USER, user.getRole());
        assertNull(user.getCompany());
        assertNull(user.getUsername());
        assertNull(user.getPassword()); 
    }

    @Test
    void testSettersAndGetters() {
        user.setName("Viki S");
        assertEquals("Viki S", user.getName());

        user.setEmail("viki.s@example.com");
        assertEquals("viki.s@example.com", user.getEmail());

        user.setPhone_number("0987654321");
        assertEquals("0987654321", user.getPhone_number());

        user.setCompany(company);
        assertEquals(company, user.getCompany());

        user.setRole(Role.ADMIN);
        assertEquals(Role.ADMIN, user.getRole());

        user.setUsername("viki");
        assertEquals("viki", user.getUsername());

        user.setPassword("password123");
        assertEquals("password123", user.getPassword());
    }


    
}

