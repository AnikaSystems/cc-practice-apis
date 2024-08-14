
package com.anikasystems.users.service.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "officer")
public class Officer {

  @Id
  @Column(name = "officer_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "last_name")
  private String lastName;

  @Column(name = "first_name")
  private String firstName;

  @Column(name = "is_supervisor")
  private boolean isSupervisor;

  @Column(name = "officer_phone")
  private String phoneNumber;

  @Column(name = "officer_email")
  private String email;

  @Column(name = "officer_field_office")
  private String fieldOffice;

  @Column(name = "officer_sig")
  private String signature;

  @Column(name = "officer_sig_doc_path")
  private String signaturePath;

  @Column(name = "officer_sig_doc_file_id")
  private String sigFileId;

  public Officer() {
  }

  public Officer(long id, String lastName, String firstName, boolean isSupervisor, String phoneNumber, String email, String fieldOffice, String signature, String signaturePath, String sigFileId) {
    this.id = id;
    this.lastName = lastName;
    this.firstName = firstName;
    this.isSupervisor = isSupervisor;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.fieldOffice = fieldOffice;
    this.signature = signature;
    this.signaturePath = signaturePath;
    this.sigFileId = sigFileId;
  }

  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public boolean isIsSupervisor() {
    return this.isSupervisor;
  }

  public boolean getIsSupervisor() {
    return this.isSupervisor;
  }

  public void setIsSupervisor(boolean isSupervisor) {
    this.isSupervisor = isSupervisor;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getFieldOffice() {
    return this.fieldOffice;
  }

  public void setFieldOffice(String fieldOffice) {
    this.fieldOffice = fieldOffice;
  }

  public String getSignature() {
    return this.signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public String getSignaturePath() {
    return this.signaturePath;
  }

  public void setSignaturePath(String signaturePath) {
    this.signaturePath = signaturePath;
  }

  public String getSigFileId() {
    return this.sigFileId;
  }

  public void setSigFileId(String sigFileId) {
    this.sigFileId = sigFileId;
  }

  public Officer id(long id) {
    setId(id);
    return this;
  }

  public Officer email(String email) {
    setEmail(email);
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Officer)) {
            return false;
        }
        Officer officer = (Officer) o;
        return id == officer.id && Objects.equals(lastName, officer.lastName) && Objects.equals(firstName, officer.firstName) && isSupervisor == officer.isSupervisor && Objects.equals(phoneNumber, officer.phoneNumber) && Objects.equals(email, officer.email) && Objects.equals(fieldOffice, officer.fieldOffice) && Objects.equals(signature, officer.signature) && Objects.equals(signaturePath, officer.signaturePath) && Objects.equals(sigFileId, officer.sigFileId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, lastName, firstName, isSupervisor, phoneNumber, email, fieldOffice, signature, signaturePath, sigFileId);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", lastName='" + getLastName() + "'" +
      ", firstName='" + getFirstName() + "'" +
      ", isSupervisor='" + isIsSupervisor() + "'" +
      ", phoneNumber='" + getPhoneNumber() + "'" +
      ", email='" + getEmail() + "'" +
      ", fieldOffice='" + getFieldOffice() + "'" +
      ", signature='" + getSignature() + "'" +
      ", signaturePath='" + getSignaturePath() + "'" +
      ", sigFileId='" + getSigFileId() + "'" +
      "}";
  }
  
  
}
