package com.anikasystems.users.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class OfficerRepositoryIntegrationTest {
    @Autowired
    OfficerRepository OfficerRepository;

    @Autowired
    TestEntityManager entityManager;
    
    public OfficerRepositoryIntegrationTest() {
        // TODO Auto-generated method stub
    }
}