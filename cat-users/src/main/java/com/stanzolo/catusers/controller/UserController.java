package com.stanzolo.catusers.controller;

import com.stanzolo.catusers.service.UserService;
import com.stanzolo.catusers.dto.CreateUserDTO;
import com.stanzolo.catusers.model.User;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@NoArgsConstructor
@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<User> getUsers(@PathVariable UUID id) {
        return userService.getUser(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<User> createUser(@RequestBody CreateUserDTO user) {
        return userService.createUser(user);
    }
}
