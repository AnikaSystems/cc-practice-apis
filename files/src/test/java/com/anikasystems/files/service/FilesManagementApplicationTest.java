package com.anikasystems.files.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.anikasystems.files.service.service.S3FileUploadService;

@SpringBootTest
class FilesManagementApplicationTest {

	@MockBean
    private S3FileUploadService s3FileUploadService;

	// @Autowired
	// private FileUploadController controller;
	
	@Test
	void contextLoads() {
		//assertThat(controller).isNotNull();
	}

}