package com.stanzolo.cattrips.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.UUID;

@Document
@Data
@ToString
@NoArgsConstructor
@Getter
@Setter
public class Trip implements Serializable {

    @JsonCreator
    public Trip(
            @JsonProperty("Id") UUID id,
            @JsonProperty("UserId") UUID userId,
            @JsonProperty("DriverId") UUID driverId,
            @JsonProperty("From") String from,
            @JsonProperty("To") String to) {
        this.id = id;
        this.userId = userId;
        this.driverId = driverId;
        this.from = from;
        this.to = to;
    }
    @Id
    private UUID id;
    private UUID userId;
    private UUID driverId;
    private String from;
    private String to;
}
