package com.anikasystems.files.service.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import com.anikasystems.files.service.service.StorageService;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class StorageController {
	private static final Logger logger = LoggerFactory.getLogger(StorageController.class);
	

    @Autowired
    private StorageService storageService;

    @PostMapping("/file/upload")
    public String uploadFile(@RequestParam("id") long id, @RequestParam("file") MultipartFile file) {
        try {
            storageService.uploadFile(id, file.getOriginalFilename(), file);
            return "File uploaded successfully!";
        } catch (IOException e) {
        	logger.error("Error uploading "+id,e);
            return "Error uploading file: " + e.getMessage();
        }
    }

  

    @GetMapping("/file/download/{fileName}")
    public ResponseEntity<ByteArrayResource> downloadFile(@PathVariable String fileName) {
    	logger.info("request received for file download : "+fileName);
        byte[] data = storageService.downloadFile(fileName);
        ByteArrayResource resource = new ByteArrayResource(data);
        return ResponseEntity
                .ok()
                .contentLength(data.length)
                .header("Content-type", "application/octet-stream")
                .header("Content-disposition", "attachment; fileName=\"" + fileName + "\"")
                .body(resource);
    }

    @DeleteMapping("/delete/{fileName}")
    public ResponseEntity<String> deleteFile(@PathVariable String fileName) {
        return new ResponseEntity<>(storageService.deleteFile(fileName), HttpStatus.OK);
    }

  
    @GetMapping("/file/profile-test")
    public ResponseEntity<String> profileTest(@RequestHeader("Authorization") String bearer) {
        String uriString = UriComponentsBuilder
                .fromUriString(
                        "https://dev-32541404.okta.com/idp/myaccount/profile")
                .build().toUriString();

        try {
            URL url = new URL(uriString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            // reuse the okta access token given to us (that should have the
            // myaccount.profile.read scope)
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
        } catch (Exception e) {
            System.out.println(uriString);
            System.out.println(bearer);
            System.err.println(e.getMessage());
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // hit the following URL via postman
    // HTTP GETcall
    // http://localhost:9091/actuator
    // and you will get all the actuator responses back from the API.
    // check the health info
    @PutMapping("/users/health")
    public Health health() {
        int errorCode = check(); // perform some specific health check
        if (errorCode != 0) {
            return Health.down().withDetail("Error Code", errorCode).build();
        }
        return Health.up().build();
    }

    public int check() {
        // Our logic to check health
        return 0;
    }
    
    @RequestMapping("/")
    public String home(){
        return "Files Microservice!";
    }

}
