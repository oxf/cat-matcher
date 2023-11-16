package com.stanzolo.caturequests.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class CreateRequestDTO {
    private UUID userId;
    private String from;
    private String to;
}
