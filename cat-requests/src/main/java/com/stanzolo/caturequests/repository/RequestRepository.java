package com.stanzolo.caturequests.repository;

import com.stanzolo.caturequests.model.Request;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RequestRepository extends ReactiveMongoRepository<Request, UUID> {
}
