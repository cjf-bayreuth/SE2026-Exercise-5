package de.uni_bayreuth.se.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CoffeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnAllCoffees() throws Exception {
        mockMvc.perform(get("/api/coffee"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Campus Cafe"));
    }

    @Test
    void shouldReturnCoffeeByName() throws Exception {
        mockMvc.perform(get("/api/coffee/Campus Cafe"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.price").value(2.5));
    }

    @Test
    void shouldReturnAccessibleCoffees() throws Exception {
        mockMvc.perform(get("/api/coffee/accessible"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].wheelchairAccessible").value(true));
    }
}
