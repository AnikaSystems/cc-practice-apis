package com.anikasystems.files.service.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.anikasystems.files.service.repository.FilesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

@Service
public class S3FileUploadService {

    @Autowired
    private AmazonS3 amazonS3;
    @Autowired
    FilesRepository filesRepository;

    @Value("${aws.s3.bucketName}")
    private String bucketName;
 
    public void uploadFile(long id, String key, MultipartFile file) throws IOException {
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file.getInputStream(), null);
        amazonS3.putObject(putObjectRequest);
        saveToDb(id);
    }

    public void saveToDb(long id) {
        Optional<com.anikasystems.files.service.model.File> fileData = filesRepository.findById(id);
        if (fileData.isPresent()) {
            filesRepository.save(id);
        }
    }

    public void updateFile(long id, String applicant, String interpreter) {
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
}