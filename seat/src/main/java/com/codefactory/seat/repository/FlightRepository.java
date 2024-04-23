package com.codefactory.seat.repository;

import org.springframework.data.repository.CrudRepository;

import com.codefactory.seat.model.Flight;

public interface FlightRepository extends CrudRepository<Flight,Long> {
    
}
