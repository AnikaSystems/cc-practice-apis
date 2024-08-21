package com.anikasystems.users.service.controller;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

@SpringBootTest
public class InterpreterControllerTest {

    @Autowired
	private InterpreterController controller;

    private String testEmail = "test@fake.com";
    private String testName = "Test Name";
    private String bearer = "";

    @Test
    void testInterpreterRequest(){
        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("interpreterEmail", testEmail);
        paramMap.add("interpreterName", testName);
        paramMap.add("alienRegistrationNumber", "B789672AC");
        paramMap.add("languages", "Bengali, Hindi");

        ResponseEntity<Map<String, String>> response = controller.requestInterpreter(bearer, paramMap);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("1", response.getBody().get("id"));
    }

    @Test
    void testInterpreterSubmitInfo(){
        MultiValueMap<String, String> paramMap = new LinkedMultiValueMap<>();
        paramMap.add("interpreterEmail", testEmail);
        paramMap.add("interpreterName", testName);
        paramMap.add("interpreterAddress", "101 First St.");
        paramMap.add("interpreterPhoneNumber", "111-222-3333");
        paramMap.add("interpreterLanguages", "Bengali, Hindi");

        ResponseEntity<Map<String, String>> response = controller.submitInterpreterInfo(bearer, paramMap);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("1", response.getBody().get("id"));
    }
}