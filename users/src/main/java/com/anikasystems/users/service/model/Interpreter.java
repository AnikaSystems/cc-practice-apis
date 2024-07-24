package com.anikasystems.users.service.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "interpreter")
public class Interpreter extends User {
    public Interpreter() {
        // TODO Auto-generated method stub
    }
}