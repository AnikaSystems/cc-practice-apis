package com.anikasystems.users.service.model;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "interpreter")
public class Interpreter {

    @Id
    @Column(name = "interpreter_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "interp_address")
    private String address;

    @Column(name = "interp_phone")
    private String phoneNumber;

    @Column(name = "interp_email")
    private String email;

    @Column(name = "interp_langs")
    private String languages;

    @Column(name = "id_doc_path")
    private String idDocPath;

    @Column(name = "id_doc_file_id")
    private String idDocFileId;

    public Interpreter() {
        // TODO Auto-generated method stub
    }


    public Interpreter(String lastName, String firstName, String address, String phoneNumber, String email, String languages, String idDocPath, String idDocFileId) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.languages = languages;
        this.idDocPath = idDocPath;
        this.idDocFileId = idDocFileId;
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

    public String getLanguages() {
        return this.languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getIdDocPath() {
        return this.idDocPath;
    }

    public void setIdDocPath(String idDocPath) {
        this.idDocPath = idDocPath;
    }

    public String getIdDocFileId() {
        return this.idDocFileId;
    }

    public void setIdDocFileId(String idDocFileId) {
        this.idDocFileId = idDocFileId;
    }

    public Interpreter id(long id) {
        setId(id);
        return this;
    }

    public Interpreter lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public Interpreter firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public Interpreter address(String address) {
        setAddress(address);
        return this;
    }

    public Interpreter phoneNumber(String phoneNumber) {
        setPhoneNumber(phoneNumber);
        return this;
    }

    public Interpreter email(String email) {
        setEmail(email);
        return this;
    }

    public Interpreter languages(String languages) {
        setLanguages(languages);
        return this;
    }

    public Interpreter idDocPath(String idDocPath) {
        setIdDocPath(idDocPath);
        return this;
    }

    public Interpreter idDocFileId(String idDocFileId) {
        setIdDocFileId(idDocFileId);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Interpreter)) {
            return false;
        }
        Interpreter interpreter = (Interpreter) o;
        return id == interpreter.id && Objects.equals(lastName, interpreter.lastName) && Objects.equals(firstName, interpreter.firstName) && Objects.equals(address, interpreter.address) && Objects.equals(phoneNumber, interpreter.phoneNumber) && Objects.equals(email, interpreter.email) && Objects.equals(languages, interpreter.languages) && Objects.equals(idDocPath, interpreter.idDocPath) && Objects.equals(idDocFileId, interpreter.idDocFileId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, address, phoneNumber, email, languages, idDocPath, idDocFileId);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", address='" + getAddress() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", email='" + getEmail() + "'" +
            ", languages='" + getLanguages() + "'" +
            ", idDocPath='" + getIdDocPath() + "'" +
            ", idDocFileId='" + getIdDocFileId() + "'" +
            "}";
    }
    
}