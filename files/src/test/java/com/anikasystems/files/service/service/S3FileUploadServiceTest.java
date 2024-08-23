package com.anikasystems.files.service.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
class S3FileUploadServiceTest {
    @MockBean
    private S3FileUploadService fileUploadService;

	@Test
	void fileUploadTest() {
        //TODO - finish test
        //fileUploadService.uploadFile(id, key, file);
        assert(true);
	}

    @Test
    void fileUpdateTest(){
        //TODO - finish test
        //fileUploadService.updateFile(id, applicant, interpreter);
        assert(true);
    }
    
    @Test
    void downloadTest() {
        //TODO - finish test
        //fileUploadService.downloadFile(url, localPath);
        assert(true);
    }

}