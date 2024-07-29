package com.anikasystems.casemanagement.service.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "cases")
public class Case {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)

  @Column(name = "case_id")
  private int case_id;

  @Column(name = "user_id")
  private int user_id;

  @Column(name = "subject_id")
  private int subject_id;

  @Column(name = "interpreter_id")
  private int interpreter_id;

  @Column(name = "status_code")
  private int status_code;

  @Column(name = "status_value")
  private String status_value;

  @Column(name = "update_date")
  private Date update_date;

  public Case() {

  }

  public Case(int case_id, int user_id, int subject_id, int interpreter_id, int status_code, String status_value, Date update_Date) {
    this.case_id = case_id;
    this.user_id = user_id;
    this.subject_id = subject_id;
    this.interpreter_id = interpreter_id;
    this.status_code = status_code;
    this.status_value = status_value;
    this.update_date = update_Date;
  }

  public int getCaseId() {
    return case_id;
  }

  
  public void setCaseId(int incId) {
    this.case_id = incId;
  }

  public int getUserId() {
    return user_id;
  }

  public void setUserId(int incId) {
    this.user_id = incId;
  }

  public int getSubjectId() {
    return subject_id;
  }

  public void setSubjectId(int incId) {
    this.subject_id = incId;
  }

  public int getInterpreterId() {
    return interpreter_id;
  }

  public void setInterpreterId(int incId) {
    this.interpreter_id = incId;
  }

  public int getStatusCode() {
    return status_code;
  }

  public void setStatusCode(int incCode) {
    this.status_code = incCode;
  }

  public String getStatusValue() {
    return status_value;
  }

  public void setStatusValue(String incValue) {
    this.status_value = incValue;
  }

  public Date getUpdateDate() {
    return update_date;
  }

  public void setUpdateDate(Date incDate) {
    this.update_date = incDate;
  }


  @Override
  public String toString() {
    return "Case [case_id=" + case_id + ", user_id=" + user_id + ", subject_id=" + subject_id + ", interpreter_id=" + interpreter_id + ", status_code=" + status_code + ", status_value=" + status_value + ", update_date=" + update_date + "]";
  }

}
