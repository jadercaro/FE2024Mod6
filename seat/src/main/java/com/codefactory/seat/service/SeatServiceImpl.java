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
    private SeatStatusRepository seatStatusRepository;

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
    public List<Seat> getAvailableSeats(String status){
        Long id_status;

        SeatStatus.Status available = SeatStatus.Status.AVAILABLE;

        try {

            if (status.equalsIgnoreCase(available.name())){
                id_status = seatStatusRepository
                        .getIdByStatus(available);
                return seatRepository.getAvailableSeats(id_status);
            } else {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException ex) {return null;}
    }

}
