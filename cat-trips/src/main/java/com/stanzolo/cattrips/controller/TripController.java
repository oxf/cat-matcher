package com.stanzolo.cattrips.controller;

import com.stanzolo.cattrips.model.Trip;
import com.stanzolo.cattrips.service.TripService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@NoArgsConstructor
@RestController
@RequestMapping(value = "/trips")
public class TripController {
    @Autowired
    TripService tripService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Flux<Trip> getAllTrips() {
        return tripService.getAllTrips();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mono<Trip> getTripById(@PathVariable UUID id) {
        return tripService.getTrip(id);
    }

}
