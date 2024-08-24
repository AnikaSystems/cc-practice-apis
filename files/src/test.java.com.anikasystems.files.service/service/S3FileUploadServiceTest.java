package test.java.com.anikasystems.files.service.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.anikasystems.files.service.service.S3FileUploadService;

@SpringBootTest
class S3FileUploadServiceTest {
    @Autowired
    private S3FileUploadService fileUploadService;

    @Test
    void fileUploadTest() {
        // TODO - finish test
        long id = 1L;
        String key = "ANIKA_TEST.xlsx";
        MultipartFile multipartFile = new MockMultipartFile("ANIKA_TEST.xlsx",
                new FileInputStream(new File("/home/admin/test.xlsx")));
        fileUploadService.uploadFile(id, key, multipartFile);
        // assert (true);
    }

    @Test
    void fileUpdateTest() {
        // TODO - finish test
        long id = 1L;
        String applicant, interpreter = "X";
        fileUploadService.updateFile(id, applicant, interpreter);
        assert (true);
    }

    @Test
    void downloadTest() {
        // TODO - finish test
        // fileUploadService.downloadFile(url, localPath);
        assert (true);
    }

}