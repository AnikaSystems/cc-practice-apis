package com.anikasystems.casemanagement.service.model;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "interp_iview_case")
public class Case {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "case_id")
    private int caseId;

    @Column(name = "user_id_fk")
    private int userIdFk;

    @Column(name = "cm_id_fk")
    private int cmIdFk;

    @Column(name = "subject_id_fk")
    private int subjectIdFk;

    @Column(name = "interpreter_id_fk")
    private int interpreterIdFk;

    @Column(name = "interp_id_doc_attach")
    private boolean interpIdDocAttach;

    @Column(name = "subject_declare_sig")
    private String subjectDeclareSig;

    @Column(name = "subject_dec_sig_doc_path")
    private String subjectDecSigDocPath;

    @Column(name = "subject_dec_sig_doc_file_id")
    private String subjectDecSigDocFileId;

    @Column(name = "interp_declare_sig")
    private String interpDeclareSig;

    @Column(name = "interp_dec_sig_doc_path")
    private String interpDecSigDocPath;

    @Column(name = "interp_dec_sig_doc_file_id")
    private String interpDecSigDocFileId;

    @Column(name = "interp_declare")
    private Date interpDeclare;

    @Column(name = "officer_id_fk")
    private int officerIdFk;

    @Column(name = "officer_declare")
    private Date officerDeclare;

    @Column(name = "officer_declare_sig")
    private String officerDeclareSig;

    @Column(name = "officer_dec_sig_doc_path")
    private String officerDecSigDocPath;

    @Column(name = "officer_dec_sig_doc_file_id")
    private String officerDecSigDocFileId;

    @Column(name = "officer_declare_entered_name")
    private String officerDeclareEnteredName;

    @Column(name = "officer_field_office")
    private String officerFieldOffice;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "interp_dq")
    private boolean interpDq;

    @Column(name = "interp_dq_reason")
    private String interpDqReason;

    @Column(name = "subject_dq_name")
    private String subjectDqName;

    @Column(name = "dq_reschedule")
    private boolean dqReschedule;

    @Column(name = "officer_dq_sig")
    private String officerDqSig;

    @Column(name = "officer_dq_sig_doc_path")
    private String officerDqSigDocPath;

    @Column(name = "officer_dq_sig_doc_file_id")
    private String officerDqSigDocFileId;

    @Column(name = "officer_dq_entered_name")
    private String officerDqEnteredName;

    @Column(name = "superv_dq_sig")
    private String supervDqSig;

    @Column(name = "superv_dq_sig_doc_path")
    private String supervDqSigDocPath;

    @Column(name = "superv_dq_sig_doc_file_id")
    private String supervDqSigDocFileId;

    @Column(name = "superv_dq_entered_name")
    private String supervDqEnteredName;

    @Column(name = "continue_wo_interpreter")
    private Boolean continueWoInterpreter;

    @Column(name = "officer_wd_sig")
    private String officerWdSig;

    @Column(name = "officer_wd_sig_doc_path")
    private String officerWdSigDocPath;

    @Column(name = "officer_wd_sig_doc_file_id")
    private String officerWdSigDocFileId;

    @Column(name = "officer_wd_entered_name")
    private String officerWdEnteredName;

    @Column(name = "subject_wd_sig")
    private String subjectWdSig;

    @Column(name = "subject_wd_sig_doc_path")
    private String subjectWdSigDocPath;

    @Column(name = "subject_wd_sig_doc_file_id")
    private String subjectWdSigDocFileId;

    @Column(name = "subject_wd_entered_name")
    private String subjectWdEnteredName;

    @Column(name = "case_status_code")
    private Integer caseStatusCode;

    @Column(name = "case_status_value")
    private String caseStatusValue;

    @Column(name = "case_update_date")
    private LocalDateTime caseUpdateDate;

    public Case() {

    }

    public Case(int caseId, int userIdFk, int cmIdFk,
            int subjectIdFk, int interpreterIdFk, boolean interpIdDocAttach, String subjectDeclareSig,
            String subjectDecSigDocPath,
            String subjectDecSigDocFileId, String interpDeclareSig, String interpDecSigDocPath,
            String interpDecSigDocFileId,
            Date interpDeclare, int officerIdFk, Date officerDeclare, String officerDeclareSig,
            String officerDecSigDocPath, String officerDecSigDocFileId,
            String officerDeclareEnteredName, String officerFieldOffice, Date updateDate, boolean interpDq,
            String interpDqReason, String subjectDqName, boolean dqReschedule,
            String officerDqSig, String officerDqSigDocPath, String officerDqSigDocFileId,
            String officerDqEnteredName, String supervDqSig, String supervDqSigDocPath,
            String supervDqSigDocFileId, String supervDqEnteredName, Boolean continueWoInterpreter,
            String officerWdSig, String officerWdSigDocPath, String officerWdSigDocFileId,
            String officerWdEnteredName, String subjectWdSig, String subjectWdSigDocPath,
            String subjectWdSigDocFileId, String subjectWdEnteredName, Integer caseStatusCode,
            String caseStatusValue, LocalDateTime caseUpdateDate) {
        this.caseId = caseId;
        this.userIdFk = userIdFk;
        this.cmIdFk = cmIdFk;
        this.subjectIdFk = subjectIdFk;
        this.interpreterIdFk = interpreterIdFk;
        this.interpIdDocAttach = interpIdDocAttach;
        this.subjectDeclareSig = subjectDeclareSig;
        this.subjectDecSigDocPath = subjectDecSigDocPath;
        this.subjectDecSigDocFileId = subjectDecSigDocFileId;
        this.interpDeclareSig = interpDeclareSig;
        this.interpDecSigDocPath = interpDecSigDocPath;
        this.interpDecSigDocFileId = interpDecSigDocFileId;
        this.interpDeclare = interpDeclare;
        this.officerIdFk = officerIdFk;
        this.officerDeclare = officerDeclare;
        this.officerDeclareSig = officerDeclareSig;
        this.officerDecSigDocPath = officerDecSigDocPath;
        this.officerDecSigDocFileId = officerDecSigDocFileId;
        this.officerDeclareEnteredName = officerDeclareEnteredName;
        this.officerFieldOffice = officerFieldOffice;
        this.updateDate = updateDate;
        this.interpDq = interpDq;
        this.interpDqReason = interpDqReason;
        this.subjectDqName = subjectDqName;
        this.dqReschedule = dqReschedule;
        this.officerDqSig = officerDqSig;
        this.officerDqSigDocPath = officerDqSigDocPath;
        this.officerDqSigDocFileId = officerDqSigDocFileId;
        this.officerDqEnteredName = officerDqEnteredName;
        this.supervDqSig = supervDqSig;
        this.supervDqSigDocPath = supervDqSigDocPath;
        this.supervDqSigDocFileId = supervDqSigDocFileId;
        this.supervDqEnteredName = supervDqEnteredName;
        this.continueWoInterpreter = continueWoInterpreter;
        this.officerWdSig = officerWdSig;
        this.officerWdSigDocPath = officerWdSigDocPath;
        this.officerWdSigDocFileId = officerWdSigDocFileId;
        this.officerWdEnteredName = officerWdEnteredName;
        this.subjectWdSig = subjectWdSig;
        this.subjectWdSigDocPath = subjectWdSigDocPath;
        this.subjectWdSigDocFileId = subjectWdSigDocFileId;
        this.subjectWdEnteredName = subjectWdEnteredName;
        this.caseStatusCode = caseStatusCode;
        this.caseStatusValue = caseStatusValue;
        this.caseUpdateDate = caseUpdateDate;
    }

    public int getCaseId() {
        return caseId;
    }

    public void setCaseId(int caseId) {
        this.caseId = caseId;
    }

    public int getUserIdFk() {
        return userIdFk;
    }

    public void setUserIdFk(int userIdFk) {
        this.userIdFk = userIdFk;
    }

    public int getCmIdFk() {
        return cmIdFk;
    }

    public void setCmIdFk(int cmIdFk) {
        this.cmIdFk = cmIdFk;
    }

    public int getSubjectIdFk() {
        return subjectIdFk;
    }

    public void setSubjectIdFk(int subjectIdFk) {
        this.subjectIdFk = subjectIdFk;
    }

    public int getInterpreterIdFk() {
        return interpreterIdFk;
    }

    public void setInterpreterIdFk(int interpreterIdFk) {
        this.interpreterIdFk = interpreterIdFk;
    }

    public boolean isInterpIdDocAttach() {
        return interpIdDocAttach;
    }

    public void setInterpIdDocAttach(boolean interpIdDocAttach) {
        this.interpIdDocAttach = interpIdDocAttach;
    }

    public String getSubjectDeclareSig() {
        return subjectDeclareSig;
    }

    public void setSubjectDeclareSig(String subjectDeclareSig) {
        this.subjectDeclareSig = subjectDeclareSig;
    }

    public String getSubjectDecSigDocPath() {
        return subjectDecSigDocPath;
    }

    public void setSubjectDecSigDocPath(String subjectDecSigDocPath) {
        this.subjectDecSigDocPath = subjectDecSigDocPath;
    }

    public String getSubjectDecSigDocFileId() {
        return subjectDecSigDocFileId;
    }

    public void setSubjectDecSigDocFileId(String subjectDecSigDocFileId) {
        this.subjectDecSigDocFileId = subjectDecSigDocFileId;
    }

    public String getInterpDeclareSig() {
        return interpDeclareSig;
    }

    public void setInterpDeclareSig(String interpDeclareSig) {
        this.interpDeclareSig = interpDeclareSig;
    }

    public String getInterpDecSigDocPath() {
        return interpDecSigDocPath;
    }

    public void setInterpDecSigDocPath(String interpDecSigDocPath) {
        this.interpDecSigDocPath = interpDecSigDocPath;
    }

    public String getInterpDecSigDocFileId() {
        return interpDecSigDocFileId;
    }

    public void setInterpDecSigDocFileId(String interpDecSigDocFileId) {
        this.interpDecSigDocFileId = interpDecSigDocFileId;
    }

    public Date getInterpDeclare() {
        return interpDeclare;
    }

    public void setInterpDeclare(Date interpDeclare) {
        this.interpDeclare = interpDeclare;
    }

    public int getOfficerIdFk() {
        return officerIdFk;
    }

    public void setOfficerIdFk(int officerIdFk) {
        this.officerIdFk = officerIdFk;
    }

    public Date getOfficerDeclare() {
        return officerDeclare;
    }

    public void setOfficerDeclare(Date officerDeclare) {
        this.officerDeclare = officerDeclare;
    }

    public String getOfficerDeclareSig() {
        return officerDeclareSig;
    }

    public void setOfficerDeclareSig(String officerDeclareSig) {
        this.officerDeclareSig = officerDeclareSig;
    }

    public String getOfficerDecSigDocPath() {
        return officerDecSigDocPath;
    }

    public void setOfficerDecSigDocPath(String officerDecSigDocPath) {
        this.officerDecSigDocPath = officerDecSigDocPath;
    }

    public String getOfficerDecSigDocFileId() {
        return officerDecSigDocFileId;
    }

    public void setOfficerDecSigDocFileId(String officerDecSigDocFileId) {
        this.officerDecSigDocFileId = officerDecSigDocFileId;
    }

    public String getOfficerDeclareEnteredName() {
        return officerDeclareEnteredName;
    }

    public void setOfficerDeclareEnteredName(String officerDeclareEnteredName) {
        this.officerDeclareEnteredName = officerDeclareEnteredName;
    }

    public String getOfficerFieldOffice() {
        return officerFieldOffice;
    }

    public void setOfficerFieldOffice(String officerFieldOffice) {
        this.officerFieldOffice = officerFieldOffice;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public boolean isInterpDq() {
        return interpDq;
    }

    public void setInterpDq(boolean interpDq) {
        this.interpDq = interpDq;
    }

    public String getInterpDqReason() {
        return interpDqReason;
    }

    public void setInterpDqReason(String interpDqReason) {
        this.interpDqReason = interpDqReason;
    }

    public String getSubjectDqName() {
        return subjectDqName;
    }

    public void setSubjectDqName(String subjectDqName) {
        this.subjectDqName = subjectDqName;
    }

    public boolean isDqReschedule() {
        return dqReschedule;
    }

    public void setDqReschedule(boolean dqReschedule) {
        this.dqReschedule = dqReschedule;
    }

    public String getOfficerDqSig() {
        return officerDqSig;
    }

    public void setOfficerDqSig(String officerDqSig) {
        this.officerDqSig = officerDqSig;
    }

    public String getOfficerDqSigDocPath() {
        return officerDqSigDocPath;
    }

    public void setOfficerDqSigDocPath(String officerDqSigDocPath) {
        this.officerDqSigDocPath = officerDqSigDocPath;
    }

    public String getOfficerDqSigDocFileId() {
        return officerDqSigDocFileId;
    }

    public void setOfficerDqSigDocFileId(String officerDqSigDocFileId) {
        this.officerDqSigDocFileId = officerDqSigDocFileId;
    }

    public String getOfficerDqEnteredName() {
        return officerDqEnteredName;
    }

    public void setOfficerDqEnteredName(String officerDqEnteredName) {
        this.officerDqEnteredName = officerDqEnteredName;
    }

    public String getSupervDqSig() {
        return supervDqSig;
    }

    public void setSupervDqSig(String supervDqSig) {
        this.supervDqSig = supervDqSig;
    }

    public String getSupervDqSigDocPath() {
        return supervDqSigDocPath;
    }

    public void setSupervDqSigDocPath(String supervDqSigDocPath) {
        this.supervDqSigDocPath = supervDqSigDocPath;
    }

    public String getSupervDqSigDocFileId() {
        return supervDqSigDocFileId;
    }

    public void setSupervDqSigDocFileId(String supervDqSigDocFileId) {
        this.supervDqSigDocFileId = supervDqSigDocFileId;
    }

    public String getSupervDqEnteredName() {
        return supervDqEnteredName;
    }

    public void setSupervDqEnteredName(String supervDqEnteredName) {
        this.supervDqEnteredName = supervDqEnteredName;
    }

    public Boolean getContinueWoInterpreter() {
        return continueWoInterpreter;
    }

    public void setContinueWoInterpreter(Boolean continueWoInterpreter) {
        this.continueWoInterpreter = continueWoInterpreter;
    }

    public String getOfficerWdSig() {
        return officerWdSig;
    }

    public void setOfficerWdSig(String officerWdSig) {
        this.officerWdSig = officerWdSig;
    }

    public String getOfficerWdSigDocPath() {
        return officerWdSigDocPath;
    }

    public void setOfficerWdSigDocPath(String officerWdSigDocPath) {
        this.officerWdSigDocPath = officerWdSigDocPath;
    }

    public String getOfficerWdSigDocFileId() {
        return officerWdSigDocFileId;
    }

    public void setOfficerWdSigDocFileId(String officerWdSigDocFileId) {
        this.officerWdSigDocFileId = officerWdSigDocFileId;
    }

    public String getOfficerWdEnteredName() {
        return officerWdEnteredName;
    }

    public void setOfficerWdEnteredName(String officerWdEnteredName) {
        this.officerWdEnteredName = officerWdEnteredName;
    }

    public String getSubjectWdSig() {
        return subjectWdSig;
    }

    public void setSubjectWdSig(String subjectWdSig) {
        this.subjectWdSig = subjectWdSig;
    }

    public String getSubjectWdSigDocPath() {
        return subjectWdSigDocPath;
    }

    public void setSubjectWdSigDocPath(String subjectWdSigDocPath) {
        this.subjectWdSigDocPath = subjectWdSigDocPath;
    }

    public String getSubjectWdSigDocFileId() {
        return subjectWdSigDocFileId;
    }

    public void setSubjectWdSigDocFileId(String subjectWdSigDocFileId) {
        this.subjectWdSigDocFileId = subjectWdSigDocFileId;
    }

    public String getSubjectWdEnteredName() {
        return subjectWdEnteredName;
    }

    public void setSubjectWdEnteredName(String subjectWdEnteredName) {
        this.subjectWdEnteredName = subjectWdEnteredName;
    }

    public Integer getCaseStatusCode() {
        return caseStatusCode;
    }

    public void setCaseStatusCode(Integer caseStatusCode) {
        this.caseStatusCode = caseStatusCode;
    }

    public String getCaseStatusValue() {
        return caseStatusValue;
    }

    public void setCaseStatusValue(String caseStatusValue) {
        this.caseStatusValue = caseStatusValue;
    }

    public LocalDateTime getCaseUpdateDate() {
        return caseUpdateDate;
    }

    public void setCaseUpdateDate(LocalDateTime caseUpdateDate) {
        this.caseUpdateDate = caseUpdateDate;
    }

    @Override
    public String toString() {
        return "Case [" +
                "caseId=" + caseId +
                ", userIdFk=" + userIdFk +
                ", cmIdFk=" + cmIdFk +
                ", subjectIdFk=" + subjectIdFk +
                ", interpreterIdFk=" + interpreterIdFk +
                ", interpIdDocAttach=" + interpIdDocAttach +
                ", subjectDeclareSig=" + subjectDeclareSig +
                ", subjectDecSigDocPath=" + subjectDecSigDocPath +
                ", subjectDecSigDocFileId=" + subjectDecSigDocFileId +
                ", interpDeclareSig=" + interpDeclareSig +
                ", interpDecSigDocPath=" + interpDecSigDocPath +
                ", interpDecSigDocFileId=" + interpDecSigDocFileId +
                ", interpDeclare=" + interpDeclare +
                ", officerIdFk=" + officerIdFk +
                ", officerDeclare=" + officerDeclare +
                ", officerDeclareSig=" + officerDeclareSig +
                ", officerDecSigDocPath=" + officerDecSigDocPath +
                ", officerDecSigDocFileId=" + officerDecSigDocFileId +
                ", officerDeclareEnteredName=" + officerDeclareEnteredName +
                ", officerFieldOffice=" + officerFieldOffice +
                ", updateDate=" + updateDate +
                ", interpDq=" + interpDq +
                ", interpDqReason=" + interpDqReason +
                ", subjectDqName=" + subjectDqName +
                ", dqReschedule=" + dqReschedule +
                ", officerDqSig=" + officerDqSig +
                ", officerDqSigDocPath=" + officerDqSigDocPath +
                ", officerDqSigDocFileId=" + officerDqSigDocFileId +
                ", officerDqEnteredName=" + officerDqEnteredName +
                ", supervDqSig=" + supervDqSig +
                ", supervDqSigDocPath=" + supervDqSigDocPath +
                ", supervDqSigDocFileId=" + supervDqSigDocFileId +
                ", supervDqEnteredName=" + supervDqEnteredName +
                ", continueWoInterpreter=" + continueWoInterpreter +
                ", officerWdSig=" + officerWdSig +
                ", officerWdSigDocPath=" + officerWdSigDocPath +
                ", officerWdSigDocFileId=" + officerWdSigDocFileId +
                ", officerWdEnteredName=" + officerWdEnteredName +
                ", subjectWdSig=" + subjectWdSig +
                ", subjectWdSigDocPath=" + subjectWdSigDocPath +
                ", subjectWdSigDocFileId=" + subjectWdSigDocFileId +
                ", subjectWdEnteredName=" + subjectWdEnteredName +
                ", caseStatusCode=" + caseStatusCode +
                ", caseStatusValue=" + caseStatusValue +
                ", caseUpdateDate=" + caseUpdateDate +
                "]";
    }

}
