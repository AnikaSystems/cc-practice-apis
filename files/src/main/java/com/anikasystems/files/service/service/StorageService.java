package com.anikasystems.files.service.service;

import com.anikasystems.files.service.config.AmazonS3Config;
import com.amazonaws.services.lookoutequipment.model.S3Object;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.util.IOUtils;
import com.anikasystems.files.service.repository.FilesRepository;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;

@Service
@Slf4j
public class StorageService {

    @Autowired
    FilesRepository filesRepository;

    @Autowired
    AmazonS3 s3Client;

    @Value("${application.bucket.name}")
    private String bucketName;

    public void uploadFile(long id, String key, MultipartFile file) throws IOException {
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file.getInputStream(), null);
        AmazonS3 amazonS3 = AmazonS3Config.S3Client();
        amazonS3.putObject(putObjectRequest);
        saveToDb();
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
            // Log.debug("Error converting MultipartFile to File...", ioe);
        }
        return convertedFile;
    }

    public void saveToDb() {
        long id = 1L;
        Optional<com.anikasystems.files.service.model.File> fileData = filesRepository.findById(id);
        if (fileData.isPresent()) {
            filesRepository.save(id);
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