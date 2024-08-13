
package com.anikasystems.casemanagement.service.model;

import java.sql.Date;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "cases")
public class Case {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)

  @Column(name = "case_id")
  private int case_id;

  @Column(name = "user_id_fk")
  private int user_id_fk;

  @Column(name = "cm_id_fk")
  private int cm_id_fk;

  @Column(name = "subject_id_fk")
  private int subject_id_fk;

  @Column(name = "interpreter_id_fk")
  private int interpreter_id_fk;

  @Column(name = "interp_id_doc_attach")
  private boolean interp_id_doc_attach;

  @Column(name = "subject_declare_sig")
  private String subject_declare_sig;

  @Column(name = "subject_dec_sig_doc_path")
  private String subject_dec_sig_doc_path;

  @Column(name = "subject_dec_sig_doc_file_id")
  private String subject_dec_sig_doc_file_id;

  @Column(name = "interp_declare_sig")
  private String interp_declare_sig;

  @Column(name = "interp_dec_sig_doc_path")
  private String interp_dec_sig_doc_path;

  @Column(name = "interp_dec_sig_doc_file_id")
  private String interp_dec_sig_doc_file_id;

  @Column(name = "interp_declare")
  private Date interp_declare;

  @Column(name = "officer_id_fk")
  private int officer_id_fk;

  @Column(name = "officer_declare")
  private Date officer_declare;

  @Column(name = "officer_declare_sig")
  private String officer_declare_sig;

  @Column(name = "officer_dec_sig_doc_path")
  private String officer_dec_sig_doc_path;

  @Column(name = "officer_dec_sig_doc_file_id")
  private String officer_dec_sig_doc_file_id;

  @Column(name = "officer_declare_entered_name")
  private String officer_declare_entered_name;

  @Column(name = "officer_field_office")
  private String officer_field_office;

  @Column(name = "update_date")
  private Date update_date;

  @Column(name = "interp_dq")
  private boolean interp_dq;

  @Column(name = "interp_dq_reason")
  private String interp_dq_reason;

  @Column(name = "subject_dq_name")
  private String subject_dq_name;

  @Column(name = "dq_reschedule")
  private boolean dq_reschedule;

  @Column(name = "officer_dq_sig")
  private String officer_dq_sig;

  @Column(name = "officer_dq_sig_doc_path")
  private String officer_dq_sig_doc_path;

  @Column(name = "officer_dq_sig_doc_file_id")
  private String officer_dq_sig_doc_file_id;

  @Column(name = "officer_dq_entered_name")
  private String officer_dq_entered_name;

  @Column(name = "superv_dq_sig")
  private String superv_dq_sig;

  @Column(name = "superv_dq_sig_doc_path")
  private String superv_dq_sig_doc_path;

  @Column(name = "superv_dq_sig_doc_file_id")
  private String superv_dq_sig_doc_file_id;

  @Column(name = "superv_dq_entered_name")
  private String superv_dq_entered_name;

  @Column(name = "continue_wo_interpreter")
  private Boolean continue_wo_interpreter;

  @Column(name = "officer_wd_sig")
  private String officer_wd_sig;

  @Column(name = "officer_wd_sig_doc_path")
  private String officer_wd_sig_doc_path;

  @Column(name = "officer_wd_sig_doc_file_id")
  private String officer_wd_sig_doc_file_id;

  @Column(name = "officer_wd_entered_name")
  private String officer_wd_entered_name;

  @Column(name = "subject_wd_sig")
  private String subject_wd_sig;

  @Column(name = "subject_wd_sig_doc_path")
  private String subject_wd_sig_doc_path;

  @Column(name = "subject_wd_sig_doc_file_id")
  private String subject_wd_sig_doc_file_id;

  @Column(name = "subject_wd_entered_name")
  private String subject_wd_entered_name;

  @Column(name = "case_status_code")
  private Integer case_status_code;

  @Column(name = "case_status_value")
  private String case_status_value;

  @Column(name = "case_update_date")
  private LocalDateTime case_update_date;

  public Case() {

  }

  public Case(int case_id, int user_id_fk, int cm_id_fk,
      int subject_id_fk, int interpreter_id_fk, boolean interp_id_doc_attach, String subject_declare_sig,
      String subject_dec_sig_doc_path,
      String subject_dec_sig_doc_file_id, String interp_declare_sig, String interp_dec_sig_doc_path,
      String interp_dec_sig_doc_file_id,
      Date interp_declare, int officer_id_fk, Date officer_declare, String officer_declare_sig,
      String officer_dec_sig_doc_path, String officer_dec_sig_doc_file_id,
      String officer_declare_entered_name, String officer_field_office, Date update_date, boolean interp_dq,
      String interp_dq_reason, String subject_dq_name, boolean dq_reschedule,
      String officer_dq_sig, String officer_dq_sig_doc_path, String officer_dq_sig_doc_file_id,
      String officer_dq_entered_name, String superv_dq_sig, String superv_dq_sig_doc_path,
      String superv_dq_sig_doc_file_id, String superv_dq_entered_name, Boolean continue_wo_interpreter,
      String officer_wd_sig, String officer_wd_sig_doc_path, String officer_wd_sig_doc_file_id,
      String officer_wd_entered_name, String subject_wd_sig, String subject_wd_sig_doc_path,
      String subject_wd_sig_doc_file_id, String subject_wd_entered_name, Integer case_status_code,
      String case_status_value, LocalDateTime case_update_date) {
    this.case_id = case_id;
    this.user_id_fk = user_id_fk;
    this.cm_id_fk = cm_id_fk;
    this.subject_id_fk = subject_id_fk;
    this.interpreter_id_fk = interpreter_id_fk;
    this.interp_id_doc_attach = interp_id_doc_attach;
    this.subject_declare_sig = subject_declare_sig;
    this.subject_dec_sig_doc_path = subject_dec_sig_doc_path;
    this.subject_dec_sig_doc_file_id = subject_dec_sig_doc_file_id;
    this.interp_declare_sig = interp_declare_sig;
    this.interp_dec_sig_doc_path = interp_dec_sig_doc_path;
    this.interp_dec_sig_doc_file_id = interp_dec_sig_doc_file_id;
    this.interp_declare = interp_declare;
    this.officer_id_fk = officer_id_fk;
    this.officer_declare = officer_declare;
    this.officer_declare_sig = officer_declare_sig;
    this.officer_dec_sig_doc_path = officer_dec_sig_doc_path;
    this.officer_dec_sig_doc_file_id = officer_dec_sig_doc_file_id;
    this.officer_declare_entered_name = officer_declare_entered_name;
    this.officer_field_office = officer_field_office;
    this.update_date = update_date;
    this.interp_dq = interp_dq;
    this.interp_dq_reason = interp_dq_reason;
    this.subject_dq_name = subject_dq_name;
    this.dq_reschedule = dq_reschedule;
    this.officer_dq_sig = officer_dq_sig;
    this.officer_dq_sig_doc_path = officer_dq_sig_doc_path;
    this.officer_dq_sig_doc_file_id = officer_dq_sig_doc_file_id;
    this.officer_dq_entered_name = officer_dq_entered_name;
    this.superv_dq_sig = superv_dq_sig;
    this.superv_dq_sig_doc_path = superv_dq_sig_doc_path;
    this.superv_dq_sig_doc_file_id = superv_dq_sig_doc_file_id;
    this.superv_dq_entered_name = superv_dq_entered_name;
    this.continue_wo_interpreter = continue_wo_interpreter;
    this.officer_wd_sig = officer_wd_sig;
    this.officer_wd_sig_doc_path = officer_wd_sig_doc_path;
    this.officer_wd_sig_doc_file_id = officer_wd_sig_doc_file_id;
    this.officer_wd_entered_name = officer_wd_entered_name;
    this.subject_wd_sig = subject_wd_sig;
    this.subject_wd_sig_doc_path = subject_wd_sig_doc_path;
    this.subject_wd_sig_doc_file_id = subject_wd_sig_doc_file_id;
    this.subject_wd_entered_name = subject_wd_entered_name;
    this.case_status_code = case_status_code;
    this.case_status_value = case_status_value;
    this.case_update_date = case_update_date;
  }

  public int getCase_id() {
    return case_id;
}

public void setCase_id(int case_id) {
    this.case_id = case_id;
}

public int getUser_id_fk() {
    return user_id_fk;
}

public void setUser_id_fk(int user_id_fk) {
    this.user_id_fk = user_id_fk;
}

public int getCm_id_fk() {
    return cm_id_fk;
}

public void setCm_id_fk(int cm_id_fk) {
    this.cm_id_fk = cm_id_fk;
}

public int getSubject_id_fk() {
    return subject_id_fk;
}

public void setSubject_id_fk(int subject_id_fk) {
    this.subject_id_fk = subject_id_fk;
}

public int getInterpreter_id_fk() {
    return interpreter_id_fk;
}

public void setInterpreter_id_fk(int interpreter_id_fk) {
    this.interpreter_id_fk = interpreter_id_fk;
}

public boolean isInterp_id_doc_attach() {
    return interp_id_doc_attach;
}

public void setInterp_id_doc_attach(boolean interp_id_doc_attach) {
    this.interp_id_doc_attach = interp_id_doc_attach;
}

public String getSubject_declare_sig() {
    return subject_declare_sig;
}

public void setSubject_declare_sig(String subject_declare_sig) {
    this.subject_declare_sig = subject_declare_sig;
}

public String getSubject_dec_sig_doc_path() {
    return subject_dec_sig_doc_path;
}

public void setSubject_dec_sig_doc_path(String subject_dec_sig_doc_path) {
    this.subject_dec_sig_doc_path = subject_dec_sig_doc_path;
}

public String getSubject_dec_sig_doc_file_id() {
    return subject_dec_sig_doc_file_id;
}

public void setSubject_dec_sig_doc_file_id(String subject_dec_sig_doc_file_id) {
    this.subject_dec_sig_doc_file_id = subject_dec_sig_doc_file_id;
}

public String getInterp_declare_sig() {
    return interp_declare_sig;
}

public void setInterp_declare_sig(String interp_declare_sig) {
    this.interp_declare_sig = interp_declare_sig;
}

public String getInterp_dec_sig_doc_path() {
    return interp_dec_sig_doc_path;
}

public void setInterp_dec_sig_doc_path(String interp_dec_sig_doc_path) {
    this.interp_dec_sig_doc_path = interp_dec_sig_doc_path;
}

public String getInterp_dec_sig_doc_file_id() {
    return interp_dec_sig_doc_file_id;
}

public void setInterp_dec_sig_doc_file_id(String interp_dec_sig_doc_file_id) {
    this.interp_dec_sig_doc_file_id = interp_dec_sig_doc_file_id;
}

public Date getInterp_declare() {
    return interp_declare;
}

public void setInterp_declare(Date interp_declare) {
    this.interp_declare = interp_declare;
}

public int getOfficer_id_fk() {
    return officer_id_fk;
}

public void setOfficer_id_fk(int officer_id_fk) {
    this.officer_id_fk = officer_id_fk;
}

public Date getOfficer_declare() {
    return officer_declare;
}

public void setOfficer_declare(Date officer_declare) {
    this.officer_declare = officer_declare;
}

public String getOfficer_declare_sig() {
    return officer_declare_sig;
}

public void setOfficer_declare_sig(String officer_declare_sig) {
    this.officer_declare_sig = officer_declare_sig;
}

public String getOfficer_dec_sig_doc_path() {
    return officer_dec_sig_doc_path;
}

public void setOfficer_dec_sig_doc_path(String officer_dec_sig_doc_path) {
    this.officer_dec_sig_doc_path = officer_dec_sig_doc_path;
}

public String getOfficer_dec_sig_doc_file_id() {
    return officer_dec_sig_doc_file_id;
}

public void setOfficer_dec_sig_doc_file_id(String officer_dec_sig_doc_file_id) {
    this.officer_dec_sig_doc_file_id = officer_dec_sig_doc_file_id;
}

public String getOfficer_declare_entered_name() {
    return officer_declare_entered_name;
}

public void setOfficer_declare_entered_name(String officer_declare_entered_name) {
    this.officer_declare_entered_name = officer_declare_entered_name;
}

public String getOfficer_field_office() {
    return officer_field_office;
}

public void setOfficer_field_office(String officer_field_office) {
    this.officer_field_office = officer_field_office;
}

public Date getUpdate_date() {
    return update_date;
}

public void setUpdate_date(Date update_date) {
    this.update_date = update_date;
}

public boolean isInterp_dq() {
    return interp_dq;
}

public void setInterp_dq(boolean interp_dq) {
    this.interp_dq = interp_dq;
}

public String getInterp_dq_reason() {
    return interp_dq_reason;
}

public void setInterp_dq_reason(String interp_dq_reason) {
    this.interp_dq_reason = interp_dq_reason;
}

public String getSubject_dq_name() {
    return subject_dq_name;
}

public void setSubject_dq_name(String subject_dq_name) {
    this.subject_dq_name = subject_dq_name;
}

public boolean isDq_reschedule() {
    return dq_reschedule;
}

public void setDq_reschedule(boolean dq_reschedule) {
    this.dq_reschedule = dq_reschedule;
}

public String getOfficer_dq_sig() {
    return officer_dq_sig;
}

public void setOfficer_dq_sig(String officer_dq_sig) {
    this.officer_dq_sig = officer_dq_sig;
}

public String getOfficer_dq_sig_doc_path() {
    return officer_dq_sig_doc_path;
}

public void setOfficer_dq_sig_doc_path(String officer_dq_sig_doc_path) {
    this.officer_dq_sig_doc_path = officer_dq_sig_doc_path;
}

public String getOfficer_dq_sig_doc_file_id() {
    return officer_dq_sig_doc_file_id;
}

public void setOfficer_dq_sig_doc_file_id(String officer_dq_sig_doc_file_id) {
    this.officer_dq_sig_doc_file_id = officer_dq_sig_doc_file_id;
}

public String getOfficer_dq_entered_name() {
    return officer_dq_entered_name;
}

public void setOfficer_dq_entered_name(String officer_dq_entered_name) {
    this.officer_dq_entered_name = officer_dq_entered_name;
}

public String getSuperv_dq_sig() {
    return superv_dq_sig;
}

public void setSuperv_dq_sig(String superv_dq_sig) {
    this.superv_dq_sig = superv_dq_sig;
}

public String getSuperv_dq_sig_doc_path() {
    return superv_dq_sig_doc_path;
}

public void setSuperv_dq_sig_doc_path(String superv_dq_sig_doc_path) {
    this.superv_dq_sig_doc_path = superv_dq_sig_doc_path;
}

public String getSuperv_dq_sig_doc_file_id() {
    return superv_dq_sig_doc_file_id;
}

public void setSuperv_dq_sig_doc_file_id(String superv_dq_sig_doc_file_id) {
    this.superv_dq_sig_doc_file_id = superv_dq_sig_doc_file_id;
}

public String getSuperv_dq_entered_name() {
    return superv_dq_entered_name;
}

public void setSuperv_dq_entered_name(String superv_dq_entered_name) {
    this.superv_dq_entered_name = superv_dq_entered_name;
}

public Boolean getContinue_wo_interpreter() {
    return continue_wo_interpreter;
}

public void setContinue_wo_interpreter(Boolean continue_wo_interpreter) {
    this.continue_wo_interpreter = continue_wo_interpreter;
}

public String getOfficer_wd_sig() {
    return officer_wd_sig;
}

public void setOfficer_wd_sig(String officer_wd_sig) {
    this.officer_wd_sig = officer_wd_sig;
}

public String getOfficer_wd_sig_doc_path() {
    return officer_wd_sig_doc_path;
}

public void setOfficer_wd_sig_doc_path(String officer_wd_sig_doc_path) {
    this.officer_wd_sig_doc_path = officer_wd_sig_doc_path;
}

public String getOfficer_wd_sig_doc_file_id() {
    return officer_wd_sig_doc_file_id;
}

public void setOfficer_wd_sig_doc_file_id(String officer_wd_sig_doc_file_id) {
    this.officer_wd_sig_doc_file_id = officer_wd_sig_doc_file_id;
}

public String getOfficer_wd_entered_name() {
    return officer_wd_entered_name;
}

public void setOfficer_wd_entered_name(String officer_wd_entered_name) {
    this.officer_wd_entered_name = officer_wd_entered_name;
}

public String getSubject_wd_sig() {
    return subject_wd_sig;
}

public void setSubject_wd_sig(String subject_wd_sig) {
    this.subject_wd_sig = subject_wd_sig;
}

public String getSubject_wd_sig_doc_path() {
    return subject_wd_sig_doc_path;
}

public void setSubject_wd_sig_doc_path(String subject_wd_sig_doc_path) {
    this.subject_wd_sig_doc_path = subject_wd_sig_doc_path;
}

public String getSubject_wd_sig_doc_file_id() {
    return subject_wd_sig_doc_file_id;
}

public void setSubject_wd_sig_doc_file_id(String subject_wd_sig_doc_file_id) {
    this.subject_wd_sig_doc_file_id = subject_wd_sig_doc_file_id;
}

public String getSubject_wd_entered_name() {
    return subject_wd_entered_name;
}

public void setSubject_wd_entered_name(String subject_wd_entered_name) {
    this.subject_wd_entered_name = subject_wd_entered_name;
}

public Integer getCase_status_code() {
    return case_status_code;
}

public void setCase_status_code(Integer case_status_code) {
    this.case_status_code = case_status_code;
}

public String getCase_status_value() {
    return case_status_value;
}

public void setCase_status_value(String case_status_value) {
    this.case_status_value = case_status_value;
}

public LocalDateTime getCase_update_date() {
    return case_update_date;
}

public void setCase_update_date(LocalDateTime case_update_date) {
    this.case_update_date = case_update_date;
}

@Override
public String toString() {
  return "Case [" + 
      "case_id=" + case_id + 
      ", user_id_fk=" + user_id_fk + 
      ", cm_id_fk=" + cm_id_fk + 
      ", subject_id_fk=" + subject_id_fk + 
      ", interpreter_id_fk=" + interpreter_id_fk + 
      ", interp_id_doc_attach=" + interp_id_doc_attach + 
      ", subject_declare_sig=" + subject_declare_sig + 
      ", subject_dec_sig_doc_path=" + subject_dec_sig_doc_path + 
      ", subject_dec_sig_doc_file_id=" + subject_dec_sig_doc_file_id + 
      ", interp_declare_sig=" + interp_declare_sig + 
      ", interp_dec_sig_doc_path=" + interp_dec_sig_doc_path + 
      ", interp_dec_sig_doc_file_id=" + interp_dec_sig_doc_file_id + 
      ", interp_declare=" + interp_declare + 
      ", officer_id_fk=" + officer_id_fk + 
      ", officer_declare=" + officer_declare + 
      ", officer_declare_sig=" + officer_declare_sig + 
      ", officer_dec_sig_doc_path=" + officer_dec_sig_doc_path + 
      ", officer_dec_sig_doc_file_id=" + officer_dec_sig_doc_file_id + 
      ", officer_declare_entered_name=" + officer_declare_entered_name + 
      ", officer_field_office=" + officer_field_office + 
      ", update_date=" + update_date + 
      ", interp_dq=" + interp_dq + 
      ", interp_dq_reason=" + interp_dq_reason + 
      ", subject_dq_name=" + subject_dq_name + 
      ", dq_reschedule=" + dq_reschedule + 
      ", officer_dq_sig=" + officer_dq_sig + 
      ", officer_dq_sig_doc_path=" + officer_dq_sig_doc_path + 
      ", officer_dq_sig_doc_file_id=" + officer_dq_sig_doc_file_id + 
      ", officer_dq_entered_name=" + officer_dq_entered_name + 
      ", superv_dq_sig=" + superv_dq_sig + 
      ", superv_dq_sig_doc_path=" + superv_dq_sig_doc_path + 
      ", superv_dq_sig_doc_file_id=" + superv_dq_sig_doc_file_id + 
      ", superv_dq_entered_name=" + superv_dq_entered_name + 
      ", continue_wo_interpreter=" + continue_wo_interpreter + 
      ", officer_wd_sig=" + officer_wd_sig + 
      ", officer_wd_sig_doc_path=" + officer_wd_sig_doc_path + 
      ", officer_wd_sig_doc_file_id=" + officer_wd_sig_doc_file_id + 
      ", officer_wd_entered_name=" + officer_wd_entered_name + 
      ", subject_wd_sig=" + subject_wd_sig + 
      ", subject_wd_sig_doc_path=" + subject_wd_sig_doc_path + 
      ", subject_wd_sig_doc_file_id=" + subject_wd_sig_doc_file_id + 
      ", subject_wd_entered_name=" + subject_wd_entered_name + 
      ", case_status_code=" + case_status_code + 
      ", case_status_value=" + case_status_value + 
      ", case_update_date=" + case_update_date + 
      "]";
}

}
