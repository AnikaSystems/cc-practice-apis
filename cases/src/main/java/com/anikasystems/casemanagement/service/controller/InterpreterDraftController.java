package com.anikasystems.casemanagement.service.controller;

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
import com.anikasystems.casemanagement.service.model.CaseInterpreterDraft;
import com.anikasystems.casemanagement.service.repository.CaseInterpreterDraftRepository;
import com.anikasystems.casemanagement.service.jms.SimpleQueue;

@CrossOrigin(origins = "https://cc-case-management.s3.amazonaws.com")
@RestController
@RequestMapping("/api/drafts")
public class InterpreterDraftController {

  @Autowired
  CaseInterpreterDraftRepository caseInterpreterDraftRepository;

  @GetMapping("/interpreter")
  public ResponseEntity<List<CaseInterpreterDraft>> getAllCases(@RequestParam(required = false) String title) {
    try {
      List<CaseInterpreterDraft> drafts = caseInterpreterDraftRepository.findAll();

      return new ResponseEntity<>(drafts, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/interpreter/{id}")
  public ResponseEntity<CaseInterpreterDraft> getCaseById(@PathVariable("id") long id) {
    Optional<CaseInterpreterDraft> draftData = caseInterpreterDraftRepository.findById(id);

    if (draftData.isPresent()) {
      return new ResponseEntity<>(draftData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/interpreters")
  public ResponseEntity<CaseInterpreterDraft> createCase(@RequestBody CaseInterpreterDraft draftData) {
    try {
      CaseInterpreterDraft _draft = caseInterpreterDraftRepository.save(new CaseInterpreterDraft(Long.toString(draftData.getId())));

      SimpleQueue queue = new SimpleQueue("interpreterDrafts");
      queue.send((Long.toString(draftData.getId())));
      queue.close();

      return new ResponseEntity<>(_draft, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/interpreter/{id}")
  public ResponseEntity<CaseInterpreterDraft> updateCase(@PathVariable("id") long id, @RequestBody Case inputCase) {
    Optional<CaseInterpreterDraft> draftData = caseInterpreterDraftRepository.findById(id);

    if (draftData.isPresent()) {
      CaseInterpreterDraft _draft = draftData.get();
      _draft.setSubjectId(inputCase.getSubjectId());
      return new ResponseEntity<>(caseInterpreterDraftRepository.save(_draft), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/interpreter/{id}")
  public ResponseEntity<HttpStatus> deleteCase(@PathVariable("id") long id) {
    try {
      caseInterpreterDraftRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/interpreter")
  public ResponseEntity<HttpStatus> deleteAllCases() {
    try {
      caseInterpreterDraftRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

}
