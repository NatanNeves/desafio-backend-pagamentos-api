package com.picpay.pagamentos.controllers;

import com.picpay.pagamentos.domain.user.User;
import com.picpay.pagamentos.dtos.UserDTO;
import com.picpay.pagamentos.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> allUsers() throws Exception {
        return ResponseEntity.ok(userService.allUsers());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/{document}")
    public ResponseEntity<Optional<User>> findByDocument(@PathVariable String document) throws Exception {
        return ResponseEntity.ok(userService.findByDocument(document));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable Long id) throws Exception {
        return ResponseEntity.ok(userService.findById(id));
    }

}
