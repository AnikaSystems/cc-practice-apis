package com.anikasystems.files.service.service;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.anikasystems.files.service.repository.FilesRepository;
@Service
@Slf4j
public class StorageService {

	private static final Logger logger = LoggerFactory.getLogger(StorageService.class);
	
    @Autowired
    FilesRepository filesRepository;

    @Autowired
    AmazonS3 s3Client;

    @Value("${application.s3.bucket}")
    private String bucketName;

    public void uploadFile(long id, String key, MultipartFile file) throws IOException {         
    	logger.info("Received request to upload : "+id+" key="+key+" file:"+file.getName()+" bucketName="+bucketName);
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file.getInputStream(), null);      
        s3Client.putObject(putObjectRequest);
        saveToDb(id);
        logger.info("DONE save and upload : "+id+" key="+key+" file:"+file.getName()+" bucketName="+bucketName);
    }

    public String uploadFile(MultipartFile file) throws IOException {
        File fobj = convertMultiPartFileToFile(file);
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        s3Client.putObject(new PutObjectRequest(bucketName, fileName, fobj));
        fobj.delete();
        return "File uploaded: " + fileName;
        // saveToDb();
    }

    private File convertMultiPartFileToFile(MultipartFile mf) {
        File convertedFile = new File(mf.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(mf.getBytes());
        } catch (IOException ioe) {
             logger.debug("Error converting MultipartFile to File...", ioe);
        }
        return convertedFile;
    }

    public void saveToDb(Long id) {
        
        Optional<com.anikasystems.files.service.model.File> fileData = filesRepository.findById(id);
        if (fileData.isPresent()) {
            filesRepository.save(id);
        }else {        
        	logger.error(id+" not found");
        }
    }

    public void updateFile() {
        long id = 1L;
        String applicant = "X";
        String interpreter = "X";
        Optional<com.anikasystems.files.service.model.File> fileData = filesRepository.findById(id);
        if (fileData.isPresent()) {
            fileData.get().setApplicant(applicant);
            fileData.get().setInterpreter(interpreter);
            filesRepository.save(id);
        }
    }

    public void downloadFile(String url, String localPath) throws IOException {

        URL crunchifyRobotsURL = new URL(localPath);

        BufferedInputStream crunchifyInputStream = new BufferedInputStream(crunchifyRobotsURL.openStream());
        FileOutputStream crunchifyOutputStream = new FileOutputStream(localPath);

        byte[] crunchifySpace = new byte[2048];
        int crunchifyCounter = 0;

        while ((crunchifyCounter = crunchifyInputStream.read(crunchifySpace, 0, 1024)) != -1) {
            crunchifyOutputStream.write(crunchifySpace, 0, crunchifyCounter);
        }

        crunchifyOutputStream.close();
        crunchifyInputStream.close();

    }

    public byte[] downloadFile(String fileName) {
        com.amazonaws.services.s3.model.S3Object s3Object = s3Client.getObject(bucketName, fileName);
        S3ObjectInputStream inputStream = s3Object.getObjectContent();
        try {
            byte[] content = IOUtils.toByteArray(inputStream);
            return content;
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return null;
    }

    public String deleteFile(String fileName) {
        s3Client.deleteObject(bucketName, fileName);
        return fileName + " removed ...";
    }
}