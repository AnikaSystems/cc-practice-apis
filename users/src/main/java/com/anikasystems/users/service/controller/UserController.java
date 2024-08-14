
package com.anikasystems.users.service.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.anikasystems.users.service.jms.SimpleQueue;
import com.anikasystems.users.service.model.User;
import com.anikasystems.users.service.repository.UserRepository;

@CrossOrigin(origins = "https://cc-User-management.s3.amazonaws.com")
@RestController
@RequestMapping("/api")
public class UserController {

  @Autowired
  UserRepository UserRepository;

  @GetMapping("/Users")
  public ResponseEntity<List<User>> getAllUsers(@RequestParam(required = false) String lastName) {
    try {
      List<User> Users = new ArrayList<User>();

      if (lastName == null)
        UserRepository.findAll().forEach(Users::add);
      else
        UserRepository.findByLastName(lastName).forEach(Users::add);

      if (Users.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(Users, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/Users/{id}")
  public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
    Optional<User> UserData = UserRepository.findById(id);

    if (UserData.isPresent()) {
      return new ResponseEntity<>(UserData.get(), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/Users")
  public ResponseEntity<User> createUser(@RequestBody User UserData) {
    try {
      //public User(long id, String password, String lastName, String firstName, String address, String phoneNumber, String email) {
      User _User = UserRepository.save(new User(UserData.getId(), UserData.getPassword(), UserData.getLastName(), UserData.getFirstName(), UserData.getAddress(), UserData.getPhoneNumber(), UserData.getEmail()));

      SimpleQueue queue = new SimpleQueue("Users");
      queue.send(UserData.getLastName());
      queue.close();

      return new ResponseEntity<>(_User, HttpStatus.CREATED);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/Users/{id}")
  public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User inputUser) {
    Optional<User> UserData = UserRepository.findById(id);

    if (UserData.isPresent()) {
      User _User = UserData.get();
      _User.setFirstName(inputUser.getFirstName());
      _User.setLastName(inputUser.getLastName());
      _User.setAddress(inputUser.getAddress());
      return new ResponseEntity<>(UserRepository.save(_User), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  @DeleteMapping("/Users/{id}")
  public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") long id) {
    try {
      UserRepository.deleteById(id);
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/Users")
  public ResponseEntity<HttpStatus> deleteAllUsers() {
    try {
      UserRepository.deleteAll();
      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

  }
}
