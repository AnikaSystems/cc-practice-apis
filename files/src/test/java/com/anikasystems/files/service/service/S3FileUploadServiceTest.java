package com.anikasystems.files.service.service;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.codecommit.model.File;

@SpringBootTest
class S3FileUploadServiceTest {

    // @Autowired
    // private StorageService fileUploadService;

    // @Test
    // void fileUploadTest() throws IOException {
    // long id = 1L;
    // File file = new File();
    // String key = file.getRelativePath();
    // MultipartFile mf = new MockMultipartFile("ANIKASYSTEM_TEST", new
    // FileInputStream(""));
    // fileUploadService.uploadFile(id, key, mf);
    // }

    // @Test
    // void fileUpdateTest() {
    // fileUploadService.updateFile();
    // }

    // @Test
    // void downloadTest() {
    // assert (true);
    // }

}