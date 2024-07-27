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
import com.anikasystems.casemanagement.service.model.CaseSubjectDraft;
import com.anikasystems.casemanagement.service.repository.CaseSubjectDraftRepository;
import com.anikasystems.casemanagement.service.repository.CaseRepository;
import com.anikasystems.casemanagement.service.repository.CaseSubjectDraftRepository;
import com.anikasystems.casemanagement.service.jms.SimpleQueue;

@CrossOrigin(origins = "https://cc-case-management.s3.amazonaws.com")
@RestController
@RequestMapping("/api/drafts")
public class SubjectDraftController {

  @Autowired
  CaseSubjectDraftRepository caseSubjectDraftRepository;

  @GetMapping("/subject")
  public ResponseEntity<List<CaseSubjectDraft>> getAllCases(@RequestParam(required = false) String title) {
    try {
      List<CaseSubjectDraft> drafts = caseSubjectDraftRepository.findAll();

      return new ResponseEntity<>(drafts, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/subject/{id}")
  public ResponseEntity<CaseSubjectDraft> getCaseById(@PathVariable("id") long id) {
    Optional<CaseSubjectDraft> draftData = caseSubjectDraftRepository.findById(id);

    if (draftData.isPresent()) {
      return new ResponseEntity<>(draftData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/subjects")
  public ResponseEntity<CaseSubjectDraft> createCase(@RequestBody CaseSubjectDraft draftData) {
    try {
      CaseSubjectDraft _draft = caseSubjectDraftRepository.save(new CaseSubjectDraft(Long.toString(draftData.getId())));

      SimpleQueue queue = new SimpleQueue("SubjectDrafts");
      queue.send((Long.toString(draftData.getId())));
      queue.close();

      return new ResponseEntity<>(_draft, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/subject/{id}")
  public ResponseEntity<CaseSubjectDraft> updateCase(@PathVariable("id") long id, @RequestBody Case inputCase) {
    Optional<CaseSubjectDraft> draftData = caseSubjectDraftRepository.findById(id);

    if (draftData.isPresent()) {
      CaseSubjectDraft _draft = draftData.get();
      _draft.setSubjectId(inputCase.getSubjectId());
      return new ResponseEntity<>(caseSubjectDraftRepository.save(_draft), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/subject/{id}")
  public ResponseEntity<HttpStatus> deleteCase(@PathVariable("id") long id) {
    try {
      caseSubjectDraftRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/subject")
  public ResponseEntity<HttpStatus> deleteAllCases() {
    try {
      caseSubjectDraftRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }

}
