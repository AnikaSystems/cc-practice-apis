package com.anikasystems.users.service.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
public class UserRepositoryIntegrationTest {
    @Autowired
    UserRepository UserRepository;

    @Autowired
    TestEntityManager entityManager;
    
    public UserRepositoryIntegrationTest() {
        // TODO Auto-generated method stub
    }
}