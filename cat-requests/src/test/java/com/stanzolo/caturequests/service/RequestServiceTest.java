package com.stanzolo.caturequests.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stanzolo.caturequests.dto.CreateRequestDTO;
import com.stanzolo.caturequests.model.Request;
import com.stanzolo.caturequests.repository.RequestRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.support.SendResult;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class RequestServiceTest {

    @InjectMocks
    private RequestService requestService;

    // Mocks
    @Mock
    private ObjectMapper objectMapper;

    @Mock
    private RequestRepository requestRepository;

    @Mock
    private QueueService queueService;

    @BeforeEach
    public void setUp() throws JsonProcessingException {
        MockitoAnnotations.openMocks(this);
        when(requestService.createRequest(any())).thenReturn(new Mono<Request>() {
            @Override
            public void subscribe(CoreSubscriber<? super Request> coreSubscriber) {

            }
        });
        when(queueService.sendMessage(any())).thenReturn(new CompletableFuture<SendResult<String, String>>());
        when(objectMapper.writeValueAsString(any())).thenReturn("mockedJsonString");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createRequest() {
        UUID userId = UUID.randomUUID();
        String from = "A";
        String to = "B";
        CreateRequestDTO createRequestDTO = new CreateRequestDTO(userId, from, to);
        StepVerifier.create(
                requestService.createRequest(createRequestDTO)
                        .flatMap(createdRequest ->
                            requestService.getRequest(createdRequest.getId())
                        ))
                        .expectNextMatches(foundEntity -> {
                            assertEquals(foundEntity.getFrom(), from);
                            assertEquals(foundEntity.getTo(), to);
                            assertEquals(foundEntity.getUserId(), userId);
                            return true;
                        })
                .verifyComplete();

    }
}