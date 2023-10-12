package com.stanzolo.catusers.service;

import com.stanzolo.catusers.dto.CreateUserDTO;
import com.stanzolo.catusers.model.User;
import com.stanzolo.catusers.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Mono<User> createUser(CreateUserDTO createUserDTO) {
        UUID newId = UUID.randomUUID();
        User userToCreate = new User(newId, createUserDTO.getUsername());
        return userRepository.save(userToCreate);
    }

    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Mono<User> getUser(UUID id) {
        return userRepository.findById(id);
    }
}
