package com.anikasystems.common.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "end_user")
public class User {

  @Id
  @Column(name = "user_id")
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @Column(name = "user_pw")
  private String password;

  @Column(name = "user_acct_name")
  private String userName;

  @Column(name = "user_last_name")
  private String lastName;

  @Column(name = "user_first_name")
  private String firstName;

  @Column(name = "user_address")
  private String address;

  @Column(name = "user_phone")
  private String phoneNumber;

  @Column(name = "user_email")
  private String email;

  public User() {
  }

  public User(long id, String password, String lastName, String firstName, String address, String phoneNumber, String email) {
    this.id = id;
    this.password = password;
    this.lastName = lastName;
    this.firstName = firstName;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }


  public long getId() {
    return this.id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
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

  public String getAddress() {
    return this.address;
  }

  public void setAddress(String address) {
    this.address = address;
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

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", password='" + getPassword() + "'" +
      ", lastName='" + getLastName() + "'" +
      ", firstName='" + getFirstName() + "'" +
      ", address='" + getAddress() + "'" +
      ", phoneNumber='" + getPhoneNumber() + "'" +
      ", email='" + getEmail() + "'" +
      "}";
  }
  
}
