package com.stanzolo.catusers.repository;

import com.stanzolo.catusers.model.Request;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RequestRepository extends ReactiveMongoRepository<Request, UUID> {
}
