package com.anikasystems.casemanagement.service.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anikasystems.casemanagement.service.model.Case;

public interface CaseRepository extends JpaRepository<Case, Long> {

  List<Case> findByCaseID(String ID);
}
