package com.codefactory.seat.service;

import com.codefactory.seat.model.Seat;

import java.util.List;

public interface ISeat {
     Double getTotalFee();
     Double getSeatFee();
     void assignSeatsRandomly();
     List<Seat> getAvailableSeats(Long flightid);
     void unavaibleSeat(Long seatId);
}
