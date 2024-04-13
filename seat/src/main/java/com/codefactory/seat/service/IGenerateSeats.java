package com.codefactory.seat.service;

import com.codefactory.seat.model.Seat;


public interface IGenerateSeats {

    Iterable<Seat> createSeats(int nSeats);
}
