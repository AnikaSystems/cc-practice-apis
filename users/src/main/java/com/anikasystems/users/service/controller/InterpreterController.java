
package com.anikasystems.users.service.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.anikasystems.users.service.model.Interpreter;
import com.anikasystems.users.service.model.Interviewee;
import com.anikasystems.users.service.repository.InterpreterRepository;
import com.anikasystems.users.service.repository.IntervieweeRepository;
import com.anikasystems.users.service.repository.OfficerRepository;
import com.anikasystems.users.service.repository.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class InterpreterController {

  @Autowired
  UserRepository UserRepository;

  @Autowired
  IntervieweeRepository intervieweeRepository;

  @Autowired
  InterpreterRepository interpreterRepository;

  @Autowired
  OfficerRepository officerRepository;

  //TODO - need to make this an external property
  private String oktaUri = "https://dev-97363569-admin.okta.com/oauth2/v1/userinfo"; 

  @PutMapping("/interpreter/request")
  public ResponseEntity<Map<String, String>> requestInterpreter(@RequestHeader("Authorization") String bearer, @RequestBody MultiValueMap<String,String> paramMap) {
    // TODO (blocked by RIV-153) -call OKTA to get interviewee user info
    // get interviewee user email address from Okta data
    StringBuffer oktaInfo = getOktaInfo(bearer);
    Map<String, String> responseBody = new HashMap<>();
    
    if (oktaInfo.isEmpty()) {
      responseBody.put("error", "Failed to connect to Authentication provider");
      return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    if (oktaInfo.indexOf("401")>=0) {
        //return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
    if (oktaInfo.indexOf("403")>=0) {
        //return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
    
    // TODO (blocked by RIV-153) - get User and Interviewee objects from DB
    // Optional<User> UserData = UserRepository.findByEmail(email);

    // Get Interviewee object based on ARN and update with new data
    Interviewee interviewee = new Interviewee();
    if (paramMap.get("alienRegistrationNumber")!=null) {
      Optional<Interviewee> intervieweeData = intervieweeRepository.findByAlienRegNumber(paramMap.get("alienRegistrationNumber").get(0));
      if (intervieweeData.isPresent()) {
        interviewee = intervieweeData.get();
        if(paramMap.get("languages")!=null){
          interviewee.setNativeLangs(paramMap.get("languages").get(0));
          intervieweeRepository.save(interviewee);
        }
      } else {
      responseBody.put("error", "Failed to match Alien Registration Number");
      return new ResponseEntity<>(responseBody, HttpStatus.EXPECTATION_FAILED);
      }
    } else {
      responseBody.put("error", "Alien Registration Number no provided");
      return new ResponseEntity<>(responseBody, HttpStatus.EXPECTATION_FAILED);
    }

    // check if Interpreter already exists on system
    // if null create new, if exists update with new data from request
    Interpreter interpreter = new Interpreter();
    Optional<Interpreter> interpData = interpreterRepository.findByEmail(paramMap.get("interpreterEmail").get(0));
    if (interpData.isPresent()) {
      interpreter = updateFromParams(interpData.get(),paramMap);
      interpreterRepository.save(interpreter);
    } else {
      interpreter = updateFromParams(interpreter,paramMap);
      interpreterRepository.save(interpreter);     
    }  

    // TODO (blocked by RIV-154) - Call case service to update with user sign boolean and  
    // interpreter ID and return the case ID
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    responseBody.put("id", "1");
    responseBody.put("createdAt", timestamp.toString());

    return new ResponseEntity<>(responseBody, HttpStatus.OK);
  }

  @PutMapping("/interpreter/submitInfo")
  public ResponseEntity<Map<String, String>> submitInterpreterInfo(@RequestHeader("Authorization") String bearer, @RequestBody MultiValueMap<String,String> paramMap) {
    // call OKTA to get interviewee user info
    // get interviewee user email address from Okta data
    StringBuffer oktaInfo = getOktaInfo(bearer);
    Map<String, String> responseBody = new HashMap<>();
    
    if (oktaInfo.isEmpty()) {
      //responseBody.put("error", "Failed to connect to Authentication provider");
      //return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    if (oktaInfo.indexOf("401")>=0) {
        //return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
    if (oktaInfo.indexOf("403")>=0) {
        //return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }

    Interpreter interpreter = new Interpreter();
    Optional<Interpreter> interpData = interpreterRepository.findByEmail(paramMap.get("interpreterEmail").get(0));
    if (interpData.isPresent()) {
      interpreter = updateFromParams(interpData.get(),paramMap);
      interpreterRepository.save(interpreter);
    } else {
      responseBody.put("error", "Interpreter not found");
      return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);   
    }  

    // TODO get case ID via call to case service
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
    responseBody.put("id", "1");
    responseBody.put("updatedAt", timestamp.toString());

    return new ResponseEntity<>(responseBody, HttpStatus.OK);
  }

  private Interpreter updateFromParams(Interpreter interpreter, MultiValueMap<String,String> paramMap){
    if(paramMap.get("interpreterName")!=null){
      String name = paramMap.get("interpreterName").get(0);
      String firstName = name.substring(0, name.indexOf(" "));
      String lastName = name.substring(name.lastIndexOf(" "), name.length());
      interpreter.setFirstName(firstName);
      interpreter.setLastName(lastName);
    }

    if(paramMap.get("interpreterAddress")!=null){
      interpreter.setAddress(paramMap.get("interpreterAddress").get(0));
    }

    if(paramMap.get("interpreterPhoneNumber")!=null){
      interpreter.setPhoneNumber(paramMap.get("interpreterPhoneNumber").get(0));
    }

    if(paramMap.get("interpreterEmail")!=null){
      interpreter.setEmail(paramMap.get("interpreterEmail").get(0));
    }

    if(paramMap.get("interpreterLanguages")!=null){
      interpreter.setLanguages(paramMap.get("interpreterLanguages").get(0));
    }
    
    return interpreter;
  }

  private StringBuffer getOktaInfo(String bearer){
    String uriString = UriComponentsBuilder
        .fromUriString(oktaUri).build().toUriString();
    StringBuffer content = new StringBuffer();
    try {
      URL url = new URL(uriString);
      HttpURLConnection con = (HttpURLConnection) url.openConnection();
      // reuse the okta access token given to us (that should have the myaccount.profile.read scope)
      con.setRequestProperty("Authorization", bearer);
      // IMPORTANT - Accept header is required for okta myaccount apis
      con.setRequestProperty("Accept", "application/json; okta-version=1.0.0");
      con.setRequestMethod("GET");
      BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
      String inputLine;
      while ((inputLine = in.readLine()) != null) {
          content.append(inputLine);
      }
      in.close();
      con.disconnect();
      
    } catch(Exception e) {
      System.out.println(uriString);
      System.out.println(bearer);
      System.err.println(e.getMessage());
      content.append(e.getMessage());
    }
    return content;
  }
}
