package com.anikasystems.users.service.repository;

import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.anikasystems.users.service.model.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryIntegrationTest {
    @Autowired
    UserRepository UserRepository;

    @Autowired
    TestEntityManager entityManager;

    private final String testEmail = "testUser@fakeEmail.com";

    @Test
    @Order(1)
    public void givenNewUser_whenSaved_thenSuccess() {
        //testing the "C" in CRUD
        User newUser = new User("password", "userName", "lastName", "firstName", "address", "phoneNumber", testEmail);
        UserRepository.save(newUser);
        assert(entityManager.find(User.class, newUser.getId()).equals(newUser));    
    }

    @Test
    @Order(2)
    public void givenExistingUser_whenRead_thenSuccess() {
        //testing the 'R' in CRUD
        User newUser = entityManager.find(User.class, 1);
        assert(newUser.getUserName().equals("endusera"));
        assert(newUser.getEmail()==null);
    }

    @Test
    @Order(3)
    public void givenExistingUser_whenUpdated_thenSuccess() {
        //Testing the 'U' in CRUD
        User localUser = UserRepository.findById(1).get();
        localUser.email(testEmail);
        //UserRepository.save(localUser);
        assert(entityManager.find(User.class, 1).getEmail().equals(testEmail));
    }

    @Test
    @Order(4)
    public void givenExistingUser_whenDeleted_thenSuccess() {
        //Testing the 'D' in CRUD
        Optional<User> userData = UserRepository.findByUserName("userName");
        if(userData.isPresent()){
            User delUser = userData.get();
            UserRepository.delete(delUser);
            assert(entityManager.find(User.class, delUser.getId())==null);
        }
        
    }

}