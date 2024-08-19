package com.anikasystems.users.service.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.anikasystems.users.service.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findById(long id);

  Optional<User> findByUserName(String userName);

  Optional<User> findByEmail(String email);

  List<User> findByLastName(String lastName);
}
