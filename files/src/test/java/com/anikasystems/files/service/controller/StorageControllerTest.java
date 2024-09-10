package com.anikasystems.files.service.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;

@SpringBootTest
class StorageControllerTest {

	@Autowired
	private StorageController storageController;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	String filename= "filename.txt";
	
	@Test
	void testUploadFile() throws IOException {

		assertThat(storageController).isNotNull();
		File file = File.createTempFile("unittest", ".txt");
		FileUtils.write(file, "Test Data", Charset.defaultCharset());
		file.deleteOnExit();

		MockMultipartFile mmpf = new MockMultipartFile("data", filename, "text/plain", "some xml".getBytes());

		String webresult = this.storageController.uploadFile(99L, mmpf);
		System.out.println("Result = " + webresult);
		assertEquals("File uploaded successfully!", webresult);
	}

	@Test
	void testDownloadFile() throws IOException {

		assertThat(storageController).isNotNull();
		String msg= "some xml";
		MockMultipartFile mmpf = new MockMultipartFile("data", filename, "text/plain", msg.getBytes());
		String strresult = this.storageController.uploadFile(99L, mmpf);
		assertEquals("File uploaded successfully!", strresult);
		 ResponseEntity<ByteArrayResource> webresult = this.storageController.downloadFile(filename);
		 String bytesresult=webresult.getBody().getContentAsString(Charset.defaultCharset());
		 assertEquals(msg, bytesresult);
		System.out.println("bytesresult = " + bytesresult+" strresult="+strresult);
		
	}

	@Test
	void testDeleteFile() {
		assertThat(storageController).isNotNull();
		String msg= "some xml";
		String delmsg= filename + " removed ...";
		MockMultipartFile mmpf = new MockMultipartFile("data", filename, "text/plain", msg.getBytes());
		String strresult = this.storageController.uploadFile(99L, mmpf);
		assertEquals("File uploaded successfully!", strresult);
		 String delresult = this.storageController.deleteFile(filename);
		 
		 assertEquals(delmsg, delresult);
		System.out.println("delresult = " + delresult+" strresult="+strresult);
	}

}
