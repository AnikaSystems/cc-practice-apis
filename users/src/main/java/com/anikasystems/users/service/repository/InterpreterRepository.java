package com.anikasystems.users.service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anikasystems.users.service.model.Interpreter;

public interface InterpreterRepository extends JpaRepository<Interpreter, Long> {

  Optional<Interpreter> findById(long id);

  List<Interpreter> findByLastName(String lastName);
}
