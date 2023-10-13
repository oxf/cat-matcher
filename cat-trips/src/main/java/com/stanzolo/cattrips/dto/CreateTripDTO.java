package com.stanzolo.cattrips.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateTripDTO {
    private UUID userId;
    private UUID driverId;
    private String from;
    private String to;
}
