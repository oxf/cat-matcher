package com.stanzolo.caturequests.service;

import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public interface QueueService {
    public CompletableFuture<SendResult<String, String>> sendMessage(String message) ;
}
