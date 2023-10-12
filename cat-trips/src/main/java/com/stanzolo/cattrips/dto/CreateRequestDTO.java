package com.stanzolo.catusers.dto;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
public class CreateRequestDTO {
    private UUID userId;
    private String from;
    private String to;
}
