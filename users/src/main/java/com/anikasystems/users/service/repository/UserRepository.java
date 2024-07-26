package com.anikasystems.users.service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anikasystems.users.service.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findById(long id);

  List<User> findByLastName(String lastName);
}
