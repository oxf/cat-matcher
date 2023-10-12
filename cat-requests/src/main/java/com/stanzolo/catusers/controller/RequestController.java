package com.stanzolo.catusers.controller;

import com.stanzolo.catusers.dto.CreateRequestDTO;
import com.stanzolo.catusers.model.Request;
import com.stanzolo.catusers.service.RequestService;
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
@RequestMapping(value = "/requests")
public class RequestController {
    @Autowired
    RequestService requestService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Request> getRequests() {
        return requestService.getAllRequests();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Request> getRequests(@PathVariable UUID id) {
        return requestService.getRequest(id);
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Request> createRequest(@RequestBody CreateRequestDTO requestDTO) {
        return requestService.createRequest(requestDTO);
    }
}
