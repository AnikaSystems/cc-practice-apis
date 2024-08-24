package com.anikasystems.files.service.controller;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FileUploadControllerTest {

    @Test
    void testUploadFile() {
        FileUploadController fileController = new FileUploadController();
        ResponseEntity<String> response = fileController.uploadFile(1, "ANIKA_TEST");

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
