// This is a personal academic project. Dear PVS-Studio, please check it.
// PVS-Studio Static Code Analyzer for C, C++, C#, and Java: https://pvs-studio.com
package goldswan.calculator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import goldswan.calculator.dto.CalculationRequest;
import goldswan.calculator.service.CalculationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalculationController.class)
@Import(CalculationService.class)
public class CalculationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testAddEndpoint() throws Exception {
        CalculationRequest request = new CalculationRequest();
        request.setNumber1(2);
        request.setNumber2(3);

        mockMvc.perform(post("/api/calculate/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(5));
    }

    @Test
    public void testSubtractEndpoint() throws Exception {
        CalculationRequest request = new CalculationRequest();
        request.setNumber1(5);
        request.setNumber2(3);

        mockMvc.perform(post("/api/calculate/subtract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(2));
    }

    @Test
    public void testMultiplyEndpoint() throws Exception {
        CalculationRequest request = new CalculationRequest();
        request.setNumber1(2);
        request.setNumber2(3);

        mockMvc.perform(post("/api/calculate/multiply")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(6));
    }

    @Test
    public void testDivideEndpoint() throws Exception {
        CalculationRequest request = new CalculationRequest();
        request.setNumber1(6);
        request.setNumber2(3);

        mockMvc.perform(post("/api/calculate/divide")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result").value(2));
    }

    @Test
    public void testDivideByZero() throws Exception {
        CalculationRequest request = new CalculationRequest();
        request.setNumber1(6);
        request.setNumber2(0);

        mockMvc.perform(post("/api/calculate/divide")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isBadRequest());
    }
}
