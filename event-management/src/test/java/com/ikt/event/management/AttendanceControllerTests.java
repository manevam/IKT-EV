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

    @Test
    public void testAttendanceControllerEndpoints() throws Exception {
        
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/mgmt/attendance/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"someField\": \"someValue\" }"))
                .andExpect(MockMvcResultMatchers.status().isOk());

        
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/mgmt/attendance/all"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

     
        String responseContent = result.getResponse().getContentAsString();
       
    }
}
