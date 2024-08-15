package com.anikasystems.users.service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anikasystems.users.service.model.Officer;

public interface OfficerRepository extends JpaRepository<Officer, Long> {

  Optional<Officer> findById(long id);

  List<Officer> findByLastName(String lastName);
}
