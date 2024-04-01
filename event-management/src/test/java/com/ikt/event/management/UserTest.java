package com.ikt.event.management;

import com.ikt.event.management.entity.Company;
import com.ikt.event.management.entity.Role;
import com.ikt.event.management.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



import java.util.ArrayList;
import java.util.List;

public class UserTest {

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User("Viktorija Serafimovska", "serafimovskaviktorija5@gmail.com", "123456789");
    }

    //Checks if the user object is initialized correctly and if the getters return the expected values.
    @Test
    public void testUserInitialization() {
        assertNotNull(user);
        assertEquals("Viktorija Serafimovska", user.getName());
        assertEquals("serafimovskaviktorija5@gmail.com", user.getEmail());
        assertEquals("123456789", user.getPhone_number());
    }



    // Tests the association with the Company class.
    @Test
    public void testCompanyAssociation() {
        Company company = new Company();
        user.setCompany(company);
        assertEquals(company, user.getCompany());
    }


// Tests the association with the Role class.
    @Test
    public void testRolesAssociation() {
        Role role1 = new Role();
        Role role2 = new Role();
        List<Role> roles = new ArrayList<>();
        roles.add(role1);
        roles.add(role2);

        user.setRolesUserHas(roles);

        assertEquals(2, user.getRolesUserHas().size());
        assertEquals(role1, user.getRolesUserHas().get(0));
        assertEquals(role2, user.getRolesUserHas().get(1));
    }


    //Ensure that the no-argument constructor (@NoArgsConstructor) initializes the object properly.

    @Test
    public void testNullConstructor() {
        User user = new User();
        assertNotNull(user);
        assertNull(user.getName());
        assertNull(user.getEmail());
        assertNull(user.getPhone_number());
    }




    //Verify that setter methods correctly set the values.
    @Test
    public void testSetterMethods() {
        user.setName("Viki");
        user.setEmail("viki@example.com");
        user.setPhone_number("987654321");

        assertEquals("Viki", user.getName());
        assertEquals("viki@example.com", user.getEmail());
        assertEquals("987654321", user.getPhone_number());
    }



    // Add more tests for other columns, associations, and validations as needed
}

