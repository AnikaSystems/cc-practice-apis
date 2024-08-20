
package com.anikasystems.users.service.model;

import java.util.Objects;

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

  public User(long id, String password, String userName, String lastName, String firstName, String address, String phoneNumber, String email) {
    this.id = id;
    this.password = password;
    this.userName = userName;
    this.lastName = lastName;
    this.firstName = firstName;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.email = email;
  }

    public User(String password, String userName, String lastName, String firstName, String address, String phoneNumber, String email) {
    this.password = password;
    this.userName = userName;
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

  public User id(long id) {
    setId(id);
    return this;
  }

  public User password(String password) {
    setPassword(password);
    return this;
  }

  public User userName(String userName) {
    setUserName(userName);
    return this;
  }

  public User lastName(String lastName) {
    setLastName(lastName);
    return this;
  }

  public User firstName(String firstName) {
    setFirstName(firstName);
    return this;
  }

  public User address(String address) {
    setAddress(address);
    return this;
  }

  public User phoneNumber(String phoneNumber) {
    setPhoneNumber(phoneNumber);
    return this;
  }

  public User email(String email) {
    setEmail(email);
    return this;
  }

  @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return id == user.id && Objects.equals(password, user.password) && Objects.equals(userName, user.userName) && Objects.equals(lastName, user.lastName) && Objects.equals(firstName, user.firstName) && Objects.equals(address, user.address) && Objects.equals(phoneNumber, user.phoneNumber) && Objects.equals(email, user.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, password, userName, lastName, firstName, address, phoneNumber, email);
  }

  @Override
  public String toString() {
    return "{" +
      " id='" + getId() + "'" +
      ", password='" + getPassword() + "'" +
      ", userName='" + getUserName() + "'" +
      ", lastName='" + getLastName() + "'" +
      ", firstName='" + getFirstName() + "'" +
      ", address='" + getAddress() + "'" +
      ", phoneNumber='" + getPhoneNumber() + "'" +
      ", email='" + getEmail() + "'" +
      "}";
  }
  
  
}
