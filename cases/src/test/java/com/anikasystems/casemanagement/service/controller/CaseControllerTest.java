package com.anikasystems.casemanagement.service.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CaseControllerTest {

    @Test
    void testUppercaseString() {
        CaseController caseController = new CaseController();
        String input = "hello world";
        ResponseEntity<String> response = caseController.uppercaseString(input);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("HELLO WORLD", response.getBody());
    }

    @Test
    void testUppercaseStringWithEmptyInput() {
        CaseController caseController = new CaseController();
        String input = "";
        ResponseEntity<String> response = caseController.uppercaseString(input);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals("", response.getBody());
    }
}
