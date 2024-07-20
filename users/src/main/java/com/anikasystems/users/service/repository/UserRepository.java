package com.anikasystems.users.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anikasystems.users.service.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
  List<User> findByPublished(boolean published);

  List<User> findByTitleContainingIgnoreUser(String title);
}
