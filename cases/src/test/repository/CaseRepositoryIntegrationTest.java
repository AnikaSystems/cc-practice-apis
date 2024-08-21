package com.anikasystems.users.service.repository;

import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;


import com.anikasystems.casemanagement.service.model.Case;;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CaseRepositoryIntegrationTest {
    @Autowired
    CaseRepository CaseRepository;

    @Autowired
    TestEntityManager entityManager;

    private final String testEmail = "testUser@fakeEmail.com";

    

    @Test
    @Order(1)
    public void givenNewCase_whenSaved_thenSuccess() {
        //testing the "C" in CRUD
        Case newCase = new Case(
            1, // case_id
            101, // user_id_fk
            201, // cm_id_fk
            301, // subject_id_fk
            401, // interpreter_id_fk
            true, // interp_id_doc_attach
            "John Doe", // subject_declare_sig
            "/path/to/subject_declare_signature", // subject_dec_sig_doc_path
            "file123", // subject_dec_sig_doc_file_id
            "Jane Doe", // interp_declare_sig
            "/path/to/interpreter_declare_signature", // interp_dec_sig_doc_path
            "file456", // interp_dec_sig_doc_file_id
            Date.valueOf("2023-08-01"), // interp_declare
            501, // officer_id_fk
            Date.valueOf("2023-08-02"), // officer_declare
            "Officer Smith", // officer_declare_sig
            "/path/to/officer_declare_signature", // officer_dec_sig_doc_path
            "file789", // officer_dec_sig_doc_file_id
            "Officer John Smith", // officer_declare_entered_name
            "New York Office", // officer_field_office
            Date.valueOf("2023-08-15"), // update_date
            false, // interp_dq
            null, // interp_dq_reason
            null, // subject_dq_name
            false, // dq_reschedule
            null, // officer_dq_sig
            null, // officer_dq_sig_doc_path
            null, // officer_dq_sig_doc_file_id
            null, // officer_dq_entered_name
            null, // superv_dq_sig
            null, // superv_dq_sig_doc_path
            null, // superv_dq_sig_doc_file_id
            null, // superv_dq_entered_name
            true, // continue_wo_interpreter
            "Officer Smith", // officer_wd_sig
            "/path/to/officer_wd_signature", // officer_wd_sig_doc_path
            "file987", // officer_wd_sig_doc_file_id
            "Officer John Smith", // officer_wd_entered_name
            "Subject Smith", // subject_wd_sig
            "/path/to/subject_wd_signature", // subject_wd_sig_doc_path
            "file654", // subject_wd_sig_doc_file_id
            "Subject John Smith", // subject_wd_entered_name
            1, // case_status_code (1 might mean 'Open')
            "Open", // case_status_value
            LocalDateTime.now() // case_update_date
        );
        CaseRepository.save(newCase);
        assert(entityManager.find(Case.class, newCase.getCase_id()).equals(newCase));    
    }

    @Test
    @Order(2)
    public void givenExistingCase_whenRead_thenSuccess() {
        //testing the 'R' in CRUD
        Case newCase = entityManager.find(Case.class, 1);
        assert(newCase.getCase_status_code.equals("1"));
    }

    @Test
    @Order(3)
    public void givenExistingCase_whenUpdated_thenSuccess() {
        //Testing the 'U' in CRUD
        Case localCase = CaseRepository.findByCase_Id(1).get();
        localCase.setCase_status_code(2);
        assert(entityManager.find(Case.class, 1).getCase_status_code().equals(2));
    }

    @Test
    @Order(4)
    public void givenExistingCase_whenDeleted_thenSuccess() {
        //Testing the 'D' in CRUD
        Optional<Case> CaseData = CaseRepository.findByCase_Id(1);
        if(CaseData.isPresent()){
            Case delCase = CaseData.get();
            CaseRepository.delete(delCase);
            assert(entityManager.find(Case.class, delCase.getCase_id())==null);
        }
        
    }

}