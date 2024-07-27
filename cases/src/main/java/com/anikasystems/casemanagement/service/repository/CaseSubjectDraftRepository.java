package com.anikasystems.casemanagement.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anikasystems.casemanagement.service.model.CaseSubjectDraft;

public interface CaseSubjectDraftRepository extends JpaRepository<CaseSubjectDraft, Long> {
}
