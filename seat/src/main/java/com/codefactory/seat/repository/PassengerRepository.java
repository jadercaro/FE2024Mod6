package com.codefactory.seat.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.codefactory.seat.model.Passenger;

public interface PassengerRepository extends CrudRepository<Passenger,Long>{
    @Query("SELECT p FROM Passenger p WHERE p.booking IS NOT NULL")
    Iterable<Passenger> passengerNotNull();
    
}
