package com.codefactory.seat.service;

import org.springframework.stereotype.Service;

import com.codefactory.seat.model.SeatxPassenger;

@Service
public interface ISeatxPassenger {
    Iterable<SeatxPassenger> createSeatxPassenger();
    String assingSeat(Long passengerId, Long seatId);
}
