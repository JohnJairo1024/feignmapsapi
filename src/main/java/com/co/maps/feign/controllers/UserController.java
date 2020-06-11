package com.co.maps.feign.controllers;


import com.co.maps.feign.domain.User;
import com.co.maps.feign.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("")
    public ResponseEntity<List<User>> getAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);

    }

    @PostMapping("/user")
    public ResponseEntity save(@RequestBody User user) {
        User savedUser = userService.save(user);
        return ResponseEntity.ok(savedUser);

    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> getById(@PathVariable(value = "id") long id) {
        User user = userService.findById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.notFound().build();

    }

    @GetMapping("/user/email/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable(value = "email") String email) {
        if (userService.findByEmail(email) != null) {
            return ResponseEntity.ok(userService.findByEmail(email));
        }
        return ResponseEntity.notFound().build();

    }


}
