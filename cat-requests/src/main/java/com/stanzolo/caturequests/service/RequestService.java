package com.stanzolo.caturequests.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stanzolo.caturequests.dto.CreateRequestDTO;
import com.stanzolo.caturequests.model.Request;
import com.stanzolo.caturequests.repository.RequestRepository;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class RequestService {
    private ObjectMapper objectMapper;
    private RequestRepository requestRepository;
    private QueueService queueService;

    @Autowired
    public RequestService(ObjectMapper objectMapper, RequestRepository requestRepository, QueueService queueService) {
        this.objectMapper = objectMapper;
        this.requestRepository = requestRepository;
        this.queueService = queueService;
    }


    @SneakyThrows
    public Mono<Request> createRequest(CreateRequestDTO createRequestDTO) {
        UUID newId = UUID.randomUUID();
        Request requestToCreate = new Request(newId,
                createRequestDTO.getUserId(),
                createRequestDTO.getFrom(),
                createRequestDTO.getTo());
        var res = queueService.sendMessage(objectMapper.writeValueAsString(requestToCreate));
        return requestRepository.save(requestToCreate);
    }

    public Flux<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public Mono<Request> getRequest(UUID id) {
        return requestRepository.findById(id);
    }

    @SneakyThrows
    public void simulateRequests() {
        while(true) {
            UUID uuid = UUID.randomUUID();
            queueService.sendMessage(uuid.toString());
            System.out.println("message sent: " + uuid.toString());
            Thread.sleep(3000);
        }
    }
}
