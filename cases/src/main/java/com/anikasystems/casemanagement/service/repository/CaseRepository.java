package com.anikasystems.casemanagement.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anikasystems.casemanagement.service.model.Case;

public interface CaseRepository extends JpaRepository<Case, Long> {

  List<Case> findByCase_Id(int id);
  List<Case> findByUser_Id_Fk(String user_id_fk);
  List<Case> findByCase_status_code(String case_status_code);


}
