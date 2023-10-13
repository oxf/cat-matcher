package com.stanzolo.cattrips.service;

import com.stanzolo.cattrips.dto.CreateTripDTO;
import com.stanzolo.cattrips.model.Trip;
import com.stanzolo.cattrips.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class TripService {
    @Autowired
    private TripRepository tripRepository;

    public Mono<Trip> createTrip(CreateTripDTO createTripDTO) {
        UUID newId = UUID.randomUUID();
        Trip tripToCreate = new Trip(newId,
                createTripDTO.getUserId(),
                createTripDTO.getDriverId(),
                createTripDTO.getFrom(),
                createTripDTO.getTo());
        return tripRepository.save(tripToCreate);
    }

    public Flux<Trip> getAllTrips() {
        return tripRepository.findAll();
    }

    public Mono<Trip> getTrip(UUID id) {
        return tripRepository.findById(id);
    }
}
