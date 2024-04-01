package com.ikt.event.management;

import com.ikt.event.management.entity.Company;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CompanyTest {

    private Company company;

    @BeforeEach
    public void setUp() {
        company = new Company();
    }

    //Ensures that the no-argument constructor initializes the Company object properly.

    @Test
    public void testNoArgsConstructor() {
        assertNotNull(company);
    }

    // Checks if the all-argument constructor initializes the Company object properly with provided values.

    @Test
    public void testAllArgsConstructor() {
        Company company = new Company("Example Company", "example@example.com");
        assertEquals("Example Company", company.getName());
        assertEquals("example@example.com", company.getEmail());
    }


   //Verifies that the getters and setters work as expected
    @Test
    public void testGettersAndSetters() {
        company.setName("New Company");
        company.setEmail("new@example.com");

        assertEquals("New Company", company.getName());
        assertEquals("new@example.com", company.getEmail());
    }


}
