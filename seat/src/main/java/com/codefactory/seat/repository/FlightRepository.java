package com.codefactory.seat.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.codefactory.seat.model.Flight;

@Service
public interface FlightRepository extends CrudRepository<Flight,Long>{
    
}
