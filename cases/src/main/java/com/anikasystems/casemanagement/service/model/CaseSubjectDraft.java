package com.anikasystems.casemanagement.service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "interp_iview_subject_draft")
public class CaseSubjectDraft {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "external_id")
  private String external_id;

  @Column(name = "subject_id")
  private String subjectId;

  @Column(name = "created_date")
  private String createdDate;

  @Column(name = "updated_date")
  private String updatedDate;

  @Column(name = "subject_name")
  private String subjectName;

  @Column(name = "subject_alien_reg_number")
  private String subjectAlienRegNumber;

  @Column(name = "subject_native_langs")
  private String subjectNativeLangs;

  @Column(name = "interp_name")
  private String interpName;

  @Column(name = "interp_address")
  private String interpAddress;

  @Column(name = "interp_email")
  private String interpEmail;

  @Column(name = "interp_phone_number")
  private String interpPhoneNumber;

  public CaseSubjectDraft() {}

  public CaseSubjectDraft(String subjectId) {
    this.subjectId = subjectId;
  }

  public long getId() {
    return id;
  }

  public String getSubjectId() {
    return subjectId;
  }

  public void setSubjectId(String subjectId) {
    this.subjectId = subjectId;
  }

  @Override
  public String toString() {
    return "CaseSubjectDraft [id=" + id + "]";
  }

}
