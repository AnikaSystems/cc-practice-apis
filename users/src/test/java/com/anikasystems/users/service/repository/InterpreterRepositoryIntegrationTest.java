package com.anikasystems.users.service.repository;

import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.anikasystems.users.service.model.Interpreter;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class InterpreterRepositoryIntegrationTest {
    @Autowired
    InterpreterRepository InterpreterRepository;

    @Autowired
    TestEntityManager entityManager;
    
    private final String testEmail = "testUser@fakeEmail.com";

    @Test
    @Order(1)
    public void givennewInterpreter_whenSaved_thenSuccess() {
        //testing the "C" in CRUD
        Interpreter newInterpreter = new Interpreter("lastName", "firstName", "address", "phoneNumber", testEmail, "languages", "idDocPath", "idDocFileId");
        InterpreterRepository.save(newInterpreter);
        assert(entityManager.find(Interpreter.class, newInterpreter.getId()).equals(newInterpreter));    
    }

    @Test
    @Order(2)
    public void givenExistingUser_whenRead_thenSuccess() {
        //testing the 'R' in CRUD
        Interpreter newInterpreter = InterpreterRepository.findById(1).get();
        assert(newInterpreter.getFirstName().equals("Interp1First"));
    }

    @Test
    @Order(3)
    public void givenExistingUser_whenUpdated_thenSuccess() {
        //Testing the 'U' in CRUD
        Interpreter localInterpreter = InterpreterRepository.findById(1).get();
        localInterpreter.setEmail(testEmail);
        //UserRepository.save(localUser);
        assert(entityManager.find(Interpreter.class, 1).getEmail().equals(testEmail));
    }

    @Test
    @Order(4)
    public void givenExistingUser_whenDeleted_thenSuccess() {
        //Testing the 'D' in CRUD
        Optional<Interpreter> IntervieweeData = InterpreterRepository.findByEmail(testEmail);
        if(IntervieweeData.isPresent()){
            Interpreter delInterpreter = IntervieweeData.get();
            InterpreterRepository.delete(delInterpreter);
            assert(entityManager.find(Interpreter.class, delInterpreter.getId())==null);
        }
        
    }
}