package com.educandoweb.curso.controller;

import com.educandoweb.curso.modelo.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping
    public ResponseEntity<User> findAll()
    {
        User u = new User(1L, "Diogo", "diogo@gmail.com", "123456", "123");
        return ResponseEntity.ok().body(u);
    }
}
