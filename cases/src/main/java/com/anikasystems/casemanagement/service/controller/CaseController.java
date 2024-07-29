package com.anikasystems.casemanagement.service.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.anikasystems.casemanagement.service.model.Case;
import com.anikasystems.casemanagement.service.repository.CaseRepository;
import com.anikasystems.casemanagement.service.jms.SimpleQueue;

@CrossOrigin(origins = "https://cc-case-management.s3.amazonaws.com")
@RestController
@RequestMapping("/api")
public class CaseController {

  @Autowired
  CaseRepository caseRepository;

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
      BufferedReader in = new BufferedReader(
        new InputStreamReader(con.getInputStream()));
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

  @GetMapping("/cases")
  public ResponseEntity<List<Case>> getAllCases(@RequestParam(required = false) String title) {
    try {
      List<Case> cases = caseRepository.findAll();

      return new ResponseEntity<>(cases, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/cases/{id}")
  public ResponseEntity<Case> getCaseById(@PathVariable("id") long id) {
    Optional<Case> caseData = caseRepository.findById(id);

    if (caseData.isPresent()) {
      return new ResponseEntity<>(caseData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/cases")
  public ResponseEntity<Case> createCase(@RequestBody Case caseData) {
    try {
      Case _case = caseRepository.save(new Case(caseData.getSubjectId()));

      SimpleQueue queue = new SimpleQueue("cases");
      queue.send((Long.toString(caseData.getId())));
      queue.close();

      return new ResponseEntity<>(_case, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/cases/{id}")
  public ResponseEntity<Case> updateCase(@PathVariable("id") long id, @RequestBody Case inputCase) {
    Optional<Case> caseData = caseRepository.findById(id);

    if (caseData.isPresent()) {
      Case _case = caseData.get();
      _case.setSubjectId(inputCase.getSubjectId());
      return new ResponseEntity<>(caseRepository.save(_case), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/cases/{id}")
  public ResponseEntity<HttpStatus> deleteCase(@PathVariable("id") long id) {
    try {
      caseRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/cases")
  public ResponseEntity<HttpStatus> deleteAllCases() {
    try {
      caseRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

}
