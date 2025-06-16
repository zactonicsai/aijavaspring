package ai.zactonics.springdemo.actuator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class AppInfoEndpointTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Verify appinfo actuator endpoint returns application details from properties")
    void testAppInfoEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/actuator/appinfo"))
               .andExpect(MockMvcResultMatchers.status().isOk())
               .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("Spring Demo Application"))
               .andExpect(MockMvcResultMatchers.jsonPath("$.version").value("1.0.0"))
               .andExpect(MockMvcResultMatchers.jsonPath("$.description").value("A simple Spring Boot application with Actuator"));
    }
}