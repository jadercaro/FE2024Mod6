package com.codefactory.seat.repository;

import org.springframework.data.repository.CrudRepository;
import com.codefactory.seat.model.Seat;
public interface SeatRepository extends CrudRepository<Seat,Long> {

}
