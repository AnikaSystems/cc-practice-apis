package com.anikasystems.casemanagement.service.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anikasystems.casemanagement.service.model.Case;
import com.anikasystems.casemanagement.service.repository.CaseRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class CaseController {

  @Autowired
  CaseRepository caseRepository;

  @GetMapping("/cases")
  public ResponseEntity<List<Case>> getAllCases(@RequestParam(required = false) Integer status) {
    try {
      List<Case> cases = new ArrayList<Case>();

      if (status == null)
       caseRepository.findAll().forEach(cases::add);
      else
       caseRepository.findByCaseStatusCode(status).forEach(cases::add);

      if (cases.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      // cases = caseRepository.findAll();

      return new ResponseEntity<>(cases, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/cases/{id}")
  public ResponseEntity<Case> getCaseById(@PathVariable("id") int id) {
    List<Case> caseData = caseRepository.findByCaseId(id);

    if (caseData!=null) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/cases")
  public ResponseEntity<Case> createCase(@RequestBody Case caseData) {
    try {
      
      Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      Case _case = caseData;
      _case.setCreatedAt(timestamp.toLocalDateTime());
      Case _caseSave = caseRepository.save(_case);
      return new ResponseEntity<>(_case, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/cases/{id}")
  public ResponseEntity<Case> updateCase(@PathVariable("id") long id, @RequestBody Case inputCase) {
    Optional<Case> caseData = caseRepository.findById(id);
    Timestamp timestamp = new Timestamp(System.currentTimeMillis());

    if (caseData.isPresent()) {
      Case _case = caseData.get();
      _case.setCreatedAt(timestamp.toLocalDateTime());
  
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

  //This is a test API to make the input string uppercase
  @GetMapping("/cases/uppercase/{title}")
  public ResponseEntity<String> uppercaseString(@PathVariable("title") String string) {
    return new ResponseEntity<>(string.toUpperCase(), HttpStatus.OK);
  }

}
