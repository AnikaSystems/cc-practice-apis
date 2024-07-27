package com.anikasystems.casemanagement.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anikasystems.casemanagement.service.model.CaseInterpreterDraft;

public interface CaseInterpreterDraftRepository extends JpaRepository<CaseInterpreterDraft, Long> {
}
