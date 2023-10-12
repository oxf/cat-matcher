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
@Builder
@NoArgsConstructor
@Getter
@Setter
public class User implements Serializable {

    @JsonCreator
    public User(
            @JsonProperty("Id") UUID id,
            @JsonProperty("Username") String name) {
        this.id = id;
        this.username = name;
    }
    @Id
    private UUID id;
    private String username;
}
