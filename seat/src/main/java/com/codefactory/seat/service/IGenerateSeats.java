package com.codefactory.seat.service;

import com.codefactory.seat.model.Seat;

import java.util.List;

public interface IGenerateSeats {

    Iterable<Seat> createSeats(int nSeats);
}
