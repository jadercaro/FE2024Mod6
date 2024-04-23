package com.codefactory.seat.service;

import com.codefactory.seat.model.Seat;
import com.codefactory.seat.model.SeatStatus;
import com.codefactory.seat.repository.SeatRepository;
import com.codefactory.seat.repository.SeatStatusRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class SeatServiceImpl implements ISeat{

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    SeatStatusRepository seatStatusRepository;

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
            if((flightid != null && flightid > 0)){
            return seatRepository.getAvailableSeats(flightid);
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException ex) {return null;}
}

    @Override
    public void unavaibleSeat(Long seatid) {
        Seat seat = seatRepository.findById(seatid).orElse(null);
        SeatStatus status = seatStatusRepository.findById(Long.parseLong("2")).orElse(null);
        seat.setSeatStatus(status);
        seatRepository.save(seat);
    }

}
