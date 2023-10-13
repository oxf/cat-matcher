package com.stanzolo.cattrips.repository;

import com.stanzolo.cattrips.model.Trip;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TripRepository extends ReactiveMongoRepository<Trip, UUID> {
}
