package com.anikasystems.casemanagement.service.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(CaseController.class)
public class CaseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testUppercaseString() throws Exception {
        String input = "test";
        String expectedOutput = "TEST";

        mockMvc.perform(get("/api/cases/uppercase/" + input))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedOutput));
    }

    @Test
    public void testUppercaseStringWithNumbers() throws Exception {
        String input = "test123";
        String expectedOutput = "TEST123";

        mockMvc.perform(get("/api/cases/uppercase/" + input))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedOutput));
    }

    @Test
    public void testUppercaseStringWithSpecialCharacters() throws Exception {
        String input = "test@123";
        String expectedOutput = "TEST@123";

        mockMvc.perform(get("/api/cases/uppercase/" + input))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedOutput));
    }

    @Test
    public void testUppercaseStringWithEmptyString() throws Exception {
        String input = "";
        String expectedOutput = "";

        mockMvc.perform(get("/api/cases/uppercase/" + input))
                .andExpect(status().isOk())
                .andExpect(content().string(expectedOutput));
    }
}