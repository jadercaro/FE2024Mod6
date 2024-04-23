package com.codefactory.seat.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.codefactory.seat.model.Seat;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatRepository extends CrudRepository<Seat,Long> {

    // Fetch cars by brand
    @Query("select s from Seat s where s.seatStatus.id = 1 and s.flight.id = :flightid")
    List<Seat> getAvailableSeats(@Param("flightid") Long flightid);
}
