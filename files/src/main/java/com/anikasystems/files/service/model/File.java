package com.anikasystems.files.service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "File")
public class File {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @Column(name = "published")
  private boolean published;

  @Column(name = "applicant")
  private String applicant;

  @Column(name = "interpreter")
  private String interpreter;

  public File() {}

  public File(String title, String description, boolean published, String applicant, String interpreter) {
    this.title = title;
    this.description = description;
    this.published = published;
    this.applicant = applicant;
    this.interpreter = interpreter;
  }

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public boolean isPublished() {
    return published;
  }

  public void setPublished(boolean isPublished) {
    this.published = isPublished;
  }

  public String getApplicant() {
    return applicant;
  }

  public void setApplicant(String applicant) {
    this.applicant = applicant;
  }

  public String getInterpreter() {
    return interpreter;
  }

  public void setInterpreter(String interpreter) {
    this.interpreter = interpreter;
  }

  @Override
  public String toString() {
    return "Case [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
  }

}