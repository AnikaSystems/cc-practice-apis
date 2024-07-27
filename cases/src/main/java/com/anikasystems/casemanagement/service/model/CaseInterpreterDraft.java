package com.anikasystems.casemanagement.service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "interp_iview_interp_draft")
public class CaseInterpreterDraft {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "external_id")
  private String external_id;

  @Column(name = "interp_id")
  private String interpId;

  @Column(name = "created_date")
  private String createdDate;

  @Column(name = "updated_date")
  private String updatedDate;

  @Column(name = "case_id_fk")
  private String caseId;

  @Column(name = "interp_langs")
  private String interpLangs;

  @Column(name = "interp_id_doc_file_id")
  private String interpIdDocFileId;

  @Column(name = "interp_id_doc_path")
  private String interpIdDocPath;

  public CaseInterpreterDraft() {}

  public CaseInterpreterDraft(String interpId) {
    this.interpId = interpId;
  }

  public long getId() {
    return id;
  }

  public String getInterpId() {
    return interpId;
  }

  public void setSubjectId(String interpId) {
    this.interpId = interpId;
  }

  @Override
  public String toString() {
    return "CaseInterpreterDraft [id=" + id + "]";
  }

}
