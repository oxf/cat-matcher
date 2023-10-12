package com.stanzolo.catusers.service;

import com.stanzolo.catusers.dto.CreateRequestDTO;
import com.stanzolo.catusers.model.Request;
import com.stanzolo.catusers.repository.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class RequestService {
    @Autowired
    private RequestRepository requestRepository;

    public Mono<Request> createRequest(CreateRequestDTO createRequestDTO) {
        UUID newId = UUID.randomUUID();
        Request requestToCreate = new Request(newId,
                createRequestDTO.getUserId(),
                createRequestDTO.getFrom(),
                createRequestDTO.getTo());
        return requestRepository.save(requestToCreate);
    }

    public Flux<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public Mono<Request> getRequest(UUID id) {
        return requestRepository.findById(id);
    }
}
