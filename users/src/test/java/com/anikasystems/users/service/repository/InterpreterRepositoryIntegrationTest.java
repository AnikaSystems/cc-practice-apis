package com.anikasystems.users.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class InterpreterRepositoryIntegrationTest {
    @Autowired
    InterpreterRepository InterpreterRepository;

    @Autowired
    TestEntityManager entityManager;
    
    public InterpreterRepositoryIntegrationTest() {
        // TODO Auto-generated method stub
    }
}