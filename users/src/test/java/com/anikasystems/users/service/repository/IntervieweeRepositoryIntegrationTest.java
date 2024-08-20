package com.anikasystems.users.service.repository;

import java.util.Optional;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.anikasystems.users.service.model.Interviewee;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class IntervieweeRepositoryIntegrationTest {
    @Autowired
    IntervieweeRepository IntervieweeRepository;

    @Autowired
    TestEntityManager entityManager;
    
    private final String testEmail = "testUser@fakeEmail.com";

    @Test
    @Order(1)
    public void givenNewInterviewee_whenSaved_thenSuccess() {
        //testing the "C" in CRUD        
        Interviewee newInterviewee = new Interviewee("lastName", "firstName", "alienRegNumber", "nativeLangs", testEmail);
        IntervieweeRepository.save(newInterviewee);
        assert(entityManager.find(Interviewee.class, newInterviewee.getId()).equals(newInterviewee));    
    }

    @Test
    @Order(2)
    public void givenExistingUser_whenRead_thenSuccess() {
        //testing the 'R' in CRUD
        Interviewee newInterviewee = IntervieweeRepository.findById(1).get();
        assert(newInterviewee.getFirstName().equals("Subject1First"));
    }

    @Test
    @Order(3)
    public void givenExistingUser_whenUpdated_thenSuccess() {
        //Testing the 'U' in CRUD
        Interviewee localInterviewee = IntervieweeRepository.findById(1).get();
        localInterviewee.email(testEmail);
        //UserRepository.save(localUser);
        assert(entityManager.find(Interviewee.class, 1).getEmail().equals(testEmail));
    }

    @Test
    @Order(4)
    public void givenExistingUser_whenDeleted_thenSuccess() {
        //Testing the 'D' in CRUD
        Optional<Interviewee> IntervieweeData = IntervieweeRepository.findByEmail(testEmail);
        if(IntervieweeData.isPresent()){
            Interviewee delInterviewee = IntervieweeData.get();
            IntervieweeRepository.delete(delInterviewee);
            assert(entityManager.find(Interviewee.class, delInterviewee.getId())==null);
        }
        
    }
}