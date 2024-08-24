package com.anikasystems.file.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.http.HttpResponse;

import com.anikasystems.files.service.controller.FileUploadController;
import com.anikasystems.files.service.service.S3FileUploadService;

@SpringBootTest
class FilesManagementApplicationTest {

    @Autowired
    private FileUploadController controller;

    @MockBean
    private S3FileUploadService s3FileUploadService;

    @Test
    void contextLoads() {
        // assertThat(controller).isNotNull();
    }

    @Test
    void testHealth() {
        Health health = controller.health();
        assertEquals(health.getStatus().toString(), "UP");
    }
}
