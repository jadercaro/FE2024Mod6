package com.codefactory.seat.service;

import com.codefactory.seat.model.Seat;
import com.codefactory.seat.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class SeatServiceImpl implements ISeat{

    @Autowired
    private SeatRepository seatRepository;


    @Override
    public Double getTotalFee() {
        return null;
    }

    @Override
    public Double getSeatFee() {
        return null;
    }

    @Override
    public void assignSeatsRandomly() {

    }


    @Override
    public List<Seat> getAvailableSeats(Long flightid){
        try {
            return seatRepository.getAvailableSeats(flightid);
            
        } catch (IllegalArgumentException ex) {return null;}
    }

}
