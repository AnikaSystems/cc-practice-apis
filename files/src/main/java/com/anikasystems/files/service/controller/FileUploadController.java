package com.anikasystems.files.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.anikasystems.files.service.service.S3FileUploadService;
 
@RestController
@RequestMapping("/api")
public class FileUploadController {
 
    @Autowired
    private S3FileUploadService s3FileUploadService;
 
    @PostMapping("/upload")
    public String uploadFile(@RequestParam("id") long id, @RequestParam("file") MultipartFile file) {
        try {
            s3FileUploadService.uploadFile(id, file.getOriginalFilename(), file);
            return "File uploaded successfully!";
        } catch (IOException e) {
            return "Error uploading file: " + e.getMessage();
        }
    }

    @PutMapping("/upload")
    public void saveFile(@RequestParam("id") long id, @RequestParam("applicant") String applicant, @RequestParam("interpreter") String interpreter) {
        
        s3FileUploadService.updateFile(id, applicant, interpreter);
        
    }

    @PutMapping("/download")
    public void downloadFile(@RequestParam("url") String url, @RequestParam("localPath") String localPath) throws IOException{
        
        s3FileUploadService.downloadFile(url, localPath);
        
    }
    
    @SuppressWarnings("null")
    @GetMapping("/profile-test")
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

}