package com.codefactory.seat.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codefactory.seat.model.Passenger;
import com.codefactory.seat.model.Seat;
import com.codefactory.seat.model.SeatxPassenger;
import com.codefactory.seat.repository.PassengerRepository;
import com.codefactory.seat.repository.SeatRepository;
import com.codefactory.seat.repository.SeatxPassengerRepository;

@Service
public class SeatxPassengerImpl implements ISeatxPassenger{
    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    SeatxPassengerRepository seatxPassengerRepository;

    @Autowired
    SeatRepository seatRepository;

    @Override
    public Iterable<SeatxPassenger> createSeatxPassenger() {
        
        Iterable<Passenger> passengers = passengerRepository.passengerNotNull();
        List<SeatxPassenger> seatXPassengers = new ArrayList<>();

        for (Passenger passenger : passengers) {
            SeatxPassenger seatxPassenger = new SeatxPassenger(passenger);
            seatXPassengers.add(seatxPassenger);}

        return seatxPassengerRepository.saveAll(seatXPassengers);
    }

    @Override
    public String assingSeat(Long id, Long seatId) {
        SeatxPassenger seatxPassenger = seatxPassengerRepository.findById(id).orElse(null);
        Seat seat = seatRepository.findById(seatId).orElse(null);
        seatxPassenger.setSeat(seat);
        seatxPassengerRepository.save(seatxPassenger);
        return seatxPassenger.toString();
    }

    
    
}
