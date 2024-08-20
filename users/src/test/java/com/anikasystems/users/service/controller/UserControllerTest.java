package com.anikasystems.users.service.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
public class UserControllerTest {

    @Autowired
	private UserController controller;

    @Test
    void testHealth(){
        ResponseEntity<HttpStatus> response = controller.health();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}