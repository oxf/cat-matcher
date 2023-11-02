package com.stanzolo.caturequests.service;

import org.springframework.stereotype.Service;

@Service
public interface QueueService {
    public void sendMessage(String message);
}
