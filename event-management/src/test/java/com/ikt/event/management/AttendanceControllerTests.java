package com.ikt.event.management;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ikt.event.management.repository.AttendanceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
public class AttendanceControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AttendanceRepository attendanceRepository;

    // Ensure to clear or initialize test data before each test
    // This can be done using @BeforeEach and @AfterEach methods as per requirement

    @Test
    public void testAttendanceControllerEndpoints() throws Exception {
        // Create test data or interact with repository as needed
        // For simplicity, assume we have some data or can insert it using the repository

        // Example: Create a new attendance entry
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/mgmt/attendance/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"someField\": \"someValue\" }"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        // Example: Retrieve attendance data
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/mgmt/attendance/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        // Example: Validate the response
        String responseContent = result.getResponse().getContentAsString();
        // Assuming the response is in JSON format, you can deserialize it for further assertions
        // Example using ObjectMapper:
        // YourEntityClass responseEntity = new ObjectMapper().readValue(responseContent, YourEntityClass.class);
        // assertEquals(expectedValue, responseEntity.getSomeField());
    }
}

