package com.anikasystems.users.service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "interview_subject")
public class Interviewee {
    
    @Id
    @Column(name = "subject_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "alien_reg_number")
    private String alienRegNumber;

    @Column(name = "native_langs")
    private String nativeLangs;
    
    public Interviewee() {
    }

    public Interviewee(long id, String lastName, String firstName, String alienRegNumber, String nativeLangs) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.alienRegNumber = alienRegNumber;
        this.nativeLangs = nativeLangs;
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

    public String getAlienRegNumber() {
        return this.alienRegNumber;
    }

    public void setAlienRegNumber(String alienRegNumber) {
        this.alienRegNumber = alienRegNumber;
    }

    public String getNativeLangs() {
        return this.nativeLangs;
    }

    public void setNativeLangs(String nativeLangs) {
        this.nativeLangs = nativeLangs;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", alienRegNumber='" + getAlienRegNumber() + "'" +
            ", nativeLangs='" + getNativeLangs() + "'" +
            "}";
    }

}