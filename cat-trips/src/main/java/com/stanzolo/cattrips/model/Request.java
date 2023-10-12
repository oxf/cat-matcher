package com.stanzolo.catusers.model;

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
public class Request implements Serializable {

    @JsonCreator
    public Request(
            @JsonProperty("Id") UUID id,
            @JsonProperty("UserId") UUID userId,
            @JsonProperty("From") String from,
            @JsonProperty("To") String to) {
        this.id = id;
        this.userId = userId;
        this.from = from;
        this.to = to;
    }
    @Id
    private UUID id;
    private UUID userId;
    private String from;
    private String to;
}
