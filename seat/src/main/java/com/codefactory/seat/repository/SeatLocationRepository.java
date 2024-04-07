package com.codefactory.seat.repository;

import com.codefactory.seat.model.SeatClass;
import org.springframework.data.repository.CrudRepository;

public interface SeatLocationRepository extends CrudRepository<SeatClass,Long> {
}
