package com.anikasystems.users.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class IntervieweeRepositoryIntegrationTest {
    @Autowired
    IntervieweeRepository IntervieweeRepository;

    @Autowired
    TestEntityManager entityManager;
    
    public IntervieweeRepositoryIntegrationTest() {
        // TODO Auto-generated method stub
    }
}