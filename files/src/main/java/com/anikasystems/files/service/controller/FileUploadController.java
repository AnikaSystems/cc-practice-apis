package com.anikasystems.files.service.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.anikasystems.files.service.service.S3FileUploadService;
 
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class FileUploadController {
 
    @Autowired
    private S3FileUploadService s3FileUploadService;
 
    @PostMapping("/file/upload")
    public String uploadFile(@RequestParam("id") long id, @RequestParam("file") MultipartFile file) {
        try {
            s3FileUploadService.uploadFile(id, file.getOriginalFilename(), file);
            return "File uploaded successfully!";
        } catch (IOException e) {
            return "Error uploading file: " + e.getMessage();
        }
    }

    @PutMapping("/file/upload")
    public void saveFile(@RequestParam("id") long id, @RequestParam("applicant") String applicant, @RequestParam("interpreter") String interpreter) {
        
        s3FileUploadService.updateFile(id, applicant, interpreter);
        
    }

    @PutMapping("/file/download")
    public void downloadFile(@RequestParam("url") String url, @RequestParam("localPath") String localPath) throws IOException{
        
        s3FileUploadService.downloadFile(url, localPath);
        
    }
    
    @SuppressWarnings("null")
    @GetMapping("/file/profile-test")
    public ResponseEntity<String> profileTest(@RequestHeader("Authorization") String bearer) {
        String uriString = UriComponentsBuilder
            .fromUriString(
            "https://dev-32541404.okta.com/idp/myaccount/profile")
            .build().toUriString();
        
        try {
            URL url = new URL(uriString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            // reuse the okta access token given to us (that should have the myaccount.profile.read scope)
            con.setRequestProperty("Authorization", bearer);
            // IMPORTANT - Accept header is required for okta myaccount apis
            con.setRequestProperty("Accept", "application/json; okta-version=1.0.0");
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            return new ResponseEntity<>(content.toString(), HttpStatus.OK);
        } catch(Exception e) {
            System.out.println(uriString);
            System.out.println(bearer);
            System.err.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //hit the following URL via postman
    // HTTP GETcall
    // http://localhost:9091/actuator
    // and you will get all the actuator responses back from the API.
    // check the health info
    @RequestMapping("/users/health")
    public Health health() {
        int errorCode = check(); // perform some specific health check
        if (errorCode != 0) {
            return Health.down()
              .withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }
    
    public int check() {
    	// Our logic to check health
    	return 0;
    }
}
