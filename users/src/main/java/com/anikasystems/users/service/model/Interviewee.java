package com.anikasystems.users.service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "interview_subject")
public class Interviewee extends User {
    public Interviewee() {
        // TODO Auto-generated method stub
    }
}