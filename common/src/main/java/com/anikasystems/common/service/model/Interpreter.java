package com.anikasystems.common.service.model;
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

    @Column(name = "id_doc_path")
    private String idDocPath;

    @Column(name = "id_doc_file_id")
    private String idDocFileId;

    public Interpreter() {
        // TODO Auto-generated method stub
    }

    public Interpreter(long id, String lastName, String firstName, String address, String phoneNumber, String email, String idDocPath, String idDocFileId) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
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


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", address='" + getAddress() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", email='" + getEmail() + "'" +
            ", idDocPath='" + getIdDocPath() + "'" +
            ", idDocFileId='" + getIdDocFileId() + "'" +
            "}";
    }


}