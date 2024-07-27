package com.anikasystems.casemanagement.service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "interp_iview_case")
public class Case {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "external_id")
  private String external_id;

  @Column(name = "subject_id")
  private String subjectId;

  public Case() {}

  public Case(String subjectId) {
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
    return "Case [id=" + id + "]";
  }

}
