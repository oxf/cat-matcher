package com.stanzolo.caturequests.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.stanzolo.caturequests.dto.CreateRequestDTO;
import com.stanzolo.caturequests.repository.RequestRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.kafka.support.SendResult;

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
        when(queueService.sendMessage(any())).thenReturn(new CompletableFuture<SendResult<String, String>>());
        when(objectMapper.writeValueAsString(any())).thenReturn("mockedJsonString");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void createRequest() {
        UUID id = UUID.randomUUID();
        String from = "A";
        String to = "B";
        requestService.createRequest(new CreateRequestDTO(id, from, to));
    }
}