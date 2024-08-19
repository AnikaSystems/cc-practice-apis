package com.anikasystems.users.service.model;

import java.util.Objects;

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

    @Column(name = "email")
    private String email;
    
    public Interviewee() {
    }


    public Interviewee(String lastName, String firstName, String alienRegNumber, String nativeLangs, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.alienRegNumber = alienRegNumber;
        this.nativeLangs = nativeLangs;
        this.email = email;
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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Interviewee id(long id) {
        setId(id);
        return this;
    }

    public Interviewee lastName(String lastName) {
        setLastName(lastName);
        return this;
    }

    public Interviewee firstName(String firstName) {
        setFirstName(firstName);
        return this;
    }

    public Interviewee alienRegNumber(String alienRegNumber) {
        setAlienRegNumber(alienRegNumber);
        return this;
    }

    public Interviewee nativeLangs(String nativeLangs) {
        setNativeLangs(nativeLangs);
        return this;
    }

    public Interviewee email(String email) {
        setEmail(email);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Interviewee)) {
            return false;
        }
        Interviewee interviewee = (Interviewee) o;
        return id == interviewee.id && Objects.equals(lastName, interviewee.lastName) && Objects.equals(firstName, interviewee.firstName) && Objects.equals(alienRegNumber, interviewee.alienRegNumber) && Objects.equals(nativeLangs, interviewee.nativeLangs) && Objects.equals(email, interviewee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastName, firstName, alienRegNumber, nativeLangs, email);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", lastName='" + getLastName() + "'" +
            ", firstName='" + getFirstName() + "'" +
            ", alienRegNumber='" + getAlienRegNumber() + "'" +
            ", nativeLangs='" + getNativeLangs() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }
    
}