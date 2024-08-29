
package com.anikasystems.files.service.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;

class FileUploadControllerTest {

    @Autowired
    private FileUploadController fileUploadController;

    // @Test
    // void contextLoads() {
    // }

    // @Test
    // void testUploadFile() throws IOException {
    // long id = 1L;
    // MultipartFile mf = new MockMultipartFile("ANIKASYSTEM_TEST", new
    // FileInputStream(""));
    // fileUploadController.uploadFile(id, mf);
    // }

    @Test
    void testHealth() {
        FileUploadController controller = new FileUploadController();
        Health health = controller.health();
        assertEquals(health.getStatus().toString(), "UP");
    }

}
