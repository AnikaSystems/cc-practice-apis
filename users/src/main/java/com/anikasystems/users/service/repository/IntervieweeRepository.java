package com.anikasystems.users.service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anikasystems.users.service.model.Interviewee;

public interface IntervieweeRepository extends JpaRepository<Interviewee, Long> {

  Optional<Interviewee> findById(long id);

  List<Interviewee> findByLastName(String lastName);
}
